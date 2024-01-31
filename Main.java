import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

public class Main {
    public static void main(String[] args) throws IOException {
        //csvOpening obj = new csvOpening();

        int[] obj = csvOpening.opening("TrafficFlowDataset.csv");

        double[][] random = sortExperiment.randomSortingExperiment(obj);
        double[][] sorted = sortExperiment.sortedSortingExperiment(obj);
        double[][] reversed = sortExperiment.reversedSortingExperiment(obj);
        double[][] search = searchExperiment.experimentSearching(obj);



       // X axis data
        int[] xAxis = {500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 250000};


        showAndSaveChart("Test on Random Input", xAxis, random);
        showAndSaveChart("Test on Sorted Input", xAxis, sorted);
        showAndSaveChart("Test on Reversed Input", xAxis, reversed);
        showAndSaveChart("Searching Test Analysis", xAxis, reversed);




    }
    public static void showAndSaveChart(String title, int[] xAxis, double[][] yAxis) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle("Time in Milliseconds").xAxisTitle("Input Size").build();

        // Convert x axis to double[]
        double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add a plot for a sorting algorithm
        chart.addSeries("selection", doubleX, yAxis[0]);
        chart.addSeries("quick", doubleX, yAxis[1]);
        chart.addSeries("bucket", doubleX, yAxis[2]);

        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);

        // Show the chart
        new SwingWrapper(chart).displayChart();
    }
}

