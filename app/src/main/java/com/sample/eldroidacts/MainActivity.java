package com.sample.eldroidacts;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements HeadlineListFragment.OnHeadlineSelectedListener {

    private static final String TAG = "MainActivity";

    private int[] newsImages = {
            R.drawable.earthquake,
            R.drawable.football,
            R.drawable.weather,
            R.drawable.phone,
            R.drawable.movie
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_news_content) != null) {
            Log.d(TAG, "Two-pane layout detected");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_news_content, NewsContentFragment.newInstance(0, "Select a headline", R.drawable.ic_launcher_background))
                    .commit();
        }
    }

    @Override
    public void onHeadlineSelected(int position, String content) {
        Log.d(TAG, "Headline selected: position=" + position + ", content=" + content);

        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_news_content);

        if (newsContentFragment != null) {
            Log.d(TAG, "Replacing content in two-pane layout");
            newsContentFragment = NewsContentFragment.newInstance(position, content, newsImages[position]);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_news_content, newsContentFragment)
                    .commit();
        } else {
            Log.d(TAG, "Replacing content in one-pane layout");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_headlines, NewsContentFragment.newInstance(position, content, newsImages[position]))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
