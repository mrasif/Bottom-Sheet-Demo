package com.example.asif.bottomsheetdemo;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow=findViewById(R.id.btnShow);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(MainActivity.this);
                View parentView=getLayoutInflater().inflate(R.layout.dialog_bottom_sheet,null);
                bottomSheetDialog.setContentView(parentView);
                BottomSheetBehavior bottomSheetBehavior=BottomSheetBehavior.from((View)parentView.getParent());
//                bottomSheetBehavior.setPeekHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,400,getResources().getDisplayMetrics()));
                bottomSheetDialog.show();
                Button btnAddContent=parentView.findViewById(R.id.btnAddContent);
                btnAddContent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bottomSheetDialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Content Saved !", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
