package cn.edu.zucc.freshos.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.freshos.itf.IProductManager;
import cn.edu.zucc.freshos.model.FreshCategory;
import cn.edu.zucc.freshos.model.ProductInformation;
import cn.edu.zucc.freshos.model.UserInformation;
import cn.edu.zucc.freshos.util.*;

public class ProductManager implements IProductManager{
	FreshCategory kindid=new FreshCategory();
	
	@Override
	public ProductInformation addProduct(String product_id, FreshCategory kind_id,String product_name,String product_price,String Product_vipprice,String number,String Product_specification, String details) throws BaseException {
		// TODO Auto-generated method stub
		if(product_id==null || "".equals(product_id)) throw new BusinessException("商品编号不能为空");
		if(product_name==null || "".equals(product_name)) throw new BusinessException("商品名称不能为空");
		if(product_price==null || "".equals(product_price)) throw new BusinessException("价格不能为空");
		if(Product_vipprice==null || "".equals(Product_vipprice)) throw new BusinessException("会员价不能为空");
		if(number==null || "".equals(number)) throw new BusinessException("数量不能为空");
		if(Product_specification==null || "".equals(Product_specification)) throw new BusinessException("规格不能为空");
		if(details==null || "".equals(details)) throw new BusinessException("详情不能为空");

		Connection conn=null;
		try {
			String kindidString=kindid.getKindId();
			conn=DBUtil.getConnection();
			
			String sql="select * from product_information where product_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, product_id);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("商品编号已存在");
			rs.close();
			pst.close();
			
			sql="insert into product_information(product_id,kind_id,product_name,product_price,Product_vipprice,number,Product_specification,details) values(?,?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1,product_id);
			pst.setString(2,kindidString);
			pst.setString(3,product_name);
			pst.setString(4,product_price);
			pst.setString(5,Product_vipprice);
			pst.setString(6,number);
			pst.setString(7,Product_specification);
			pst.setString(8,details);
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
	public List<ProductInformation> loadProducts(FreshCategory kind) throws BaseException {
		List<ProductInformation> result=new ArrayList<ProductInformation>();
		Connection conn=null;
		try {
			String kindid=kind.getKindId();
			conn=DBUtil.getConnection();
			String sql="select * from product_information where kind_id=? order by product_id";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, kindid);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				ProductInformation bp=new ProductInformation();
				bp.setProductId(rs.getString(1));
				bp.setKindId(rs.getString(2));
				bp.setProductName(rs.getString(3));
				bp.setProductPrice(rs.getString(4));
				bp.setProductVipprice(rs.getString(5));
				bp.setNumber(rs.getString(6));
				bp.setProductSpecification(rs.getString(7));
				bp.setDetails(rs.getString(8));
			    result.add(bp);
			}
			rs.close();
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
		
		return result;
	}

	@Override
	public void deleteProduct(ProductInformation product) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			
			String sql="delete from product_information where product_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, product.getProductId());
			pst.execute();
			pst.close();
			
			
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
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
