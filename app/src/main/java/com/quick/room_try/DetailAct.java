package com.quick.room_try;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.quick.room_try.Adapter.DetailAdapter;
import com.quick.room_try.Room.AppDatabase;
import com.quick.room_try.Room.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.quick.room_try.Room.MyApp.db;

public class DetailAct extends AppCompatActivity {
    RecyclerView rv_detail;

    DetailAdapter mAdapter;
    List<Mahasiswa> listMahasiswa = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        rv_detail = findViewById(R.id.rv_detail);

        fetchDataFromRoom();
        initRecyclerView();
        setAdapter();
    }

    private void fetchDataFromRoom() {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mahasiswa").allowMainThreadQueries().build();
        listMahasiswa = db.userDao().getAll();

        for (int i = 0; i < listMahasiswa.size(); i++) {
            Log.e("Aplikasi", listMahasiswa.get(i).getAlamat() + i);
            Log.e("Aplikasi", listMahasiswa.get(i).getKejuruan() + i);
            Log.e("Aplikasi", listMahasiswa.get(i).getNama() + i);
            Log.e("Aplikasi", listMahasiswa.get(i).getNim() + i);
        }
    }

        private void initRecyclerView() {
            rv_detail.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            rv_detail.setLayoutManager(llm);
            mAdapter =new DetailAdapter(this,listMahasiswa);
        }
    private void setAdapter() {
        rv_detail.setAdapter(mAdapter);
    }


}