package com.quick.room_try;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.quick.room_try.Room.Mahasiswa;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.quick.room_try.Room.MyApp.db;

public class MainActivity extends AppCompatActivity {

    EditText et_nama, et_nim, et_jurusan, et_alamat;
    Button btn_input;

    Mahasiswa mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_nama = findViewById(R.id.et_nama);
        et_nim = findViewById(R.id.et_nim);
        et_jurusan =findViewById(R.id.et_jurusan);
        et_alamat = findViewById(R.id.et_alamat);
        btn_input = findViewById(R.id.btn_input);
        onInput();

    }

    private void onInput() {
        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_nama.getText().toString().isEmpty()&&
                    !et_nim.getText().toString().isEmpty()&&
                    !et_jurusan.getText().toString().isEmpty()&&
                    !et_alamat.getText().toString().isEmpty()) {

                    mahasiswa = new Mahasiswa();
                    mahasiswa.setNama(et_nama.getText().toString());
                    mahasiswa.setNim(et_nim.getText().toString());
                    mahasiswa.setAlamat(et_alamat.getText().toString());
                    mahasiswa.setKejuruan(et_jurusan.getText().toString());

                    db.userDao().insertAll(mahasiswa);
                    startActivity(new Intent(MainActivity.this, DetailAct.class));
                }else{
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}