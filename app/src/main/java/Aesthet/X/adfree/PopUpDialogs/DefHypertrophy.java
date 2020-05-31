package Aesthet.X.adfree.PopUpDialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.scifit.R;

class DefHypertrophy extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogCustom);
        builder.setTitle(getString(R.string.hypertrophy))
                .setMessage(getString(R.string.hypertrophy2));
        return builder.create();
    }
}
