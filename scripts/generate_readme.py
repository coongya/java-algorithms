#!/usr/bin/env python3
"""README.md 목차 자동 생성 스크립트.

src/main/java/com/<platform>/javaalgorithms/ 아래의 문제 폴더를 스캔해서
README.md 의 `## 목차` 이하를 다시 생성한다.

문제 폴더 규칙: q<번호>_<이름>/ 안에 README.md 와 풀이 .java 파일이 있어야 한다.
문제 제목/난이도는 문제 README 의 첫 제목 줄에서 읽는다.
    예) `# 1. Two Sum [Easy]`, `# 1. 개인정보 수집 유효기간 [Lv.1]`, `# 문자 찾기`
"""

import re
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
SRC = ROOT / "src" / "main" / "java" / "com"
README = ROOT / "README.md"

TOC_MARKER = "## 목차"

# 플랫폼 표시 순서와 제목. 새 플랫폼 폴더는 여기 추가하면 되고,
# 없으면 폴더명을 대문자로 시작하는 제목으로 자동 표시한다.
PLATFORM_ORDER = ["inflearn", "leetcode", "kakao", "toss"]
PLATFORM_TITLES = {
    "leetcode": "LeetCode",
    "kakao": "Kakao",
    "toss": "Toss",
}

# 인프런 섹션 폴더명 -> 목차 제목. 새 섹션을 추가하면 여기에 제목을 등록한다.
# (등록하지 않으면 "Section 03" 처럼 폴더명 기반 제목으로 표시된다.)
INFLEARN_SECTIONS = {
    "sec02": "Section 02. String (문자열)",
    "sec03": "Section 03. Array (1,2차원 배열)",
    "sec04": "Section 04. Two pointers, Sliding window",
    "sec05": "Section 05. HashMap, TreeSet"
}

DEFAULT_HEADER = "# Java Algorithms\n\n자바 알고리즘 문제 풀이   \n\n## 목차\n"

TITLE_RE = re.compile(r"^#\s+(?:(\d+)\.\s*)?(.+?)(?:\s*\[([^\]]+)\])?\s*$")
PROBLEM_DIR_RE = re.compile(r"^q(\d+)_(.+)$")


def parse_problem(problem_dir: Path):
    """문제 폴더에서 (번호, 제목, 난이도, README경로, 풀이파일들)을 읽는다."""
    m = PROBLEM_DIR_RE.match(problem_dir.name)
    if not m:
        return None
    number = int(m.group(1))
    title = m.group(2)
    difficulty = None

    readme = problem_dir / "README.md"
    if readme.is_file():
        for line in readme.read_text(encoding="utf-8").splitlines():
            tm = TITLE_RE.match(line.strip())
            if tm:
                if tm.group(1):
                    number = int(tm.group(1))
                title = tm.group(2).strip()
                difficulty = tm.group(3)
                break

    solutions = sorted(p for p in problem_dir.glob("*.java"))
    return {
        "number": number,
        "title": title,
        "difficulty": difficulty,
        "readme": readme if readme.is_file() else None,
        "solutions": solutions,
    }


def rel(path: Path) -> str:
    return path.relative_to(ROOT).as_posix()


def render_table(problems) -> str:
    problems = sorted(problems, key=lambda p: p["number"])
    has_difficulty = any(p["difficulty"] for p in problems)

    if has_difficulty:
        lines = ["| # | 문제 | 난이도 | 풀이 |", "|---|------|--------|------|"]
    else:
        lines = ["| # | 문제 | 풀이 |", "|---|------|------|"]

    for p in problems:
        if p["readme"]:
            problem_cell = f"[{p['title']}]({rel(p['readme'])})"
        else:
            problem_cell = p["title"]
        solution_cell = ", ".join(f"[{s.name}]({rel(s)})" for s in p["solutions"])
        if has_difficulty:
            lines.append(
                f"| {p['number']} | {problem_cell} | {p['difficulty'] or '-'} | {solution_cell} |"
            )
        else:
            lines.append(f"| {p['number']} | {problem_cell} | {solution_cell} |")
    return "\n".join(lines)


def group_title(dir_name: str) -> str:
    """그룹 폴더명 -> 목차 제목. 예) y2023_blind_recruitment -> 2023 BLIND RECRUITMENT"""
    m = re.match(r"^y(\d{4})_(.+)$", dir_name)
    if m:
        return f"{m.group(1)} {m.group(2).replace('_', ' ').upper()}"
    m = re.match(r"^sec(\d+)$", dir_name)
    if m:
        return f"Section {m.group(1)}"
    return dir_name.replace("_", " ").title()


def inflearn_section_title(section_dir: Path) -> str:
    if section_dir.name in INFLEARN_SECTIONS:
        return INFLEARN_SECTIONS[section_dir.name]
    section_readme = section_dir / "README.md"
    if section_readme.is_file():
        for line in section_readme.read_text(encoding="utf-8").splitlines():
            if line.startswith("# "):
                return line[2:].strip()
    return group_title(section_dir.name)


def collect_problems(directory: Path):
    return [
        p
        for d in sorted(directory.iterdir())
        if d.is_dir() and (p := parse_problem(d))
    ]


def render_platform(platform_dir: Path) -> list:
    """플랫폼 폴더 하나를 목차 블록(문자열) 리스트로 렌더링한다."""
    base = platform_dir / "javaalgorithms"
    if not base.is_dir():
        base = platform_dir
    name = platform_dir.name

    # 인프런: 섹션별로 최상위 ### 블록을 만든다.
    if name == "inflearn":
        blocks = []
        for section in sorted(d for d in base.iterdir() if d.is_dir()):
            problems = collect_problems(section)
            if problems:
                blocks.append(
                    f"### {inflearn_section_title(section)}\n\n{render_table(problems)}"
                )
        return blocks

    title = PLATFORM_TITLES.get(name, name.capitalize())
    direct_problems = collect_problems(base)
    if direct_problems:
        return [f"### {title}\n\n{render_table(direct_problems)}"]

    # 하위 그룹(연도별 등)이 있는 플랫폼: #### 소제목으로 나눈다.
    sub_blocks = []
    for group in sorted(d for d in base.iterdir() if d.is_dir()):
        problems = collect_problems(group)
        if problems:
            sub_blocks.append(f"#### {group_title(group.name)}\n\n{render_table(problems)}")
    if not sub_blocks:
        return []
    return [f"### {title}\n\n" + "\n\n".join(sub_blocks)]


def build_toc() -> str:
    platform_dirs = [d for d in SRC.iterdir() if d.is_dir()] if SRC.is_dir() else []
    platform_dirs.sort(
        key=lambda d: (
            PLATFORM_ORDER.index(d.name)
            if d.name in PLATFORM_ORDER
            else len(PLATFORM_ORDER),
            d.name,
        )
    )
    blocks = []
    for platform_dir in platform_dirs:
        blocks.extend(render_platform(platform_dir))
    return "\n\n---\n\n".join(blocks)


def main() -> int:
    if README.is_file():
        content = README.read_text(encoding="utf-8")
        idx = content.find(TOC_MARKER)
        if idx != -1:
            header = content[: idx + len(TOC_MARKER)] + "\n"
        else:
            header = content.rstrip() + "\n\n" + TOC_MARKER + "\n"
    else:
        header = DEFAULT_HEADER

    new_content = header + "\n" + build_toc() + "\n"
    if README.is_file() and README.read_text(encoding="utf-8") == new_content:
        print("README.md is up to date.")
        return 0
    README.write_text(new_content, encoding="utf-8")
    print("README.md updated.")
    return 0


if __name__ == "__main__":
    sys.exit(main())
