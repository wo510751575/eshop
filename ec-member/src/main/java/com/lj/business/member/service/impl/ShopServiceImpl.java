package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IGuidMemberDao;
import com.lj.business.member.dao.IManagerMemberDao;
import com.lj.business.member.dao.IShopDao;
import com.lj.business.member.domain.GuidMember;
import com.lj.business.member.domain.ManagerMember;
import com.lj.business.member.domain.Shop;
import com.lj.business.member.dto.AddShop;
import com.lj.business.member.dto.AddShopReturn;
import com.lj.business.member.dto.DelShop;
import com.lj.business.member.dto.DelShopReturn;
import com.lj.business.member.dto.FindShop;
import com.lj.business.member.dto.FindShopDetail;
import com.lj.business.member.dto.FindShopDetailReturn;
import com.lj.business.member.dto.FindShopDto;
import com.lj.business.member.dto.FindShopPage;
import com.lj.business.member.dto.FindShopPageReturn;
import com.lj.business.member.dto.FindShopReturn;
import com.lj.business.member.dto.FindShopReturnAreaCode;
import com.lj.business.member.dto.GuidInfoShop;
import com.lj.business.member.dto.UpdateShop;
import com.lj.business.member.dto.UpdateShopReturn;
import com.lj.business.member.emus.MemberType;
import com.lj.business.member.emus.ShopStatus;
import com.lj.business.member.service.IShopService;

/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * 
 * CreateDate: 2017-06-14
 */
@Service
public class ShopServiceImpl implements IShopService { 


	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);


	/** The shop dao. */
	@Resource
	private IShopDao shopDao;

	/** The manager member dao. */
	@Resource
	private IManagerMemberDao managerMemberDao;

	/** The guid member dao. */
	@Resource
	private IGuidMemberDao guidMemberDao;



	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IShopService#addShop(com.lj.business.member.dto.AddShop)
	 */
	@Override
	public AddShopReturn addShop(
			AddShop addShop) throws TsfaServiceException {
		logger.debug("addShop(AddShop addShop={}) - start", addShop); 

		AssertUtils.notNull(addShop);
		try {
			Shop shop = new Shop();
			//add数据录入
			shop.setCode(GUID.generateCode());
			shop.setShopNo(GUID.getPreUUID());
			shop.setShopName(addShop.getShopName());
			shop.setShopType(addShop.getShopType());
			shop.setMemberNoMerchant(addShop.getMemberNoMerchant());
			shop.setMemberNameMerchant(addShop.getMemberNameMerchant());
			shop.setStatus(addShop.getStatus());
			shop.setTelephone(addShop.getTelephone());
			shop.setMobile(addShop.getMobile());
			shop.setEmail(addShop.getEmail());
			shop.setAddress(addShop.getAddress());
			shop.setAreaCode(addShop.getAreaCode());
			shop.setAreaName(addShop.getAreaName());
			shop.setProvinceCode(addShop.getProvinceCode());
			shop.setCityCode(addShop.getCityCode());
			shop.setCityAreaCode(addShop.getCityAreaCode());
			shop.setAddrInfo(addShop.getAddrInfo());
			shop.setLogoAddr(addShop.getLogoAddr());
			shop.setLongitude(addShop.getLongitude());
			shop.setLatitude(addShop.getLatitude());
			shop.setBizScope(addShop.getBizScope());
			shop.setQcord(addShop.getQcord());
			shop.setCreateId(addShop.getCreateId());
			shop.setCreateDate(new Date());
			shop.setUpdateId(addShop.getCreateId());
			shop.setUpdateDate(new Date());
			shop.setOpenDate(addShop.getOpenDate());
			shop.setRemark4(addShop.getRemark4());
			shop.setRemark3(addShop.getRemark3());
			shop.setRemark(addShop.getRemark());
			shop.setRemark2(addShop.getRemark2());
			shop.setShopNoMerchant(addShop.getShopNoMerchant());
			shopDao.insertSelective(shop);
			AddShopReturn addShopReturn = new AddShopReturn();

			logger.debug("addShop(AddShop) - end - return value={}", addShopReturn); 
			return addShopReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增门店表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_ADD_ERROR,"新增门店表信息错误！",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IShopService#delShop(com.lj.business.member.dto.DelShop)
	 */
	@Override
	public DelShopReturn delShop(
			DelShop delShop) throws TsfaServiceException {
		logger.debug("delShop(DelShop delShop={}) - start", delShop); 

		AssertUtils.notNull(delShop);
		AssertUtils.notNull(delShop.getCode(),"ID不能为空！");
		try {
			shopDao.deleteByPrimaryKey(delShop.getCode());
			DelShopReturn delShopReturn  = new DelShopReturn();

			logger.debug("delShop(DelShop) - end - return value={}", delShopReturn); //$NON-NLS-1$
			return delShopReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除门店表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_DEL_ERROR,"删除门店表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IShopService#updateShop(com.lj.business.member.dto.UpdateShop)
	 */
	@Override
	public UpdateShopReturn updateShop(
			UpdateShop updateShop)
					throws TsfaServiceException {
		logger.debug("updateShop(UpdateShop updateShop={}) - start", updateShop); //$NON-NLS-1$

		AssertUtils.notNull(updateShop);
		AssertUtils.notNullAndEmpty(updateShop.getCode(),"Code不能为空");
		try {
			Shop shop = new Shop();
			//update数据录入
			shop.setCode(updateShop.getCode());
			shop.setShopName(updateShop.getShopName());
			shop.setShopType(updateShop.getShopType());
			shop.setMemberNoMerchant(updateShop.getMemberNoMerchant());
			shop.setMemberNameMerchant(updateShop.getMemberNameMerchant());
			shop.setStatus(updateShop.getStatus());
			shop.setTelephone(updateShop.getTelephone());
			shop.setMobile(updateShop.getMobile());
			shop.setEmail(updateShop.getEmail());
			shop.setAddress(updateShop.getAddress());
			shop.setAreaCode(updateShop.getAreaCode());
			shop.setAreaName(updateShop.getAreaName());
			shop.setProvinceCode(updateShop.getProvinceCode());
			shop.setCityCode(updateShop.getCityCode());
			shop.setCityAreaCode(updateShop.getCityAreaCode());
			shop.setAddrInfo(updateShop.getAddrInfo());
			shop.setLogoAddr(updateShop.getLogoAddr());
			shop.setLongitude(updateShop.getLongitude());
			shop.setLatitude(updateShop.getLatitude());
			shop.setBizScope(updateShop.getBizScope());
			shop.setQcord(updateShop.getQcord());
			shop.setUpdateId(updateShop.getUpdateId());
			shop.setUpdateDate(updateShop.getUpdateDate());
			shop.setOpenDate(updateShop.getOpenDate());
			shop.setRemark4(updateShop.getRemark4());
			shop.setRemark3(updateShop.getRemark3());
			shop.setRemark(updateShop.getRemark());
			shop.setRemark2(updateShop.getRemark2());
			shop.setShopNoMerchant(updateShop.getShopNoMerchant());
			AssertUtils.notUpdateMoreThanOne(shopDao.updateByPrimaryKeySelective(shop));
			UpdateShopReturn updateShopReturn = new UpdateShopReturn();

			logger.debug("updateShop(UpdateShop) - end - return value={}", updateShopReturn); //$NON-NLS-1$
			return updateShopReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("门店表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_UPDATE_ERROR,"门店表信息更新错误！",e);
		}
	}



	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IShopService#findShop(com.lj.business.member.dto.FindShop)
	 */
	@Override
	public FindShopReturn findShop(
			FindShop findShop) throws TsfaServiceException {
		logger.debug("findShop(FindShop findShop={}) - start", findShop); //$NON-NLS-1$

		AssertUtils.notNull(findShop);
		AssertUtils.notAllNull(findShop.getCode(),"ID不能为空");
		try {
			Shop shop = shopDao.selectByPrimaryKey(findShop.getCode());
			if(shop == null){
				throw new TsfaServiceException(ErrorCode.SHOP_NOT_EXIST_ERROR,"门店信息不存在");
			}
			FindShopReturn findShopReturn = new FindShopReturn();
			//find数据录入
			findShopReturn.setCode(shop.getCode());
			findShopReturn.setShopNo(shop.getShopNo());
			findShopReturn.setShopName(shop.getShopName());
			findShopReturn.setShopType(shop.getShopType());
			findShopReturn.setMemberNoMerchant(shop.getMemberNoMerchant());
			findShopReturn.setMemberNameMerchant(shop.getMemberNameMerchant());
			findShopReturn.setStatus(shop.getStatus());
			findShopReturn.setTelephone(shop.getTelephone());
			findShopReturn.setMobile(shop.getMobile());
			findShopReturn.setEmail(shop.getEmail());
			findShopReturn.setAddress(shop.getAddress());
			findShopReturn.setAreaCode(shop.getAreaCode());
			findShopReturn.setAreaName(shop.getAreaName());
			findShopReturn.setProvinceCode(shop.getProvinceCode());
			findShopReturn.setCityCode(shop.getCityCode());
			findShopReturn.setCityAreaCode(shop.getCityAreaCode());
			findShopReturn.setAddrInfo(shop.getAddrInfo());
			findShopReturn.setLogoAddr(shop.getLogoAddr());
			findShopReturn.setLongitude(shop.getLongitude());
			findShopReturn.setLatitude(shop.getLatitude());
			findShopReturn.setBizScope(shop.getBizScope());
			findShopReturn.setQcord(shop.getQcord());
			findShopReturn.setCreateId(shop.getCreateId());
			findShopReturn.setCreateDate(shop.getCreateDate());
			findShopReturn.setUpdateId(shop.getUpdateId());
			findShopReturn.setUpdateDate(shop.getUpdateDate());
			findShopReturn.setRemark4(shop.getRemark4());
			findShopReturn.setRemark3(shop.getRemark3());
			findShopReturn.setRemark(shop.getRemark());
			findShopReturn.setRemark2(shop.getRemark2());
			findShopReturn.setShopNoMerchant(shop.getShopNoMerchant());
			logger.debug("findShop(FindShop) - end - return value={}", findShopReturn); //$NON-NLS-1$
			return findShopReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找门店表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"查找门店表信息错误！",e);
		}


	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IShopService#findShopPage(com.lj.business.member.dto.FindShopPage)
	 */
	@Override
	public Page<FindShopPageReturn> findShopPage(
			FindShopPage findShopPage)
					throws TsfaServiceException {
		logger.debug("findShopPage(FindShopPage findShopPage={}) - start", findShopPage); //$NON-NLS-1$

		AssertUtils.notNull(findShopPage);
		List<FindShopPageReturn> returnList;
		int count = 0;
		try {
			returnList = shopDao.findShopPage(findShopPage);
			count = shopDao.findShopPageCount(findShopPage);
		}  catch (Exception e) {
			logger.error("门店表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_PAGE_ERROR,"门店表信息分页查询错误.！",e);
		}
		Page<FindShopPageReturn> returnPage = new Page<FindShopPageReturn>(returnList, count, findShopPage);

		logger.debug("findShopPage(FindShopPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}

	@Override
	public List<FindShopPageReturn> findShopsExport(FindShopPage findShopPage) {
		List<FindShopPageReturn> returnList=null;
		try {
			returnList = shopDao.findShopsExport(findShopPage);
		}  catch (Exception e) {
			logger.error("门店表信息查询错误",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"门店表信息查询错误.！",e);
		}
		return  returnList;
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IShopService#findShops(com.lj.business.member.dto.FindShop)
	 */
	@Override
	public List<FindShopPageReturn> findShops(FindShop findShop) {

		AssertUtils.notNull(findShop);
		List<FindShopPageReturn> returnList=null;
		try {
			returnList = shopDao.findShops(findShop);
		}  catch (Exception e) {
			logger.error("门店表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_PAGE_ERROR,"门店表信息分页查询错误.！",e);
		}

		return  returnList;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IShopService#findShopCount(com.lj.business.member.dto.FindShopPage)
	 */
	@Override
	public int findShopCount(FindShopPage findShopPage) {
		int count=0;
		try {
			count = shopDao.findShopPageCount(findShopPage);
			return count;
		}  catch (Exception e) {
			logger.error("查找门店统计信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"查找门店统计信息错误！",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IShopService#countByCondition(java.util.Map)
	 */
	@Override
	public Map<String, Object> countByCondition(Map<String, Object> parmMap) {
		AssertUtils.notNull(parmMap);
		AssertUtils.notNull(parmMap.get("memberNoMerchant"));

		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			returnMap = shopDao.countByCondition(parmMap);
		}  catch (Exception e) {
			logger.error("查找门店统计信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"查找门店统计信息错误！",e);
		}
		return returnMap;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IShopService#findShopDetail(com.lj.business.member.dto.FindShopDetail)
	 */
	@Override
	public FindShopDetailReturn findShopDetail(FindShopDetail findShopDetail)
			throws TsfaServiceException {
		logger.debug("findShopDetail(FindShopDetail findShopDetail={}) - start", findShopDetail); //$NON-NLS-1$

		AssertUtils.notNull(findShopDetail);
		String merchantNo = findShopDetail.getMerchantNo();
		AssertUtils.notNullAndEmpty(merchantNo,"商户编号不能为空");
		String shopNo = findShopDetail.getShopNo();
		AssertUtils.notNullAndEmpty(shopNo,"分店编号不能为空");
		try {
			FindShopDetailReturn findShopDetailReturn = new FindShopDetailReturn();
			//门店信息
			Shop shop =shopDao.selectByShopNo(shopNo);
			findShopDetailReturn.setLogoAddr(shop.getLogoAddr());
			//店长信息
			ManagerMember managerMemberQuery = new ManagerMember();
			managerMemberQuery.setMemberNoMerchant(merchantNo);
			managerMemberQuery.setMemberNoShop(shopNo);
			managerMemberQuery.setMemberType(MemberType.SHOP.toString());
			List<ManagerMember> list = managerMemberDao.selectByParams(managerMemberQuery);
			if(list.size() >= 1){
				ManagerMember managerMember = list.get(0);
				findShopDetailReturn.setMemberNameSp(managerMember.getMemberName());
			}
			//区域经理
			managerMemberQuery.setAreaCode(shop.getAreaCode());
			managerMemberQuery.setMemberType(MemberType.AREA_MAN.toString());
			managerMemberQuery.setMemberNoShop(null);
			List<ManagerMember> listArea = managerMemberDao.selectByParams(managerMemberQuery);
			if(listArea.size() >= 1){
				findShopDetailReturn.setMemberNameArea(listArea.get(0).getMemberName());
			}

			//店员信息
			GuidMember guidMemberQuery = new GuidMember();
			guidMemberQuery.setShopNo(shopNo);
			List<GuidInfoShop> memberInfoGuid = guidMemberDao.selectGuidInfoShop(guidMemberQuery);
			findShopDetailReturn.setMemberInfoGuid(memberInfoGuid);

			logger.debug("findShopDetail(FindShopDetail) - end - return value={}", findShopDetailReturn); //$NON-NLS-1$
			return findShopDetailReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找门店表信息错误",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"查找门店表信息错误",e);
		}
	}
	
	@Override
	public List<FindShopPageReturn> findMonthOpen(FindShop findShop) {
		logger.debug("findMonthOpen(FindShop findShop={}) - start", findShop); //$NON-NLS-1$

		AssertUtils.notNull(findShop);
		AssertUtils.notNull(findShop.getMemberNoMerchant());
		List<FindShopPageReturn> returnList=null;
		findShop.setStartTime(DateUtils.getMonthFirstDay());
		findShop.setEndTime(DateUtils.getMonthLastDay());
		findShop.setStatus(ShopStatus.OPENED.toString());
		try {
			returnList = shopDao.findShops(findShop);
		}  catch (Exception e) {
			logger.error("门店表信息查询错误",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_PAGE_ERROR,"门店表信息查询错误.！",e);
		}

		logger.debug("findMonthOpen(FindShop) - end - return value={}", returnList); //$NON-NLS-1$
		return  returnList;
	} 
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IShopService#findShopByShopNo(com.lj.business.member.dto.FindShop)
	 */
	@Override
	public FindShopReturn findShopByShopNo(FindShop findShop) throws TsfaServiceException {
		logger.debug("findShop(FindShop findShop={}) - start", findShop); //$NON-NLS-1$

		AssertUtils.notNull(findShop);
		AssertUtils.notAllNull(findShop.getShopNo(),"分店编号不能为空");
		try {
			Shop shop = shopDao.selectByShopNo(findShop.getShopNo());
			if(shop == null){
				throw new TsfaServiceException(ErrorCode.SHOP_NOT_EXIST_ERROR,"门店信息不存在");
			}
			FindShopReturn findShopReturn = new FindShopReturn();
			//find数据录入
			findShopReturn.setCode(shop.getCode());
			findShopReturn.setShopNo(shop.getShopNo());
			findShopReturn.setShopName(shop.getShopName());
			findShopReturn.setMemberNoMerchant(shop.getMemberNoMerchant());
			findShopReturn.setMemberNameMerchant(shop.getMemberNameMerchant());
			findShopReturn.setStatus(shop.getStatus());
			findShopReturn.setTelephone(shop.getTelephone());
			findShopReturn.setMobile(shop.getMobile());
			findShopReturn.setEmail(shop.getEmail());
			findShopReturn.setAddress(shop.getAddress());
			findShopReturn.setAreaCode(shop.getAreaCode());
			findShopReturn.setAreaName(shop.getAreaName());
			findShopReturn.setProvinceCode(shop.getProvinceCode());
			findShopReturn.setCityCode(shop.getCityCode());
			findShopReturn.setCityAreaCode(shop.getCityAreaCode());
			findShopReturn.setAddrInfo(shop.getAddrInfo());
			findShopReturn.setLogoAddr(shop.getLogoAddr());
			findShopReturn.setLongitude(shop.getLongitude());
			findShopReturn.setLatitude(shop.getLatitude());
			findShopReturn.setBizScope(shop.getBizScope());
			findShopReturn.setQcord(shop.getQcord());
			findShopReturn.setCreateId(shop.getCreateId());
			findShopReturn.setCreateDate(shop.getCreateDate());
			findShopReturn.setOpenDate(shop.getOpenDate());
			findShopReturn.setUpdateId(shop.getUpdateId());
			findShopReturn.setUpdateDate(shop.getUpdateDate());
			findShopReturn.setRemark4(shop.getRemark4());
			findShopReturn.setRemark3(shop.getRemark3());
			findShopReturn.setRemark(shop.getRemark());
			findShopReturn.setRemark2(shop.getRemark2());
			findShopReturn.setShopNoMerchant(shop.getShopNoMerchant());
			logger.debug("findShop(FindShop) - end - return value={}", findShopReturn); //$NON-NLS-1$
			return findShopReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找门店表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"查找门店表信息错误！",e);
		}


	}
	@Override
	public List<FindShopReturnAreaCode> selectByAreaCode(
			FindShopDto findShopDto) throws TsfaServiceException {
		logger.debug("selectByAreaCode(FindShopDetail findShopDetail={}) - start", findShopDto);
		AssertUtils.notNull(findShopDto);
		List<FindShopReturnAreaCode> list=null;
		try {
			list=shopDao.selectByAreaCode(findShopDto);
		} catch (Exception e) {
			logger.error("查找门店表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"查找门店表信息错误！",e);
		}
		return list;
	}


	@Override
	public int findShopCounts(FindShopDto findShopDto) {
		AssertUtils.notNull(findShopDto);
	    int count=0;
		try {
			count=shopDao.findShopCounts(findShopDto);
		} catch (Exception e) {
			logger.error("统计门店错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"统计门店表信息错误！",e);
		}
		return count;
	}


	@Override
	public List<Map<String, Object>> findGroupByCity(Map<String,Object> parmMap) {
		logger.debug("findGroupByCity - start");
		AssertUtils.notNull(parmMap);
		AssertUtils.notNull(parmMap.get("merchantNo"));
		List<Map<String, Object>> list;
		try {
			list=shopDao.findGroupByCity(parmMap);
		} catch (Exception e) {
			logger.error("获取门店城市接口错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"获取门店城市接口错误！",e);
		}
		return list;
	}

	@Override
	public List<FindShopPageReturn> selectByShopNoList(List<String> shopNoList) {
		try {
		    return shopDao.selectByShopNoList(shopNoList);
		} catch (Exception e) {
			logger.error("查询商户列表时错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"查询商户列表时错误！",e);
		}
	}


	@Override
	public List<FindShopReturnAreaCode> selectByProvinceCode(FindShopDto findShopDto) {
		logger.debug("selectByProvinceCode(FindShopDto findShopDto)- start");
		List<FindShopReturnAreaCode> findShopReturnAreaCode=null;
		try {
			findShopReturnAreaCode=shopDao.selectByProvinceCode(findShopDto);
		} catch (Exception e) {
			logger.error("查找门店表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"查找门店表信息错误！",e);
		}
		return findShopReturnAreaCode;
	}


	@Override
	public List<FindShopReturnAreaCode>  findAreaCode(FindShopDto findShopDto) {
		logger.debug("findAreaCode(FindShopDto findShopDto)- start");
		List<FindShopReturnAreaCode>  findShopReturnAreaCode=null;
		try {
			findShopReturnAreaCode=shopDao.findAreaCode(findShopDto);
		} catch (Exception e) {
			logger.error("查找门店表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"查找门店表信息错误！",e);
		}
		return findShopReturnAreaCode;
	}


	@Override
	public List<FindShopReturnAreaCode> findShopByAreaCode(FindShopDto findShopDto) {
		logger.debug("findShopByAreaCode(FindShopDto findShopDto={})- start", findShopDto);
		List<FindShopReturnAreaCode> findShopReturn=null;
		try {
			findShopReturn = shopDao.findShopByAreaCode(findShopDto);
		} catch (Exception e) {
			logger.error("根据地区查找门店表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"根据地区查找门店表信息错误！",e);
		}
		return findShopReturn;
	}


	@Override
	public  List<Map<String, Object>> findCountBySize(Map<String, Object> map) {
		logger.debug("findCountBySize(Map<String, Object>={})- start", map);
		AssertUtils.notNull(map);
		List<Map<String, Object>> returnMap = null;
		try {
			returnMap=shopDao.findCountBySize(map);
		} catch (Exception e) {
			logger.error("根据地区查找门店表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"根据地区查找门店表信息错误！",e);
		}
		 
		return returnMap;
	}


	@Override
	public List<FindShopPageReturn> findShopType(FindShop findShop) {
		logger.debug("findShop(FindShop findShop={}) - start", findShop); //$NON-NLS-1$
		AssertUtils.notNull(findShop);
		List<FindShopPageReturn> list=null;
		try {
			list=shopDao.findShopType(findShop);
		} catch (Exception e) {
			logger.error("根据地区查找门店表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"根据地区查找门店表信息错误！",e);
		}
		return list;
	}


	@Override
	public FindShopPageReturn findShopNoByCode(FindShop findShop) {
		logger.debug("findShop(FindShop findShop={}) - start", findShop); //$NON-NLS-1$
		AssertUtils.notNull(findShop);
		FindShopPageReturn findShopPageReturn=null;
		try {
			findShopPageReturn=shopDao.findShopNoByCode(findShop);
		} catch (Exception e) {
			logger.error("根据地区查找门店表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"根据地区查找门店表信息错误！",e);
		}
		return findShopPageReturn;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IShopService#findShopNoByMerchantNo_ec(com.lj.business.member.dto.FindShop)
	 */
	@Override
	public FindShopPageReturn findShopByMerchantNo_ec(FindShop findShop)
			throws TsfaServiceException {
		logger.debug("findShopNoByMerchantNo_ec(FindShop findShop={}) - start", findShop); //$NON-NLS-1$
		AssertUtils.notNull(findShop);
		AssertUtils.notAllNull(findShop.getMemberNoMerchant(),"memberNoMerchant不能为空");
		FindShopPageReturn findShopPageReturn=null;
		try {
			List<FindShopPageReturn>  lists=shopDao.findShops(findShop);
			if (lists != null && lists.size() > 0) {
				return lists.get(0);
			}
		} catch (Exception e) {
			logger.error("根据商户号查找门店表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_FIND_ERROR,"根据商户号查找门店表信息错误！",e);
		}
		return findShopPageReturn;
	}



}
