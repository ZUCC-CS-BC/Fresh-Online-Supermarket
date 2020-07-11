package cn.edu.zucc.freshos.itf;

import cn.edu.zucc.freshos.model.UserInformation;
import cn.edu.zucc.freshos.util.BaseException;

public interface IUserManager {
	/**

	 */
	public UserInformation reg(String user_id,String user_name,String user_gender,String user_pwd,String user_pwd2,String user_telphone,String user_webmail,String user_city) throws BaseException;
	/**

	 */
	public UserInformation login(String userid,String pwd)throws BaseException;
	/**

	 */
	public void changePwd(UserInformation user, String oldPwd,String newPwd, String newPwd2)throws BaseException;
	
	public void changeInfor(UserInformation user, String user_name,String user_gender, String user_telphone,String user_webmail,String user_city)throws BaseException;
}
