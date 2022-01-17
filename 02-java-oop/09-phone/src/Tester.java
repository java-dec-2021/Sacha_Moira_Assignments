public class Tester {
    public static void main(String[] args){
        Galaxy s21 = new Galaxy("s21 Ultra", 100, "AT&T", "Banana Phone",
                "Ring Ring Ring Banana Phone");
        s21.setRingTone("Jingle Bells", "Jingle Bells Jingle Bells Jingle All The Way");
        s21.displayInfo();
        System.out.printf("Current Ring: %s\n", s21.ring("Banana Phone"));
        System.out.printf("Unlock Method: %s\n", s21.unlock());
    }
}
