package ru.iete.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by iete on 17.05.15.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
