class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int carsCount = position.length;
        int[][] cars = new int[carsCount][2];
        for (int i = 0;i<carsCount;i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i]; 
        }
        Arrays.sort(cars, (a,b) -> b[0] - a[0]);
        Double minAhead = Double.MIN_VALUE;
        int fleetCount = 0;
        for (int i =0;i<carsCount;i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];
            if ( time > minAhead ) {
                minAhead= time;
                fleetCount++;
            }
        }

        return fleetCount;
    }
}
