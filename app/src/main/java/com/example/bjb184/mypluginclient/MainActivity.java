package com.example.bjb184.mypluginclient;

import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.bjb184.mypluginclient.wiegit.MyDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   private List list;
    private Button btDF;
    private AppCompatButton tvApplication;
    private MyDialogFragment myDialogFragment;
    private Mapplication instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = Mapplication.getInstance();

        AppCompatSpinner appSP = findViewById(R.id.app_sp);
        btDF = findViewById(R.id.bt_dialog_fragment);
        tvApplication = findViewById(R.id.tv_application);
        list= new ArrayList<>();
        list.add("旧表条码不一致");
        list.add("拆表读数不符");
        list.add("施工日期不符");
        list.add("其他");

        ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.simple_spinner, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        appSP.setAdapter(adapter);

        btDF.setOnClickListener(this);
        if (instance!=null)
        {
        tvApplication.setText(instance.getText());
        }
        myDialogFragment = MyDialogFragment.newInstance(true);

    }

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt_dialog_fragment:
//                showDialog(1);
                Dialog dialog = myDialogFragment.getDialog();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                myDialogFragment.show(ft, "df");

                break;
        }
    }
}
