class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        combine(0, candidates, target, list);

        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();

    public void combine(int i, int[] arr, int target, List<Integer> list) {
        if (i == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if (arr[i] <= target) {
            list.add(arr[i]);
            combine(i, arr, target - arr[i], list);
            
            if (!list.isEmpty()) {
                list.remove(list.size() - 1);
            }
        }

        combine(i + 1, arr, target, list);
    }
}