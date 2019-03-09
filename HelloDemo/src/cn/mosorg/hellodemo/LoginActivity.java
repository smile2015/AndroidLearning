package cn.mosorg.hellodemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.mosorg.hellodemo.common.LogUtil;
import cn.mosorg.hellodemo.service.foundPassWord;
import cn.mosorg.hellodemo.service.loginMsg;

public class LoginActivity extends Activity implements OnClickListener  {
	//声明变量
	private Handler mHandler;
	EditText account;
	EditText password;
	private Button loginButton ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		account =(EditText) findViewById(R.id.loginAccount_id);
	      password=(EditText) findViewById(R.id.password_id);
	      loginButton=(Button) findViewById(R.id.login);
	     // 对登录按钮设置监听，方法由下面的Onclick实现
	      loginButton.setOnClickListener(this);
	}
	@Override
    /**
     * 实现登录按钮的跳转
     */
    public void onClick(View v) {
      // 根据id判断单击的是哪个控件，固定写法
      switch (v.getId()) {
      case R.id.login:
        login();
        break;
      default:
        break;
      }
    }
	
	/**
     * 登录方法
     */
    public boolean login() {
      if (isUserNameAndPwdValid()) {    	  
    	  mHandler=new Handler(){
          public void handleMessage(Message msg){
        	  
        	  switch(msg.what){
        	  case -1:
        		  Toast.makeText(LoginActivity.this,"服务器连接失败!",
                  Toast.LENGTH_SHORT).show();
        		  break;
        	  case -2:
        		  Toast.makeText(LoginActivity.this,"哎呀,出错啦...",
                  Toast.LENGTH_SHORT).show();
        		  break;
        	  case 1:
        		  /***
        		  String temp=(String)msg.obj;        		  
        		  //将拿到的json转换成数组
        		  List<loginMsg> loginMsgInfo=JSON.parseArray(temp, loginMsg.class);
        		  List<foundPassWord> foundPassWordInfo=JSON.parseArray(temp,foundPassWord.class);
        		  String AccountNum=loginMsgInfo.get(0).getAccountNum();
        		  Log.w("LoginActivity", "loginMsg AccountNum"+AccountNum);
        		  String psaaword=foundPassWordInfo.get(0).getPassWord();
        		  Log.w("LoginActivity", "foundPassWord psaaword"+psaaword);
        		  ***/
        		  
        		  
        		  String userName=account.getText().toString().trim();
        		  String pwd=password.getText().toString().trim();
        		  
        		  
        		  
        		  loginMsg lmsg=(loginMsg) msg.obj;
        		  String AccountNum=lmsg.getAccountNum();
        		  Log.w("LoginActivity", "loginMsg AccountNum = "+AccountNum);
        		  /***
        		  foundPassWord fmsg=(foundPassWord) msg.obj;
        		  String psaaword=fmsg.getPassWord();
        		  Log.w("LoginActivity", "foundPassWord psaaword"+psaaword);
        		  ***/
        		  
        		  if (userName.equals(AccountNum)) {
        			  Toast.makeText(LoginActivity.this, "登录成功", 0).show();
        			  //实现界面的跳转
        			  Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        			  intent.putExtra("userName", userName);
        			  intent.putExtra("pwd", pwd);
        			  intent.putExtra("age", 34);
        			  startActivity(intent);
        			  //关闭当前界面
        			  finish();
        		  }else{
        			  Toast.makeText(LoginActivity.this, "登录失败", 0).show();
        		  }
        	  }
          	}
    	  };
    	  //主线程
          new Thread(){        	  
        	  public void run(){
        		  Message msg= new Message();
        		  try{
        			  Map<String,String> parmas=new HashMap<String,String>();
        			  parmas.put("username","1");
        			  parmas.put("password","2");
        			  String loginMsgurl="http://192.168.1.110:8080/SchoolShopJson/LoginMsg.txt";
        			  String foundPassWordurl="http://192.168.1.110:8080/SchoolShopJson/foundPassWord.txt";
        			  //要发送的数据和访问的地址
        			  //String resultloginMsgString=AgentApi.dopost(parmas,loginMsgurl);
        			  //String resultfpasswordString=AgentApi.dopost(parmas, foundPassWordurl);
        			  loginMsg lmsg=new loginMsg();
        			  lmsg.setAccountNum("u1333");
        			  lmsg.setAvatarPath("/brnd/dd");
        			  lmsg.setGrowths(1);
        			  lmsg.setLittleName("smile");
        			  lmsg.setMemberIntegral("m23dfs");
        			  lmsg.setMemberIntegral("gfds");
        			  
        			  
        			  foundPassWord fmsg=new foundPassWord();
        			  fmsg.setPassWord("smile");
        			  fmsg.setPhoneNumber("13684973673");
        			  fmsg.setRepetyPassWord("smile");
        			  fmsg.setVlidationNum("1232");
	              
        			  //发送handler信息
        			  msg.what=1;
        			  msg.obj=lmsg;
        		  }catch(Exception e){
        			  e.printStackTrace();
        			  //使用-1代表程序异常
        			  msg.what=-2;
        			  msg.obj=e;
        		  }
        		  mHandler.sendMessage(msg);
        	  }
          	}.start();
      	}
      	return false;
    }
    
    /**
     * 判断用户名和密码是否有效
     *
     * @return
     */
    public boolean isUserNameAndPwdValid() {
    	// 用户名和密码不得为空
    	if (account.getText().toString().trim().equals("")) {
    		Toast.makeText(this, getString(R.string.accountName_empty),
            Toast.LENGTH_SHORT).show();
    		return false;
    	} else if (password.getText().toString().trim().equals("")) {
    		Toast.makeText(this, getString(R.string.password_empty),
            Toast.LENGTH_SHORT).show();
    		return false;
    	}
    	return true;
    }
	
}
