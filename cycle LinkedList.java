/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;  // Slow pointer moves one step at a time
        ListNode fast = head;  // Fast pointer moves two steps at a time

        // Traverse the list while fast and fast.next are not null
        while (fast != null && fast.next != null) {
            slow = slow.next;            // Move slow pointer by one step
            fast = fast.next.next;       // Move fast pointer by two steps

            // If slow and fast meet, a cycle exists
            if (slow == fast) {
                return true;  // Cycle detected
            }
        }

        // If we exit the loop, there is no cycle
        return false;
    }
}
