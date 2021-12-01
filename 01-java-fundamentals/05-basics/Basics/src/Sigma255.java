public class Sigma255 {
    public void sigma255(){
        int sum=0;
        int temp=0;
        for(short i = 1; i < 256; i++) {
            sum+=i;
            System.out.println(i + " plus " + temp + " = " + sum);
            temp = sum;
        }
    }
}
