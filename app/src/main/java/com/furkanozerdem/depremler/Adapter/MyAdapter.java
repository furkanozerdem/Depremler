package com.furkanozerdem.depremler.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.furkanozerdem.depremler.Activities.Main2Activity;
import com.furkanozerdem.depremler.Model.Data;
import com.furkanozerdem.depremler.R;

import java.io.Serializable;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyCard> {
    ArrayList<Data> myFullData;
    ArrayList<Data> myViewData;
    Context context;

    public MyAdapter(ArrayList<Data> allData, Context context) {
      myFullData = allData;
      myViewData = new ArrayList<>();
      myViewData.addAll(myFullData);
      this.context = context;

    }

    @NonNull
    @Override
    public MyCard onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_layout,parent,false);
        return new MyCard(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyCard holder, final int position) {
        double magnitude = Double.parseDouble(myViewData.get(position).getBuyukluk()); //Büyüklük sıralaması double.
        cityText.setText(myViewData.get(position).getYer() + "  " + myViewData.get(position).getSehir());
        timeText.setText("Saat : " + myViewData.get(position).getSaat());
        magnitudeText.setText("  Büyüklük : " + myViewData.get(position).getBuyukluk());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Main2Activity.class);
                intent.putExtra("tarih", myViewData.get(position).getTarih());
                intent.putExtra("saat", myViewData.get(position).getSaat());
                intent.putExtra("enlem", myViewData.get(position).getEnlem());
                intent.putExtra("boylam", myViewData.get(position).getBoylam());
                intent.putExtra("derinlik", myViewData.get(position).getDerinlik());
                intent.putExtra("buyukluk", myViewData.get(position).getBuyukluk());
                intent.putExtra("sehir", myViewData.get(position).getSehir());
                intent.putExtra("yer", myViewData.get(position).getYer());

               context.startActivity(intent);

            }
        });

        if(magnitude <= 3) {
            myLayout.setBackgroundResource(R.color.non_danger);
        } else if (magnitude > 3 && magnitude <= 5.5) {
            myLayout.setBackgroundResource(R.color.lowerthandanger);
        }else {
            myLayout.setBackgroundResource(R.color.danger);
        }
    }
    //////////////////////// -- if this function has not been written, when scrolling on the recyclerView, data on recyclerView, that inputs 12 and its multiplies, changes randomly.
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    //////////////////////// -- didn't understand why

    @Override
    public int getItemCount() {
        return myViewData.size();
    }

    LinearLayout myLayout;
    TextView cityText, timeText, magnitudeText;

    public class MyCard extends RecyclerView.ViewHolder {


        public MyCard(@NonNull View itemView) {
            super(itemView);
            cityText = itemView.findViewById(R.id.clockText);
            timeText = itemView.findViewById(R.id.timeText);
            magnitudeText = itemView.findViewById(R.id.buyuklukText);
            myLayout = itemView.findViewById(R.id.linear_);

        }

    }
    public void setList(ArrayList<Data> newData) {
        myViewData.clear();
        myViewData.addAll(newData);

    }




}
