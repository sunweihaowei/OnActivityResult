package com.example.onactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_c extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        Button btn = (Button) findViewById(R.id.c_back_a);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("respond", "Hello,Alice!I'm Cathy.");
                // 设置返回码和返回携带的数据
                setResult(Activity.RESULT_OK, intent);
                //RESULT_OK就是一个默认值，=-1，它说OK就OK吧
                finish();
            }
        });
    }
}
