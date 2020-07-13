package com.furkanozerdem.depremler.RetroInterface;

import com.furkanozerdem.depremler.Model.Data;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroInterface {

    @GET("api")
    Call<ArrayList<Data>> getAllData();

}
