package com.AesthetX.aesthetx.PopUpDialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.scifit.R;

public class DashPMGDialog extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogCustom);
        builder.setMessage(getString(R.string.pmgdash));
        return builder.create();
    }
}
