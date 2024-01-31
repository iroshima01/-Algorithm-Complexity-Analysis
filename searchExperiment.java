import java.util.Random;

public class searchExperiment {

    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static double[][] experimentSearching(int[] flowarray){
        int index = 0;
        double runningTimeLinear = 0;
        double runningTimeBinary = 0;
        double runningTimeRandomLinear = 0;

        double[][] searchTable = new double[3][10];


        for (int i = 500; i < 260000; i = i*2){
            if (i == 256000){
                i = 250000;
            }

            int[] list = sort.selectionSort(flowarray, i);

            int[] randomList = new int[i];
            System.arraycopy(flowarray, 0, randomList, 0, i);
            randomList[0]++;

            for (int j = 0; j < 1000; j++){

                int value = getRandom(list);

                double startLinear = System.nanoTime();
                search.linearSearch(list, value);
                double endLinear = System.nanoTime();

                double startBinary = System.nanoTime();
                search.binarySearch(list, value);
                double endBinary = System.nanoTime();

                double startLinearRandom = System.nanoTime();
                search.linearSearch(randomList, value);
                double endLinearRandom = System.nanoTime();


                runningTimeLinear += endLinear - startLinear;
                runningTimeBinary += endBinary - startBinary;
                runningTimeRandomLinear += endLinearRandom - startLinearRandom;

            }


            runningTimeBinary = runningTimeBinary/1000;
            runningTimeLinear = runningTimeLinear/1000;
            runningTimeRandomLinear = runningTimeRandomLinear/1000;

            searchTable[0][index] = runningTimeRandomLinear;
            searchTable[1][index] = runningTimeLinear;
            searchTable[2][index] = runningTimeBinary;

            index++;

            runningTimeLinear = 0;
            runningTimeBinary = 0;
            runningTimeRandomLinear = 0;

        }
        return searchTable;
    }


}
