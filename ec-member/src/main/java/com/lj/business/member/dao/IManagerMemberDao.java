package com.lj.business.member.dao;

import java.util.List;
import java.util.Map;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.domain.ManagerMember;
import com.lj.business.member.dto.FindManagerMemberPage;
import com.lj.business.member.dto.FindManagerMemberPageReturn;
import com.lj.business.member.dto.FindManagersDto;
import com.lj.business.member.dto.FindManagersReturnDto;
import com.lj.business.member.dto.ManagerMemberDto;
import com.lj.business.member.dto.ManagerMemberReturnDto;
import com.lj.business.member.dto.UpdateManagerOrGuidPwdDto;

public interface IManagerMemberDao {
    int deleteByPrimaryKey(String code);

    int insertSelective(ManagerMember record);

    ManagerMember selectByPrimaryKey(String code);
    
    List<ManagerMember> selectByParams(ManagerMember managerMember);

    int updateByPrimaryKeySelective(ManagerMember record);

	List<FindManagerMemberPageReturn> findManagerMemberPage(
			FindManagerMemberPage findManagerMemberPage);

	List<FindManagerMemberPageReturn> findManagerMemberExport(
			FindManagerMemberPage findManagerMemberPage);
	
	int findManagerMemberPageCount(FindManagerMemberPage findManagerMemberPage);
	
	ManagerMember findManagerMember(ManagerMember record);
	/**
	 * 
	 *
	 * 方法说明：查找个人中心店长信息
	 *
	 * @param ManagerMemberDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月11日
	 *
	 */
	ManagerMemberReturnDto findManager(ManagerMemberDto managerMemberDto);
	/**
	 * 
	 *
	 * 方法说明：更新个人中心店长信息
	 *
	 * @param managerMemberDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月11日
	 *
	 */
	int updateManager(ManagerMember record);
	/**
	 * 
	 *
	 * 方法说明：添加个人中心店长信息
	 *
	 * @param managerMemberDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月11日
	 *
	 */
	int addManager(ManagerMember record);
	
	/**
	 * 
	 *
	 * 方法说明：获取管理人员列表
	 *
	 * @param findManagerMemberPage
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月12日
	 *
	 */
	List<FindManagerMemberPageReturn> findManagerMembers(FindManagerMemberPage findManagerMemberPage);
	/**
	 * 
	 *
	 * 方法说明：获取管理人员列表(通讯录)
	 *
	 * @param findManagerMemberPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月13日
	 *
	 */
	List<FindManagersReturnDto> findManagers(FindManagersDto findManagersDto);
	
	/**
	 * 
	 *
	 * 方法说明：更新密码
	 *
	 * @param updateManagerOrGuidPwdDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月26日
	 *
	 */
	int updateManagerForPwd(UpdateManagerOrGuidPwdDto updateManagerOrGuidPwdDto);
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param updateManagerOrGuidPwdDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月27日
	 *
	 */
	int updateManagerAndGuidForPwd(UpdateManagerOrGuidPwdDto updateManagerOrGuidPwdDto);

	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param updateManagerOrGuidPwdDto
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年8月28日
	 *
	 */
	List<ManagerMemberReturnDto> findManagerByShop(String shopNo);

	/**
	 * 
	 *
	 * 方法说明：获取该商户总客户数
	 *
	 * @param merchantNo 商户编号
	 * @throws TsfaServiceException
	 *
	 * @author 梅宏博 CreateDate: 2017年9月01日
	 *
	 */
	int findCountManagerMember(String merchantNo);

	/**
	 * 
	 *
	 * 方法说明：获取该商户区域经理年龄分段
	 *
	 * @param parmMap
	 * @throws TsfaServiceException
	 *
	 * @author 梅宏博 CreateDate: 2017年9月01日
	 *
	 */
	Map<String, Object> countByCondition(Map<String, Object> parmMap);
	
	/**
	 * 
	 *
	 * 方法说明：查询店长编号
	 *
	 * @param findManagerMemberPage
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年9月11日
	 *
	 */
	List<FindManagerMemberPageReturn> findMemberNoShop(FindManagerMemberPage findManagerMemberPage);
	 
	 
}