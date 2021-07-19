package com.harry.harrypotter.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wand {
    @SerializedName("wood")
    @Expose
    public String wood;
    @SerializedName("core")
    @Expose
    public String core;
    @SerializedName("length")
    @Expose
    public String length;
}
