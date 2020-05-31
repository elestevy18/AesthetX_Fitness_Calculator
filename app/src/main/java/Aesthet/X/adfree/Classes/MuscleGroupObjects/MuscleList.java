package Aesthet.X.adfree.Classes.MuscleGroupObjects;

import android.widget.ProgressBar;

public class MuscleList {
    private final int mImageResource;
    private final int mProgress;
    private final String neckText1;
    private final String neckText2;
    private final String txtprogress;
    private final String txtmax;
    private ProgressBar mProgressBar;
    private final int mMax;


    public MuscleList(int imageResource, String textneck1, String textneck2, String progresstxt, String maxtxt, int progress, int max) {
        mImageResource = imageResource;
        neckText1 = textneck1;
        neckText2 = textneck2;
        txtprogress = progresstxt;
        txtmax = maxtxt;
        mProgress = progress;
        mMax = max;
    }

    public int getProgress() {
        return mProgress;
    }

    public int getMax() {
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
