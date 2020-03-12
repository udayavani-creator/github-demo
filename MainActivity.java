package com.example.creativeapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    String url = "https://api.myjson.com/bins/1ap29m";
    RecyclerView recyclerView;
    ProgressBar progressBar;

    CustomerAdapter adapter;

    ArrayList<Customer> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progress_circular);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getDataFromServer();
    }
    private void getDataFromServer() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) { progressBar.setVisibility(View.GONE);
                if (response != null) {
                    Log.e(TAG, "onResponse: " + response);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject data = jsonArray.getJSONObject(i);
                             arrayList.add(new Customer(data.getString("customerid"),data.getString("customername"),data.getString("customername"),new UserDetails(data.getString("userid"),data.getString("password"),data.getString("role" )),new BillingAddress(data.getString("bid"),data.getInt("houseno"),data.getString("street"),data.getString("city"),data.getString("state"),data.getInt("pincode"))))  ;
                        }
                        setAdapter();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Log.e(TAG, "onErrorResponse: " + error);
                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);

    }
    private void setAdapter() {
        Log.e(TAG, "setAdapter: " + arrayList.size());
        adapter = new CustomerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }

}


