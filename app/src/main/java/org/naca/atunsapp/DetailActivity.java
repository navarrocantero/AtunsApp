package org.naca.atunsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.naca.atunsapp.model.Album;
import org.naca.atunsapp.model.Track;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Clase detalle del album
 */
public class DetailActivity extends AppCompatActivity {

    TextView mTextViewAlbumName;
    TextView mTextViewAlbumArtist;
    ImageView mImageViewAlbumImage;
    ListView mListViewATracks;
    ArrayList<Track> mlistTracks = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(org.naca.atunsapp.R.layout.activity_detail);
        Album album = new Album();

        mTextViewAlbumName = findViewById(R.id.textView_albumName);
        mTextViewAlbumArtist = findViewById(R.id.textView_albumArtist);
        mImageViewAlbumImage = findViewById(R.id.imageView_AlbumImage);
        mListViewATracks = findViewById(R.id.list_view_tracks);

        Intent detailIntent = DetailActivity.this.getIntent();
        if (detailIntent.hasExtra("album")) {
            album = (Album) detailIntent.getSerializableExtra("album");
        }

        mTextViewAlbumName.setText(album.getName());
        mTextViewAlbumArtist.setText(album.getArtist());
        
        if (!album.getImage().equals("")) {
            Picasso.with(this).load(album.getImage()).into(mImageViewAlbumImage);
        }
        final TrackAdapter trackAdapter = new TrackAdapter(this, mlistTracks);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(getString(R.string.URL) + getString(R.string.API) + album.name,
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString,
                                          Throwable throwable) {
                        Log.e("MainActivity", "conection fail!!!");
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.d("MainActivity", "OK->Response:" + responseString);
                        Gson gson = new GsonBuilder().create();
                        Track[] tracks = gson.fromJson(responseString, Track[].class);
                        for (Track track : tracks) {
                            mlistTracks.add(track);
                        }
                        mListViewATracks.setAdapter(trackAdapter);

                    }
                });
    }
}