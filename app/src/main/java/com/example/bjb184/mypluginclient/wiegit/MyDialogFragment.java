package com.example.bjb184.mypluginclient.wiegit;


import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.bjb184.mypluginclient.R;

/*
 *
 *作者：BJB184
 *日期：18/08/09
 */public class MyDialogFragment extends DialogFragment implements View.OnClickListener {
    private static  final String NO_TITLE="noTitle";
    private static MyDialogFragment myDialogFragment;
    private boolean mNoTitle;

    public static MyDialogFragment newInstance(Boolean noTitle){
         if (myDialogFragment ==null){
             myDialogFragment=new MyDialogFragment();
         }

         Bundle bundle = new Bundle();
         bundle.putBoolean(NO_TITLE, noTitle);
         myDialogFragment.setArguments(bundle);
         return myDialogFragment;
     }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNoTitle = getArguments().getBoolean(NO_TITLE);
        setStyle(DialogFragment.STYLE_NORMAL,R.style.CustomDatePickerDialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (mNoTitle) {
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);//设置dialog没有title
        }
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.RED));
        getDialog().getWindow().setDimAmount(0.8f);//背景黑暗度
        return inflater.inflate(R.layout.simple_spinner,container,false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(android.R.id.text1).setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
/*        getDialog().setCancelable(false);
        getDialog().setCanceledOnTouchOutside(false);*/

        //注意下面这个方法会将布局的根部局忽略掉，所以需要嵌套一个布局
        Window dialogWindow = getDialog().getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.gravity = Gravity.LEFT | Gravity.TOP;//改变在屏幕中的位置,如果需要改变上下左右具体的位置，比如100dp，则需要对布局设置margin
//            Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
//            lp.width = defaultDisplay.getWidth() - 200;  //改变宽度
//            lp.height=300;//   改变高度
        dialogWindow.setAttributes(lp);

        getDialog().setCancelable(false);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {//可以在这拦截返回键啊home键啊事件
                dialog.dismiss();
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case android.R.id.text1:
                break;
        }
    }
}
