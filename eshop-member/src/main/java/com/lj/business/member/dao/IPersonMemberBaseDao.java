package com.lj.business.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lj.business.member.domain.PersonMemberBase;
import com.lj.business.member.dto.FindPersonMemberBase;
import com.lj.business.member.dto.FindPersonMemberBaseList;
import com.lj.business.member.dto.FindPersonMemberBasePage;
import com.lj.business.member.dto.FindPersonMemberBasePageReturn;
import com.lj.business.member.dto.FindPersonMemberBaseReturnList;
import com.lj.business.member.dto.FindPersonMemberBaseReturnMap;
import com.lj.business.member.dto.FindPersonMemberName;
import com.lj.business.member.dto.UpdatePersonMemberBaseRatioClientInfoDto;

public interface IPersonMemberBaseDao {
    int deleteByPrimaryKey(String code);

    int insertSelective(PersonMemberBase record);

    PersonMemberBase selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(PersonMemberBase record);

	List<FindPersonMemberBasePageReturn> findPersonMemberBasePage(
			FindPersonMemberBasePage findPersonMemberBasePage);

	int findPersonMemberBasePageCount(
			FindPersonMemberBasePage findPersonMemberBasePage);

    PersonMemberBase findByMobile(FindPersonMemberBase findPersonMemberBase);
    
    FindPersonMemberBaseReturnMap findByMobiles(FindPersonMemberBase findPersonMemberBase);

    int updateByPrimaryKey(PersonMemberBase record);
    
    PersonMemberBase selectByParams(FindPersonMemberBase findPersonMemberBase);

    /**
     * 
     *
     * 方法说明：根据编码获取客户
     *
     * @param codeList
     * @return
     *
     * @author 武鹏飞 CreateDate: 2017年7月21日
     *
     */
    List<FindPersonMemberName> findByCodeList(@Param("codeList") List<String> codeList);
   /**
    * 
    *
    * 方法说明：OMS专用（根据客户编号或客户名称查询）
    *
    * @param findPersonMemberBaseList
    * @return
    *
    * @author 罗书明 CreateDate: 2017年7月22日
    *
    */
    FindPersonMemberBaseReturnList findPersonMemberBaseList(FindPersonMemberBaseList findPersonMemberBaseList);
    /**
     * 
     *
     * 方法说明：统计省/区域客户数量
     *
     * @param findPersonMemberBaseList
     * @return
     *
     * @author 罗书明 CreateDate: 2017年8月7日
     *
     */
    FindPersonMemberBaseReturnList findPersonMemberBaseCounts(FindPersonMemberBaseList findPersonMemberBaseList);
    
    /**
     * 
     *
     * 方法说明：修改完成度
     *
     * @param dto
     *
     * @author 冯辉 CreateDate: 2017年8月17日
     *
     */
    void updateRatioClientInfoByMemberNo(UpdatePersonMemberBaseRatioClientInfoDto dto) ;
    /**
     * 
     *
     * 方法说明：查询性别分组客户数最多的客户的性别
     *
     * @return
     *
     * @author 罗书明 CreateDate: 2017年8月18日
     *
     */
    FindPersonMemberBaseReturnList findPersonMemberMax();
    /**
     * 
     *
     * 方法说明：查询区域客户数
     *
     * @return
     *
     * @author 罗书明 CreateDate: 2017年8月18日
     *
     */
	List<FindPersonMemberBaseList> findPersonMemberBaseMemberCount(FindPersonMemberBase findPersonMemberBase);
	/**
	 * 
	 *
	 * 方法说明：新增客户数
	 *
	 * @param findPersonMemberBaseList
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月28日
	 *
	 */
	int findPersonMemberBaseNumAdd(FindPersonMemberBaseList findPersonMemberBaseList);
	
	
	PersonMemberBase findPersonMemberBaseParams(FindPersonMemberBase findPersonMemberBase);
	

}