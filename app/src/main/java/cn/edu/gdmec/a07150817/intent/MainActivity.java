package cn.edu.gdmec.a07150817.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textView);
        et1 = (EditText) findViewById(R.id.url);
        et2 = (EditText) findViewById(R.id.phone);
    }
    public void xianshi(View v){
        ComponentName componentName = new ComponentName(this,IntentDemo2.class);
        Intent i1 = new Intent();
        i1.setComponent(componentName);
        startActivity(i1);
    }
    public void yinshi(View v){
        String action = "cn.edu.gdmec.littleflower";
        Intent i2 = new Intent();
        i2.setAction(action);
        startActivity(i2);
    }
    public void view(View v){
        Intent i3 = new Intent();
        //不懂
        i3.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(et1.getText().toString());
        i3.setData(uri);
        startActivity(i3);
    }
    public void dial (View v){
        //重新创建一个Intent，但这貌似是电话的什么鬼的
        Intent i3 = new Intent(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel:"+et2.getText().toString());
        i3.setData(uri);
        startActivity(i3);
    }
    public void startactivityforresult(View v){
        Bundle bundle = new Bundle();
        bundle.putString("value",et1.getText().toString());
        Intent intent = new Intent(MainActivity.this,IntentDemo2.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,10);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 10:
                Bundle bundle = data.getExtras();
                tv1.setText(bundle.getString("result"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
