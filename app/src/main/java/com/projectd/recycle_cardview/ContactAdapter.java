package com.projectd.recycle_cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private List<Contact> contactList;
    private Context ct;
    private LinearLayout ItemList;

    public ContactAdapter (List<Contact> contactList) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_name, tv_subject, tv_text;
        public ImageView iv_image;
        public LinearLayout ItemList;

        public ViewHolder(View view) {
            super(view);
            tv_name = view.findViewById(R.id.tv_name);
            tv_subject = view.findViewById(R.id.tv_subject);
            tv_text = view.findViewById(R.id.tv_text);
            iv_image = view.findViewById(R.id.iv_image);
            ItemList = itemView.findViewById(R.id.ItemList);
        }
    }

    public ContactAdapter(List<Contact> contactList, Context ct) {
        this.ct = ct;
        this.contactList = contactList;
    }

    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Contact contact = contactList.get(position);
        holder.tv_name.setText(String.valueOf(contact.getName()));
        holder.tv_subject.setText(String.valueOf(contact.getSubject()));
        holder.tv_text.setText(String.valueOf(contact.getDescription()));
        Glide.with(ct).load(contact.getImage()).apply(RequestOptions.circleCropTransform().circleCrop()).into(holder.iv_image);

        holder.ItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Email "+position+" ditekan", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }


}









