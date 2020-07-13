package com.furkanozerdem.depremler.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.furkanozerdem.depremler.Model.Data;
import com.furkanozerdem.depremler.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.libraries.places.api.Places;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements OnMapReadyCallback {

    SupportMapFragment mapFragment;
    String enlem,boylam,derinlik;

    public BlankFragment() {
        // Required empty public constructor
    }

    public BlankFragment(String enlem, String boylam, String derinlik) {
        this.enlem = enlem;
        this.boylam = boylam;
        this.derinlik = derinlik;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank,container,false);
        mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.mymap);
        if(mapFragment == null){
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.mymap,mapFragment).commit();
        }


        mapFragment.getMapAsync(this);
        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng latLng = new LatLng(Double.valueOf(enlem),Double.valueOf(boylam));

        googleMap.addMarker(new MarkerOptions().position(latLng).title("Derinlik : " + derinlik + " km"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
    }
}
