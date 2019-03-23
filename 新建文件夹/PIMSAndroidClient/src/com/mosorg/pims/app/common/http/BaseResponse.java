/**
 * 
 */
package com.mosorg.pims.app.common.http;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class BaseResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ret="0";//请求状态码
	private String errcode="0";//错误码
	private String msg="succes";
	
	public String getRet() {
		return ret;
	}
	public void setRet(String ret) {
		this.ret = ret;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
