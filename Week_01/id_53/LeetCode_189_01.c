void rotate(int* nums, int numsSize, int k){ 
    int i, j, p, q, t;
    if(numsSize<=1 || (k = k%numsSize) == 0) return;

    p = numsSize, q = k;
    while( (t = p % q) != 0 )
        p = q, q = t;
    
    for (p=0; p<q; p++) {
        for(i=p, t=nums[p]; (j = (numsSize+i-k) % numsSize) != p; i=j)
            nums[i] = nums[j];
        nums[i] = t; 
    }
    return;
}
