/***
 * 说明：找回密码的相关信息
 * 作者：smile
 * 时间：2019年3月09日 17:26:18
 */
package cn.mosorg.hellodemo.service;
import java.io.Serializable;
import android.R.string;
public class foundPassWord implements Serializable {
  private String phoneNumber; //手机号
  private String vlidationNum; //验证码
  private String passWord; //密码
  private String repetyPassWord; //确认密码
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  public String getVlidationNum() {
    return vlidationNum;
  }
  public void setVlidationNum(String vlidationNum) {
    this.vlidationNum = vlidationNum;
  }
  public String getPassWord() {
    return passWord;
  }
  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }
  public String getRepetyPassWord() {
    return repetyPassWord;
  }
  public void setRepetyPassWord(String repetyPassWord) {
    this.repetyPassWord = repetyPassWord;
  }  
  
}