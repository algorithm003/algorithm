using System;

public class LeedCode_1_59
{
        public int[] TwoSum(int[] nums, int target)
        {
            int[] result = { 0, 0 };
            int less = 0;
            int temp = 0;
            int currentIndex = 0;
            bool isRight = false;
            foreach (var item in nums)
            {
                less++;
                for (int i = less; i < nums.Length; i++)
                {
                    temp = item + nums[i];
                    if (temp == target)
                    {
                        result[0] = less - 1;
                        result[1] = i;
                        isRight = true;
                    }
                }
                if (!isRight)
                {
                    currentIndex++;
                }
                else
                {
                    break;
                }
            }

            return result;
        }

}
