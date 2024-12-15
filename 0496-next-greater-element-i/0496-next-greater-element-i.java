class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();

        Stack<Integer> stk = new Stack<>();
        stk.push(nums2[0]);

        for (int i = 1; i < m; i++) {

            while (!stk.isEmpty() && nums2[i] > stk.peek()) {
                map.put(stk.pop(), nums2[i]);
            }
            stk.push(nums2[i]);

        }

        while(!stk.isEmpty()){
            map.put(stk.pop(), -1);
        }

        for(int j = 0; j < n; j++){
            ans[j] = map.get(nums1[j]);
        }

        return ans;
    }
}

/*
 * -------------------BRUTE FORCE------------------------
 * class Solution {
 * public int[] nextGreaterElement(int[] nums1, int[] nums2) {
 * int n = nums1.length;
 * int m = nums2.length;
 * int[] ans = new int[n];
 * HashMap<Integer, Integer> map = new HashMap<>();
 * for(int i = 0; i < m; i++){
 * map.put(nums2[i], -1);
 * for(int j = i + 1; j < m; j++){
 * if(nums2[i] < nums2[j]){
 * map.put(nums2[i], nums2[j]);
 * break;
 * }
 * }
 * }
 * for(int i = 0; i < n; i++){
 * ans[i] = map.get(nums1[i]);
 * }
 * return ans;
 * }
 * }
 */