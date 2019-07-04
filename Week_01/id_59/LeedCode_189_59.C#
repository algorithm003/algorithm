using System;

public class LeedCode_189
{
    public void Rotate(int[] nums, int k)
    {
        int maxLength = nums.Length;
        int temp = 0;

        if (maxLength < k)
        {
            k = k - maxLength;
        }
        //网上所说：二分之一交换 对喔
        for (int i = 0; i < maxLength / 2; i++)
        {
            temp = nums[i];
            nums[i] = nums[maxLength - i - 1];
            nums[maxLength - i - 1] = temp;
        }
        for (int i = 0; i < (maxLength - k) / 2; i++)
        {
            temp = nums[i + k];
            nums[i + k] = nums[maxLength - i - 1];
            nums[maxLength - i - 1] = temp;
        }

        if (k - 1 > maxLength - 1)
        {
            return;
        }
        for (int i = 0; i < k / 2; i++)
        {

            temp = nums[i];
            nums[i] = nums[k - i - 1];
            nums[k - i - 1] = temp;
        }

        foreach (var item in nums)
        {
            Console.Write(item + ",");
        }
    }


    public void RotateAra(int[] nums, int k)
    {
        int maxLength = nums.Length;

        if (maxLength < k)
        {
            k = k - maxLength;
        }
        if (maxLength - 1 < k)
        {
            return;
        }
        Stack<int> preposeNum = new Stack<int>();
        for (int i = 0; i < k; i++)
        {
            preposeNum.Push(nums[maxLength - i - 1]);
        }
        for (int j = 0; j < maxLength - k; j++)
        {
            nums[maxLength - j - 1] = nums[maxLength - k - j - 1];
        }
        for (int i = 0; i < k; i++)
        {
            nums[i] = preposeNum.Pop();
        }
        foreach (var item in nums)
        {
            Console.Write(item + ",");
        }
    }
}
