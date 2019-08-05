func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)

	j, count := 0, 0
	for i := 0; i < len(g); i++ {
		for j < len(s) && s[j] < g[i] {
			j++
		}
		if j >= len(s) {
			break
		} else {
			count++
			j++
		}
	}
	return count
}



