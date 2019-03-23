package com.mosorg.pims.app.ui.view;

import com.mosorg.pims.androidclient.R;
import com.mosorg.pims.app.common.http.reponse.HttpResponeCallBack;
import com.mosorg.pims.app.common.utils.CircleImageView;
import com.mosorg.pims.app.common.vo.User;
import com.mosorg.pims.common.utils.Utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends Activity implements HttpResponeCallBack {
	
	private EditText loginAccount;//账号
    private EditText loginPassword;//密码
    private Button loginBtn;
    private Button registerBtn;
    private ImageView iv_head;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		init();
		
	}
	
	/**
     * 初始化数据
     */
    private void init() {
    	//根据ID获取按钮控件对象
        loginAccount = (EditText) findViewById(R.id.login_account);
        loginPassword = (EditText) findViewById(R.id.login_password);
        loginBtn = (Button) findViewById(R.id.login_btn);
        registerBtn = (Button) findViewById(R.id.register_btn);
        
        //点击登录按钮
        loginBtn.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
            	
            	//根据ID从控件获取值
                String account = loginAccount.getText().toString();//账号
                String password = loginPassword.getText().toString();//密码
                
                String email = "mwb20088@163.com";//Email
                
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
                	intent.setClass(LoginActivity.this, MainActivity.class);
                	
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
                    Toast.makeText(LoginActivity.this, "账号或者密码有误", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(intent);
                finish();
            }
        });
    }

	@Override
	public void onResponeStart(String apiName) {
		Toast.makeText(LoginActivity.this, "正在加载数据中", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onLoading(String apiName, long count, long current) {
		Toast.makeText(LoginActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onSuccess(String apiName, Object object) {
		Toast.makeText(LoginActivity.this, "登录成功!", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onFailure(String apiName, Throwable t, int errorNo, String strMsg) {
        Toast.makeText(LoginActivity.this, "登录失败!", Toast.LENGTH_SHORT).show(); 
	}
}
