package org.naca.atunsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import org.naca.atunsapp.model.Track;

import java.util.ArrayList;

/**
 * Created by navarrocantero on 11/12/2017.
 */

public class TrackAdapter extends ArrayAdapter {


    public TrackAdapter(@NonNull Context context, ArrayList<Track> arrayList) {
        super(context, 0, arrayList);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the current is empty
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_track, parent, false);
        }
        Track track = (Track) getItem(position);

        if (track != null) {
            TextView name = (TextView) convertView.findViewById(R.id.text_view_track_name);
            TextView bpm = (TextView) convertView.findViewById(R.id.text_view_track_bpm);
            RatingBar ratingBar = (RatingBar) convertView.findViewById(R.id.ratingBar);

            name.setText(track.getName());
            bpm.setText(String.format("Bpm : %s", track.getBpm()));
            try {
                if (!track.getRating().trim().equals("")) {
                    ratingBar.setRating(Float.parseFloat(track.getRating()));
                }
            } catch (NullPointerException e) {
            }
        }
        return convertView;
    }
}