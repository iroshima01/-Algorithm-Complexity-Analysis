import java.util.Random;
public class search {

    double[][] searchTable = new double[3][10];

    public static int linearSearch(int[] flowarray, int value){
        int size = flowarray.length;
        for (int i = 0; i < size -1; i++){
            if (flowarray[i] == value){
                return  i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] flowarray, int value){
        int low = 0;
        int high = flowarray.length -1;

        while (high - low > 1){
            int mid = (high + low) / 2;
            if (flowarray[mid] < value){
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        if (flowarray[low] == value){
            return low;
        } else if (flowarray[high] == value) {
            return high;

        }
        return -1;

    }
}
