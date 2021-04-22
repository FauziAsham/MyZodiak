package com.example.myzodiak;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ListZodiakAdapter extends RecyclerView.Adapter<ListZodiakAdapter.ListViewHolder> {

    private ArrayList<Zodiak> zodiaks;

    public ListZodiakAdapter(ArrayList<Zodiak> zodiaks) {
        this.zodiaks = zodiaks;
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_zodiak, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Zodiak zodiak = zodiaks.get(position);
        Glide.with(holder.itemView.getContext()).load(zodiak.getPhoto()).apply(new RequestOptions().override(55, 55));
        holder.ivPhoto.setImageResource(zodiak.getPhoto());
        holder.tvName.setText(zodiak.getName());
        holder.tvDetail.setText(zodiak.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onItemClickCallback.onItemClicked(listHero.get(holder.getAdapterPosition()));
                Intent intent = new Intent(holder.itemView.getContext(), detailZodiak.class);
                intent.putExtra("photo", zodiak.getPhoto());
                intent.putExtra("name", zodiak.getName());
                intent.putExtra("detail", zodiak.getDetail());

                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return zodiaks.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;
        TextView tvName, tvDetail;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.iv_zodiak);
            tvName = itemView.findViewById(R.id.tv_zodiak_name);
            tvDetail = itemView.findViewById(R.id.tv_zodiak_detail);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Zodiak data);
    }
}
