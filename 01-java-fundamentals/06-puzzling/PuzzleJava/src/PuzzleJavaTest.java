public class PuzzleJavaTest {
    public static void main(String[] args){
        PuzzleJava random = new PuzzleJava();

//        GET TEN ROLLS TEST CASE:

        int[] intArr = random.getTenRolls();

        System.out.print("Random Number Array: [");
        for (int i : intArr)  System.out.printf(" %d ", i);
        System.out.println("];");

//        GET RANDOM LETTER TEST CASE:

        System.out.printf("Random Letter = %s;\n", random.getRandomLetter());

//        GENERATE PASSWORD TEST CASE OPTION 1:

        System.out.printf("Random Password = %s;\n", random.generatePassword());

//        GENERATE PASSWORD TEST CASE OPTION 2::

        StringBuilder[] passwordArr = random.getNewPasswordSet(10);

        System.out.printf("Random Password2 = %s;\n", random.generatePassword2());

//        GET NEW PASSWORD SET TEST CASE:

        System.out.println("Random Password Array: ");
        for(byte i=0;i<passwordArr.length;i++)  System.out.printf(" %d.) %s \n", i+1, passwordArr[i]);

//        SHUFFLE ARRAY TEST CASE:

        int[] arr = {1,2,3,4,5};
        int[] shuffledArr = random.shuffleArray(arr);

        System.out.print("Initial Array: [");
        for(byte i=0;i<arr.length;i++)  System.out.printf(" %d ", i+1, arr[i]);
        System.out.println("];");

        System.out.print("Shuffled Array: [");
        for(byte i=0;i<shuffledArr.length;i++)  System.out.printf(" %d ", shuffledArr[i]);
        System.out.println("];");
    }
}
