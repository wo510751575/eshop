package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.ProductSku;
import com.lj.eshop.dto.FindProductSkuPage;
import com.lj.eshop.dto.ProductSkuDto;

public interface IProductSkuDao {
	int insertSelective(ProductSku record);

	ProductSkuDto selectByPrimaryKey(String code);

	int updateByPrimaryKeySelective(ProductSku record);

	List<ProductSkuDto> findProductSkuPage(FindProductSkuPage findProductSkuPage);

	int findProductSkuPageCount(FindProductSkuPage findProductSkuPage);

	List<ProductSkuDto> findProductSkus(FindProductSkuPage findProductSkuPage);

	int updateProductSkuByProductCode(ProductSku record);

	/**
	 * 
	 *
	 * 方法说明：按供应商设置的 折扣比例计算提出，仅查需要的数据，比如成本价不查。
	 *
	 * @param findProductSkuPage
	 * @return
	 *
	 * @author lhy 2017年8月31日
	 *
	 */
	List<ProductSkuDto> findMinProductSkus(FindProductSkuPage findProductSkuPage);

}