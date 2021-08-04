package com.example.mixpaneldemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MyCartMedicine.class},version = 1,exportSchema = false)
public abstract class MyCartMedicineDB extends RoomDatabase {

     private static MyCartMedicineDB myCartMedicineDB;

     private static  String DATABASE_NAME = "med_easy_database";

     public synchronized static MyCartMedicineDB getInstance(Context context){

         if (myCartMedicineDB == null){
             myCartMedicineDB = Room.databaseBuilder(context.getApplicationContext()
                     ,MyCartMedicineDB.class,DATABASE_NAME)
                     .allowMainThreadQueries()
                     .fallbackToDestructiveMigration()
                     .build();

         }
         return myCartMedicineDB;
     }

     public abstract MyCartMedicineDao cartMedicineDao();
}
