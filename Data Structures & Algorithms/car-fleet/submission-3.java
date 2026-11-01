class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        double[][] cars = new double[n][2]; 

        for(int i=0;i<n;i++){
            cars[i][0]=position[i];
            cars[i][1]= (double)(target - position[i])/speed[i];
        }

        Arrays.sort(cars, (a,b) -> Double.compare(b[0],a[0]));

        int count=0;
        double prevCars=0;
        for(double[] c : cars){
            if(c[1]>prevCars){
                count++;
                prevCars=c[1];
            }
        }
        return count;
    }
}
