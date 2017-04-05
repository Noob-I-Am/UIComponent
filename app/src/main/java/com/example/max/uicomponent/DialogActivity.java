package com.example.max.uicomponent;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;



public class DialogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("AlertDialog");
//        setContentView(R.layout.dialoglayout);
        LinearLayout mylayout=(LinearLayout)getLayoutInflater().inflate(R.layout.login,null);
        new AlertDialog.Builder(this).setTitle("Login").setView(mylayout).setPositiveButton("Cancel",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        }).create().show();
    }
}
