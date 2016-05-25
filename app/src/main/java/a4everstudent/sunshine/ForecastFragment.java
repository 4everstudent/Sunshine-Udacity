package a4everstudent.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ForecastFragment extends Fragment {


    private ArrayAdapter<String> mForecastAdapter;

    public ForecastFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Add this line in order for this fragment to handle menu events.
        setHasOptionsMenu(true);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //creates dummy data
        String[] data = {
            "Today - Mostly Sunny - 22º/12º",
            "Tomorrow - Partly Cloudy - 25º/15º",
            "Tuesday - Scattered Showers - 21º/14º",
            "Wednesday- Scattered Showers - 20º/13º",
            "Thursday - Mostly Sunny - 20º/15º",
            "Friday - Scattered Showers - 21º/15º"};

        List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));

        // Create the ArrayAdapter that will take data from a source (like our dummy forecast) and
        // use it to populate the ListView it's attached to.
        mForecastAdapter =
                new ArrayAdapter<String>(
                        getActivity(), // The current context (this activity)
                        R.layout.list_item_forecast, // The name of the layout ID.
                        R.id.list_item_forecast_textview, // The ID of the textview to populate.
                        weekForecast);

        View rootView = inflater.inflate(R.layout.fragment_main_activity, container, false);

        // Get a reference to the ListView, and attach this adapter to it.
        ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(mForecastAdapter);

        return rootView;

    }


}
