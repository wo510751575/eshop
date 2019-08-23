package com.lj.business.cf.dao;

import java.util.List;

import com.lj.business.cf.domain.WorkTaskChoose;
import com.lj.business.cf.dto.workTaskChoose.FindWorkTaskChoosePageDto;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * 类说明：工作事项选择接口
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月5日
 */
public interface IWorkTaskChooseDao {
	/**
	 * 
	 *
	 * 方法说明：新增工作事项选择
	 *
	 * @param bom
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	int addWorkTaskChoose(WorkTaskChoose workTaskChoose);
	/**
	 * 
	 *
	 * 方法说明：编辑工作事项选择
	 *
	 * @param bom
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	int editWorkTaskChoose(WorkTaskChoose workTaskChoose);
	/**
	 * 
	 *
	 * 方法说明：根据主键查询工作事项选择
	 *
	 * @param code
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	WorkTaskChoose selectByCode(String code);
	
	WorkTaskChoose selectParamkey(WorkTaskChoose workTaskChoose);
	/**
	 * 
	 *
	 * 方法说明：查询工作事项选择(不分页)
	 *
	 * @param FindExGuiderPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	List<FindWorkTaskChoosePageDto> findWorkTaskChooses(FindWorkTaskChoosePageDto findWorkTaskChoosePageDto);
	/**
	 * 
	 *
	 * 方法说明：查询所有工作事项选择(分页)
	 *
	 * @param findBomPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	List<FindWorkTaskChoosePageDto> findWorkTaskChoosePage(FindWorkTaskChoosePageDto findWorkTaskChoosePageDto);
	/**
	 * 
	 *
	 * 方法说明：查询工作事项选择条数
	 *
	 * @param findBomPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	int findWorkTaskChoosePageCount(FindWorkTaskChoosePageDto findWorkTaskChoosePageDto);
	/**
	 * 
	 *
	 * 方法说明：删除已选择的工作事项根据商户
	 * OMS-绑定工作事项所需
	 *
	 * @param code
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月5日
	 *
	 */
	int delWorkTaskChooseBymerchantNo(String merchantNo);

	/**
	 * 根据商户编号列表查询任务
	 * @param merchantNoList 商户编号列表
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月25日
	 */
	List<FindWorkTaskChoosePageDto> findWorkTaskChooseByMerchantNo(@Param("merchantNoList") List<String> merchantNoList);
}