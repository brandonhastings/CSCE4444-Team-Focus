package com.example.bhastings.workoutwithfriends;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.Series;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import java.util.ArrayList;
import java.util.Locale;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.PieChartView;


/**
 * A simple {@link Fragment} subclass.
 */



public class WorkoutStatsFragment extends Fragment {

  /* public void drawChart(){
        float[] percentages = {13f, 7f, 5f, 5f, 10f, 20f, 3f, 6f, 11f, 10f};
        String[] muscleGroups = {"Biceps", "Back", "Legs", "Delts", "Shoulders", "Chest", "Triceps", "Abs", "Trapezius", "Run"};

       int[] colors = {Color.BLUE, Color.RED, Color.CYAN, Color.YELLOW, Color.GREEN, Color.GRAY, Color.MAGENTA, Color.rgb(255, 160, 0, ),Color.rgb(255,192,203), Color.rgb(222,184,135) };

       CategorySeries distributionSeries = new CategorySeries("Muscle Groups");

       for(int i = 0; i < percentages.length; i++){
           distributionSeries.add(muscleGroups[i], percentages[i]);
       }

       DefaultRenderer defaultRenderer = new DefaultRenderer();
       for(int i=0; i < percentages.length; i++){
           SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
           seriesRenderer.setColor(colors[i]);
           seriesRenderer.setDisplayChartValues(true);

           defaultRenderer.setBackgroundColor(Color.WHITE);
           defaultRenderer.setLabelsTextSize(20f);
           defaultRenderer.setLegendTextSize(20f);
           defaultRenderer.setApplyBackgroundColor(true);

           defaultRenderer.addSeriesRenderer(seriesRenderer);

           defaultRenderer.setChartTitle("Workout Report (Week)");
           defaultRenderer.setChartTitleTextSize(20);
           defaultRenderer.setZoomButtonsVisible(false);

           View workoutChart = ChartFactory.getPieChartView(getContext(), distributionSeries, defaultRenderer);
       }
   }
*/


    public WorkoutStatsFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_workout_stats, container, false);

        float[] percentages = {13f, 7f, 5f, 5f, 10f, 20f, 3f, 6f, 11f, 10f};
        String[] muscleGroups = {"Biceps", "Back", "Legs", "Delts", "Shoulders", "Chest", "Triceps", "Abs", "Trapezius", "Run"};

        int[] colors = {Color.BLUE, Color.RED, Color.CYAN, Color.YELLOW, Color.GREEN, Color.GRAY, Color.MAGENTA, Color.rgb(255, 160, 0),Color.rgb(255,192,203), Color.rgb(222,184,135) };

        CategorySeries distributionSeries = new CategorySeries("Muscle Groups");

        for(int i = 0; i < percentages.length; i++){
            distributionSeries.add(muscleGroups[i], percentages[i]);
        }

        DefaultRenderer defaultRenderer = new DefaultRenderer();
        for(int i=0; i < percentages.length; i++) {
            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
            seriesRenderer.setColor(colors[i]);
            seriesRenderer.setDisplayChartValues(true);

            defaultRenderer.setBackgroundColor(Color.WHITE);
            defaultRenderer.setLabelsTextSize(30f);
            defaultRenderer.setLabelsColor(Color.BLACK);
            defaultRenderer.setLegendTextSize(28f);
            defaultRenderer.setApplyBackgroundColor(true);

            defaultRenderer.addSeriesRenderer(seriesRenderer);
        }
            defaultRenderer.setChartTitle("Workout Report (Week)");
            defaultRenderer.setChartTitleTextSize(60);
            defaultRenderer.setZoomButtonsVisible(false);

            LinearLayout chartContainer = (LinearLayout) view.findViewById(R.id.graphWorkout);
            View workoutChart = ChartFactory.getPieChartView(getContext(), distributionSeries, defaultRenderer);

            chartContainer.addView(workoutChart);


            return view;
    }

}
