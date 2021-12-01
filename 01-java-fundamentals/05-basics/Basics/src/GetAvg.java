public class GetAvg {
    public void getAvg(int[] arr){

        int sum=0;
        for (int j : arr) sum += j;
        System.out.println("The average of the array values = " + sum/arr.length);
    }
}
