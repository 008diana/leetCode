//Thanks to Dhruv Ladani, yeh optimal approach mila. love the way he computes both nse, pse at the same time 
class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1000000007;
        Stack<Integer> st = new Stack<>();
        long sumOfMinimums = 0;

        for (int i = 0; i <= arr.length; i++) {
            while (!st.empty() && (i == arr.length || arr[st.peek()] >= arr[i])) {
                int mid = st.pop();
                int leftBoundary = st.empty() ? -1 : st.peek();
                int rightBoundary = i;

                long count = (mid - leftBoundary) * (rightBoundary - mid) % MOD;

                sumOfMinimums += (count * arr[mid]) % MOD;
                sumOfMinimums %= MOD;
            }
            st.push(i);
        }

        return (int) sumOfMinimums;
    }
}

/*
-----------------------MY SOLUTION BASED ON STRIVER'S EXPLAINATION-------------------------
class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int mod = (int)Math.pow(10, 9) + 7;
        int sum = 0;
        int[] right = new int[n];
        right = nextSmallestElement(arr);
        int[] left = new int[n]; 
        left = previousSmallestOrEqualElement(arr);

        for(int i = 0; i < n; i++){
            long contribution = ((long)(right[i] - i) * (i - left[i]) % mod) * arr[i] % mod; // Use modulo
            sum = (sum + (int)contribution) % mod; // Update sum with modulo
        }

        return sum % mod;        

    }

    public static int[] nextSmallestElement(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for(int i = 1; i < n; i++){
            while(!stk.isEmpty() && arr[stk.peek()] > arr[i]){
                map.put(stk.pop(), i);
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            map.put(stk.pop(), n);
        }
        for(int i = 0; i < n; i++){
            ans[i] = map.get(i);
        }
        return ans;
    }

    public static int[] previousSmallestOrEqualElement(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        stk.push(n-1);
        for(int i = n-2; i >= 0; i--){
            while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]){
                map.put(stk.pop(), i);
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            map.put(stk.pop(), -1);
        }
        for(int i = 0; i < n; i++){
            ans[i] = map.get(i);
        }
        return ans;
    }
}
*/