class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int result = 0;
        int n = cost.length;
        int i =0;
        int totalGas = 0;
        int totalCost = 0;

        for (int j=0;j<n;j++) {
            totalGas+=gas[j];
            totalCost+=cost[j];
        }
        if (totalCost>totalGas) return -1;
        while (i<n) {
            total+= gas[i] - cost[i];
            if (total<0) {
                total = 0;
                result = i+1;
            }
            i++;
        }
        return result;
    }
}
