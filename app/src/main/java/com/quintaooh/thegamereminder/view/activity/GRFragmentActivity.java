package com.quintaooh.thegamereminder.view.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by riccardo on 30/10/2018.
 */

public class GRFragmentActivity extends GRActivity {
    private @IdRes
    int mContainerId;

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
    }

    public void setContainerId(int fragmentContainerId) {

        mContainerId = fragmentContainerId;
    }


    @Override
    public void onBackPressed() {
        if (mFragmentManager.getBackStackEntryCount() <= 1) {
            finish();
            return;
        }

        if (!isFinishing()) {

            mFragmentManager.popBackStack();
        }
    }

    public void switchFragment(Fragment fragment) {

        if (mContainerId == 0) {
            throw new IllegalStateException("Must call setContainerId before switchFragment");
        }

        if (!isFinishing()) {

            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.replace(mContainerId, fragment);
            transaction.addToBackStack(fragment.getClass().getSimpleName());
            transaction.commitAllowingStateLoss();
        }
    }
}
