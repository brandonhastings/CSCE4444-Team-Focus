package com.example.bhastings.workoutwithfriends;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;


/**
 * A simple {@link Fragment} subclass.
 */
public class DietStatsFragment extends Fragment {


    public DietStatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, //when screen's view is created
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diet_stats, container, false);

        GraphView dietGraph = (GraphView) view.findViewById(R.id.graphWorkout); //declare graph

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(dietGraph); //declare label formatting variable
        staticLabelsFormatter.setHorizontalLabels(new String[] {"Snack", "Breakfast", "Lunch", "Dinner"}); //initialize x axis labels

        //declare meal variables
        int snack, breakfast, lunch, dinner;

        //assign caloric values
        snack = 1300;
        breakfast = 1500;
        lunch = 2100;
        dinner = 1550;

        //fill graph data
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, snack),
                new DataPoint(1, breakfast),
                new DataPoint(2, lunch),
                new DataPoint(3, dinner),

        });

        dietGraph.addSeries(series); //pass data to the graph
        series.setSpacing(20); //set spacing for values
        dietGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter); //render graph to screen
        dietGraph.setTitle("Caloric Intake Report (Today)"); //assign graph title

        Button backToStats = (Button) view.findViewById(R.id.bBackToStatsDiet); //when button is clicked
        backToStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment vStats = new StatisticsFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_user_area, vStats);
                fragmentTransaction.commit();
            }
        });

        //display screen
        return view;
    }

}
