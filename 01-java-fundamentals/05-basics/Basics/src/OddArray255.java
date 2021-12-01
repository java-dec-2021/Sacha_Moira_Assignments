public class OddArray255 {
    public void oddArray255(){
        short cnt=0;
        int[] arr = new int[128];

        for(short i =1;i<256;i+=2){
                arr[cnt] = i;
                System.out.println("Value at index " + cnt + " = " + arr[cnt]);
                cnt++;
        }
    }
}
