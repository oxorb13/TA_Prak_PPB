package com.example.ta_prakppb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ta_prakppb.api.DataGundam;
import com.example.ta_prakppb.api.DataMovie;

import java.util.List;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.MyViewHolder> {
    private List<DataMovie> dataUser;
    private Context mContext;

    private List<DataModel> dataGambar;

    public RecyclerViewAdapter2(List<DataMovie> dataUser, Context mContext, List<DataModel> dataGambar) {
        this.dataUser = dataUser;
        this.mContext = mContext;
        this.dataGambar = dataGambar;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new RecyclerViewAdapter2.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter2.MyViewHolder holder, int position) {
        holder.gambar.setImageResource(dataGambar.get(position).getGambar());
        holder.tittleTextView.setText(dataUser.get(position).getFilm_name());

        holder.itemView.setOnClickListener(view -> {

            Intent intent = new Intent(mContext, DetailActivity2.class);
            intent.putExtra("Nama Film = ", dataUser.get(position).getFilm_name());
            intent.putExtra("Rilis Film = ", dataUser.get(position).getFilm_release());
            intent.putExtra("Tipe Film = ", dataUser.get(position).getFilm_type());
            intent.putExtra("Timeline Film = ", dataUser.get(position).getFilm_timeline());
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return dataUser.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tittleTextView;
        ImageView gambar;
        public MyViewHolder(View view){
            super(view);
            gambar = view.findViewById(R.id.gambar);
            tittleTextView = view.findViewById(R.id.title);
        }
    }
}
