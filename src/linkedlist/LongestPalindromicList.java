package linkedlist;

public class LongestPalindromicList {
    public int maxPalindrome(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        int ans = 0;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            ans = Math.max(ans, 2*countCommon(prev, next) + 1);
            ans = Math.max(ans, 2*countCommon(curr, next));
            prev = curr;
            curr = next;
        }
        return ans;
    }
    public int countCommon(ListNode first, ListNode second) {
        ListNode a = first;
        ListNode b = second;
        int cnt = 0;
        while(a != null && b != null) {
            if(a.val==b.val) {
                cnt++;
            }
            else {
                break;
            }
            a = a.next;
            b = b.next;
        }
        return cnt;
    }
}
