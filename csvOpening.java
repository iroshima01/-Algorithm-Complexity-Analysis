import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class csvOpening {

    public static int counter(String fileName) throws IOException {
        int v = 0;
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        while (file.readLine() != null) v++;
        file.close();
        return v;
    }

    public static int[] opening(String fileName) throws IOException {

        int a = counter(fileName);

        Scanner file = new Scanner(new FileReader("TrafficFlowDataset.csv"));
        String line = file.nextLine();

        int[] flowDuration = new int[a];
        int index = 0;


        while (file.hasNext()) {
            line = file.nextLine();
            flowDuration[index++] = Integer.parseInt(line.split(",")[6]);
        }

        return flowDuration;

    }
}
