package com.mosorg.pims.app.common.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author itlanbao
 * IT蓝豹
 * 解析获取用户基本信息
 */
public class User  implements Parcelable {

/**
	 * 
	 */
	private String userid;//用户id
	private String nickname;//昵称
	private String userhead;//用户头像路径 
	private String email;//用户邮件
	
	//账号
	private String account;
	
	//手机号
	private String phone;
	
	//密码
	private String password;

	private Integer age;

	private String sex;
	
	private String role;//角色 是不是管理员
	
	//使用Parcelable需要用到
	public User(){}
		
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUserhead() {
		return userhead;
	}
	public void setUserhead(String userhead) {
		this.userhead = userhead;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int describeContents() {
		return 0;
	}
	@Override
	public void writeToParcel(Parcel parcel, int flag) {
		parcel.writeString(userid);
		parcel.writeInt(age);
		parcel.writeString(nickname);
		parcel.writeString(userhead);
		parcel.writeString(email);
		parcel.writeString(account);
		parcel.writeString(phone);
		parcel.writeString(password);
		parcel.writeString(sex);
		parcel.writeString(role);
	}
	
	//使用Parcelable需要用到
	public static final Creator<User> CREATOR = new Creator<User>() {
		public User createFromParcel(Parcel in) {
			return new User(in);
		}
 
		public User[] newArray(int size) {
			return new User[size];
		}
	};
 
	//使用Parcelable需要用到
	private User(Parcel in) {
		userid = in.readString();
		age = in.readInt();
		nickname = in.readString();
		userhead = in.readString();
		email = in.readString();
		account = in.readString();
		phone = in.readString();
		password = in.readString();
		sex = in.readString();
		role = in.readString();
	} 

}
