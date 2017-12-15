package org.naca.atunsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.naca.atunsapp.model.Album;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

  ListView mListViewAlbums;
  ArrayList<Album> mlistAlbums = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(org.naca.atunsapp.R.layout.activity_main);

    mListViewAlbums = findViewById(org.naca.atunsapp.R.id.list_view_albums);

    final ArrayAdapter<Album> adapter = new ArrayAdapter<Album>(
        this,
        org.naca.atunsapp.R.layout.list_item_album,
        org.naca.atunsapp.R.id.text_view_album,
        mlistAlbums
    );
    mListViewAlbums.setAdapter(adapter);

    mListViewAlbums.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent detailIntent = new Intent(
            MainActivity.this,
            DetailActivity.class);
        detailIntent.putExtra("album", mlistAlbums.get(position));
        startActivity(detailIntent);
      }
    });

    AsyncHttpClient client = new AsyncHttpClient();
    client.get(getString(R.string.URL)+ getString(R.string.API),
        new TextHttpResponseHandler() {
          @Override
          public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            Log.e("MainActivity", "conection fail!!!");
          }

          @Override
          public void onSuccess(int statusCode, Header[] headers, String responseString) {
            Log.d("MainActivity", "OK->Response:"+ responseString);
            Gson gson = new GsonBuilder().create();
            Album[] albums = gson.fromJson(responseString, Album[].class);
            adapter.clear();
            for (Album album: albums){
              adapter.add(album);
            }
          }
        });
  }
}