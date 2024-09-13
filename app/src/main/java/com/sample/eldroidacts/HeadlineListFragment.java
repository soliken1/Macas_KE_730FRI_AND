package com.sample.eldroidacts;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.ListFragment;
import android.view.View;
import android.widget.ListView;

public class HeadlineListFragment extends ListFragment {

    private OnHeadlineSelectedListener callback;

    public interface OnHeadlineSelectedListener {
        void onHeadlineSelected(int position);
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
    public void onListItemClick(ListView l, View v, int position, long id) {
        callback.onHeadlineSelected(position);
    }
}