package org.thinway.linuxapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListViewDistros;
    ArrayList<String> mListaDistros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListViewDistros = findViewById(R.id.list_view_distros);

        loadDistros();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.list_item_distro,
                R.id.text_view_distro,
                mListaDistros
        );

        mListViewDistros.setAdapter(adapter);

        mListViewDistros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Pulsado", Toast.LENGTH_SHORT).show();
                //Intent detailIntent = new Intent(
                //        MainActivity.this,
                //        DetailActivity.class);
                //detailIntent.putExtra("candy_name", mListaJedis.get(position));
                //startActivity(detailIntent);
            }
        });

        //AsyncHttpClient client = new AsyncHttpClient();
//        client.get("https://vast-brushlands-23089.herokuapp.com/main/api",
//                new TextHttpResponseHandler() {
//                    @Override
//                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
//                        Log.e("AsyncTask", "MUERTE: " + responseString);
//                    }
//
//                    @Override
//                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
//                        Log.d("AsyncTask", "Petición OK: " + responseString);
//                        Gson gson = new GsonBuilder().create();
//                        listaCandies = gson.fromJson(responseString, Candy[].class);
//                        adapter.clear();
//                        for(Candy candy: listaCandies){
//                            adapter.add(candy.name);
//                        }
//                    }
//                });
    }

    private void loadDistros(){
        mListaDistros.add("Luke");
        mListaDistros.add("Rajivari†");
        mListaDistros.add("Garon Jard");
        mListaDistros.add("Cala Brin");
        mListaDistros.add("Ters Sendon");
        mListaDistros.add("Nomi Sunrider");
        mListaDistros.add("Kavar†");
        mListaDistros.add("Zez-Kai Ell†");
        mListaDistros.add("Vrook Lamar†");
        mListaDistros.add("Loona Vash†");
        mListaDistros.add("Vandar Tokare†");
        mListaDistros.add("Dorjander Kace");
        mListaDistros.add("Lucien Draay");
        mListaDistros.add("Mical");
        mListaDistros.add("Belth Allusis†");
        mListaDistros.add("Otegω");
        mListaDistros.add("Nikil Nobil");
        mListaDistros.add("Wens Aleusis");
        mListaDistros.add("Oric Traless");
        mListaDistros.add("Giffis Fane");
        mListaDistros.add("Syo Bakarn");
        mListaDistros.add("Jaric Kaedan†");
        mListaDistros.add("Bela Kiwiiks");
        mListaDistros.add("Orgus Din†");
        mListaDistros.add("Tol Braga");
        mListaDistros.add("Shol Bestros");
        mListaDistros.add("Barsen'thor");
        mListaDistros.add("Yaddle†");
        mListaDistros.add("Oppo Rancisis†");
        mListaDistros.add("Omo Bouri†");
        mListaDistros.add("Tor Difusal");
        mListaDistros.add("Thame Cerulian†");
        mListaDistros.add("T'un");
    }
}
