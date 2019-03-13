/**
 * 
 */
package com.mosorg.pims.app.common.http.reponse;

import java.util.ArrayList;
import java.util.List;

import com.mosorg.pims.app.common.http.BaseResponse;
import com.mosorg.pims.app.common.vo.User;



/**
 * @author Administrator
 *
 */
public class UserResponse extends BaseResponse {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<User> users =new ArrayList<>();

	public List<User> getUsers() {
		return users;
	}

	public void setUser(List<User> users) {
		this.users = users;
	}
	
	

}
