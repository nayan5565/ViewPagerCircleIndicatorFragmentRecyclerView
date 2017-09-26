package com.nayan.candyparty;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by developer on 9/24/2017.
 */

public class FragmentOnbording3 extends Fragment {
    @Nullable
    public static FragmentOnbording newInstance() {
        return new FragmentOnbording();
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.on_bording_1, container, false);
        return view;
    }
}
