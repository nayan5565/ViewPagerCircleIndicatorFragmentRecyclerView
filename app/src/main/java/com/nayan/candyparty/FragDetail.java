package com.nayan.candyparty;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by developer on 9/25/2017.
 */

public class FragDetail extends Fragment {
    TextView txtDetails;
    private static FragDetail instance;
    @Nullable
    public static FragDetail newInstance() {
        instance=new FragDetail();
        return instance;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_details, container, false);
        txtDetails=(TextView)view.findViewById(R.id.txtDeatils);
        txtDetails.setText(MainActivity.getInstance().productArrayList.get(Utils.pos).getDetail());
        return view;
    }
}
