class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> included = new HashSet<>();
        return findsubs(0, nums, included, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> findsubs(int index, int[] nums, HashSet<List<Integer>> included, 
                                       List<Integer> subset, List<List<Integer>> result) {
        if (index == nums.length) {
            ArrayList<Integer> sortedSubset = new ArrayList<>(subset);
            Collections.sort(sortedSubset);
            if (!included.contains(sortedSubset)) {
                included.add(sortedSubset);
                result.add(new ArrayList<>(subset));
            }
            return result;
        }

        subset.add(nums[index]);
        findsubs(index + 1, nums, included, subset, result);
        subset.remove(subset.size() - 1);
        findsubs(index + 1, nums, included, subset, result);

        return result;
    }
}