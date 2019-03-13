package com.mosorg.pims.app.ui.view;

import com.mosorg.pims.androidclient.R;
import com.mosorg.pims.app.common.http.reponse.HttpResponeCallBack;
import com.mosorg.pims.app.common.vo.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

public class WelcomeActivity extends Activity implements HttpResponeCallBack {
	
	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		iv = (ImageView) this.findViewById(R.id.logo);

        //实现动画
		AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimation.setDuration(2000);
        iv.startAnimation(alphaAnimation);
        
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            /**
             * 动画结束时判断是否保存有登录的信息
             * @param animation
             */
            @Override
            public void onAnimationEnd(Animation animation) {
                //暂时用用户名密码登录
                //String account = UserPreference.read(KeyConstance.IS_USER_ACCOUNT, null);//软件还没有保持账号
                //String password = UserPreference.read(KeyConstance.IS_USER_PASSWORD, null);
                //String userid = UserPreference.read(KeyConstance.IS_USER_ID, null);

            	String account = "";
            	String password = "";
            	String userid = "u1234";
            	String phone = "13927476384";
            	String email = "mwb20088@163.com";//Email
            	
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
            	
            	Intent intent = new Intent(); 
            	
            	if (TextUtils.isEmpty(user.getAccount())) {//没有保存的登录信息跳转到登录界面
                    //空的，表示没有注册，或者清除数据
            		
                    intent.setClass(WelcomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.slide_in_left, 
                    		android.R.anim.slide_out_right);
                    finish();
                } else {
                    //用保存的信息直接登录
                    //RequestApiData.getInstance().getLoginData(userAccount, userPassword,UserBaseInfo.class, WelcomeActivity.this);
                    
                	intent.setClass(WelcomeActivity.this, MainActivity.class);
                	
                	//使用intent内置的putExtra传递参数给 MainActivity
                	//实际上intent.putExtra内部也是使用Bundle
                	//intent.putExtra("account", account); 
                	
                	//使用Bundle传递参数，可以传递对象
                	Bundle bundle = new Bundle();                	 
    				bundle.putParcelable("User", user);     
    				intent.putExtras(bundle);
                	
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.slide_in_left,
                            android.R.anim.slide_out_right);
                    finish();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public void onResponeStart(String apiName) {

    }

    @Override
    public void onLoading(String apiName, long count, long current) {
        Toast.makeText(WelcomeActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(String apiName, Object object) {
    	Intent intent = new Intent();
        intent.setClass(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left,
                android.R.anim.slide_out_right);
        finish();
    }

    @Override
    public void onFailure(String apiName, Throwable t, int errorNo, String strMsg) {
        Toast.makeText(WelcomeActivity.this, "Failure", Toast.LENGTH_SHORT).show();
    }
}
