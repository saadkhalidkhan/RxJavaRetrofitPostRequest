package com.example.saadkhan.retrofitrxjava;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Saad Khan on 20/03/2018.
 */

public class PGCModel {

    @SerializedName("Code")
    @Expose
    private int Code;
    @SerializedName("Message")
    @Expose
    private String Message;

    public int getCode() { return this.Code; }

    public String getMessage() { return this.Message; }

}
