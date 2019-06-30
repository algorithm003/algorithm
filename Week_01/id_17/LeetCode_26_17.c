int removeDuplicates(int* nums, int numsSize){
    
    int cnt = 1;
    
    if (nums == NULL || numsSize == 0){
        return 0;
    }
    
    for (int i = 1; i < numsSize; i++){
        if (nums[i] != nums[i - 1])     
            nums[cnt++] = nums[i];
    }
    return cnt;
}
