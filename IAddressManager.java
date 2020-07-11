package cn.edu.zucc.freshos.itf;

import java.util.List;

import cn.edu.zucc.freshos.model.BeanAddress;
import cn.edu.zucc.freshos.model.UserInformation;
import cn.edu.zucc.freshos.util.BaseException;

public interface IAddressManager {

	public BeanAddress addAddress(String addressid,UserInformation user, String province,String city,String area,String address,String username,String phone) throws BaseException;
	/**

	 */
	public List<BeanAddress> loadAll(UserInformation user)throws BaseException;
	/**

	 */
	public void deleteKind(BeanAddress address)throws BaseException;
}
