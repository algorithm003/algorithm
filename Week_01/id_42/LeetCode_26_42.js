/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
    let count = 0
    let pre = -1
    for (let i = 0, len = nums.length; i < len; i++) {
        let num = nums[i]
        if (num === nums[i + 1]) {
            if (pre !== num) {
                count++
                pre = num
            }
        } else if (num !== pre) {
            count++
        }
    }
    return count;
};