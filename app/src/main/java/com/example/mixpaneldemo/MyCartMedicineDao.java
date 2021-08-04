package com.example.mixpaneldemo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MyCartMedicineDao {

    @Query("SELECT * FROM my_cart_medicine")
    List<MyCartMedicine> getAll();

    @Insert(onConflict = REPLACE)
    void insert(MyCartMedicine task);

    @Delete
    void delete(MyCartMedicine task);

    @Update
    void update(MyCartMedicine task);
}
