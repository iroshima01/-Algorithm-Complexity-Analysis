public class sortExperiment {

    public static double[][] randomSortingExperiment(int[] flowarray){

        double[][] random = new double[3][10];
        int arrayindex = 0;

        double runningTimeSelection = 0;
        double runningTimeQuick = 0;
        double runningTimeBucket = 0;

        for (int i = 500; i < 260000; i = 2*i){

            if (i == 256000){
                i = 250000;
            }
            for (int j = 0; j < 10; j++){

                double startSelection = System.nanoTime();
                sort.selectionSort(flowarray, i);
                double endSelection = System.nanoTime();

                double startQuick = System.nanoTime();
                sort.quickSort(flowarray, i - 1, 0);
                double endQuick = System.nanoTime();

                int[] arrayForBucket = new int[i];
                System.arraycopy(flowarray, 0, arrayForBucket, 0, i);
                arrayForBucket[0]++;

                double startBubble = System.nanoTime();
                sort.bucketSort(arrayForBucket, i);
                double endBubble = System.nanoTime();

                //arrayForBubble = null;

                runningTimeSelection += endSelection - startSelection;
                runningTimeQuick += endQuick - startQuick;
                runningTimeBucket += endBubble - startBubble;


            }

            runningTimeSelection = runningTimeSelection/10000000;
            runningTimeQuick = runningTimeQuick/10000000;
            runningTimeBucket = runningTimeBucket/10000000;

            random[0][arrayindex] = runningTimeSelection;
            random[1][arrayindex] = runningTimeQuick;
            random[2][arrayindex] = runningTimeBucket;

            arrayindex++;

            runningTimeSelection = 0;
            runningTimeQuick = 0;
            runningTimeBucket = 0;
        }
        return random;
    }

    public static double[][] sortedSortingExperiment(int[] flowarray ){
        double[][] sorted = new double[3][10];
        int arrayindex = 0;

        double runningTimeSelectionSorted = 0;
        double runningTimeQuickSorted = 0;
        double runningTimeBucketSorted = 0;


        for (int i = 500; i < 260000; i = i*2){

            if (i == 256000){
                i = 250000;
            }

            int[] sortedForUsing = sort.selectionSort(flowarray, i);

            for (int j = 0; j < 10; j++){

                double startSelection = System.nanoTime();
                sort.selectionSort(sortedForUsing, i);
                double endSelection = System.nanoTime();

                double startQuick = System.nanoTime();
                sort.quickSort(sortedForUsing, i - 1, 0);
                double endQuick = System.nanoTime();

                int[] arrayForBucket = new int[i];
                System.arraycopy(sortedForUsing, 0, arrayForBucket, 0, i);
                arrayForBucket[0]++;

                double startBubble = System.nanoTime();
                sort.bucketSort(arrayForBucket, i);
                double endBubble = System.nanoTime();

                runningTimeSelectionSorted += endSelection - startSelection;
                runningTimeQuickSorted += endQuick - startQuick;
                runningTimeBucketSorted += endBubble - startBubble;

            }
            runningTimeSelectionSorted = runningTimeSelectionSorted/10000000;
            runningTimeQuickSorted = runningTimeQuickSorted/10000000;
            runningTimeBucketSorted = runningTimeBucketSorted/10000000;


            sorted[0][arrayindex] = runningTimeSelectionSorted;
            sorted[1][arrayindex] = runningTimeQuickSorted;
            sorted[2][arrayindex] = runningTimeBucketSorted;

            arrayindex++;

            runningTimeSelectionSorted = 0;
            runningTimeQuickSorted = 0;
            runningTimeBucketSorted = 0;

        }


        return sorted;
    }

    public static int[] reversing(int[] arr, int n){
        int[] reversed_ = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            reversed_[j - 1] = arr[i];
            j = j - 1;
        }
        return reversed_;
    }

    public static double[][] reversedSortingExperiment(int[] flowarray){

        double[][] reversed = new double[3][10];
        int arrayindex = 0;

        double runningTimeSelectionReversed = 0;
        double runningTimeQuickReversed = 0;
        double runningTimeBucketReversed = 0;

        for (int i = 500; i < 260000; i = i*2){

            if (i == 256000){
                i = 250000;
            }

            int[] sortedForUsing = sort.selectionSort(flowarray, i);

            int[] reversedArr = reversing(sortedForUsing, sortedForUsing.length);

            for (int j = 0; j < 10; j++){

                double startSelection = System.nanoTime();
                sort.selectionSort(reversedArr, i);
                double endSelection = System.nanoTime();

                double startQuick = System.nanoTime();
                sort.quickSort(reversedArr, i - 1, 0);
                double endQuick = System.nanoTime();

                int[] arrayForBucket = new int[i];
                System.arraycopy(reversedArr, 0, arrayForBucket, 0, i);
                arrayForBucket[0]++;

                double startBubble = System.nanoTime();
                sort.bucketSort(arrayForBucket, i);
                double endBubble = System.nanoTime();

                runningTimeSelectionReversed += endSelection - startSelection;
                runningTimeQuickReversed += endQuick - startQuick;
                runningTimeBucketReversed += endBubble - startBubble;

            }

            runningTimeSelectionReversed = runningTimeSelectionReversed/10000000;
            runningTimeQuickReversed = runningTimeQuickReversed/10000000;
            runningTimeBucketReversed = runningTimeBucketReversed/10000000;

            reversed[0][arrayindex] = runningTimeSelectionReversed;
            reversed[1][arrayindex] = runningTimeQuickReversed;
            reversed[2][arrayindex] = runningTimeBucketReversed;

            arrayindex++;

            runningTimeSelectionReversed = 0;
            runningTimeQuickReversed = 0;
            runningTimeBucketReversed = 0;

        }

        return reversed;
    }

}
