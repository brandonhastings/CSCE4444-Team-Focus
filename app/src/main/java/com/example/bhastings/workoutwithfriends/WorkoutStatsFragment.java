package com.example.bhastings.workoutwithfriends;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.Series;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.PieChartView;


/**
 * A simple {@link Fragment} subclass.
 */



public class WorkoutStatsFragment extends Fragment {

    String username;
    Bundle bundle = new Bundle();


    public WorkoutStatsFragment() {
        // Required empty public constructor
    }

    float[] percentages = new float[9];
    ArrayList<String> Workouts = new ArrayList<>();
    String [] workouts = new String[9];
    //String[] Workouts = {"Default1", "Default2", "Default3", "Custom1", "Custom2", "Custom3", "Run"};

    String default1 = new String();
    String default2 = new String();
    String default3 = new String();
    String custom1 = new String();
    String custom2 = new String();
    String custom3 = new String();
    String custom4 = new String();
    String custom5 = new String();
    String run = new String();


    public void fillPercentages(float[] percentages){
        //fill percentages
        for(int i=0; i<9; i++){
            percentages[i] = (float) 1/9;
        }
    }

    public void fillWorkouts(List<String> workouts, String[] Workouts){
        //fill workouts

        default1 = "Default1";
        default2 = "Default2";
        default3 = "Default3";
        run = "Run";
        workouts.add(default1);
        workouts.add(default2);
        workouts.add(default3);
        workouts.add(run);

        custom1 = "Custom1";
        custom2 = "Custom2";
        custom3 = "Custom3";
        custom4 = "Custom4";
        custom5 = "Custom5";
        workouts.add(custom1);
        workouts.add(custom2);
        workouts.add(custom3);
        workouts.add(custom4);
        workouts.add(custom5);

        for (int i=0; i<9; i++){
            Workouts[i] = workouts.get(i);
        }
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        username = this.getArguments().getString("username");
        bundle.putString("username", username);


        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_workout_stats, container, false);

        fillWorkouts(Workouts, workouts);
        //fillPercentages(percentages);

        for(int i=0; i<9; i++){
            percentages[i] = (float) 1/9;
        }


        int[] colors = {Color.BLUE, Color.RED, Color.CYAN, Color.YELLOW, Color.GREEN, Color.GRAY, Color.MAGENTA, Color.rgb(255, 160, 0),Color.rgb(255,192,203), Color.rgb(222,184,135) };

        CategorySeries distributionSeries = new CategorySeries("Workouts");

        for(int i = 0; i < percentages.length; i++){
            distributionSeries.add(workouts[i], percentages[i]);
        }

        DefaultRenderer defaultRenderer = new DefaultRenderer();
        for(int i=0; i < percentages.length; i++) {
            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
            seriesRenderer.setColor(colors[i]);
         //   seriesRenderer.setDisplayChartValues(true);

            defaultRenderer.setBackgroundColor(Color.WHITE);
            defaultRenderer.setLabelsTextSize(30f);
            defaultRenderer.setLabelsColor(Color.BLACK);
            defaultRenderer.setLegendTextSize(25f);
            defaultRenderer.setApplyBackgroundColor(true);

            defaultRenderer.addSeriesRenderer(seriesRenderer);
        }
            defaultRenderer.setChartTitle("Workout Report (Week)");
            defaultRenderer.setChartTitleTextSize(60);
            defaultRenderer.setZoomButtonsVisible(false);
            defaultRenderer.setPanEnabled(false);

            LinearLayout chartContainer = (LinearLayout) view.findViewById(R.id.graphWorkout);
            View workoutChart = ChartFactory.getPieChartView(getContext(), distributionSeries, defaultRenderer);

            chartContainer.addView(workoutChart);

        Button bBackToStatsMenu = (Button) view.findViewById(R.id.bBackToStatsMenu);
        bBackToStatsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment vStats = new StatisticsFragment();
                vStats.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, vStats);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

            return view;
    }

}
