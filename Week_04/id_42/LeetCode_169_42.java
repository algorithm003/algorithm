public class LeetCode_169_42 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int num : nums) { // 统计每个元素出现的次数
            Integer count = map.get(num);
            count = count == null ? 1 : ++count;
            map.put(num, count);
            if (map.get(num) > len / 2) return num;
        }
        return 0;
    }

    @Test
    public void test() {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
