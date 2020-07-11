package cn.edu.zucc.freshos.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.freshos.itf.IKindManager;
import cn.edu.zucc.freshos.model.FreshCategory;
import cn.edu.zucc.freshos.model.UserInformation;
import cn.edu.zucc.freshos.util.BaseException;
import cn.edu.zucc.freshos.util.BusinessException;
import cn.edu.zucc.freshos.util.DBUtil;
import cn.edu.zucc.freshos.util.DbException;

public class CategoryManager implements IKindManager{

	@Override
	public FreshCategory addKind(String kindid, String kindname, String kinddes) throws BaseException {
		// TODO Auto-generated method stub
		if(kindid==null || "".equals(kindid)) throw new BusinessException("生鲜类别编号不能为空");
		if(kindname==null || "".equals(kindname)) throw new BusinessException("生鲜类别名称不能为空");
		if(kinddes==null || "".equals(kinddes)) throw new BusinessException("生鲜类别描述不能为空");
		
		FreshCategory bk=new FreshCategory();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from fresh_kind where kind_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, kindid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("编号已存在");
			rs.close();
			pst.close();
			
			sql="insert into fresh_kind(kind_id,kind_name,kind_dcp) values(?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1,kindid);
			pst.setString(2,kindname);
			pst.setString(3,kinddes);
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
		return bk;
	}

	@Override
	public List<FreshCategory> loadAll() throws BaseException {
		// TODO Auto-generated method stub
		List<FreshCategory> result=new ArrayList<FreshCategory>();
		Connection conn=null;
		  	try {
		  		conn=DBUtil.getConnection();
		  		String sql="select * from fresh_kind  order by kind_id";
		  		java.sql.PreparedStatement pst=conn.prepareStatement(sql);
		  		//pst.setString(1, BeanFreshKind.currentLoginUser.getKindId());
		  		java.sql.ResultSet rs=pst.executeQuery();
		  		while(rs.next()) {
		  			FreshCategory bk=new FreshCategory();
		  			bk.setKindId(rs.getString(1));
			    	bk.setKindName(rs.getString(2));
			    	bk.setKindDcp(rs.getString(3));
			    	result.add(bk);
		  		}
		  }catch (SQLException e) {
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
		  
		  return result;
	}

	@Override
	public void deleteKind(FreshCategory kind) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			
			String sql="select count(*) from product_information where kind_id= ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, kind.getKindId());
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)>0) {
					rs.close();
					pst.close();
					throw new BusinessException("类别已经存在商品，不能删除");
				}
			}
			rs.close();
			pst.close();
			
			sql="delete from fresh_kind where kind_id = ?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,kind.getKindId());
			pst.execute();
			pst.close();
			
			conn.commit();
		}catch (BaseException e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (SQLException ex) {
				// TODO: handle exception
				e.printStackTrace();
			}
			throw e;
		}
		catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
