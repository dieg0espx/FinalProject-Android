package com.example.morecipes.morecipes.Local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//En esta clase estamos agregando el método Insertar, Seleccionar, Eliminar y Actualizar
    @Dao
    public interface MyDao  {
        @Insert
        void addData(MyDatalist mydatalist);

        @Query("select * from mydatalist WHERE name LIKE :name")
        List<MyDatalist>getMyData(String name);

        @Delete
        void delete(MyDatalist mydatalist);

        @Update
        void update(MyDatalist mydatalist);

}
