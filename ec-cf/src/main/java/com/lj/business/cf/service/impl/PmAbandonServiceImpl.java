package com.lj.business.cf.service.impl;

import java.util.Date;
import java.util.HashMap;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IPmAbandonDao;
import com.lj.business.cf.domain.PmAbandon;
import com.lj.business.cf.dto.clientFollowSummary.FindAbandonRecordCountReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindBuyRecordPage;
import com.lj.business.cf.dto.pmAbandon.AbandonCheckDto;
import com.lj.business.cf.dto.pmAbandon.AddPmAbandon;
import com.lj.business.cf.dto.pmAbandon.AddPmAbandonReturn;
import com.lj.business.cf.dto.pmAbandon.DelPmAbandon;
import com.lj.business.cf.dto.pmAbandon.DelPmAbandonReturn;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandon;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonList;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonListReturn;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonPage;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonPageReturn;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonReturn;
import com.lj.business.cf.dto.pmAbandon.UpdatePmAbandon;
import com.lj.business.cf.dto.pmAbandon.UpdatePmAbandonReturn;
import com.lj.business.cf.emus.CheckResult;
import com.lj.business.cf.emus.MemerType;
import com.lj.business.cf.service.IClientFollowSummaryService;
import com.lj.business.cf.service.IPmAbandonService;


/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 邹磊
 * 
 * 
 * 
 * CreateDate: 2017-06-14
 */
@Service
public class PmAbandonServiceImpl implements IPmAbandonService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(PmAbandonServiceImpl.class);
	

	/** The pm abandon dao. */
	@Resource
	private IPmAbandonDao pmAbandonDao;
	
	@Resource
	private IClientFollowSummaryService clientFollowSummaryService;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IPmAbandonService#addPmAbandon(com.lj.business.cf.dto.AddPmAbandon)
	 */
	
	@Override
	public AddPmAbandonReturn addPmAbandon(
			AddPmAbandon addPmAbandon) throws TsfaServiceException {
		logger.debug("addPmAbandon(AddPmAbandon addPmAbandon={}) - start", addPmAbandon); 

		AssertUtils.notNull(addPmAbandon);
		try {
			PmAbandon pmAbandon = new PmAbandon();
			//add数据录入
			pmAbandon.setCode(GUID.getPreUUID());
			pmAbandon.setMerchantNo(addPmAbandon.getMerchantNo());
			pmAbandon.setMemberNoCheck(addPmAbandon.getMemberNoCheck());
			pmAbandon.setMemberNoGm(addPmAbandon.getMemberNoGm());
			pmAbandon.setMemberNameGm(addPmAbandon.getMemberNameGm());
			pmAbandon.setMemberNo(addPmAbandon.getMemberNo());
			pmAbandon.setMemberName(addPmAbandon.getMemberName());
			pmAbandon.setResean(addPmAbandon.getResean());
			pmAbandon.setFollowDate(addPmAbandon.getFollowDate());
			pmAbandon.setCheckDate(addPmAbandon.getCheckDate());
			pmAbandon.setChecker(addPmAbandon.getChecker());
			pmAbandon.setCheckDes(addPmAbandon.getCheckDes());
			pmAbandon.setCfNo(addPmAbandon.getCfNo());
			pmAbandon.setRemark(addPmAbandon.getRemark());
			pmAbandon.setCreateId(addPmAbandon.getCreateId());
			pmAbandon.setUpdateId(addPmAbandon.getUpdateId());
			pmAbandon.setUpdateDate(addPmAbandon.getUpdateDate());
			pmAbandon.setBomCode(addPmAbandon.getBomCode());
			pmAbandon.setBomName(addPmAbandon.getBomName());
			pmAbandon.setCheckResult(addPmAbandon.getCheckResult());
			pmAbandon.setCreateDate(new Date());
			pmAbandonDao.insert(pmAbandon);
			AddPmAbandonReturn addPmAbandonReturn = new AddPmAbandonReturn();
			addPmAbandonReturn.setCode(pmAbandon.getCode());
			logger.debug("addPmAbandon(AddPmAbandon) - end - return value={}", addPmAbandonReturn); 
			return addPmAbandonReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户放弃表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_ABANDON_ADD_ERROR,"新增客户放弃表信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IPmAbandonService#delPmAbandon(com.lj.business.cf.dto.DelPmAbandon)
	 */
	
	@Override
	public DelPmAbandonReturn delPmAbandon(
			DelPmAbandon delPmAbandon) throws TsfaServiceException {
		logger.debug("delPmAbandon(DelPmAbandon delPmAbandon={}) - start", delPmAbandon); 

		AssertUtils.notNull(delPmAbandon);
		AssertUtils.notNull(delPmAbandon.getCode(),"ID不能为空！");
		try {
			pmAbandonDao.deleteByPrimaryKey(delPmAbandon.getCode());
			DelPmAbandonReturn delPmAbandonReturn  = new DelPmAbandonReturn();

			logger.debug("delPmAbandon(DelPmAbandon) - end - return value={}", delPmAbandonReturn); //$NON-NLS-1$
			return delPmAbandonReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除客户放弃表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_ABANDON_DEL_ERROR,"删除客户放弃表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IPmAbandonService#updatePmAbandon(com.lj.business.cf.dto.UpdatePmAbandon)
	 */
	
	@Override
	public UpdatePmAbandonReturn updatePmAbandon(
			UpdatePmAbandon updatePmAbandon)
			throws TsfaServiceException {
		logger.debug("updatePmAbandon(UpdatePmAbandon updatePmAbandon={}) - start", updatePmAbandon); //$NON-NLS-1$

		AssertUtils.notNull(updatePmAbandon);
		AssertUtils.notNullAndEmpty(updatePmAbandon.getCode(),"ID不能为空");
		try {
			PmAbandon pmAbandon = new PmAbandon();
			//update数据录入
			pmAbandon.setCode(updatePmAbandon.getCode());
			pmAbandon.setMerchantNo(updatePmAbandon.getMerchantNo());
			pmAbandon.setMemberNoCheck(updatePmAbandon.getMemberNoCheck());
			pmAbandon.setMemberNoGm(updatePmAbandon.getMemberNoGm());
			pmAbandon.setMemberNameGm(updatePmAbandon.getMemberNameGm());
			pmAbandon.setResean(updatePmAbandon.getResean());
			pmAbandon.setFollowDate(updatePmAbandon.getFollowDate());
			pmAbandon.setCheckDate(updatePmAbandon.getCheckDate());
			pmAbandon.setChecker(updatePmAbandon.getChecker());
			pmAbandon.setCheckDes(updatePmAbandon.getCheckDes());
			pmAbandon.setCfNo(updatePmAbandon.getCfNo());
			pmAbandon.setRemark(updatePmAbandon.getRemark());
			pmAbandon.setCreateId(updatePmAbandon.getCreateId());
			pmAbandon.setCreateDate(updatePmAbandon.getCreateDate());
			pmAbandon.setUpdateId(updatePmAbandon.getUpdateId());
			pmAbandon.setUpdateDate(updatePmAbandon.getUpdateDate());
			pmAbandon.setBomCode(updatePmAbandon.getBomCode());
			pmAbandon.setBomName(updatePmAbandon.getBomName());
			AssertUtils.notUpdateMoreThanOne(pmAbandonDao.updateByPrimaryKeySelective(pmAbandon));
			UpdatePmAbandonReturn updatePmAbandonReturn = new UpdatePmAbandonReturn();

			logger.debug("updatePmAbandon(UpdatePmAbandon) - end - return value={}", updatePmAbandonReturn); //$NON-NLS-1$
			return updatePmAbandonReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户放弃表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_ABANDON_UPDATE_ERROR,"客户放弃表信息更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IPmAbandonService#findPmAbandon(com.lj.business.cf.dto.FindPmAbandon)
	 */
	
	@Override
	public FindPmAbandonReturn findPmAbandon(
			FindPmAbandon findPmAbandon) throws TsfaServiceException {
		logger.debug("findPmAbandon(FindPmAbandon findPmAbandon={}) - start", findPmAbandon); //$NON-NLS-1$

		AssertUtils.notNull(findPmAbandon);
		AssertUtils.notAllNull(findPmAbandon.getCode(),"编号不能为空");
		try {
			PmAbandon pmAbandon = pmAbandonDao.selectByPrimaryKey(findPmAbandon.getCode());
			if(pmAbandon == null){
				throw new TsfaServiceException(ErrorCode.PM_ABANDON_NOT_EXIST_ERROR,"客户放弃表信息不存在");
			}
			FindPmAbandonReturn findPmAbandonReturn = new FindPmAbandonReturn();
			//find数据录入
			findPmAbandonReturn.setCode(pmAbandon.getCode());
			findPmAbandonReturn.setMerchantNo(pmAbandon.getMerchantNo());
			findPmAbandonReturn.setMemberNoCheck(pmAbandon.getMemberNoCheck());
			findPmAbandonReturn.setMemberNo(pmAbandon.getMemberNo());
			findPmAbandonReturn.setMemberName(pmAbandon.getMemberName());
			findPmAbandonReturn.setMemberNoGm(pmAbandon.getMemberNoGm());
			findPmAbandonReturn.setMemberNameGm(pmAbandon.getMemberNameGm());
			findPmAbandonReturn.setResean(pmAbandon.getResean());
			findPmAbandonReturn.setFollowDate(pmAbandon.getFollowDate());
			findPmAbandonReturn.setCheckDate(pmAbandon.getCheckDate());
			findPmAbandonReturn.setChecker(pmAbandon.getChecker());
			findPmAbandonReturn.setCheckDes(pmAbandon.getCheckDes());
			findPmAbandonReturn.setCfNo(pmAbandon.getCfNo());
			findPmAbandonReturn.setRemark(pmAbandon.getRemark());
			findPmAbandonReturn.setCreateId(pmAbandon.getCreateId());
			findPmAbandonReturn.setCreateDate(pmAbandon.getCreateDate());
			findPmAbandonReturn.setUpdateId(pmAbandon.getUpdateId());
			findPmAbandonReturn.setUpdateDate(pmAbandon.getUpdateDate());
			findPmAbandonReturn.setBomCode(pmAbandon.getBomCode());
			findPmAbandonReturn.setBomName(pmAbandon.getBomName());
			
			logger.debug("findPmAbandon(FindPmAbandon) - end - return value={}", findPmAbandonReturn); //$NON-NLS-1$
			return findPmAbandonReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户放弃表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_ABANDON_FIND_ERROR,"查找客户放弃表信息错误！",e);
		}


	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IPmAbandonService#findPmAbandonPage(com.lj.business.cf.dto.FindPmAbandonPage)
	 */
	
	@Override
	public Page<FindPmAbandonPageReturn> findPmAbandonPage(
			FindPmAbandonPage findPmAbandonPage)
			throws TsfaServiceException {
		logger.debug("findPmAbandonPage(FindPmAbandonPage findPmAbandonPage={}) - start", findPmAbandonPage); //$NON-NLS-1$

		AssertUtils.notNull(findPmAbandonPage);
		List<FindPmAbandonPageReturn> returnList;
		int count = 0;
		try {
			returnList = pmAbandonDao.findPmAbandonPage(findPmAbandonPage);
			count = pmAbandonDao.findPmAbandonPageCount(findPmAbandonPage);
		}  catch (Exception e) {
			logger.error("客户放弃表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.PM_ABANDON_FIND_PAGE_ERROR,"客户放弃表信息分页查询错误.！",e);
		}
		Page<FindPmAbandonPageReturn> returnPage = new Page<FindPmAbandonPageReturn>(returnList, count, findPmAbandonPage);

		logger.debug("findPmAbandonPage(FindPmAbandonPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IPmAbandonService#abandonMember(com.lj.business.cf.dto.AddPmAbandon)
	 */
	
	@Override
	public AddPmAbandonReturn abandonMember(AddPmAbandon addPmAbandon) throws TsfaServiceException {
		
		logger.debug("abandonMember(AddPmAbandon addPmAbandon={}) - start", addPmAbandon); 

		AssertUtils.notNull(addPmAbandon);
		try {
			PmAbandon pmAbandon = new PmAbandon();
			//add数据录入
			pmAbandon.setCode(GUID.getPreUUID());
			pmAbandon.setMerchantNo(addPmAbandon.getMerchantNo());
			pmAbandon.setMemberNoCheck(addPmAbandon.getMemberNoCheck());
			pmAbandon.setMemberNoGm(addPmAbandon.getMemberNoGm());
			pmAbandon.setMemberNameGm(addPmAbandon.getMemberNameGm());
			pmAbandon.setResean(addPmAbandon.getResean());
			pmAbandon.setCfNo(addPmAbandon.getCfNo());
			pmAbandon.setFollowDate(addPmAbandon.getFollowDate());
			pmAbandon.setRemark(addPmAbandon.getRemark());
			pmAbandon.setCreateId(addPmAbandon.getCreateId());
			pmAbandon.setCreateDate(addPmAbandon.getCreateDate());
			pmAbandon.setUpdateId(addPmAbandon.getUpdateId());
			pmAbandon.setUpdateDate(addPmAbandon.getUpdateDate());
			pmAbandon.setBomCode(addPmAbandon.getBomCode());
			pmAbandon.setBomName(addPmAbandon.getBomName());
			pmAbandonDao.insert(pmAbandon);
			
			AddPmAbandonReturn addPmAbandonReturn = new AddPmAbandonReturn();
			
			logger.debug("abandonMember(AddPmAbandon) - end - return value={}", addPmAbandonReturn); 
			return addPmAbandonReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户放弃表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_ABANDON_ADD_ERROR,"新增客户放弃表信息错误！",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IPmAbandonService#abandonHistory(com.lj.business.cf.dto.FindPmAbandon)
	 */
	
	@Override
	public List<FindPmAbandonReturn> abandonHistory(FindPmAbandon findPmAbandon) throws TsfaServiceException {
		logger.debug("abandonHistory(FindPmAbandon abandonHistory={}) - start", findPmAbandon); //$NON-NLS-1$

		List<FindPmAbandonReturn> returnList = null;;
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberNo", findPmAbandon.getMemberNo());
			map.put("memberGMCode", findPmAbandon.getMemberGMCode());
			returnList = pmAbandonDao.abandonHistory(map);
		}  catch (Exception e) {
			logger.error("客户放弃表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.PM_ABANDON_FIND_PAGE_ERROR,"客户放弃表信息分页查询错误.！",e);
		}

		logger.debug("abandonHistory(FindPmAbandon) - end - return value={}", returnList); //$NON-NLS-1$
		return  returnList;
	}

	/**
	 * 放弃审批.
	 *
	 * @param abandonCheckDto the abandon check dto
	 * @return the int
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public int abandonCheck(AbandonCheckDto abandonCheckDto) throws TsfaServiceException {
		logger.debug("abandonCheck(AbandonCheckDto abandonCheckDto={}) - start", abandonCheckDto); //$NON-NLS-1$
		
		AssertUtils.notNull(abandonCheckDto);
		AssertUtils.notNullAndEmpty(abandonCheckDto.getCode(), "放弃编号不能为空");
		AssertUtils.notNullAndEmpty(abandonCheckDto.getMemberType(), "用户类型不能为空");
		AssertUtils.isEqual(abandonCheckDto.getMemberType(), MemerType.SHOP.toString(), "用户类型不是店长");
		AssertUtils.notNullAndEmpty(abandonCheckDto.getChecker(), "审批人姓名不能为空");
		AssertUtils.notNullAndEmpty(abandonCheckDto.getMemberNoCheck(), "审批人编号不能为空");
		
		int ret = 0;
		try {
			PmAbandon pmAbandon = new PmAbandon();
			pmAbandon.setCode(abandonCheckDto.getCode());
			pmAbandon.setCheckResult(abandonCheckDto.getCheckResult());
			pmAbandon.setCheckDate(new Date());
			pmAbandon.setChecker(abandonCheckDto.getChecker());
			pmAbandon.setCheckDes(abandonCheckDto.getCheckDes());
			pmAbandon.setMemberNoCheck(abandonCheckDto.getMemberNoCheck());
			pmAbandon.setUpdateId(abandonCheckDto.getMemberNoCheck());
			pmAbandon.setUpdateDate(new Date());
			ret = pmAbandonDao.updateByPrimaryKeySelective(pmAbandon);
			logger.debug("abandonCheck(AbandonCheckDto abandonCheckDto={}) - end", abandonCheckDto); //$NON-NLS-1$
			return ret;
		}  catch (Exception e) {
			logger.error("客户放弃表审批错误",e);
			throw new TsfaServiceException(ErrorCode.PM_ABANDON_CHECK_ERROR,"客户放弃表审批错误.！",e);
		}

	}

	/**
	 * 放弃记录.
	 *
	 * @param findPmAbandonList the find pm abandon list
	 * @return the list< find pm abandon list return>
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public List<FindPmAbandonListReturn> findPmAbandonList(
			FindPmAbandonList findPmAbandonList)throws TsfaServiceException  {
		logger.debug("findPmAbandonList(FindPmAbandonList findPmAbandonList={}) - start", findPmAbandonList);
		List<FindPmAbandonListReturn> list=null;
		try {
			list=pmAbandonDao.findPmAbandonList(findPmAbandonList);
			
			FindBuyRecordPage findBuyRecordPage = new FindBuyRecordPage();
			findBuyRecordPage.setMemberNo(findPmAbandonList.getMemberNo());
			findBuyRecordPage.setMemberNoGm(findPmAbandonList.getMemberNoGm());
			findBuyRecordPage.setMerchantNo(findPmAbandonList.getMerchantNo());
			findBuyRecordPage.setStart(0);
			findBuyRecordPage.setLimit(10000);
			List<FindAbandonRecordCountReturn> listCount = clientFollowSummaryService.findAbandonRecordCount(findBuyRecordPage);
			Map<String,Integer> map = new HashMap<>();
			if(listCount != null && listCount.size() > 0){
				int total = 0;
				String cfNo = "";
				for(FindAbandonRecordCountReturn findAbandonRecordCountReturn : listCount){
					if("".equals(cfNo)){
						cfNo = findAbandonRecordCountReturn.getCfNo();
						total = total + findAbandonRecordCountReturn.getTotal();
					}else{
						if(cfNo.equals(findAbandonRecordCountReturn.getCfNo())){
							total = total + findAbandonRecordCountReturn.getTotal();
						}else{
							cfNo = findAbandonRecordCountReturn.getCfNo();
							total = findAbandonRecordCountReturn.getTotal();
						}
					}
					map.put(findAbandonRecordCountReturn.getPaCode(), total);
				}
			}
			
			if(list != null && list.size() > 0){
				for(FindPmAbandonListReturn findPmAbandonListReturn : list){
					Integer total = map.get(findPmAbandonListReturn.getCode());
					if(total == null){
						findPmAbandonListReturn.setFollowNum(0 + "");
					}else{
						findPmAbandonListReturn.setFollowNum(total + "");
					}
				}
			}
		} catch (Exception e) {
			logger.error("客户放弃表信息查询错误",e);
			throw new TsfaServiceException(ErrorCode.PM_ABANDON_FIND_PAGE_ERROR,"客户放弃表信息查询错误.！",e);
		}
		
		return list;
	}

	/**
	 * 修改未审批的放弃记录为拒绝.
	 *
	 * @param cfNo the cf no
	 * @param memberNo the member no
	 * @param memberNoGm the member no gm
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public void updateNoCheckByCfNo(String cfNo, String memberNo,String memberNoGm) throws TsfaServiceException {
		try{
			Map<String, Object> map = new HashMap<>();
			map.put("checkResult", CheckResult.REJECT);
			map.put("checkDes", "成单修改放弃审批状态为拒绝");
			map.put("cfNo", cfNo);
			map.put("memberNo", memberNo);
			map.put("memberNoGm", memberNoGm);
			map.put("oldCheckResult", CheckResult.WAIT);
			pmAbandonDao.updateNoCheckByCfNo(map);
		}catch (Exception e) {
			logger.error("修改未审批的放弃记录为拒绝错误",e);
			throw new TsfaServiceException(ErrorCode.PM_ABANDON_UPDATE_NOCHECK_ERROR,"修改未审批的放弃记录为拒绝错误.！",e);
		}
	}

	/**
	 * 查找未审批的放弃记录.
	 *
	 * @param cfNo the cf no
	 * @param memberNo the member no
	 * @param memberNoGm the member no gm
	 * @return the list< find pm abandon list return>
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public List<FindPmAbandonListReturn> findNoCheckByCfNo(String cfNo, String memberNo,String memberNoGm) throws TsfaServiceException {
		try{
			Map<String, Object> map = new HashMap<>();
			map.put("cfNo", cfNo);
			map.put("memberNo", memberNo);
			map.put("memberNoGm", memberNoGm);
			map.put("checkResult", CheckResult.WAIT);
			return pmAbandonDao.findNoCheckByCfNo(map);
		}catch (Exception e) {
			logger.error("查找未审批的放弃记录错误",e);
			throw new TsfaServiceException(ErrorCode.PM_ABANDON_UPDATE_NOCHECK_ERROR,"查找未审批的放弃记录错误.！",e);
		}
	}	
	
}
