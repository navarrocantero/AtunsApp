//package org.naca.atunsapp;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//import java.util.ArrayList;
//import org.naca.atunsapp.model.Track;
//
///**
// * Created by navarrocantero on 11/12/2017.
// */
//
//public class TrackAdapter extends BaseAdapter {
//
//  private LayoutInflater inflater;
//  private ArrayList<Track> trackArrayList;
//
//  @Override
//  public int getCount() {
//    return trackArrayList.size();
//  }
//
//  @Override
//  public Object getItem(int position) {
//    return trackArrayList.get(position);
//  }
//
//  @Override
//  public long getItemId(int position) {
//    return position;
//  }
//
//  @Override
//  public View getView(int position, View convertView, ViewGroup parent) {
//    Track track = (Track) getItem(position);
//
//    if (convertView == null) {
//      convertView = inflater.inflate(R.layout.list_item_track, null);
//    }
//
//    TextView name = (TextView) convertView.findViewById(R.id.text_view_track_name);
//    TextView rating = (TextView) convertView.findViewById(R.id.text_view_track_rating);
//    TextView bpm = (TextView) convertView.findViewById(R.id.rating);
//
//    if (track != null) {
//
//      name.setText(track.getName());
//      rating.setText(track.getRating());
//      bpm.setText(track.getBpm());
//    }
//    return convertView;
//  }
//}