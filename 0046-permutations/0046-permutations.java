class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }

    static void recurPermute(int idx, int[] arr, List<List<Integer>> ans) {
        if (idx == arr.length) {
            List<Integer> list = new ArrayList<>();
            
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, i, idx);
            recurPermute(idx + 1, arr, ans);
            swap(arr, i, idx);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}