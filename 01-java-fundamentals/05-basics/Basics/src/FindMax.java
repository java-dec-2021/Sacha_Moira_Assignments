public class FindMax {
    public void findMax(int [] arr){

        int isMax=0;
        for (int j : arr) if (j > isMax) isMax = j;
        System.out.println("The max value in the array = " + isMax);
    }
}
