package com.example.scifit.Classes.MuscleGroupObjects;

import android.widget.ProgressBar;

public class MuscleList {
    private int mImageResource;
    private int mProgress;
    private String neckText1;
    private String neckText2;
    private String txtprogress;
    private String txtmax;
    private ProgressBar mProgressBar;
    int mMax;


    public MuscleList(int imageResource, String textneck1, String textneck2, String progresstxt, String maxtxt, int progress, int max) {
        mImageResource = imageResource;
        neckText1 = textneck1;
        neckText2 = textneck2;
        txtprogress = progresstxt;
        txtmax = maxtxt;
        mProgress = progress;
        mMax = max;
    }

    public int getProgress(){
        return mProgress;
    }
    public int getMax(){
        return mMax;
    }

    public int getImageResourceNeck() {
        return mImageResource;
    }

    public String getNeckText1() {
        return neckText1;
    }
    public String getNeckText2() {
        return neckText2;
    }
    public String getprogresstxt() {
        return txtprogress;
    }
    public String getmaxtxt() {
        return txtmax;
    }


}
