public class MaxMinAvg {
    public int[] maxMinAvg(int[] arr){

        int[] minMaxAvgArr = new int[3];
        minMaxAvgArr[1]=arr[0];

        for (int j : arr) {
            if (minMaxAvgArr[0] < j) minMaxAvgArr[0] = j;
            if (minMaxAvgArr[1] > j) minMaxAvgArr[1] = j;
            minMaxAvgArr[2] += j;
        }
        minMaxAvgArr[2]= minMaxAvgArr[2]/=arr.length;
        return minMaxAvgArr;
    }
}
