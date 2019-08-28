package com.lj.business.cf.dao;

import java.util.List;

import com.lj.business.cf.domain.ComTaskChoose;
import com.lj.business.cf.dto.FindComTaskChooseByCode;
import com.lj.business.cf.dto.FindComTaskChooseByCodeReturnDto;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChooseIndex;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChooseIndexReturn;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChoosePageDto;
/**
 * 
 * 
 * 类说明：客户沟通任务选择
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月5日
 */
public interface IComTaskChooseDao {
	
	/**
	 * 
	 *
	 * 方法说明：沟通任务分类信息查询_APP
	 *
	 * @param findComTaskChooseIndex
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年7月22日
	 *
	 */
	List<FindComTaskChooseIndexReturn> findComTaskChooseIndex(FindComTaskChooseIndex findComTaskChooseIndex);
	/**
	 * 
	 *
	 * 方法说明：新增客户沟通任务选择表
	 *
	 * @param bom
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	int addComTaskChoose(ComTaskChoose comTaskChoose);
	/**
	 * 
	 *
	 * 方法说明：编辑客户沟通任务选择表
	 *
	 * @param bom
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	int editComTaskChoose(ComTaskChoose comTaskChoose);
	/**
	 * 
	 *
	 * 方法说明：根据主键查询客户沟通任务选择表
	 *
	 * @param code
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	ComTaskChoose selectByCode(String code);
	
	
	ComTaskChoose selectByParamKey(ComTaskChoose comTaskChoose);
	
	/**
	 * 
	 *
	 * 方法说明：查询客户沟通任务选择表(不分页)
	 *
	 * @param FindExGuiderPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	List<FindComTaskChoosePageDto> findComTaskChooses(FindComTaskChoosePageDto findComTaskChoosePageDto);
	
	/**
	 * 
	 *
	 * 方法说明：查询客户沟通任务选择表 不包含分组和初次结束
	 *
	 * @param findComTaskChoosePageDto
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年8月9日
	 *
	 */
	List<FindComTaskChoosePageDto> findComTaskChoosesApp(FindComTaskChoosePageDto findComTaskChoosePageDto);
	
	/**
	 * 
	 *
	 * 方法说明：查询客户沟通任务选择表 不包含分组和初次结束
	 *
	 * @param findComTaskChoosePageDto
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年8月15日
	 *
	 */
	List<FindComTaskChoosePageDto> findComTaskChoosesNewApp(FindComTaskChoosePageDto findComTaskChoosePageDto);
	
	/**
	 * 
	 *
	 * 方法说明：查询所有客户沟通任务选择表(分页)
	 *
	 * @param findBomPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	List<FindComTaskChoosePageDto> findComTaskChoosePage(FindComTaskChoosePageDto findComTaskChoosePageDto);
	/**
	 * 
	 *
	 * 方法说明：查询客户沟通任务选择表条数
	 *
	 * @param findBomPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	int findComTaskChoosePageCount(FindComTaskChoosePageDto findComTaskChoosePageDto);
	
	/**
	 * 
	 *
	 * 方法说明：删除已选择项，根据商户
	 *
	 * @param merchantNo
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月6日
	 *
	 */
	int delComTaskChooseByMerchantNo(String merchantNo);
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param findComTaskChooseByCode
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年8月15日
	 *
	 */
	FindComTaskChooseByCodeReturnDto findComTaskChooseByCode(FindComTaskChooseByCode findComTaskChooseByCode);
}