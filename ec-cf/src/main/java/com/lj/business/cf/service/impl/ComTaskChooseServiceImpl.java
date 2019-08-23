package com.lj.business.cf.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaContextServiceException;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IComTaskChooseDao;
import com.lj.business.cf.domain.ComTaskChoose;
import com.lj.business.cf.dto.FindComTaskChooseByCode;
import com.lj.business.cf.dto.FindComTaskChooseByCodeReturnDto;
import com.lj.business.cf.dto.comTaskChoose.AddComTaskChooseDto;
import com.lj.business.cf.dto.comTaskChoose.ComTaskChooseReturnDto;
import com.lj.business.cf.dto.comTaskChoose.EditComTaskChooseDto;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChoose;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChooseIndex;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChooseIndexReturn;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChoosePageDto;
import com.lj.business.cf.emus.ComTaskType;
import com.lj.business.cf.service.IComTaskChooseService;
import com.lj.business.member.dto.CheckPmTypeDto;
import com.lj.business.member.dto.CheckPmTypeReturn;
import com.lj.business.member.service.IPmTypeService;


/**
 * 类说明：客户沟通任务选择表实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * CreateDate: 2017年6月30日s
 * @Company: 领居科技有限公司
 */
@Service
public class ComTaskChooseServiceImpl implements IComTaskChooseService {

	/** The com task choose dao. */
	@Resource
	private IComTaskChooseDao comTaskChooseDao;
	
	@Resource
	public IPmTypeService pmTypeService;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ComTaskChooseServiceImpl.class);

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskChooseService#addComTaskChoose(com.lj.business.cf.dto.AddComTaskChooseDto)
	 */
	@Override
	public void addComTaskChoose(AddComTaskChooseDto addComTaskChooseDto) {
		logger.debug("addComTaskChoose(AddComTaskChooseDto addComTaskChooseDto={}) - start", addComTaskChooseDto); //$NON-NLS-1$
		AssertUtils.notNull(addComTaskChooseDto);
		AssertUtils.notNullAndEmpty(addComTaskChooseDto.getMerchantNo(),"商户编号不能为空");
		try {
			ComTaskChoose comTaskChoose = new ComTaskChoose(); 
			comTaskChoose.setCode(GUID.getPreUUID());
			comTaskChoose.setMerchantNo(addComTaskChooseDto.getMerchantNo());
			comTaskChoose.setShopNo(addComTaskChooseDto.getShopNo());
			comTaskChoose.setShopName(addComTaskChooseDto.getShopName());
			comTaskChoose.setMemberNoGm(addComTaskChooseDto.getMemberNoGm());
			comTaskChoose.setMemberNameGm(addComTaskChooseDto.getMemberNameGm());
			comTaskChoose.setCodeList(addComTaskChooseDto.getCodeList());
			comTaskChoose.setNameList(addComTaskChooseDto.getNameList());
			comTaskChoose.setStatus(addComTaskChooseDto.getStatus());
			comTaskChoose.setComTaskType(StringUtils.toStringNull(addComTaskChooseDto.getComTaskType()));
			comTaskChoose.setFreValue(addComTaskChooseDto.getFreValue());
			comTaskChoose.setSeq(addComTaskChooseDto.getSeq());
			comTaskChoose.setRemark(addComTaskChooseDto.getRemark());
			comTaskChoose.setRemark2(addComTaskChooseDto.getRemark2());
			comTaskChoose.setRemark3(addComTaskChooseDto.getRemark3());
			comTaskChoose.setRemark4(addComTaskChooseDto.getRemark4());
			comTaskChooseDao.addComTaskChoose(comTaskChoose);
		} catch (TsfaContextServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增客户沟通任务选择表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.COMTASKCHOOSE_ADD_ERROR,"新增客户沟通任务选择表信息错误！", e);
		}

		logger.debug("addComTaskChoose(AddComTaskChooseDto) - end"); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskChooseService#editComTaskChoose(com.lj.business.cf.dto.EditComTaskChooseDto)
	 */
	@Override
	public void editComTaskChoose(EditComTaskChooseDto editComTaskChooseDto) {
		logger.debug("editComTaskChoose(EditComTaskChooseDto editComTaskChooseDto={}) - start", editComTaskChooseDto); //$NON-NLS-1$

		AssertUtils.notNull(editComTaskChooseDto);
		AssertUtils.notNullAndEmpty(editComTaskChooseDto.getMerchantNo(),"商户编号不能为空");
		try {
			ComTaskChoose comTaskChoose = new ComTaskChoose();
			comTaskChoose.setCode(GUID.getPreUUID());
			comTaskChoose.setMerchantNo(editComTaskChooseDto.getMerchantNo());
			comTaskChoose.setShopNo(editComTaskChooseDto.getShopNo());
			comTaskChoose.setShopName(editComTaskChooseDto.getShopName());
			comTaskChoose.setMemberNoGm(editComTaskChooseDto.getMemberNoGm());
			comTaskChoose.setMemberNameGm(editComTaskChooseDto.getMemberNameGm());
			comTaskChoose.setCodeList(editComTaskChooseDto.getCodeList());
			comTaskChoose.setNameList(editComTaskChooseDto.getNameList());
			comTaskChoose.setComTaskType(StringUtils.toStringNull(editComTaskChooseDto.getComTaskType()));
			comTaskChoose.setStatus(editComTaskChooseDto.getStatus());
			comTaskChoose.setFreValue(editComTaskChooseDto.getFreValue());
			comTaskChoose.setSeq(editComTaskChooseDto.getSeq());
			comTaskChoose.setRemark(editComTaskChooseDto.getRemark());
			comTaskChoose.setRemark2(editComTaskChooseDto.getRemark2());
			comTaskChoose.setRemark3(editComTaskChooseDto.getRemark3());
			comTaskChoose.setRemark4(editComTaskChooseDto.getRemark4());
			comTaskChooseDao.editComTaskChoose(comTaskChoose);
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("编辑客户沟通任务选择表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.COMTASKCHOOSE_EDIT_ERROR,
					"编辑客户沟通任务选择表信息错误！", e);
		}

		logger.debug("editComTaskChoose(EditComTaskChooseDto) - end"); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskChooseService#selectByCode(java.lang.String)
	 */
	@Override
	public ComTaskChooseReturnDto selectByCode(String code) {
		AssertUtils.notNullAndEmpty(code,"CODE不能为空");
		try {
			ComTaskChoose comTaskChoose = comTaskChooseDao.selectByCode(code);
			ComTaskChooseReturnDto comTaskChooseReturnDto = new ComTaskChooseReturnDto();
			comTaskChooseReturnDto.setCode(comTaskChoose.getCode());
			comTaskChooseReturnDto.setMerchantNo(comTaskChoose.getMerchantNo());
			comTaskChooseReturnDto.setShopNo(comTaskChoose.getShopNo());
			comTaskChooseReturnDto.setShopName(comTaskChoose.getShopName());
			comTaskChooseReturnDto.setMemberNoGm(comTaskChoose.getMemberNoGm());
			comTaskChooseReturnDto.setMemberNameGm(comTaskChoose.getMemberNameGm());
			comTaskChooseReturnDto.setCodeList(comTaskChoose.getCodeList());
			comTaskChooseReturnDto.setNameList(comTaskChoose.getNameList());
			comTaskChooseReturnDto.setStatus(comTaskChoose.getStatus());
			comTaskChooseReturnDto.setComTaskType(comTaskChoose.getComTaskType());
			comTaskChooseReturnDto.setFreValue(comTaskChoose.getFreValue());
			comTaskChooseReturnDto.setSeq(comTaskChoose.getSeq());
			comTaskChooseReturnDto.setRemark(comTaskChoose.getRemark());
			comTaskChooseReturnDto.setRemark2(comTaskChoose.getRemark2());
			comTaskChooseReturnDto.setRemark3(comTaskChoose.getRemark3());
			comTaskChooseReturnDto.setRemark4(comTaskChoose.getRemark4());
			comTaskChooseReturnDto.setCreateDate(comTaskChoose.getCreateDate());
			return comTaskChooseReturnDto;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("查找客户沟通任务选择表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.COMTASKCHOOSE_FIND_ERROR,"查找客户沟通任务选择表信息错误！",e);
		}  
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskChooseService#findComTaskChooses(com.lj.business.cf.dto.FindComTaskChoosePageDto)
	 */
	@Override
	public List<FindComTaskChoosePageDto> findComTaskChooses(
			FindComTaskChoosePageDto findComTaskChoosePageDto) {
		logger.debug("findComTaskChooses(FindComTaskChoosePageDto findComTaskChoosePageDto) ) - start",findComTaskChoosePageDto);
		AssertUtils.notNull(findComTaskChoosePageDto);
		List<FindComTaskChoosePageDto> returnList;
		try {
			returnList = comTaskChooseDao.findComTaskChooses(findComTaskChoosePageDto);
		} catch (Exception e) {
			logger.error("查找客户沟通任务选择表信息错误", e);
			throw new TsfaServiceException(ErrorCode.COMTASKCHOOSE_FIND_ERROR,"查找客户沟通任务选择表信息错误.！", e);
		}
		logger.debug("findComTaskChooses(FindComTaskChoosePageDto) - end - return value={}",returnList);
		return returnList;
	}
	
	public List<FindComTaskChoosePageDto> findComTaskChoosesApp(FindComTaskChoosePageDto findComTaskChoosePageDto) {
		AssertUtils.notNull(findComTaskChoosePageDto);
		List<FindComTaskChoosePageDto> returnList;
		try {
			returnList = comTaskChooseDao.findComTaskChoosesApp(findComTaskChoosePageDto);
		} catch (Exception e) {
			logger.error("查找客户沟通任务选择表信息错误", e);
			throw new TsfaServiceException(ErrorCode.COMTASKCHOOSE_FIND_ERROR,"查找客户沟通任务选择表信息错误.！", e);
		}
		return returnList;
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskChooseService#findComTaskChoosePage(com.lj.business.cf.dto.FindComTaskChoosePageDto)
	 */
	@Override
	public Page<FindComTaskChoosePageDto> findComTaskChoosePage(
			FindComTaskChoosePageDto findComTaskChoosePageDto) {
		logger.debug("findComTaskChoosePageDto(FindComTaskChoosePageDto findComTaskChoosePageDto) ) - start",findComTaskChoosePageDto);

		AssertUtils.notNull(findComTaskChoosePageDto);
		List<FindComTaskChoosePageDto> returnList;
		int count = 0;
		try {
			returnList = comTaskChooseDao.findComTaskChoosePage(findComTaskChoosePageDto);
			count = comTaskChooseDao.findComTaskChoosePageCount(findComTaskChoosePageDto);
		} catch (Exception e) {
			logger.error("客户沟通任务选择表信息分页查询错误", e);
			throw new TsfaServiceException(ErrorCode.COMTASKCHOOSE_FIND_PAGE_ERROR,"客户沟通任务选择表信息分页查询错误.！", e);
		}
		Page<FindComTaskChoosePageDto> returnPage = new Page<FindComTaskChoosePageDto>(returnList, count, findComTaskChoosePageDto);

		logger.debug("findComTaskChoosePageDto(FindComTaskChoosePageDto) - end - return value={}",returnPage);
		return returnPage;
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskChooseService#delComTaskChooseByMerchantNo(java.lang.String)
	 */
	@Override
	public void delComTaskChooseByMerchantNo(String merchantNo) {
		try {
			comTaskChooseDao.delComTaskChooseByMerchantNo(merchantNo);
		} catch (Exception e) {
			logger.error("删除客户沟通任务选择表信息错误", e);
			throw new TsfaServiceException(ErrorCode.COMTASKCHOOSE_DEL_ERROR,"删除客户沟通任务选择表信息错误.！", e);
		}
	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskChooseService#findComTaskChooseIndex(com.lj.business.cf.dto.comTaskChoose.FindComTaskChooseIndex)
	 */
	@Override
	public List<FindComTaskChooseIndexReturn> findComTaskChooseIndex(
			FindComTaskChooseIndex findComTaskChooseIndex)
			throws TsfaServiceException {
		logger.debug("findComTaskChooseIndex(FindComTaskChooseIndex findComTaskChooseIndex={}) - start", findComTaskChooseIndex); //$NON-NLS-1$

		AssertUtils.notNull(findComTaskChooseIndex);
		AssertUtils.notNull(findComTaskChooseIndex.getMemberNoGm(),"导购编号不能为空！");
		AssertUtils.notNull(findComTaskChooseIndex.getMerchantNo(),"商户编号不能为空！");
		List<FindComTaskChooseIndexReturn> returnList;
		try {
			Date now = new Date();
			now = org.apache.commons.lang.time.DateUtils.truncate(now, Calendar.DAY_OF_MONTH);
			findComTaskChooseIndex.setWorkDateStart(now);
			Date workDateEnd = DateUtils.getNextday(now) ;
			findComTaskChooseIndex.setWorkDateEnd(workDateEnd);
			returnList = comTaskChooseDao.findComTaskChooseIndex(findComTaskChooseIndex);
		} catch (Exception e) {
			logger.error("查找客户沟通任务选择表信息错误", e);
			throw new TsfaServiceException(ErrorCode.COMTASKCHOOSE_FIND_ERROR,"查找客户沟通任务选择表信息错误.！", e);
		}

		logger.debug("findComTaskChooseIndex(FindComTaskChooseIndex) - end - return value={}", returnList); //$NON-NLS-1$
		return returnList;
	
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskChooseService#findComTaskChoose(com.lj.business.cf.dto.comTaskChoose.FindComTaskChoose)
	 */
	@Override
	public ComTaskChooseReturnDto findComTaskChoose(
			FindComTaskChoose findComTaskChoose) {
		logger.debug("findComTaskChoose(FindComTaskChoose findComTaskChoose={}) - start", findComTaskChoose); //$NON-NLS-1$

		if(StringUtils.isEmpty(findComTaskChoose.getCode()) && (StringUtils.isEmpty(findComTaskChoose.getMerchantNo()) || StringUtils.isEmpty(findComTaskChoose.getComTaskType())) ){
			throw new IllegalArgumentException("参数不能全部为空!");
		} 
		try {
			ComTaskChoose comTaskChooseQuery = new ComTaskChoose();
			comTaskChooseQuery.setCode(findComTaskChoose.getCode());
			comTaskChooseQuery.setMerchantNo(findComTaskChoose.getMerchantNo());
			comTaskChooseQuery.setComTaskType(findComTaskChoose.getComTaskType());
			ComTaskChoose comTaskChoose = comTaskChooseDao.selectByParamKey(comTaskChooseQuery);
			ComTaskChooseReturnDto comTaskChooseReturnDto = new ComTaskChooseReturnDto();
			comTaskChooseReturnDto.setCode(comTaskChoose.getCode());
			comTaskChooseReturnDto.setMerchantNo(comTaskChoose.getMerchantNo());
			comTaskChooseReturnDto.setShopNo(comTaskChoose.getShopNo());
			comTaskChooseReturnDto.setShopName(comTaskChoose.getShopName());
			comTaskChooseReturnDto.setMemberNoGm(comTaskChoose.getMemberNoGm());
			comTaskChooseReturnDto.setMemberNameGm(comTaskChoose.getMemberNameGm());
			comTaskChooseReturnDto.setCodeList(comTaskChoose.getCodeList());
			comTaskChooseReturnDto.setNameList(comTaskChoose.getNameList());
			comTaskChooseReturnDto.setStatus(comTaskChoose.getStatus());
			comTaskChooseReturnDto.setComTaskType(comTaskChoose.getComTaskType());
			comTaskChooseReturnDto.setFreValue(comTaskChoose.getFreValue());
			comTaskChooseReturnDto.setSeq(comTaskChoose.getSeq());
			comTaskChooseReturnDto.setRemark(comTaskChoose.getRemark());
			comTaskChooseReturnDto.setRemark2(comTaskChoose.getRemark2());
			comTaskChooseReturnDto.setRemark3(comTaskChoose.getRemark3());
			comTaskChooseReturnDto.setRemark4(comTaskChoose.getRemark4());
			comTaskChooseReturnDto.setCreateDate(comTaskChoose.getCreateDate());

			logger.debug("findComTaskChoose(FindComTaskChoose) - end - return value={}", comTaskChooseReturnDto); //$NON-NLS-1$
			return comTaskChooseReturnDto;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("查找客户沟通任务选择表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.COMTASKCHOOSE_FIND_ERROR,"查找客户沟通任务选择表信息错误！",e);
		}  
	
	
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskChooseService#findComTaskChooseByCode(com.lj.business.cf.dto.FindComTaskChooseByCode)
	 */
	@Override
	public FindComTaskChooseByCodeReturnDto findComTaskChooseByCode(FindComTaskChooseByCode findComTaskChooseByCode) {
		AssertUtils.notNull(findComTaskChooseByCode);
		try {
			FindComTaskChooseByCodeReturnDto findComTaskChooseByCodeReturnDto = comTaskChooseDao.findComTaskChooseByCode(findComTaskChooseByCode);
			return findComTaskChooseByCodeReturnDto;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("查找客户沟通任务选择表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.COMTASKCHOOSE_FIND_ERROR,"查找客户沟通任务选择表信息错误！",e);
		}  
	}
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskChooseService#findComTaskChoosesNewApp(com.lj.business.cf.dto.comTaskChoose.FindComTaskChoosePageDto)
	 */
	@Override
	public List<FindComTaskChoosePageDto> findComTaskChoosesNewApp(FindComTaskChoosePageDto findComTaskChoosePageDto) {
		AssertUtils.notNull(findComTaskChoosePageDto);
		List<FindComTaskChoosePageDto> returnList;
		try {
			CheckPmTypeDto checkPmTypeDto = new CheckPmTypeDto();
			checkPmTypeDto.setMemberNo(findComTaskChoosePageDto.getMemberNo());
			checkPmTypeDto.setMemberNoGm(findComTaskChoosePageDto.getMemberNoGm());
			checkPmTypeDto.setMerchantNo(findComTaskChoosePageDto.getMerchantNo());
			CheckPmTypeReturn checkPmTypeReturn = pmTypeService.checkPmType(checkPmTypeDto);
			returnList = comTaskChooseDao.findComTaskChoosesNewApp(findComTaskChoosePageDto);
			
			List<FindComTaskChoosePageDto> returnListTemp = new ArrayList<FindComTaskChoosePageDto>();
			if(returnList != null && returnList.size() > 0){
				if(checkPmTypeReturn != null){
					//非意向 只有沟通
					if(checkPmTypeReturn.getOther() != null && checkPmTypeReturn.getOther()){
							for(FindComTaskChoosePageDto dto :returnList){
								if(ComTaskType.COM_TASK.toString().equals(dto.getComTaskType())){
									returnListTemp.add(dto);
								}
							}
					}else{
						//其他排除沟通
						for(FindComTaskChoosePageDto dto :returnList){
							if(!ComTaskType.COM_TASK.toString().equals(dto.getComTaskType())){
								returnListTemp.add(dto);
							}
						}
					}
				}
			}
			return returnListTemp;
		} catch (Exception e) {
			logger.error("查找客户沟通任务选择表信息错误", e);
			throw new TsfaServiceException(ErrorCode.COMTASKCHOOSE_FIND_ERROR,"查找客户沟通任务选择表信息错误.！", e);
		}
	}
	
}
