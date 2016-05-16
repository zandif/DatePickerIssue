package net.vectortime.datepickerissue;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity.mFab != null) {
            mainActivity.mFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogFragment df = DatePickerDialogFragment.newInstance(0);
                    df.show(getFragmentManager().beginTransaction(), "Dialog Fragment");
                }
            });
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    // Dialog Fragment
    public static class DatePickerDialogFragment extends DialogFragment {
        private static final String PARCEL_KEY = "parcel_key";
        private static final String TAG = DatePickerDialogFragment.class.getSimpleName();
        @BindView(R.id.datePickerDatePicker)
        public DatePicker mDatePicker;
        @BindView(R.id.datePickerSaveButton)
        public Button mButton;

        static DatePickerDialogFragment newInstance(int num) {
            DatePickerDialogFragment f = new DatePickerDialogFragment();
            Bundle args = new Bundle();
            f.setArguments(args);
            return f;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public void onAttach(final Activity activity) {
            super.onAttach(activity);
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            if (savedInstanceState != null && savedInstanceState.containsKey(PARCEL_KEY)) {
                Log.d(TAG, "Recreating the view 0");
            }
            View v = inflater.inflate(R.layout.dialogfragment_picker, container, false);
            getDialog().setTitle("Date Picker test");
            ButterKnife.bind(this, v);

            if (savedInstanceState != null && savedInstanceState.containsKey(PARCEL_KEY)) {Log.d(TAG, "Recreating the view 1");}

            if (savedInstanceState != null && savedInstanceState.containsKey(PARCEL_KEY)) {Log.d
                    (TAG, "Recreating the view 2");}

            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int day = mDatePicker.getDayOfMonth();
                    int month = mDatePicker.getMonth();
                    int year = mDatePicker.getYear();
                    Calendar c = Calendar.getInstance();
                    c.set(year, month, day, 0, 0, 0);

                    dismiss();
                }
            });

            if (savedInstanceState != null && savedInstanceState.containsKey(PARCEL_KEY)) {Log.d
                    (TAG, "Recreating the view 3");}
            return v;
        }

    }
}
