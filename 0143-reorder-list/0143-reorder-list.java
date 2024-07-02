//not my code
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode prev = null, next = null;
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Step 3: Merge the two halves
        ListNode firstHalf = head;
        ListNode secondHalf = prev; // prev now points to the head of the reversed second half
        while (secondHalf.next != null) {
            next = firstHalf.next;
            prev = secondHalf.next;
            
            firstHalf.next = secondHalf;
            secondHalf.next = next;
            
            firstHalf = next;
            secondHalf = prev;
        }
    }
}


/*
explaination
Let's go through each step in detail to understand how the reorderList method works, including the specific step of finding the middle of the list.

Step-by-Step Explanation
Step 1: Find the Middle of the List
This step uses two pointers, slow and fast, to find the middle of the linked list. Here's how it works:

Initialization:

slow and fast both start at the head of the list.
slow moves one step at a time.
fast moves two steps at a time.
Process:

As fast moves twice as fast as slow, when fast reaches the end of the list, slow will be at the middle.
Example:
Let's consider the list 1 → 2 → 3 → 4 → 5.

Initial state:
slow → 1
fast → 1

First iteration:
slow → 2
fast → 3

Second iteration:
slow → 3
fast → 5
Now, fast can't move two steps further (as it would be null), so slow is at the middle of the list.

Step 2: Reverse the Second Half of the List
Once the middle of the list is found, the next step is to reverse the second half of the list.

Initialization:

prev is set to null.
slow continues from where it left off in Step 1 (at the middle of the list).
Process:

Reverse the links of the nodes starting from slow to the end of the list.
Example:

Starting from the middle:
slow → 3

First iteration:
prev → 3
slow → 4

Second iteration:
prev → 4 → 3
slow → 5

Third iteration:
prev → 5 → 4 → 3
slow → null
Now, the second half of the list is reversed, and prev points to the head of this reversed list.

Step 3: Merge the Two Halves
Finally, we merge the first half of the list with the reversed second half.

Initialization:

firstHalf starts at the head of the list.
secondHalf starts at prev (head of the reversed second half).
Process:

Alternate nodes between firstHalf and secondHalf to merge them.
Example:
Let's consider the first half (1 → 2 → 3) and the reversed second half (5 → 4 → 3).


Initial state:
firstHalf → 1
secondHalf → 5

First iteration:
firstHalf → 1 → 5
secondHalf → 1 → 5 → 2

Second iteration:
firstHalf → 1 → 5 → 2
secondHalf → 1 → 5 → 2 → 4

Third iteration:
firstHalf → 1 → 5 → 2 → 4 → 3
secondHalf → null
Now, the list is reordered as required.

Visual Representation
Finding the Middle:


head → 1 → 2 → 3 → 4 → 5
                 ↑
               slow
Reversing the Second Half:


head → 1 → 2 → 3    5 ← 4
                   prev
Merging the Two Halves:


head → 1 → 5 → 2 → 4 → 3
*/