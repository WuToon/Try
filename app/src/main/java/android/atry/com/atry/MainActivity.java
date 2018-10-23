package android.atry.com.atry;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Button button = (Button)findViewById(R.id.login);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        //登录功能
        public void onClick(View view) {


            //loginName setOn
            String username = ((EditText)findViewById(R.id.loginName)).getText().toString();
            String password = ((EditText)findViewById(R.id.psd)).getText().toString();

            //登录逻辑判断
            if(username.equals("wuyulun")&&password.equals("2580")){
                Toast.makeText(getApplicationContext(),
                        "登录成功", Toast.LENGTH_SHORT).show();

                //intent穿梭
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);


            }
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(getApplicationContext(),"密码或账号不能为空!",Toast.LENGTH_SHORT).show();
                return;
            }

            else {
                Toast.makeText(getApplicationContext(),
                        "用户名不存在或密码错误，请重试",
                                        Toast.LENGTH_LONG).show();
            }
        }
    });

        //注册TextView点击事件
        TextView textView = (TextView)findViewById(R.id.takein);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog
                        =   new AlertDialog.Builder(MainActivity.this);

                LinearLayout linearLayout_zhuce = (LinearLayout)getLayoutInflater()
                                            .inflate(R.layout.activity_main,null);

                dialog.setTitle("新用户注册")
                        .setView(linearLayout_zhuce)
                        .setPositiveButton("确定",
                                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int whichButton) {
                        //注册处理

                        Intent intent = new Intent(MainActivity.this, SignUp.class);
                    }
                })
                        .setNegativeButton("取消",
                                    new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int whichButton) {
                        return;
                    }
                }).show();
            }
        });




    }
}
