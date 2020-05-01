package com.apps.panirayadi;
/*
Tgl  : 1 mei 2020
nim  : 10117144
nama : Muhamad Pani Rayadi
kelas: IF4
*/
import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {AktivisEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract AktivisDao aktivisDao();
}
