package com.example.cse110_team16_project.Database;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Upsert;

import com.example.cse110_team16_project.classes.SCLocation;

import java.util.List;

@Dao
public abstract class SCLocationDao {

    //Do not use, use Insert instead
    //chance it isn't working properly
    @Upsert
    public abstract long upsert(SCLocation scLocation);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insert(SCLocation scLocation);

    @Query("SELECT EXISTS(SELECT 1 FROM location WHERE public_code = :public_code)")
    public abstract boolean exists(String public_code);

    @Query("SELECT * FROM  location WHERE public_code = :public_code")
    public abstract SCLocation get(String public_code);

    @Query("SELECT * FROM  location WHERE public_code = :public_code")
    public abstract LiveData<SCLocation> getLive(String public_code);

    @Query("SELECT * FROM location ORDER BY public_code")
    public abstract List<SCLocation> getAll();

    @Query("SELECT public_code FROM location ORDER BY public_code")
    public abstract List<String> getAllPublicCodes();

    @Query("DELETE FROM location WHERE public_code=:public_code")
    public abstract void deleteByCode(String public_code);

    @Delete
    public abstract int delete(SCLocation scLocation);
}
