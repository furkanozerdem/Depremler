package com.furkanozerdem.depremler.Activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.furkanozerdem.depremler.Adapter.MyAdapter;
import com.furkanozerdem.depremler.Model.Data;
import com.furkanozerdem.depremler.R;
import com.furkanozerdem.depremler.RetroInterface.RetroInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  {
    Retrofit retrofit;
    String BASE_URL = "https://turkiyedepremapi.herokuapp.com/";
    MyAdapter myAdapter;
    ArrayList<Data> data;
    RecyclerView myRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //-------------------------------------------------------- init
        myRecyclerView = findViewById(R.id.myRecyclerView);
        data = new ArrayList<>();
        myAdapter = new MyAdapter(data,MainActivity.this);
        myRecyclerView.setAdapter(myAdapter);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));



        //--------------------------------------------------- preparing gson and retrofit
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
   //---------------------------------------------
        ReLoad();


    }

    private void ReLoad() {
        RetroInterface retroInterface = retrofit.create(RetroInterface.class);
        Call<ArrayList<Data>> call = retroInterface.getAllData();

        call.enqueue(new Callback<ArrayList<Data>>() {
            @Override
            public void onResponse(Call<ArrayList<Data>> call, Response<ArrayList<Data>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this,"Detaylı bilgi için verilerin üzerine tıklayabilirsiniz...",Toast.LENGTH_SHORT).show();
                    final ArrayList<Data> allData = new ArrayList<>(response.body());
                    data = new ArrayList<>(allData);
                    myAdapter.setList(data);
                    myAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Data>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Lütfen internet bağlantınız olduğuna emin olun", Toast.LENGTH_LONG).show();
            }
        });

    }




}
