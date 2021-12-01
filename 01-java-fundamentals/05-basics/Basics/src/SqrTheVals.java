public class SqrTheVals {
    public void sqrTheVals(int[] arr){

        for(short i =0;i<arr.length;i++){
            int temp=arr[i];
            arr[i] *= arr[i];
            System.out.println("Value squared value of " + arr[i]/temp + " = " + arr[i]);
        }
    }
}
