package com.quintaooh.thegamereminder.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.quintaooh.thegamereminder.R;
import com.quintaooh.thegamereminder.helper.SchedulerHelper;

/**
 * Created by riccardo on 22/10/2018.
 */

public class MainActivity extends GRActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SchedulerHelper.startRemindingJob(this);
    }
}
