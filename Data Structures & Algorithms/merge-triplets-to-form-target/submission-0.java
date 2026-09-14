class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        int[][] validTriplets = new int[n][3];
        int index = 0;
        for (int[] triplet: triplets) {
            if (triplet[0]<= target[0] && triplet[1]<= target[1] &&triplet[2]<= target[2]) {
                validTriplets[index++] = triplet;
            }
        }
        for (int i=0;i<3;i++) {
            boolean isPresent = false;
            for (int j=0;j<index;j++) {
                if (target[i] == validTriplets[j][i]) {
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) return false;
        }
        return true;
    }
}
