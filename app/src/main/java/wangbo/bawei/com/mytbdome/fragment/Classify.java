package wangbo.bawei.com.mytbdome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wangbo.bawei.com.mytbdome.R;

/**
 * author:Created by Wangbo on 2017/12/15.
 */

public class Classify extends Fragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.classify_mai, null);
        return view;
    }

}
