package com.example.ptsdetector;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Score extends AppCompatActivity {
    //public LineChart lineChart;
    public PieChart pieChart;
    private BarChart barchart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_score);

        //lineChart = findViewById(R.id.line_chart);
        pieChart = findViewById(R.id.pie_chart);
        barchart = findViewById(R.id.bar_chart);

        barchart();
       // piechart();
    }

    public void lineChart(){
        ArrayList<Entry> yValues = new ArrayList<>();
        yValues.add(new Entry(0,60f));
        yValues.add(new Entry(1,45f));
        yValues.add(new Entry(2,56f));
        yValues.add(new Entry(3,34f));
        yValues.add(new Entry(4,58f));
        yValues.add(new Entry(5,76f));
        yValues.add(new Entry(6,67f));

        LineDataSet set1 = new LineDataSet(yValues, "");

        set1.setFillAlpha(110);
        set1.setColor(Color.RED);
        set1.setLineWidth(3f);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data1 = new LineData(dataSets);
        //lineChart.setData(data1);
    }

    public void barchart(){
        //Setting up the BAR CHART
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 4f));
        barEntries.add(new BarEntry(2, 6f));
        barEntries.add(new BarEntry(3, 4.6f));
        barEntries.add(new BarEntry(4, 5f));
        barEntries.add(new BarEntry(5, 6f));
        barEntries.add(new BarEntry(6, 10f));
        barEntries.add(new BarEntry(7, 4f));
        barEntries.add(new BarEntry(8, 12f));
        barEntries.add(new BarEntry(9, 5f));
        barEntries.add(new BarEntry(10, 7f));

        BarDataSet barDataSet = new BarDataSet(barEntries, "Bar Chart");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        BarData data = new BarData(barDataSet);
        barchart.setFitBars(true);
        barchart.setData(data);
        barchart.getDescription().setText("Test Results");
        barchart.animateY(2000);
    }

    public void piechart(){

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(true);
        pieChart.setExtraOffsets(5,10,10,5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);
        pieChart.setCenterTextColor(Color.BLACK);

        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(4f, "Question 1"));
        pieEntries.add(new PieEntry(6f, "Question 2"));
        pieEntries.add(new PieEntry(4.6f, "Question 3"));
        pieEntries.add(new PieEntry(5f, "Question 4"));
        pieEntries.add(new PieEntry(6f, "Question 5"));
        pieEntries.add(new PieEntry(10f, "Question 6"));
        pieEntries.add(new PieEntry(4f, "Question 7"));
        pieEntries.add(new PieEntry(12f, "Question 8"));
        pieEntries.add(new PieEntry(5f, "Question 9"));
        pieEntries.add(new PieEntry(7f, "Question 10"));


        PieDataSet dataSet = new PieDataSet(pieEntries, "Revenue by Services");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData pieData = new PieData(dataSet);
        pieData.setValueTextSize(10f);
        pieData.setValueTextColor(Color.YELLOW);

        pieChart.setData(pieData);
    }
}