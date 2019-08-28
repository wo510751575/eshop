package com.lj.eshop.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.IWshopInfoDao;
import com.lj.eshop.domain.WshopInfo;
import com.lj.eshop.dto.FindWshopInfoPage;
import com.lj.eshop.dto.WshopInfoDto;
import com.lj.eshop.service.IWshopInfoService;

@Service
public class WshopInfoServiceImpl implements IWshopInfoService {

	
	private static final Logger logger = LoggerFactory.getLogger(WshopInfoServiceImpl.class);
	
	@Autowired
	private IWshopInfoDao wshopInfoDao;
	
	@Override
	public WshopInfoDto addWshopInfo(WshopInfoDto wshopInfoDto)throws TsfaServiceException {
		logger.debug("addWshopInfo(WshopInfoDto wshopInfoDto)={}) - start", wshopInfoDto); 
		AssertUtils.notNull(wshopInfoDto);
		try {
			WshopInfo record = new WshopInfo();
			//add数据录入
			record.setCode(GUID.getPreUUID());
			record.setCreater(wshopInfoDto.getCreater());
			record.setDetail(wshopInfoDto.getDetail());
			record.setFlagInfo(wshopInfoDto.getFlagInfo());
			record.setImg1(wshopInfoDto.getImg1());
			record.setImg2(wshopInfoDto.getImg2());
			record.setImg3(wshopInfoDto.getImg3());
			record.setImg4(wshopInfoDto.getImg4());
			record.setImg5(wshopInfoDto.getImg5());
			record.setReadCnt(wshopInfoDto.getReadCnt());
			record.setShareCnt(wshopInfoDto.getShareCnt());
			record.setStatus(wshopInfoDto.getStatus());
			record.setTitle(wshopInfoDto.getTitle());
			record.setCreateTime(new Date());
			wshopInfoDao.insertSelective(record);
			WshopInfoDto returnDto = new WshopInfoDto();
			logger.debug("addWshopInfo(returnDto) - end - return:"+returnDto); 
			return returnDto;
			
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增微信加油站错误！",e);
			throw new TsfaServiceException(ErrorCode.ESHOP_WSHOPINFO_ADD_ERROR,"新增微信加油站错误！",e);
		}
	}

	@Override
	public WshopInfoDto updateWshopInfo(WshopInfoDto wshopInfoDto)
			throws TsfaServiceException {
		logger.debug("updateWshopInfo(WshopInfoDto wshopInfoDto)={}) - start", wshopInfoDto); 
		AssertUtils.notNull(wshopInfoDto);
		AssertUtils.notNullAndEmpty(wshopInfoDto.getCode(), "CODE不能为空");
		try {
			WshopInfo record = new WshopInfo();
			record.setCode(wshopInfoDto.getCode());
			record.setCreater(wshopInfoDto.getCreater());
			/*record.setCreateTime(wshopInfoDto.getCreateTime());*/
			record.setDetail(wshopInfoDto.getDetail());
			record.setFlagInfo(wshopInfoDto.getFlagInfo());
			record.setImg1(wshopInfoDto.getImg1());
			record.setImg2(wshopInfoDto.getImg2());
			record.setImg3(wshopInfoDto.getImg3());
			record.setImg4(wshopInfoDto.getImg4());
			record.setImg5(wshopInfoDto.getImg5());
			record.setReadCnt(wshopInfoDto.getReadCnt());
			record.setShareCnt(wshopInfoDto.getShareCnt());
			record.setStatus(wshopInfoDto.getStatus());
			record.setTitle(wshopInfoDto.getTitle());
			record.setUpdateTime(new Date());
			wshopInfoDao.updateByPrimaryKeySelective(record);
			WshopInfoDto returnDto = new WshopInfoDto();
			logger.debug("updateWshopInfo(returnDto) - end - return:"+returnDto); 
			return returnDto;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("修改微信加油站错误！", e);
			throw new TsfaServiceException(ErrorCode.ESHOP_WSHOPINFO_UPDATE_ERROR, "修改微信加油站错误！", e);
		}
	}

	@Override
	public WshopInfoDto findWshopInfo(FindWshopInfoPage findWshopInfoPage)
			throws TsfaServiceException {
		logger.debug("findWshopInfo(FindWshopInfoPage findWshopInfoPage)={}) - start", findWshopInfoPage); 
		AssertUtils.notNull(findWshopInfoPage);
		AssertUtils.notAllNullAndEmpty(findWshopInfoPage.getCode(), "Code不能为空");
		try {
			WshopInfo wshopInfo = wshopInfoDao.selectByPrimaryKey(findWshopInfoPage.getCode());
			if (wshopInfo == null) {
				throw new TsfaServiceException(ErrorCode.ESHOP_WSHOPINFO_NOT_EXIST_ERROR, "微信加油站信息不存在");
			}
			WshopInfoDto wshopInfoDto = new WshopInfoDto();
			// find数据录入
			wshopInfoDto.setCode(wshopInfo.getCode());
			wshopInfoDto.setCreater(wshopInfo.getCreater());
			wshopInfoDto.setDetail(wshopInfo.getDetail());
			wshopInfoDto.setFlagInfo(wshopInfo.getFlagInfo());
			wshopInfoDto.setImg1(wshopInfo.getImg1());
			wshopInfoDto.setImg2(wshopInfo.getImg2());
			wshopInfoDto.setImg3(wshopInfo.getImg3());
			wshopInfoDto.setImg4(wshopInfo.getImg4());
			wshopInfoDto.setImg5(wshopInfo.getImg5());
			wshopInfoDto.setReadCnt(wshopInfo.getReadCnt());
			wshopInfoDto.setStatus(wshopInfo.getStatus());
			wshopInfoDto.setTitle(wshopInfo.getTitle());
			wshopInfoDto.setUpdateTime(wshopInfo.getUpdateTime());
			wshopInfoDto.setCreateTime(wshopInfo.getCreateTime());
			logger.debug("findMerchant(FindMerchant) - end - return value={}", wshopInfoDto); 
			return wshopInfoDto;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找微信加油站信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ESHOP_WSHOPINFO_FIND_ERROR,"查找微信加油站信息错误！", e);
		}
	}

	@Override
	public Page<FindWshopInfoPage> findWshopInfoPage(FindWshopInfoPage findWshopInfoPage) throws TsfaServiceException {
		logger.debug("findWshopInfoPage(FindWshopInfoPage findWshopInfoPage)={}) - start", findWshopInfoPage); 
		AssertUtils.notNull(findWshopInfoPage);
		List<FindWshopInfoPage> returnList = null;
		int count = 0;
		try {
			returnList = wshopInfoDao.findWshopInfoPage(findWshopInfoPage);
			count = wshopInfoDao.findWshopInfoPageCount(findWshopInfoPage);
		} catch (Exception e) {
			logger.error("查找微信加油站信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ESHOP_WSHOPINFO_FIND_ERROR,"查找微信加油站信息错误！", e);
		}
		Page<FindWshopInfoPage> returnPage = new Page<FindWshopInfoPage>(returnList, count, findWshopInfoPage);
		logger.debug("findWshopInfoPage(FindWshopInfoPage) - end - return value={}", returnPage);
		return returnPage;
	}

	@Override
	public List<FindWshopInfoPage> findWshopInfos(FindWshopInfoPage findWshopInfoPage) {
		logger.debug("findWshopInfoPage(FindWshopInfoPage findWshopInfoPage)={}) - start", findWshopInfoPage); 
		AssertUtils.notNull(findWshopInfoPage);
		List<FindWshopInfoPage> returnList = null;
		try {
			returnList = wshopInfoDao.findWshopInfoPage(findWshopInfoPage);
		} catch (Exception e) {
			logger.error("查找微信加油站信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ESHOP_WSHOPINFO_FIND_ERROR,"查找微信加油站信息错误！", e);
		}
		logger.debug("findWshopInfoPage(FindWshopInfoPage) - end - return value={}", returnList);
		return returnList;
	}

}
