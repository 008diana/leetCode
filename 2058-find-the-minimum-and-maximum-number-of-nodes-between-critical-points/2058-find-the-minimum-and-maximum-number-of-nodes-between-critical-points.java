//semi my solution, hostel stuff happened today. need some introspection
/*
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
*/

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int counter = 0;
        ListNode curr = head.next;
        ListNode prev = head;
        ArrayList<Integer> criticalPoints = new ArrayList<>();

        // Traverse the linked list to find critical points
        while (curr != null && curr.next != null) {
            counter++;
            if ((prev.val < curr.val && curr.val > curr.next.val) || (prev.val > curr.val && curr.val < curr.next.val)) {
                criticalPoints.add(counter);
            }
            prev = curr;
            curr = curr.next;
        }

        // If there are less than two critical points, return [-1, -1]
        if (criticalPoints.size() < 2) {
            return new int[]{-1, -1};
        }

        // Calculate the minimum and maximum distances between critical points
        for (int i = 1; i < criticalPoints.size(); i++) {
            int distance = criticalPoints.get(i) - criticalPoints.get(i - 1);
            min = Math.min(min, distance);
        }
        
        max = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);

        return new int[]{min, max};
    }
}
