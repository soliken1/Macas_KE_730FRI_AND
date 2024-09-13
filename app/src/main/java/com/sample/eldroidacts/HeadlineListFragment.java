package com.sample.eldroidacts;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ListView;
import androidx.fragment.app.ListFragment;

public class HeadlineListFragment extends ListFragment {

    private OnHeadlineSelectedListener callback;

    // Sample headlines and news content
    private String[] headlines = {
            "Headline 1: Breaking News",
            "Headline 2: Sports Update",
            "Headline 3: Weather Alert",
            "Headline 4: Technology News",
            "Headline 5: Entertainment"
    };

    private String[] newsContent = {
            "Breaking News Content: A massive earthquake has struck the city of San Francisco. Early reports suggest the magnitude of the quake was 7.8 on the Richter scale, causing widespread damage to buildings, roads, and infrastructure. Rescue teams are working around the clock to provide aid and support to those affected.",

            "Sports Update Content: The national football team secured a thrilling 3-2 victory over their arch-rivals in the World Cup semi-finals. In an intense match that went into extra time, the winning goal came from a stunning free kick in the final moments. Fans around the country are celebrating the historic win.",

            "Weather Alert Content: A category 4 hurricane is making its way toward the eastern coastline, bringing with it torrential rain and wind speeds of up to 150 mph. Authorities have issued mandatory evacuation orders for coastal areas, warning residents to take immediate action to ensure their safety.",

            "Technology News Content: Tech giant InnovateX has unveiled its latest flagship smartphone, the 'XPhone Z,' which features an advanced AI-powered camera system, a foldable display, and a new biometric authentication system. The device is expected to revolutionize the smartphone industry and set new standards for mobile technology.",

            "Entertainment Content: The much-anticipated sequel to the blockbuster hit 'Galactic Odyssey' has finally hit theaters, and it's already breaking box office records. Critics are praising the film's stunning visual effects, gripping storyline, and standout performances from the all-star cast. Fans can’t get enough of the action-packed space adventure."
    };

    private int[] newsImages = {
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background
    };


    public interface OnHeadlineSelectedListener {
        void onHeadlineSelected(int position, String newsContent);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (OnHeadlineSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Set up the list of headlines using an ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, headlines);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Send the selected headline position and corresponding news content to the activity
        callback.onHeadlineSelected(position, newsContent[position]);
    }
}
