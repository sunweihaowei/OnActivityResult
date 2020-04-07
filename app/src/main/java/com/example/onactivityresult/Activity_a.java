package com.example.onactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_a extends Activity {
    public final int REQUEST_CODE_B = 1;
    public final int REQUEST_CODE_C = 2;

    private TextView tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        Button btn_b = (Button) findViewById(R.id.to_b);
        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_a.this,Activity_b.class);
                startActivityForResult(intent,REQUEST_CODE_B);//REQUEST_CODE用于辨别调用的是那个Activity
            }
        });

        Button btn_c = (Button) findViewById(R.id.to_c);
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_a.this,Activity_c.class);
                startActivityForResult(intent,REQUEST_CODE_C);//REQUEST_CODE用于辨别调用的是那个Activity
            }
        });
        tt = (TextView)findViewById(R.id.text);
    }
    /**
     * requestCode和startActivityForResult中的requestCode相对应
     * resultCode和Intent是由子Activity通过其setResult()方法返回
     * 大佬说的对（大佬不是我）
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //在文本上建值
        switch (requestCode) {
            case REQUEST_CODE_B: //返回的结果是来自于Activity B
                if (resultCode == Activity.RESULT_OK) {
                    tt.setText(data.getStringExtra("respond"));
                } else {
                    tt.setText("What?Nobody?");
                }
                break;
            case REQUEST_CODE_C: //返回的结果是来自于Activity C
                if (resultCode == Activity.RESULT_OK) {
                    tt.setText(data.getStringExtra("respond"));
                } else {
                    tt.setText("What?Nobody?");
                }
                break;
            default:
                break;
        }
    }
}



