package com.mosorg.pims.app.ui.view;

import com.mosorg.pims.androidclient.R;
import com.mosorg.pims.app.common.vo.User;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//通过意图获取传递过来的数据
		User user = getIntent().getParcelableExtra("User");
		
		//打印输出到控制台，可以在LogCat日志中查看
		System.out.println(user.getAccount());
 
		System.out.println(user.getAge());
		
		System.out.println(user.getNickname());
		
		
		StringBuilder sb=new StringBuilder();
		sb.append("ID："+user.getUserid()+"\n");
		sb.append("昵称："+user.getNickname()+"\n");
		sb.append("账号："+user.getAccount()+"\n");
		sb.append("密码："+user.getPassword()+"\n");
		sb.append("手机号："+user.getPhone()+"\n");
		sb.append("年龄："+user.getAge()+"\n");
		sb.append("邮箱："+user.getEmail()+"\n");
		sb.append("头像："+user.getUserhead()+"\n");
		sb.append("角色："+user.getRole()+"\n");
		sb.append("性别："+user.getSex()+"\n");
		
		String welcomeinfo = user.getNickname()
				+" ，欢迎您！\n\n============用户信息=============\n"
				+sb.toString();
		
		
		TextView tv =(TextView) findViewById(R.id.main_text_view);
		
		//设置加粗
		//TextPaint tp = tv.getPaint();		 
		//tp.setFakeBoldText(true); 
		
		//设置文本格式：如字体颜色，大小，粗体等
		SpannableString ss_welcomeinfo = new SpannableString(welcomeinfo);
		/***
		SpannableString ss_welcomeinfo = new SpannableString(user.getNickname()
				+" ，欢迎您！\n\n============用户信息=============\n"
				+"ID："+user.getUserid()+"\n"
				+"昵称："+user.getNickname()+"\n"
				+"账号："+user.getAccount()+"\n"
				+"密码："+user.getPassword()+"\n"
				+"手机号："+user.getPhone()+"\n"
				+"年龄："+user.getAge()+"\n"
				+"邮箱："+user.getEmail()+"\n"
				+"头像："+user.getUserhead()+"\n"
				+"角色："+user.getRole()+"\n"
				+"性别："+user.getSex()+"\n");
		***/
		//加字体颜色
		ss_welcomeinfo.setSpan(new ForegroundColorSpan(Color.parseColor("#FF3030")), 0,user.getNickname().length(), 
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		//加下划线
		ss_welcomeinfo.setSpan(new UnderlineSpan(), 0, user.getNickname().length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		//加粗
		ss_welcomeinfo.setSpan(new StyleSpan(Typeface.BOLD),0,user.getNickname().length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		//将内容赋值给TextView视图
		tv.setText(ss_welcomeinfo);
	}
}
