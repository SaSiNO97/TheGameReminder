package com.quintaooh.thegamereminder.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quintaooh.thegamereminder.R;

/**
 * Created by riccardo on 30/10/2018.
 */

public class HomeFragment extends GRFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.share_defeat).setOnClickListener(v -> shareDefeat());
    }

    private void shareDefeat() {
        Intent shareDefeatIntent = new Intent(Intent.ACTION_SEND);
        shareDefeatIntent.putExtra(Intent.EXTRA_TEXT, "I have lost #TheGame");
        startActivity(Intent.createChooser(shareDefeatIntent, "Share this via"));
    }
}
