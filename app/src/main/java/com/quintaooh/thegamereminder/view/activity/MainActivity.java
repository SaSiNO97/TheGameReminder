package com.quintaooh.thegamereminder.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.quintaooh.thegamereminder.R;
import com.quintaooh.thegamereminder.helper.SchedulerHelper;
import com.quintaooh.thegamereminder.view.fragment.HomeFragment;

/**
 * Created by riccardo on 22/10/2018.
 */

public class MainActivity extends GRFragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SchedulerHelper.startRemindingJob(this);
        setContainerId(R.id.fragment_container);
        switchFragment(new HomeFragment());
    }
}
