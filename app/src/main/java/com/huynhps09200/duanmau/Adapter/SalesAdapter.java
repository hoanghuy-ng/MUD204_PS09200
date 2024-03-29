package com.huynhps09200.duanmau.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.huynhps09200.duanmau.Database.HoaDonChiTietDao;
import com.huynhps09200.duanmau.Database.SachDao;
import com.huynhps09200.duanmau.Model.HoaDonChiTiet;
import com.huynhps09200.duanmau.Model.Sach;
import com.huynhps09200.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.ViewHolder>{
    ArrayList<HoaDonChiTiet> list;
    Context context;
    HoaDonChiTietDao hoaDonChiTietDao;
    BookAdapter adapter;
    DatabaseReference mData;
    String spn;
    public SalesAdapter( Context context,ArrayList<HoaDonChiTiet> list) {
        this.list = list;
        this.context = context;
        hoaDonChiTietDao=new HoaDonChiTietDao(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View itemView=layoutInflater.inflate(R.layout.sales_lv,viewGroup,false);
        mData= FirebaseDatabase.getInstance().getReference();
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final HoaDonChiTiet hoaDonChiTiet = list.get(i);
        viewHolder.TvTensach.setText(hoaDonChiTiet.maSach);
        viewHolder.TvSL.setText("Số lượng: "+hoaDonChiTiet.soLuongMua);


    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView edit,delete;
        TextView TvTensach,TvSL;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TvTensach=itemView.findViewById(R.id.Tvtenbook);
            TvSL=itemView.findViewById(R.id.TvTenSach);
        }
    }

}

