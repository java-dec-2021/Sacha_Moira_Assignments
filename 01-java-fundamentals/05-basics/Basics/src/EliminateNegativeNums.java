public class EliminateNegativeNums {
    public int[] eliminateNegs(int[] arr){

        for(short i =0;i<arr.length;i++){
            if(arr[i]<0)arr[i]=0;
        }
        return arr;
    }
}
