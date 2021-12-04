import java.util.Random;

public class PuzzleJava {
    public int[] getTenRolls(){
        Random genRand = new Random();

        //Exploring bytes which are a more appropriate range, but do not have any associated methods to accommodate the criteria.

//        byte[] randNums = new byte[10];
//        genRand.nextBytes(randNums);
//        for(byte i=0;i<randNums.length;i++){
//            if(randNums[i]<1 && i > 0){i--;}
//            else if(randNums[i]<1 && i==0){i=0;}
//            else{ System.out.println(randNums[i]); }
//        }
        int[] randNums = new int[10];
        for(byte i = 0;i<randNums.length;i++)randNums[i] = genRand.nextInt(1, 21);
        return randNums;
    }
    public char getRandomLetter(){
        //MANUALLY GENERATED ALPHABET ARRAY:
//        char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        Random ranChar = new Random();
        int i = ranChar.nextInt(25);
        //LOOP GENERATED ALPHABET ARRAY:
        char[] letters = new char[144697];
        char c='0';

        for(int j=0;j<144697;j++){
                letters[j]=c;
                c++;
        }
        return letters[i];
    }
    public String generatePassword(){
        char[] charArr = new char[50];

        for(int i = 0;i<charArr.length;i++) charArr[i]= getRandomLetter();
        return new String(charArr);
    }
    public String generatePassword2(){
        //MANUALLY GENERATED ALPHABET ARRAY:
//        String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        StringBuilder password = new StringBuilder();
        Random ranChar = new Random();
        //LOOP GENERATED ALPHABET ARRAY:
        String[] letters = new String[26];
        char[] c = {'A'};
        for(byte j=0;j<letters.length;j++){
            String s = new String(c);
            letters[j]=s;
            c[0]++;
        }
        for(byte i = 0;i<8;i++){
            int j = ranChar.nextInt(25);
            if(ranChar.nextBoolean()) {
                password.append(letters[j].toLowerCase());
            }else password.append(letters[j]);
        }
        return password.toString();
    }
    public StringBuilder[] getNewPasswordSet(int num) {
        //MANUALLY GENERATED ALPHABET ARRAY:
//        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
        StringBuilder[] words = new StringBuilder[num];
        Random ranChar = new Random();
        //LOOP GENERATED ALPHABET ARRAY:
        String[] letters = new String[26];
        char[] c = {'A'};
        for(byte j=0;j<letters.length;j++){
            String s = new String(c);
            letters[j]=s;
            c[0]++;
        }
        for (byte i = 0; i < words.length; i++) {
            StringBuilder password = new StringBuilder();
            for (byte ii = 0; ii < 8; ii++) {
                int j = ranChar.nextInt(25);
                if (ranChar.nextBoolean()) {
                    password.append(letters[j].toLowerCase());
                } else password.append(letters[j]);
            }
            words[i] = password;
        }
        return words;
    }
    public int[] shuffleArray(int[] arr){
        Random genRand = new Random();
        for(byte i = 0;i<arr.length;i++){
            int temp = arr[i];
            int r = genRand.nextInt(arr.length);
            arr[i]=arr[r];
            arr[r]=temp;
        }
        return arr;
    }
}
