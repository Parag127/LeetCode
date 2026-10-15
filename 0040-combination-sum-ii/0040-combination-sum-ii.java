class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combineSum(0, candidates, target, list, ans);
        return ans;
    }

    static void combineSum(int idx, int[] arr, int target, List<Integer> list, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            list.add(arr[i]);
            combineSum(i + 1, arr, target - arr[i], list, ans);
            list.remove(list.size() - 1);
        }
    }
}