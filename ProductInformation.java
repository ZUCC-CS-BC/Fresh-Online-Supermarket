package cn.edu.zucc.freshos.model;

public class ProductInformation {
	public static final String[] tblStepTitle={"商品编号","商品名称","价格","会员价","数量","规格","描述"};
	private String product_id;
	private String kind_id;//
	private String product_name;
	private String product_price;
	private String Product_vipprice;
	private String number;
	private String Product_specification;
	private String details;
	public static ProductInformation currentLoginUser=null;
	
	public String getCell(int col){
		if(col==0) return""+this.getProductId();
		else if(col==1) return ""+this.getProductName();
		else if(col==2) return ""+this.getProductPrice();
		else if(col==3) return ""+this.getProductVipprice();
		else if(col==4) return ""+this.getNumber();
		else if(col==5) return ""+this.getProductSpecification();
		else if(col==6) return ""+this.getDetails();
		else return "";
	}
	
	public String getProductId() {
		return product_id;
	}
	public void setProductId(String product_id) {
		this.product_id = product_id;
	}
	public String getProductName() {
		return product_name;
	}
	public void setProductName(String product_name) {
		this.product_name = product_name;
	}
	public String getKindId() {
		return kind_id;
	}
	public void setKindId(String kind_id) {
		this.kind_id = kind_id;
	}
	public String getProductPrice() {
		return product_price;
	}
	public void setProductPrice(String product_price) {
		this.product_price = product_price;
	}
	public String getProductVipprice() {
		return Product_vipprice;
	}
	public void setProductVipprice(String Product_vipprice) {
		this.Product_vipprice = Product_vipprice;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getProductSpecification() {
		return Product_specification;
	}
	public void setProductSpecification(String Product_specification) {
		this.Product_specification = Product_specification;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}
