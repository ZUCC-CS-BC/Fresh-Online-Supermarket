package cn.edu.zucc.freshos.control;

import java.sql.Connection;
import java.sql.SQLException;

import cn.edu.zucc.freshos.itf.IUserManager;
import cn.edu.zucc.freshos.model.UserInformation;
import cn.edu.zucc.freshos.util.BaseException;
import cn.edu.zucc.freshos.util.BusinessException;
import cn.edu.zucc.freshos.util.DBUtil;
import cn.edu.zucc.freshos.util.DbException;

public class UserManager implements IUserManager {

	@Override
	public UserInformation login(String userid, String pwd) throws BaseException {
		// TODO Auto-generated method stub
			UserInformation bu=new UserInformation();
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select user_id,user_pwd from user_information where user_id=? and user_pwd=?";
				java.sql.PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1, userid);
				pst.setString(2, pwd);
				java.sql.ResultSet rs=pst.executeQuery();
				if(!rs.next()) throw new BusinessException("��������ȷ���˺�����");
				rs.close();
				pst.close();
				bu.setUserId(userid);
				bu.setUserPwd(pwd);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DbException(e);
			}
			finally{
				if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			return bu;
		}
	
	@Override
	public UserInformation reg(String user_id,String user_name,String user_gender,String user_pwd,String user_pwd2,String user_telphone,String user_webmail,String user_city) throws BaseException {
		// TODO Auto-generated method stub
		if(user_id==null || "".equals(user_id)) throw new BusinessException("�û��˺Ų���Ϊ��");
		if(user_name==null || "".equals(user_name)) throw new BusinessException("�û���������Ϊ��");
		if(user_gender==null || "".equals(user_gender)) throw new BusinessException("�û��Ա���Ϊ��");
		if(user_pwd==null || "".equals(user_pwd)) throw new BusinessException("���벻��Ϊ��");
		if(!(user_pwd.equals(user_pwd2))) throw new BusinessException("�������벻һ��");
		if(user_telphone==null || "".equals(user_telphone)) throw new BusinessException("�绰����Ϊ��");
		if(user_webmail==null || "".equals(user_webmail)) throw new BusinessException("���䲻��Ϊ��");
		if(user_city==null || "".equals(user_city)) throw new BusinessException("���ڳ��в���Ϊ��");
		
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select *  from user_information where user_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, user_id);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("�˺��Ѵ���");
			rs.close();
			pst.close();
			
			sql="insert into user_information(user_id,user_name,user_gender,user_pwd,user_telphone,user_webmail,user_city,user_registration_time,vip,vip_end) values(?,?,?,?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, user_id);
			pst.setString(2, user_name);
			pst.setString(3, user_gender);
			pst.setString(4, user_pwd);
			pst.setString(5, user_telphone);
			pst.setString(6, user_webmail);
			pst.setString(7, user_city);
			pst.setTimestamp(8, new java.sql.Timestamp(System.currentTimeMillis()));
			pst.setBoolean(9, false);
			pst.setTimestamp(10,new java.sql.Timestamp(System.currentTimeMillis()));
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}

	@Override
	public void changePwd(UserInformation user, String oldPwd, String newPwd, String newPwd2) throws BaseException {
		// TODO Auto-generated method stub
		if(oldPwd==null || "".equals(oldPwd)) throw new BusinessException("ԭʼ���벻��Ϊ��");
		if(newPwd==null || "".equals(newPwd)) throw new BusinessException("�����벻��Ϊ��");
		if(!(newPwd2.equals(newPwd))) throw new BusinessException("�������벻һ��");
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select user_id,user_pwd from user_information where user_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,UserInformation.currentLoginUser.getUserId());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				if(!(oldPwd.equals(UserInformation.currentLoginUser.getUserPwd()))) throw new BusinessException("ԭʼ�������");
				sql="update user_information set user_pwd=? where user_id=?";
				pst=conn.prepareStatement(sql);
				pst.setString(1, newPwd);
				pst.setString(2, UserInformation.currentLoginUser.getUserId());
				pst.execute();
			}
			pst.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
	}

	@Override
	public void changeInfor(UserInformation user, String user_name,String user_gender, String user_telphone,String user_webmail,String user_city)throws BaseException {
		// TODO Auto-generated method stub
		if(user_name==null || "".equals(user_name)) throw new BusinessException("��������Ϊ��");
		if(user_gender==null || "".equals(user_gender)) throw new BusinessException("�Ա���Ϊ��");
		if(user_telphone==null || "".equals(user_telphone)) throw new BusinessException("�ֻ�����Ϊ��");
		if(user_webmail==null || "".equals(user_webmail)) throw new BusinessException("���䲻��Ϊ��");
		if(user_city==null || "".equals(user_city)) throw new BusinessException("���ڳ��в���Ϊ��");
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select user_id,user_pwd from user_information where user_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,UserInformation.currentLoginUser.getUserId());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				sql="update user_information set user_name=?,user_gender=?,user_telphone=?,user_webmail=?,user_city=? where user_id=?";
				pst=conn.prepareStatement(sql);
				pst.setString(1, user_name);
				pst.setString(2, user_gender);
				pst.setString(3, user_telphone);
				pst.setString(4, user_webmail);
				pst.setString(5, user_city);
				pst.setString(6, UserInformation.currentLoginUser.getUserId());
				pst.execute();
			}
			pst.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
		
		
	}
}
