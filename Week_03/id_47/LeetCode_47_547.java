class Solution {
    public int findCircleNum(int[][] M) {
        final int iPersionCount = M.length;
        boolean[] bCheckedPersionArray = new boolean[iPersionCount];
        int iCircleNum = 0;
        
        for(int i = 0 ; i < iPersionCount ; i++) {
            if(!bCheckedPersionArray[i]) {
                iCircleNum++;
                dfsCheck(M, i, bCheckedPersionArray);
            }
        }
        
        return iCircleNum;
    }
    
    private void dfsCheck(int[][] M, int i, boolean[] bCheckedPersionArray) {
        bCheckedPersionArray[i] = ture;
        
        final int iPersionCount = M.length;
        for(int j = 0 ; j < iPersionCount ; j++) {
            if(!bCheckedPersionArray[j] && M[i][j] == 1){
                dfsCheck(M, j, bCheckedPersionArray);
            }
        }
    }
}