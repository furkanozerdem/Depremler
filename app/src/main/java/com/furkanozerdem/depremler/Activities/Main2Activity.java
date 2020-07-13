package com.furkanozerdem.depremler.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.furkanozerdem.depremler.Fragments.BlankFragment;
import com.furkanozerdem.depremler.Model.Data;
import com.furkanozerdem.depremler.R;

public class Main2Activity extends AppCompatActivity {
    TextView dateText, buyuklukText, timeText, locationText;
    FrameLayout frameLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String tarih = getIntent().getStringExtra("tarih");
        String buyukluk = getIntent().getStringExtra("buyukluk");
        String saat = getIntent().getStringExtra("saat");
        String yer= getIntent().getStringExtra("yer");
        String sehir= getIntent().getStringExtra("sehir");
        String enlem= getIntent().getStringExtra("enlem");
        String boylam = getIntent().getStringExtra("boylam");
        String derinlik= getIntent().getStringExtra("derinlik");
        frameLayout = findViewById(R.id.frameLayout);



        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frameLayout,new BlankFragment(enlem,boylam,derinlik));
        ft.commit();


        if(sehir.equals("")) {
            sehir="-";
        }

        dateText=findViewById(R.id.dateText);
        buyuklukText = findViewById(R.id.buyuklukText);
        timeText=findViewById(R.id.clockText);
        locationText=findViewById(R.id.locationText);


        dateText.setText("Tarih : " + tarih);
        buyuklukText.setText("Büyüklük : " + buyukluk);
        timeText.setText("Saat : " + saat);
        locationText.setText( yer + " / "+ sehir);

    }
}
