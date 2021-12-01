public class BasicTest {
    public static void main(String[] args) {
        BasicPrintTo255 print1To255 = new BasicPrintTo255();
//        print1To255.to255();

        OddTo255 odd255 = new OddTo255();
//        odd255.oddTo255();

        Sigma255 sum255 = new Sigma255();
//        sum255.sigma255();

        IteratingArray iteratedValues = new IteratingArray();
//        iteratedValues.iteratingArray();

        FindMax isMax = new FindMax();
        int [] arr1 = {1,-2,-5,-100,-27};
//        isMax.findMax(arr1);

        OddArray255 arr = new OddArray255();
//        arr.oddArray255();

        GetAvg arrAvg = new GetAvg();
        int [] arr2 = {100, 100, 100, 100, 0};
//        arrAvg.getAvg(arr2);

        GreaterThanY isY = new GreaterThanY();
        int [] arr3 = {100, 23, 100, 3, 40};
//        System.out.println(isY.greaterThanY(arr3, 33));

        SqrTheVals sqrVal = new SqrTheVals();
        int [] arr4 = {100, 23, 100, 3, 40};
//        sqrVal.sqrTheVals(arr4);

        EliminateNegativeNums posArr = new EliminateNegativeNums();
        int [] arr5 = {100, -23, 100, 3, -40};
//        arr5=posArr.eliminateNegs(arr5);
//        for(short i =0;i<arr5.length;i++) System.out.println(arr5[i]);

        MaxMinAvg mMAArray = new MaxMinAvg();
        int [] arr6 = {100, 23, 101, 3, 40};
//        int[] maxMinAvgArr = mMAArray.maxMinAvg(arr6);
//        for(short i =0;i<maxMinAvgArr.length;i++) System.out.println(maxMinAvgArr[i]);

        ShiftingVals shifty = new ShiftingVals();
        int [] arr7 = {1, 2, 3, 4, 5};
//        int[] shiftedArr = shifty.shiftingVals(arr7);
//        for(short i =0;i<shiftedArr.length;i++) System.out.println(shiftedArr[i]);
    }

}
