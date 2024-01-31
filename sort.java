import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class sort {

    public static int[] selectionSort(int[] flowarray, int n){

        int[] selectionSorted = new int[n];

        System.arraycopy(flowarray, 0, selectionSorted, 0, n);

        selectionSorted[0]++;

        for (int i = 0; i < n-1; i++){
            int min = i;

            for (int j = i+1; j < n; j++){
                if (selectionSorted[j] < selectionSorted[min]){
                    min = j;
                }
            }
            if (min != i){
                int temp = selectionSorted[min];
                selectionSorted[min] = selectionSorted[i];
                selectionSorted[i] = temp;
            }
        }
        return selectionSorted;
    }

    public static void quickSort(int[] flowarray, int high, int low){

        int[] quickSorted = new int[flowarray.length];

        System.arraycopy(flowarray, 0, quickSorted, 0, flowarray.length);

        quickSorted[0]++;

        int size = high - low +1;

        int[] quickarray = new int[size];
        int top = -1;

        quickarray[++top] = low;
        quickarray[++top] = high;

        while (top >= 0){
            high = quickarray[top--];
            low = quickarray[top--];
            int pivot = partition(quickSorted, high, low);
            if (pivot - 1 > low){
                quickarray[++top] = low;
                quickarray[++top] = pivot - 1;
            }
            if (pivot + 1 < high){
                quickarray[++top] = pivot + 1;
                quickarray[++top] = high;
            }
        }
    }

    public static int partition(int[] quicksorted, int high, int low){

        int pivot = quicksorted[high];
        int i = low - 1;
        for (int j  = low; j < high; j++){
            if (quicksorted[j] <= pivot){
                i = i+1;
                int temp = quicksorted[i];
                quicksorted[i] = quicksorted[j];
                quicksorted[j] = temp;
            }
        }
        int temp = quicksorted[i+1];
        quicksorted[i+1] = quicksorted[high];
        quicksorted[high] = temp;
        return i + 1;
    }

    public static int findMax(int[] flowarray) {
        int m = Integer.MIN_VALUE;
        for (int i : flowarray) {
            m = Math.max(i, m);
        }
        return m;
    }

    public static List<Integer> bucketSort(int[] flowarray, int n){

        int numberOfBuckets = (int) Math.sqrt(flowarray.length);

        List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);

        for(int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        int max = findMax(flowarray);

        for (int i : flowarray){
            buckets.get(hash(i, max, numberOfBuckets)).add(i);
        }

        Comparator<Integer> comparator = Comparator.naturalOrder();

        for(List<Integer> bucket  : buckets){
            bucket.sort(comparator);
        }

        List<Integer> sortedArray = new LinkedList<>();

        for(List<Integer> bucket  : buckets){
            for (int i: bucket){
                sortedArray.add(i);
            }
        }
        return sortedArray;
    }

    public static int hash(int i, int max, int numberOfBuckets){

        return (int) ((double) i / max * (numberOfBuckets - 1));
    }
}
