package com.lj.business.member.dao;

import java.util.List;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.domain.GuidMember;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberDto;
import com.lj.business.member.dto.FindGuidMemberPage;
import com.lj.business.member.dto.FindGuidMemberPageReturn;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.FindShopGmDto;
import com.lj.business.member.dto.FindShopGmReturn;
import com.lj.business.member.dto.GuidInfoShop;
import com.lj.business.member.dto.GuidMemberReturnDto;
import com.lj.business.member.dto.UpdateManagerOrGuidPwdDto;

public interface IGuidMemberDao {
	int deleteByPrimaryKey(String code);

	int insert(GuidMember record);

	int insertSelective(GuidMember record);

	GuidMember selectByPrimaryKey(String code);

	GuidMember selectByParams(GuidMember guidMember);

	int updateByPrimaryKeySelective(GuidMember record);

	int updateByPrimaryKey(GuidMember record);

	List<FindGuidMemberPageReturn> findGuidMemberPage(FindGuidMemberPage findGuidMemberPage);

	List<FindGuidMemberPageReturn> findGuidMemberExport(FindGuidMemberPage findGuidMemberPage);

	int findGuidMemberPageCount(FindGuidMemberPage findGuidMemberPage);

	int findGuidMemberByMerchantNo(FindGuidMemberPage findGuidMemberPage);

	GuidMember findGuidMember(GuidMember guidMember);

	GuidMember findGuidMember(FindGuidMember findGuidMember);

	List<FindGuidMemberPageReturn> findGuidMembers(FindGuidMemberPage findGuidMemberPage);

	List<FindGuidMemberPageReturn> findGuidMembersNoSelf(FindGuidMemberPage findGuidMemberPage);

	/**
	 * 
	 *
	 * 方法说明：查找个人中心导购信息
	 *
	 * @param findGuidMemberDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月11日
	 *
	 */
	GuidMemberReturnDto findGuid(FindGuidMemberDto findGuidMemberDto);

	/**
	 * 
	 *
	 * 方法说明：更新个人中心导购信息
	 *
	 * @param record
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月11日
	 *
	 */
	int updateGuid(GuidMember record);

	/**
	 * 
	 *
	 * 方法说明：添加个人中心导购信息
	 *
	 * @param record
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月11日
	 *
	 */
	int addGuid(GuidMember record);

	/**
	 * 
	 *
	 * 方法说明：根据商户号和分店编号查找导购列表
	 *
	 * @param findGuidMemberDto
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年7月20日
	 *
	 */
	List<GuidMemberReturnDto> findGuidMemberList(FindGuidMemberDto findGuidMemberDto);

	/**
	 * 
	 *
	 * 方法说明：查询所有的导购
	 *
	 * @param GuidMember
	 * @return
	 *
	 * @author 杨杰 CreateDate: 2017年9月7日
	 *
	 */
	List<GuidMember> findGuidMemberAllList(GuidMember GuidMember);

	/**
	 * 
	 *
	 * 方法说明：更新导购表密码
	 *
	 * @param updateManagerOrGuidPwdDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月26日
	 *
	 */
	int updateGuidForPwd(UpdateManagerOrGuidPwdDto updateManagerOrGuidPwdDto);

	/**
	 * 
	 *
	 * 方法说明：查询店员信息_H5报表
	 *
	 * @param guidMember
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年8月1日
	 *
	 */
	List<GuidInfoShop> selectGuidInfoShop(GuidMember guidMember);

	/**
	 * 
	 *
	 * 方法说明：查找导购与门店信息
	 *
	 * @param findGuidMemberDto
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月4日
	 *
	 */
	List<GuidInfoShop> findGuidInfoShop(FindGuidMemberDto findGuidMemberDto);

	/**
	 * 
	 *
	 * 方法说明：查找分店下的导购排除自己
	 *
	 * @param findShopGmDto
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年8月8日
	 *
	 */
	List<FindShopGmReturn> findShopGm(FindShopGmDto findShopGmDto);
	
	List<FindShopGmReturn> findShopGmPy(FindShopGmDto findShopGmDto);

	/**
	 * 
	 *
	 * 方法说明：获取每个顾问未分组的客户数量
	 *
	 * @param guidMember
	 * @return
	 *
	 * @author 杨杰 CreateDate: 2017年9月7日
	 *
	 */
	int findPersonUngroupCount(GuidMember guidMember);

}