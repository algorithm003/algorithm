/**
 * @param {number[][]} M
 * @return {number}
 */
// 每个同学建一个集合，初始化每个同学为一个集合
// 双重循环遍历二维数组
// 如果M[i][j]为1且跳过重复的M[j][i]和i=j的情况
// 把有交集的合集合成一个，然后将已被合并的值赋为合并值（为了去重）
// 将数组变为Set去重，长度即为朋友圈个数
var findCircleNum = function(M) {
  let unionSet = Array(M.length).fill().map((item, index) => new Set([index]))
  for (let i = 0; i < M.length; i++) {
    for (let j = 0; j < M[i].length; j++) {
      if (M[i][j] === 1) {
        if (j <= i) continue
        let setI = unionSet[i]
        let setJ = unionSet[j]
        for (let item of setJ) {
          setI.add(item)
        }
        for (let parent of setJ) {
          unionSet[parent] = setI
        }
      }
    }
  }
  return new Set(unionSet).size
};