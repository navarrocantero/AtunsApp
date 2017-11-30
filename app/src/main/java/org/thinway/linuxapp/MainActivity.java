package org.thinway.linuxapp;

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

import org.thinway.linuxapp.model.Distro;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView mListViewDistros;
    ArrayList<Distro> mListaDistros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListViewDistros = findViewById(R.id.list_view_distros);

        final ArrayAdapter<Distro> adapter = new ArrayAdapter<Distro>(
                this,
                R.layout.list_item_distro,
                R.id.text_view_distro,
                mListaDistros
        );

        mListViewDistros.setAdapter(adapter);

        mListViewDistros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailIntent = new Intent(
                        MainActivity.this,
                        DetailActivity.class);
                detailIntent.putExtra("distro_name", mListaDistros.get(position).name);
                detailIntent.putExtra("distro_ostype", mListaDistros.get(position).ostype);
                detailIntent.putExtra("distro_basedon", mListaDistros.get(position).basedon);
                startActivity(detailIntent);
            }
        });

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://obscure-island-13934.herokuapp.com/api/distros",
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.e("MainActivity", "ADA sucks!!!");
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.d("MainActivity", "OK->Response:"+ responseString);
                        Gson gson = new GsonBuilder().create();
                        Distro[] distros = gson.fromJson(responseString, Distro[].class);
                        adapter.clear();
                        for (Distro distro: distros){
                            adapter.add(distro);
                        }
                    }
                });
    }

    private void loadDistros(){
//        mListaDistros.add("Rajivari†");
//        mListaDistros.add("Garon Jard");
//        mListaDistros.add("Cala Brin");
//        mListaDistros.add("Ters Sendon");
//        mListaDistros.add("Nomi Sunrider");
//        mListaDistros.add("Kavar†");
//        mListaDistros.add("Zez-Kai Ell†");
//        mListaDistros.add("Vrook Lamar†");
//        mListaDistros.add("Loona Vash†");
//        mListaDistros.add("Vandar Tokare†");
//        mListaDistros.add("Dorjander Kace");
//        mListaDistros.add("Lucien Draay");
//        mListaDistros.add("Mical");
//        mListaDistros.add("Belth Allusis†");
//        mListaDistros.add("Otegω");
//        mListaDistros.add("Nikil Nobil");
//        mListaDistros.add("Wens Aleusis");
//        mListaDistros.add("Oric Traless");
//        mListaDistros.add("Giffis Fane");
//        mListaDistros.add("Syo Bakarn");
//        mListaDistros.add("Jaric Kaedan†");
//        mListaDistros.add("Bela Kiwiiks");
//        mListaDistros.add("Orgus Din†");
//        mListaDistros.add("Tol Braga");
//        mListaDistros.add("Shol Bestros");
//        mListaDistros.add("Barsen'thor");
//        mListaDistros.add("Yaddle†");
//        mListaDistros.add("Oppo Rancisis†");
//        mListaDistros.add("Omo Bouri†");
//        mListaDistros.add("Tor Difusal");
//        mListaDistros.add("Thame Cerulian†");
//        mListaDistros.add("T'un");
    }
}
