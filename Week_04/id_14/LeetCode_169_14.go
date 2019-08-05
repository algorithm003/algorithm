func majorityElement(nums []int) int {
	return majRec(nums, 0, len(nums)-1)
}

func majRec(nums []int, l, r int) int {
	if r == l {
		return nums[r]
	}
	mid := l + (r-l)/2
	mElmLeft := majRec(nums, l, mid)
	mElmRight := majRec(nums, mid+1, r)

	if checkMajority(nums, mElmLeft) {
		return mElmLeft
	}

	if checkMajority(nums, mElmRight) {
		return mElmRight
	}

	return -1
}

func checkMajority(arr []int, n int) bool {
	count := 0
	for _, v := range arr {
		if v == n {
			count++
		}

	}
	if count > len(arr)/2 {
		return true
	}
	return false
}
