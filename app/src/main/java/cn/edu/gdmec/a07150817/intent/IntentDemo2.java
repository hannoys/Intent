package cn.edu.gdmec.a07150817.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IntentDemo2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_demo2);
    }
    public void upper(View v){
        //获取传过来的信使？
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final String value = bundle.getString("value").toUpperCase();
        //通过信使返回转换后的String给mainactivity
        Intent intentresult = new Intent();
        intentresult.putExtra("result",value);
        setResult(RESULT_OK,intentresult);
        finish();
    }
}
