package com.leetcode.javaalgorithms.q2_AddTwoNumbers;

public class Solution {

    // 자리별 덧셈 풀이
    // 시간복잡도: O(n) - 더 긴 연결 리스트 길이만큼 순회
    // 공간복잡도: 공간 O(n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  // 시작점: 더미 노드
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // 숫자 역순이므로 앞에서 자리수 올림이 있었으면 그 다음 합계에 더해주면 됨

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;                             // 올림 (10 이상이면 1)
            current.next = new ListNode(sum % 10);    // 일의 자리만 저장
            current = current.next;
        }

        return dummy.next; // 더미 노드 다음부터가 진짜 합계 첫 시작점
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
