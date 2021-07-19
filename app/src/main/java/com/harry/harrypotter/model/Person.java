package com.harry.harrypotter.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "characters")
public class Person {

    @PrimaryKey
    @SerializedName("name")
    @Expose
    @NonNull
    public String name;
    @SerializedName("species")
    @Expose
    public String species;
    @SerializedName("gender")
    @Expose
    public String gender;
    @SerializedName("house")
    @Expose
    public String house;
    @SerializedName("dateOfBirth")
    @Expose
    public String dateOfBirth;
    @SerializedName("yearOfBirth")
    @Expose
    public String yearOfBirth;
    @SerializedName("ancestry")
    @Expose
    public String ancestry;
    @SerializedName("eyeColour")
    @Expose
    public String eyeColour;
    @SerializedName("hairColour")
    @Expose
    public String hairColour;
    @Embedded (prefix = "wands")
    @SerializedName("wand")
    @Expose
    public Wand wand;
    @SerializedName("patronus")
    @Expose
    public String patronus;
    @SerializedName("hogwartsStudent")
    @Expose
    public Boolean hogwartsStudent;
    @SerializedName("hogwartsStaff")
    @Expose
    public Boolean hogwartsStaff;
    @SerializedName("actor")
    @Expose
    public String actor;
    @SerializedName("alive")
    @Expose
    public Boolean alive;
    @SerializedName("image")
    @Expose
    public String image;
}
