package ru.iete.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by iete on 19.05.15.
 */
public class ChooseFragment extends DialogFragment {

    public static final String EXTRA_CHOICE = "ru.iete.criminalintent.choise";
    public static final String CHOICE_DATE = "Set date";
    public static final String CHOICE_TIME = "Set time";

    private String mChoice;

    private final String[] mItemsList = new String[] {
            CHOICE_DATE,
            CHOICE_TIME
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity()).setTitle(R.string.chooser_title)
                .setItems(mItemsList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                mChoice = CHOICE_DATE;
                                break;
                            case 1:
                                mChoice = CHOICE_TIME;
                                break;
                        }
                        sendResult(Activity.RESULT_OK);
                    }
                })
                .show();
    }

    private void sendResult(int resultCode) {
        if (getTargetFragment() == null) return;

        Intent i = new Intent();
        i.putExtra(EXTRA_CHOICE, mChoice);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
    }
}
