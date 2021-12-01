public class OddTo255 {
    public void oddTo255(){
        for(short i =1;i<256;i++){
            if(i%2!=0) System.out.println("Odd #: "+ i);
        }
    }
}
