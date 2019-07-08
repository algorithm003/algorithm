# Given a chemical formula (given as a string), return the count of each atom.
#
# An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
#
# 1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.
#
# Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.
#
# A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.
#
# Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
#
# Example 1:
# Input:
# formula = "H2O"
# Output: "H2O"
# Explanation:
# The count of elements are {'H': 2, 'O': 1}.

import collections

class Solution:
    def countOfAtoms(self, formula: str) -> str:
        dic, coeff, element, stack, cnt, i = collections.defaultdict(int), 1, "", [], 0, 0

        for st in formula[::-1]:
            if st.isdigit():
                cnt += int(st) * (10 ** i)
                i += 1
            elif st == ")":
                coeff *= cnt
                stack.append(cnt)
                i = cnt = 0
            elif st == "(":
                coeff //= stack.pop()
                i = cnt = 0
            elif st.isupper():
                element += st
                dic[element[::-1]] = coeff * (cnt or 1)
                element = ""
                i = cnt = 0
            elif st.islower():
                element += st
        res = ""
        for k, v in sorted(dic.items()):
            res += k + str(v > 1 and v or "")
        return res
