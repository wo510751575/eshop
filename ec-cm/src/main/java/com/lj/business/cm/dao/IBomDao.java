package com.lj.business.cm.dao;

import java.util.List;

import com.lj.business.cm.domain.Bom;
import com.lj.business.cm.dto.EditBomDto;
import com.lj.business.cm.dto.FindBomPageDto;
/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：产品表接口类
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年6月30日
 */
public interface IBomDao {
	/**
	 * 
	 *
	 * 方法说明：新增产品
	 *
	 * @param bom
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月30日
	 *
	 */
	int addBom(EditBomDto bom);
	/**
	 * 
	 *
	 * 方法说明：编辑产品
	 *
	 * @param bom
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月30日
	 *
	 */
	int editBom(EditBomDto bom);
	/**
	 * 
	 *
	 * 方法说明：根据主键查询产品
	 *
	 * @param code
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月30日
	 *
	 */
	Bom selectByCode(String code);
	/**
	 * 
	 *
	 * 方法说明：查询所有产品(不分页)
	 *
	 * @param FindExGuiderPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月30日
	 *
	 */
	List<FindBomPageDto> findBoms(FindBomPageDto findBomPageDto);
	/**
	 * 
	 *
	 * 方法说明：查询所有产品(分页)
	 *
	 * @param findBomPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月30日
	 *
	 */
	List<FindBomPageDto> findBomPage(FindBomPageDto findBomPageDto);
	/**
	 * 
	 *
	 * 方法说明：查询产品条数
	 *
	 * @param findBomPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月30日
	 *
	 */
	int findBomPageCount(FindBomPageDto findBomPageDto);
}