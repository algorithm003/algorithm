public class LeetCode_78_42 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> subset = new ArrayList<>();
        dfs(result, subset, nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> subset, int[] nums, int i) {
        result.add(new ArrayList<Integer>(subset));
        for (int j = i; j < nums.length; j++) {
            subset.add(nums[j]);                   // 加入
            dfs(result, subset, nums, j + 1);   // 递归
            subset.remove(subset.size() - 1);        // 移除最后一个
        }
    }


    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        result.add(new ArrayList<>());
        for (int n : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i)); // 逐个取中间结果集
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        List res = subsets(nums);
        System.out.println(res);
    }
}
