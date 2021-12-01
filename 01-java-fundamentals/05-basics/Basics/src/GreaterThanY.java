public class GreaterThanY {
    public int greaterThanY(int[] arr, int y){

        short cnt=0;
        for (int j : arr) {
            if (y < j) cnt++;
        }
        return cnt;
    }
}
