package com.apps.panirayadi;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room

import java.util.ArrayList;
import java.util.List;

/*
Tgl  : 1 mei 2020
nim  : 10117144
nama : Muhamad Pani Rayadi
kelas: IF4
 */

public class MainActivity extends AppCompatActivity {

    private AktivisEntity aktivisEntity;
    public static AppDatabase db;


    List<AktivisEntity> aktivisEntities = new ArrayList<>();
    List<AktivisEntity> aktivisEntityListByZone = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"aktivis")
                .allowMainThreadQueries().build();


        aktivisEntity = new AktivisEntity();
        aktivisEntity.setNamaAktivis("Novita Sari");
        aktivisEntity.setEmailAktivis("novi@gmail.com");
        aktivisEntity.setZonaTugas("Jakarta");

        Log.d("TAMBAH","Tambah Data Aktivis");
        Log.d("TAMBAH","===================");
        Log.d("TAMBAH","Nama : "+aktivisEntity.getNamaAktivis());
        Log.d("TAMBAH","Email : "+aktivisEntity.getEmailAktivis());
        Log.d("TAMBAH","Zona : "+aktivisEntity.getZonaTugas());

        db.aktivisDao().tambahAktivis(aktivisEntity);


        Log.d("TAMPIL","Tampil seluruh data aktivis");
        Log.d("TAMPIL","===========================");

        aktivisEntities = db.aktivisDao().tampilSeluruhAktivis();

        for (int i = 0; i<aktivisEntities.size(); i++){

            Log.d("TAMPIL","Data Ke-"+(i+1));
            Log.d("TAMPIL","Nama : "+aktivisEntities.get(i).getNamaAktivis());
            Log.d("TAMPIL","Email : "+aktivisEntities.get(i).getEmailAktivis());
            Log.d("TAMPIL","Zona : "+aktivisEntities.get(i).getZonaTugas());
            Log.d("TAMPIL","========================");
        }


        Log.e("ZONE","Data Aktivis berdasarkan Zona");
        Log.e("ZONE","===================");
        aktivisEntityListByZone = db.aktivisDao().findByZone("Jakarta");
        for (int i = 0 ;i <aktivisEntityListByZone.size();i++){
            Log.e("ZONE","Data Aktivis Ke-"+(i+1));
            Log.e("ZONE",aktivisEntityListByZone.get(i).getNamaAktivis());
            Log.e("ZONE",aktivisEntityListByZone.get(i).getEmailAktivis());
            Log.e("ZONE",aktivisEntityListByZone.get(i).getZonaTugas());
            Log.e("ZONE","===================");
        }

    }
}