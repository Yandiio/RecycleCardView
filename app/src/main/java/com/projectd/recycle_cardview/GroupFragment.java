package com.projectd.recycle_cardview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class GroupFragment extends Fragment implements View.OnClickListener {
    TextView karen,sayyid,yandi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_group_fragment,null);
        karen = (TextView) view.findViewById(R.id.textNama1);
        karen.setOnClickListener(this);
        sayyid = (TextView) view.findViewById(R.id.textNama2);
        sayyid.setOnClickListener(this);
        yandi = (TextView) view.findViewById(R.id.textNama);
        yandi.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textNama2 :
                Intent i = new Intent(getActivity(), ProfileSayyid.class);
                startActivity(i);
                break;
            case R.id.textNama :
                Intent j = new Intent(getActivity(), ProfileYandi.class);
                startActivity(j);
                break;
            case R.id.textNama1 :
                Intent k = new Intent(getActivity(),ProfileKaren.class);
                startActivity(k);
                break;
        }
    }
}
