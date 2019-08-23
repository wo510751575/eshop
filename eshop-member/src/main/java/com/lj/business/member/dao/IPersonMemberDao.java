package com.lj.business.member.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.domain.PersonMember;
import com.lj.business.member.dto.CountPersonMemberReturn;
import com.lj.business.member.dto.DoRepeatMemberDto;
import com.lj.business.member.dto.FindCountPersonMember;
import com.lj.business.member.dto.FindMemberInfoReturn;
import com.lj.business.member.dto.FindMemberRecord;
import com.lj.business.member.dto.FindNewPmCountDto;
import com.lj.business.member.dto.FindNewPmPage;
import com.lj.business.member.dto.FindNewPmPageReturn;
import com.lj.business.member.dto.FindPersonMember;
import com.lj.business.member.dto.FindPersonMemberPage;
import com.lj.business.member.dto.FindPersonMemberPageReturn;
import com.lj.business.member.dto.FindPersonMemberReturn;
import com.lj.business.member.dto.FindPersonMemberReturnList;
import com.lj.business.member.dto.FindPmSeachPage;
import com.lj.business.member.dto.FindPmSeachPageReturn;
import com.lj.business.member.dto.FindPmType;
import com.lj.business.member.dto.FindPmTypeIndexPage;
import com.lj.business.member.dto.FindPmTypeIndexPageReturn;
import com.lj.business.member.dto.FindPmWxBpInfo;
import com.lj.business.member.dto.FindPmWxBpInfoReturn;
import com.lj.business.member.dto.FindPmWxInfo;
import com.lj.business.member.dto.FindPmWxInfoReturn;
import com.lj.business.member.dto.FindTodayManageShop;
import com.lj.business.member.dto.FindTodayManageShopReturn;
import com.lj.business.member.dto.FindUnContactMember;
import com.lj.business.member.dto.FindUnContactMemberReturn;
import com.lj.business.member.dto.FindUrgentMbrPage;
import com.lj.business.member.dto.FindUrgentMbrPageReturn;

public interface IPersonMemberDao {
	int deleteByPrimaryKey(String code);

	int insertSelective(PersonMember record);

	PersonMember selectByPrimaryKey(String code);

	PersonMember selectByParamKey(PersonMember personMember);

	int updateByPrimaryKeySelective(PersonMember record);

	int updateByMGM(PersonMember record);

	List<FindPersonMemberPageReturn> findPersonMemberPage(FindPersonMemberPage findPersonMemberPage);

	int findPersonMemberPageCount(FindPersonMemberPage findPersonMemberPage);

	List<FindPersonMemberReturn> selectByPhoneWxName(Map param);

	List<FindPersonMemberReturn> inqueryUngrentMember(Map param);

	List<FindPersonMemberReturn> inqueryUnGroupMember(Map param);

	List<FindPersonMemberReturn> inqueryMemberByPmType(Map param);

	List<FindPersonMemberReturn> inqueryRepeatMember(Map param);

	List<PersonMember> selectByMemberNoGMCode(Map maps);

	/**
	 * 
	 *
	 * 方法说明：查找客户所有微信信息及最新动态
	 *
	 * @param findPmWxBpInfo
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年7月21日
	 *
	 */
	List<FindPmWxBpInfoReturn> findPmWxBpInfo(FindPmWxBpInfo findPmWxBpInfo);

	/**
	 *
	 *
	 * 方法说明：查找客户所有微信信息
	 *
	 * @param findPmWxInfo
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年7月21日
	 *
	 */
	List<FindPmWxInfoReturn> findPmWxInfo(FindPmWxInfo findPmWxInfo);

	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param param
	 *            1. code 客户Code 2. pmTypeType 客户分类类型
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月12日
	 *
	 */
	FindPersonMemberPageReturn getByCond(Map<String, String> param);

	List<FindPmTypeIndexPageReturn> findPmTypeIndexPage(FindPmTypeIndexPage findPmTypeIndexPage);

	int findPmTypeIndexPageCount(FindPmTypeIndexPage findPmTypeIndexPage);

	/**
	 * 
	 *
	 * 方法说明：查询交叉数量
	 *
	 * @param findPmTypeIndexPage
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年8月10日
	 *
	 */
	int findPmTypeRepeatCount(PersonMember record);

	List<FindPmSeachPageReturn> findPmSeachPage(FindPmSeachPage findPmSeachPage);

	int findPmSeachPageCount(FindPmSeachPage findPmSeachPage);

	List<FindUrgentMbrPageReturn> findUrgentMbrPage(FindUrgentMbrPage findUrgentMbrPage);

	int findUrgentMbrPageCount(FindUrgentMbrPage findUrgentMbrPage);

	PersonMember selectByMGM(FindPersonMember findPersonMember);

	int findCountByMemberNo(FindPersonMember findPersonMember);

	List<FindNewPmPageReturn> findNewPmPage(FindNewPmPage findNewPmPage);

	int findNewPmPageCount(FindNewPmPage findNewPmPage);

	/**
	 *
	 * 方法说明：查询未联系的客户
	 *
	 * @param findUnContactMember
	 *            未联系的客户参数
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月22日
	 *
	 */
	List<FindUnContactMemberReturn> findUnContactMember(FindUnContactMember findUnContactMember);

	/**
	 *
	 * 方法说明：查询未联系的客户总数
	 *
	 * @param findUnContactMember
	 *            未联系的客户参数
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月22日
	 *
	 */
	int findUnContactMemberCount(FindUnContactMember findUnContactMember);

	/**
	 * 查询导购下所有的客户数
	 * 
	 * @param merchantNo
	 *            商户编号
	 * @param memberNoGm
	 *            导购编号
	 * @return 总数
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月24日
	 */
	int findCountByMemberNoGm(@Param("merchantNo") String merchantNo, @Param("memberNoGm") String memberNoGm);

	int findPersonMemberSums(FindUrgentMbrPage findUrgentMbrPage);

	/**
	 * 性别统计
	 * 
	 * @return
	 */
	List<Map<String, Object>> selectSexStatisticsByShopNo();

	/**
	 * 年龄统计
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	List<Map<String, Object>> selectAgeStatisticsByShopNo(@Param("beginDate") String beginDate, @Param("endDate") String endDate);

	/**
	 * 职业统计
	 * 
	 * @return
	 */
	List<Map<String, Object>> selectLineStatisticsByShopNo();

	/**
	 * 兴趣统计
	 * 
	 * @return
	 */
	List<Map<String, Object>> selectInterestStatisticsByShopNo();

	/**
	 * 
	 *
	 * 方法说明：查找客户list
	 *
	 * @param doRepeatMemberDto
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年8月14日
	 *
	 */
	List<FindPersonMemberReturn> findList(DoRepeatMemberDto doRepeatMemberDto);

	/**
	 * 
	 *
	 * 方法说明：查询客户列表
	 *
	 * @param findPersonMemberPage
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月15日
	 *
	 */
	List<FindPersonMemberPageReturn> findPersonMemberList(FindPersonMemberPage findPersonMemberPage);

	/**
	 * 
	 *
	 * 方法说明：管理工作
	 *
	 * @param findTodayManageShop
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年8月16日
	 *
	 */
	List<FindTodayManageShopReturn> todayManageShopNew(FindTodayManageShop findTodayManageShop);

	/**
	 * 方法说明: 查询导购下的客户
	 * 
	 * @return
	 */
	List<FindPersonMemberReturn> findPersonMemberByGm(FindPersonMember personMember);

	/**
	 * 
	 *
	 * 方法说明：根据导购号和时间查询新增客户
	 *
	 * @param memberNo
	 *            导购号
	 * @param date
	 *            时间
	 * @throws TsfaServiceException
	 *
	 * @author 梅宏博 CreateDate: 2017年8月18日
	 *
	 */
	long findCountPmAddByGmDay(@Param("memberNo") String memberNo, @Param("date") Date date);

	/**
	 * 
	 *
	 * 方法说明：查询客户分组数量最大一条
	 *
	 * @param findPersonMember
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月18日
	 *
	 */
	FindPersonMemberReturnList findPersonMemberTypeNum(FindPersonMember findPersonMember);

	/**
	 * 
	 *
	 * 方法说明：客户性别统计
	 *
	 * @param findPersonMember
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月18日
	 *
	 */
	List<FindUrgentMbrPageReturn> findPersonMemberSexCount(FindPersonMember findPersonMember);

	/**
	 * 
	 *
	 * 方法说明：计算新增导购数
	 *
	 * @param findNewPmCountDto
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年8月18日
	 *
	 */
	int findNewPmCount(FindNewPmCountDto findNewPmCountDto);

	/**
	 * 
	 *
	 * 方法说明：根据导购号和客户类型查询客户数量
	 *
	 * @param findPmType
	 * @return int
	 * @throws TsfaServiceException
	 *
	 * @author 梅宏博 CreateDate: 2017年8月19日
	 *
	 */
	int findCountPmByType(FindPmType findPmType);

	/**
	 * 
	 *
	 * 方法说明：查询客户分类类型数量排行(商户)
	 *
	 * @param findPersonMember
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月21日
	 *
	 */
	List<FindPersonMemberReturnList> findPersonMemberTypeList(FindPersonMember findPersonMember);

	int findPersonMemberTypeCount(FindPersonMember findPersonMember);

	/**
	 * 
	 *
	 * 方法说明：根据导购编号和商户号查询客户信息
	 *
	 * @return
	 *
	 * @author 杨杰 CreateDate: 2017年9月5日
	 *
	 */
	List<FindMemberInfoReturn> findMemberRecord(FindMemberRecord findMemberRecord);

	/**
	 * 
	 * 方法说明：根据时间分组新增客户
	 *
	 * @param map
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年9月6日
	 *
	 */
	public List<CountPersonMemberReturn> findGroupCountByDay(FindCountPersonMember findCountPersonMember);
	/**
	 * 
	 *
	 * 方法说明：查询客户数
	 *
	 * @param findPersonMember
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年9月9日
	 *
	 */
    int findPersonMemberCont(FindPersonMember findPersonMember);
}