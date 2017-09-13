package com.example.app1;


import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

//在SuperActivity当中加入了BoardCast
public class Login extends SuperActivity {
	
	
	//声明所要用的控件
	private Button Login;
	private ImageButton Clear;
	private AutoCompleteTextView UserNameText;
	private EditText PassWordText;
	private CheckBox showPwd;
	private SharedPreferences SP;
	private Editor ed;
	private boolean pwdDisplay = false;
	public String UserName,Password;
	
	
	//监听按键
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{	//监听返回键
		if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
			 	Intent intent = new Intent();
		        intent.setAction(SuperActivity.SYSTEM_EXIT);
		        sendBroadcast(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);
	}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        //对象的初始化
        Login=(Button)findViewById(R.id.login);
        UserNameText=(AutoCompleteTextView) findViewById(R.id.UserNameText);
        PassWordText=(EditText)findViewById(R.id.PassWordText);
        showPwd=(CheckBox)findViewById(R.id.showpwd);
        Clear=(ImageButton)findViewById(R.id.clear);
        SP= getPreferences(Activity.MODE_PRIVATE);
        ed=SP.edit();

        
        UserNameText.setText("Zhaosong");
        PassWordText.setText("1998@DanielZhu");
        
        //显示密码
        showPwd.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
			if(!pwdDisplay)  PassWordText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
			else PassWordText.setTransformationMethod(PasswordTransformationMethod.getInstance());
			pwdDisplay = !pwdDisplay;
				
			}
        	
        
        });
        
        
        //清除数据
        Clear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				UserNameText.setText("");
				PassWordText.setText("");
				
			}
		});
        
        
       
        
        
        //登录
        
        Login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				UserName=UserNameText.getText().toString();
				Password=PassWordText.getText().toString();
				
				if (((UserName.equals("a")) && (Password
						.equals("a"))||(UserName.equals("Zhaosong"))&&(Password.equals("1998@DanielZhu"))||(UserName.equals("danielzhu1201"))&&(Password.equals("DanielZhu199812"))))
				{
					Toast.makeText(getApplicationContext(), "密码正确，登陆成功！", Toast.LENGTH_SHORT).show();
					Intent i= new Intent(Login.this,Main.class);
					i.putExtra("KEY", UserName);
					startActivity(i);
					finish();
				}
				else
					if(UserName.length()!=0&&Password.length()==0)
					{
						Toast.makeText(getApplicationContext(), "请输入密码", Toast.LENGTH_LONG).show();
					}
					else
						
				{
					Toast.makeText(getApplicationContext(), "密码错误", Toast.LENGTH_LONG).show();
				}
				
			}
		});
    }
    
}
