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

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
//    private List<DataModel> list;
//    private ItemClickListener clickListener;
//
//    public RecyclerViewAdapter(List<DataModel> list){
//        this.list = list;
//        this.clickListener = clickListener;
//    }

    private List<DataGundam> dataUser;
    private Context mContext;

    private List<DataModel> dataGambar;

    public RecyclerViewAdapter(List<DataGundam> dataUser, Context mContext, List<DataModel> dataGambar) {
        this.dataUser = dataUser;
        this.mContext = mContext;
        this.dataGambar = dataGambar;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.gambar.setImageResource(dataGambar.get(position).getGambar());
        holder.tittleTextView.setText(dataUser.get(position).getProduct_name());

        holder.itemView.setOnClickListener(view -> {

            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra("nama_produk = ", dataUser.get(position).getProduct_name());
            intent.putExtra("harga_produk = ", dataUser.get(position).getProduct_price());
            intent.putExtra("produk_rilis = ", dataUser.get(position).getProduct_release());
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

//    public interface ItemClickListener {
//        public void onItemClick(DataModel dataModel);
//    }
}
