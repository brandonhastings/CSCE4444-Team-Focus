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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diet_stats, container, false);

        GraphView dietGraph = (GraphView) view.findViewById(R.id.graphWorkout);

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(dietGraph);
        staticLabelsFormatter.setHorizontalLabels(new String[] {"S", "M", "T", "W", "Th", "F", "S"});

        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1300),
                new DataPoint(1, 1500),
                new DataPoint(2, 2100),
                new DataPoint(3, 1550),
                new DataPoint(4, 1650),
                new DataPoint(5, 1750),
                new DataPoint(6, 1800)
        });

        dietGraph.addSeries(series);
        series.setSpacing(20);
        dietGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        dietGraph.setTitle("Caloric Intake Report (Week)");

        Button backToStats = (Button) view.findViewById(R.id.bBackToStatsDiet);
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


        return view;
    }

}
