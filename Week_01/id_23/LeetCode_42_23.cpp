class Solution {
public:
    int trap(vector<int>& height) {
        if (height.size() <= 2) {
            return 0;
        }

        int left = 0;
        int right = height.size()-1;
        int left_max = 0, right_max = 0;
        int traped = 0;

        // 代码很骚！
        while (left < right)
        {
            height[left] < height[right] ?
                (height[left] >= left_max ?
                    (left_max = height[left++]) :
                    (traped += (left_max - height[left++]))) :
                (height[right] >= right_max ?
                    (right_max = height[right--]) :
                    (traped += (right_max - height[right--])));
        }

        x = x1 > x2 ? x2 :
            x3 > x1 ? x3 : x1

            if x1 > x2 { .....}
            else if x3 > x2 { .... }

        return traped;
    }
};
