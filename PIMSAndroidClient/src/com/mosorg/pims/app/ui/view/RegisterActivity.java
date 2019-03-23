package com.mosorg.pims.app.ui.view;

import com.mosorg.pims.androidclient.R;
import com.mosorg.pims.app.common.vo.User;
import com.mosorg.pims.common.utils.Utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	
	private EditText regist_email;//邮箱
    private EditText regist_account;//账号
    private EditText regist_password;//密码
    private Button btn_submit;
    private TextView title_bar_layout_btn;
    private TextView activity_title_info;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		init();
	}
	
	/**
     * 初始化数据
     */
    private void init() {
    	//根据ID获取按钮控件对象
    	regist_email = (EditText) findViewById(R.id.input_reg_email);
    	regist_account = (EditText) findViewById(R.id.input_reg_account);
    	regist_password =  (EditText) findViewById(R.id.input_reg_password);
    	btn_submit = (Button) findViewById(R.id.btn_submit);
    	btn_submit.setText(R.string.btn_reg);
        title_bar_layout_btn = (TextView) findViewById(R.id.title_bar_layout_btn);
        title_bar_layout_btn.setText(R.string.btn_login);
        activity_title_info = (TextView) findViewById(R.id.activity_title_info);
        activity_title_info.setText(R.string.title_activity_register);
        
        //点击登录按钮
        btn_submit.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
            	
            	//根据ID从控件获取值
                String email = regist_email.getText().toString();//邮箱
                String account = regist_account.getText().toString();//账号
                String password = regist_password.getText().toString();//密码
                
                if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(password)
                        && Utils.isEmail(email)) {
                    //RequestApiData.getInstance().getLoginData(account, password, UserBaseInfo.class, LoginActivity.this);
                
                	String userid = "u1234";
                	String phone = "13927476384";
                	User user=new User();
                	user.setUserid(userid);
                	user.setAccount(account);
                	user.setPassword(password);
                	user.setPhone(phone);
                	user.setNickname("smile");
                	user.setAge(22);            	
                	user.setRole("0");
                	user.setSex("男");
                	user.setUserhead("/img/users/head/avatar.png");
                	user.setEmail(email);
                	
                	//创建意图对象
                	Intent intent = new Intent();
                	
                	//设置视图跳转关系。从LoginActivity视图跳转到MainActivity视图
                	intent.setClass(RegisterActivity.this, MainActivity.class);
                	
                	//使用Bundle传递参数，可以传递对象
                	Bundle bundle = new Bundle();                	 
    				bundle.putParcelable("User", user);     
    				intent.putExtras(bundle);
                	
    				//启动目的视图
                    startActivity(intent);
                    
                    //重载目的视图属性设置
                    overridePendingTransition(android.R.anim.slide_in_left,
                            android.R.anim.slide_out_right);
                    
                    //
                    finish();
                
                
                } else {
                	//提示Toast弹窗
                    Toast.makeText(RegisterActivity.this, "账号、密码或者邮箱不正确", Toast.LENGTH_SHORT).show();
                }
            }
        });

        title_bar_layout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                RegisterActivity.this.startActivity(intent);
                finish();
            }
        });
    }
}
