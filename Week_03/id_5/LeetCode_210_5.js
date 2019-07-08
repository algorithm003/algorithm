/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {number[]}
 */
var findOrder = function(numCourses, prerequisites) {
  if (numCourses <= 0) {
    return [];
  }
  let adjs = new Array(numCourses);
  for (let i = 0; i < numCourses; i++) {
    adjs[i] = new Set();
  }
  for (let i = 0; i < prerequisites.length; i++) {
    adjs[prerequisites[i][1]].add(prerequisites[i][0]);
  }
  let visited = new Array(numCourses).fill(false)
  let isLoop = new Array(numCourses).fill(false)
  let stack = []
  for (let i = 0; i < numCourses; i++) {
    if (!topologicalSort(i)) return []
  }
  let index = 0
  let result = []
  while (stack.length) {
    result[index++] = stack.pop()
  }
  return result

  function topologicalSort(v) {
    if (visited[v]) return true
    if (isLoop[v]) return false
    isLoop[v] = true
    for (let u of adjs[v]) {
      if (!topologicalSort(u)) return false
    }
    visited[v] = true
    stack.push(v)
    return true
  }
};