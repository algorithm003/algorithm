class Solution {
public:
    string countOfAtoms(string formula) {
        map<string, int> atomCount; string res; int start = 0;
        countOfAtoms(formula, start, atomCount);
        for_each(atomCount.begin(), atomCount.end(), [&](auto &val){res += val.first + ((val.second == 1) ? string("") : to_string(val.second));});
        return res;
    }
    
    void countOfAtoms(const string &formula, int &start, map<string, int> &res) {
        if (start >= formula.size())
            return;
        
        while (formula[start] == '(') {
            map<string, int> temp;
            countOfAtoms(formula, ++start, temp);
            for_each(temp.begin(), temp.end(), [&](auto &val){res[val.first] += val.second;});
        }
        
        if (formula[start] == ')') {
            int atomCount = getAtomCount(formula, ++start);
            for_each(res.begin(), res.end(), [&](auto &val){val.second *= atomCount;});
            return;
        }
        
        string atomName = getAtomName(formula, start);
        res[atomName] += getAtomCount(formula, start);
        countOfAtoms(formula, start, res);
    }
    
    int getAtomCount(const string &formula, int &start) {
        int count = 0;
        while (start < formula.size() && formula[start] >= '0' && formula[start] <= '9') {
            count = count * 10 + (formula[start++] - '0');
        }
        return (!count) ? 1 : count;
    }
    
    string getAtomName(const string &formula, int &start) {
        string atom(formula, start++, 1);
        while (start < formula.size() && formula[start] >= 'a' && formula[start] <= 'z') {
            atom += formula[start++];
        }
        return atom;
    }
};
