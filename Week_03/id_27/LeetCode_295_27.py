from heapq import *

class MedianFinder:
    def __init__(self):
        self.small = []  # the smaller half of the list, max heap (invert min-heap)
        self.large = []  # the larger half of the list, min heap

    def addNum(self, num):
        # if len(self.small) == len(self.large):
        #     heappush(self.large, -heappushpop(self.small, -num))
        #     # print(heappushpop(self.small, -num), self.large)
        # else:
        #     heappush(self.small, -heappushpop(self.large, num))
        if len(self.small) == len(self.large):
            heappush(self.large, -heappushpop(self.small, -num))
        else:
            heappush(self.small, -heappushpop(self.large, num))
        print(self.small)
        print(self.large)

    def findMedian(self):
        if len(self.small) == len(self.large):
            return float(self.large[0] - self.small[0]) / 2.0
        else:
            return float(self.large[0])


if __name__ == "__main__":
    obj = MedianFinder()
    obj.addNum(1)
    obj.addNum(2)
    obj.addNum(3)
    print(obj.findMedian())