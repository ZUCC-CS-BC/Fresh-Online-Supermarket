package cn.edu.zucc.freshos.itf;

import java.util.List;

import cn.edu.zucc.freshos.model.FreshCategory;
import cn.edu.zucc.freshos.model.ProductInformation;
import cn.edu.zucc.freshos.util.BaseException;

public interface IProductManager {
	/**

	 */
	public ProductInformation addProduct(String product_id, FreshCategory kind_id,String product_name,String product_price,String Product_vipprice,String number,String Product_specification, String details) throws BaseException;
	/**

	 */
	public List<ProductInformation> loadProducts(FreshCategory kind)throws BaseException;
	/**

	 */
	public void deleteProduct(ProductInformation product)throws BaseException;
}
