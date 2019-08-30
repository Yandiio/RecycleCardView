package com.projectd.recycle_cardview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private TextView mTextMessage;
    private List<Contact> contactList;
    private ContactAdapter contactAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;


    String[] Names = {"Sam", "Facebook", "Google+", "Twitter", "Pinterest Weekly", "Josh"};
    String[] Subjects = {"Weekend adventure", "James, you have 1 notification", "Top suggested Google+ pages for you",
            "Follow T-Mobile, Samsung Mobile U", "Pins you'll love", "Going lunch"};
    String[] Descriptions = {"Let's go fishing with JOhn and others. We will do...",
            "A lot has happened on Facebook since",
            "Top suggested Google+ pages for you",
            "have you seen these Pins yet? Pinterest",
            "Don't forget our lunch at 3PM in Pizza hut"};
    int[] Images = {R.drawable.name_s,
            R.drawable.name_f,
            R.drawable.name_g,
            R.drawable.name_t,
            R.drawable.name_p,
            R.drawable.name_j};




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_list_item,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        if (mRecyclerView != null) {
            mRecyclerView.setHasFixedSize(true);
        }

        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);


        contactList = new ArrayList<>();
        for (int i = 0; i < Names.length; i++) {
            Contact contact = new Contact(Names[i], Subjects[i], Descriptions[i], Images[i]);
            contactList.add(contact);
        }
        contactAdapter = new ContactAdapter(contactList);

        mRecyclerView.setAdapter(contactAdapter);
        contactAdapter.notifyDataSetChanged();
        return view;
    }
}
