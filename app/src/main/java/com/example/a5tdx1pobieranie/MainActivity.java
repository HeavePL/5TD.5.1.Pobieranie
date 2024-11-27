package com.example.a5tdx1pobieranie;

import android.os.Bundle;
import android.os.StrictMode;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String data;
    List<Article> articleList = new ArrayList<>();
    ArticleAdapter articleAdapter;
    String url = "http://json.itmargen.com/5TP/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        articleAdapter = new ArticleAdapter(articleList);
        recyclerView.setAdapter(articleAdapter);


        try {
            String result = downloadData(url);
            JSONArray jsonArray = new JSONArray(result);
            List<Article> fetchedList = jsonToList(jsonArray);

            articleList.clear();
            articleList.addAll(fetchedList);
            articleAdapter.notifyDataSetChanged();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }






    }
    private String downloadData(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            bufferedReader.close();
            return result.toString();
        } finally {
            urlConnection.disconnect();
        }
    }


    private List<Article> jsonToList(JSONArray jsonArray){
        List<Article> list = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Article article = new Article(jsonObject);
                list.add(article);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }


        }

        return list;

    }
}