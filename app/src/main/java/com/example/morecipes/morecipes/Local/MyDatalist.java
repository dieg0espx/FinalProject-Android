package com.example.morecipes.morecipes.Local;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="mydatalist")
public class MyDatalist {

    @PrimaryKey(autoGenerate = true)
    public Long id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "city")
    private String city;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

}
