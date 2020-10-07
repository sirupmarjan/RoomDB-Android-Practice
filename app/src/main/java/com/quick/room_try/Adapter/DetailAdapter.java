package com.quick.room_try.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quick.room_try.MainActivity;
import com.quick.room_try.R;
import com.quick.room_try.Room.Mahasiswa;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {
    private List<Mahasiswa> dataList;
    private Context mContext;


    public DetailAdapter(Context mContext, List<Mahasiswa> dataList){
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mahasiswa data = dataList.get(position);
        holder.nNama.setText(data.getNama());
        holder.nNim.setText(data.getNim());
        holder.nJurusan.setText(data.getKejuruan());
        holder.nAlamat.setText(data.getAlamat());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nNama,nNim,nJurusan,nAlamat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nNama = itemView.findViewById(R.id.tv_nama);
            nNim = itemView.findViewById(R.id.tv_nim);
            nJurusan = itemView.findViewById(R.id.tv_jurusan);
            nAlamat = itemView.findViewById(R.id.tv_alamat);
        }
    }
}
