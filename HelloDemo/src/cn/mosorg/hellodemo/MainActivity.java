package cn.mosorg.hellodemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent intent = this.getIntent();
		 String userName = intent.getStringExtra("userName");
		 String pwd = intent.getStringExtra("pwd");
		 int age = intent.getIntExtra("age", 22); // 缺省值为22
		
		TextView tv =(TextView) findViewById(R.id.user_name);
		
		//设置加粗
		//TextPaint tp = tv.getPaint();		 
		//tp.setFakeBoldText(true); 
		
		//设置文本格式：如字体颜色，大小，粗体等
		SpannableString ss_userName = new SpannableString(userName+" ，欢迎您！ \n\n============用户信息=============\n用户名 : "+userName+" \n用户密码 :"+pwd+" \n用户年龄 :"+Integer.toString(age));
		//加字体颜色
		ss_userName.setSpan(new ForegroundColorSpan(Color.parseColor("#FF3030")), 0,userName.length(), 
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		//加下划线
		ss_userName.setSpan(new UnderlineSpan(), 0, userName.length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		//加粗
		ss_userName.setSpan(new StyleSpan(Typeface.BOLD),0,userName.length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		tv.setText(ss_userName);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
