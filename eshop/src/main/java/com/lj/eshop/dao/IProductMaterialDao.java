package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.ProductMaterial;
import com.lj.eshop.dto.FindProductMaterialPage;
import com.lj.eshop.dto.ProductMaterialDto;

public interface IProductMaterialDao {
    int deleteByPrimaryKey(String code);

    int insert(ProductMaterial record);

    int insertSelective(ProductMaterial record);

    ProductMaterial selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(ProductMaterial record);

    int updateByPrimaryKey(ProductMaterial record);

	/**   
	 * @Title: findProductMaterials   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param findProductMaterialPage
	 * @param: @return      
	 * @return: List<ProductMaterialDto>      
	 * @throws   
	 */
	List<ProductMaterialDto> findProductMaterials(FindProductMaterialPage findProductMaterialPage);

	/**   
	 * @Title: findProductMaterialPage   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param findProductMaterialPage
	 * @param: @return      
	 * @return: List<ProductMaterialDto>      
	 * @throws   
	 */
	List<ProductMaterialDto> findProductMaterialPage(FindProductMaterialPage findProductMaterialPage);

	/**   
	 * @Title: findProductMaterialPageCount   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param findProductMaterialPage
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	int findProductMaterialPageCount(FindProductMaterialPage findProductMaterialPage);

	/**   
	 * @Title: updateByProductCode   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param code      
	 * @return: void      
	 * @throws   
	 */
	void updateByProductCode(String code);

	/**   
	 * @Title: updateStatusOpon   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param productCode      
	 * @return: void      
	 * @throws   
	 */
	void updateStatusOpon(String productCode);
}