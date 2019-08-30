package com.projectd.recycle_cardview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.projectd.recycle_cardview.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProfileYandi extends AppCompatActivity implements View.OnClickListener {
    Button gmail, facebook, website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gmail = (Button) findViewById(R.id.gmail);
        gmail.setOnClickListener(this);
        facebook = (Button) findViewById(R.id.btn_facebook);
        facebook.setOnClickListener(this);
        website = (Button) findViewById(R.id.btn_portfolio);
        website.setOnClickListener(this);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ini Pake SnackBar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //no inspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gmail:
                Intent in = new Intent(Intent.ACTION_VIEW)
                        .setType("plain/text")
                        .setData(Uri.parse("yandifenanda95@gmail.com"))
                        .setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail")
                        .putExtra(Intent.EXTRA_EMAIL,new String[]{"yandifenanda95@gmail.com"})
                        .putExtra(Intent.EXTRA_SUBJECT,"Current Work")
                        .putExtra(Intent.EXTRA_TEXT, "Hi Yandi,i'm really impressed with your works.What a nice layout it was.");
                startActivity(in);
                break;
            case R.id.btn_facebook :
                Intent fb = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.facebook.com/Pfc.Yandi"));
                startActivity(fb);
                break;
            case R.id.btn_portfolio :
                Intent portfolio = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://yandiio.space"));
                startActivity(portfolio);
                break;
        }
    }
}
