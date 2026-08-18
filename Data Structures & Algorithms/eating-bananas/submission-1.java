class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int pilesCount = piles.length;
        int maxBanana = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0;i<pilesCount;i++) {
            maxBanana = Math.max(maxBanana, piles[i]);
        }

        int start = 1;
        int end = maxBanana;
        int mid = (start+end)/2;
        while(start<=end) {   
            if (calculateHours(piles, mid) <=h) {
                end = mid-1;
                result = mid;
            } else {
                start = mid+1;
            }
            mid = (start+end)/2;
        }
        return result;
    }
    public int calculateHours(int[] piles, int k) {
        int totalHours = 0;
        for (int i=0;i<piles.length;i++) {
            totalHours += Math.ceil((double) piles[i]/k) ;
        }
        return totalHours;
    }
}
