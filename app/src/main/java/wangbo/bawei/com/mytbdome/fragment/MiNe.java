package wangbo.bawei.com.mytbdome.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import wangbo.bawei.com.mytbdome.R;
import wangbo.bawei.com.mytbdome.mine.login.LogInActivity;

/**
 * author:Created by Wangbo on 2017/12/15.
 */

public class MiNe extends Fragment {
    private View view;
    private ImageView img_tx;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.mine_main, null);
        img_tx = view.findViewById(R.id.img_tx);
        img_tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LogInActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
