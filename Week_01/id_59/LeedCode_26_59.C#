using System;

public class LeedCode_26
{

    public int RemoveDuplicates(int[] nums)
    {
        var noRepeatCount = 0;
        for (var i = 0; i < nums.Length; i++)
        {
            var intContain = Array.IndexOf(nums, nums[noRepeatCount]);
            if (intContain == noRepeatCount)
            {
                noRepeatCount++;
            }
            else
            {
                for (int j = noRepeatCount; j < nums.Length - 1; j++)
                {
                    nums[j] = nums[j + 1];
                }
                nums[nums.Length - 1] = nums[intContain];
            }
        }
        Console.WriteLine("产生新数组：");
        for (var i = 0; i < noRepeatCount; i++)
        {
            Console.Write($"{nums[i]},");
        }
        return noRepeatCount;
    }

}
