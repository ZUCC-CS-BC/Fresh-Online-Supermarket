package cn.edu.zucc.freshos.itf;

import java.util.List;

import cn.edu.zucc.freshos.model.FreshCategory;
import cn.edu.zucc.freshos.util.BaseException;

public interface IKindManager {
	/**

	 */
	public FreshCategory addKind(String kindid, String kindname,String kinddcp) throws BaseException;
	/**

	 */
	public List<FreshCategory> loadAll()throws BaseException;
	/**

	 */
	public void deleteKind(FreshCategory kind)throws BaseException;
}
