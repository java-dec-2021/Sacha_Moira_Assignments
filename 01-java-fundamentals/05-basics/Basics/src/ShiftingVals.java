public class ShiftingVals {
    public int[] shiftingVals(int[] arr){

        int temp=arr[0];
        for(short i = 1;i<arr.length;i++) arr[i-1]=arr[i];
        arr[arr.length-1]=temp;
        return arr;
    }
}
