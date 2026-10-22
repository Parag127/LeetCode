class Solution {
    public List<List<Integer>> permute(int[] nums) {
     List<List<Integer>> ans = new ArrayList<>();
     List<Integer> list = new ArrayList<>();
     boolean[] freq = new boolean[nums.length];

     recurPermute(0, nums, freq, list, ans);
     return ans;   
    }
    
    static void recurPermute(int idx, int[] nums, boolean[] freq, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                list.add(nums[i]);
                recurPermute(i + 1, nums, freq, list, ans);
                list.remove(list.size() - 1);
                freq[i] = false;
            }
        }
    }
}