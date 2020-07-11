package cn.edu.zucc.freshos.model;

public class RecipeInformation {
	private String Recipe_id;	//²ËÆ×±àºÅ
	private String Recipe_name;	//²ËÆ×Ãû³Æ
	private String Recipe_materials;	//²ËÆ×ÓÃÁÏ
	private String Recipe_step;	//²ËÆ×²½Öè

	public String getRecipeId() {
		return Recipe_id;
	}
	public void setRecipeId(String Recipe_id) {
		this.Recipe_id = Recipe_id;
	}
	public String getProductName() {
		return Recipe_name;
	}
	public void setProductName(String Recipe_name) {
		this.Recipe_name = Recipe_name;
	}
	public String getRecipeMaterials() {
		return Recipe_materials;
	}
	public void setRecipeMaterials(String Recipe_materials) {
		this.Recipe_materials = Recipe_materials;
	}
	public String getProductStep() {
		return Recipe_step;
	}
	public void setProductStep(String Recipe_step) {
		this.Recipe_step = Recipe_step;
	}
}
