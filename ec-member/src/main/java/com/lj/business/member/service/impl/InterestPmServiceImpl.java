package com.lj.business.member.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.exception.TsfaContextServiceException;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IInterestPmDao;
import com.lj.business.member.domain.InterestPm;
import com.lj.business.member.dto.AddInterestPmDto;
import com.lj.business.member.dto.EditInterestPmDto;
import com.lj.business.member.dto.FindInterestPmPageDto;
import com.lj.business.member.dto.InterestPmReturnDto;
import com.lj.business.member.service.IInterestPmService;



/**
 * 类说明：产品实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @Company: 领居科技有限公司
 * @author 邹磊
 * 
 * CreateDate: 2017年7月1日
 */
@Service
public class InterestPmServiceImpl implements IInterestPmService {
	
	/** The Interest pm dao. */
	@Resource
	private IInterestPmDao InterestPmDao;
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(InterestPmServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IInterestPmService#addInterestPm(com.lj.business.member.dto.AddInterestPmDto)
	 */
	@Override
	public void addInterestPm(AddInterestPmDto addInterestPmDto) {
		AssertUtils.notNull(addInterestPmDto);
		try {
			InterestPm interestPm = new InterestPm();
			interestPm.setCode(addInterestPmDto.getCode());
			interestPm.setMerchantNo(addInterestPmDto.getMerchantNo());
			interestPm.setName(addInterestPmDto.getName());
			interestPm.setRemark(addInterestPmDto.getRemark());
			interestPm.setCreateDate(new Date());
			InterestPmDao.addInterestPm(interestPm);
		} catch (TsfaContextServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户兴趣指数表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.INTERESTPM_ADD_ERROR,"新增客户兴趣指数表信息错误！",e);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IInterestPmService#editInterestPm(com.lj.business.member.dto.EditInterestPmDto)
	 */
	@Override
	public void editInterestPm(EditInterestPmDto editInterestPmDto) {
		AssertUtils.notNull(editInterestPmDto);
		AssertUtils.notNullAndEmpty(editInterestPmDto.getCode(),"CODE不能为空");
		try {
			InterestPm interestPm = new InterestPm();
			interestPm.setCode(editInterestPmDto.getCode());
			interestPm.setMerchantNo(editInterestPmDto.getMerchantNo());
			interestPm.setName(editInterestPmDto.getName());
			interestPm.setRemark(editInterestPmDto.getRemark());
			interestPm.setCreateDate(new Date());
			InterestPmDao.editInterestPm(interestPm);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("编辑客户兴趣指数表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.INTERESTPM_EDIT_ERROR,"编辑客户兴趣指数表信息错误！",e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IInterestPmService#selectByCode(java.lang.String)
	 */
	@Override
	public InterestPmReturnDto selectByCode(String code) {
		try {
			InterestPm interestPm  = InterestPmDao.selectByCode(code);
			InterestPmReturnDto interestPmReturnDto = new InterestPmReturnDto();
			interestPmReturnDto.setCode(interestPm.getCode());
			interestPmReturnDto.setMerchantNo(interestPm.getMerchantNo());
			interestPmReturnDto.setName(interestPm.getName());
			interestPmReturnDto.setRemark(interestPm.getRemark());
			interestPmReturnDto.setCreateDate(interestPm.getCreateDate());
			return interestPmReturnDto;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("查找客户兴趣指数表信息错误",e);
			throw new TsfaServiceException(ErrorCode.INTERESTPM_FIND_ERROR,"查找客户兴趣指数表信息错误！",e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IInterestPmService#findInterestPms(com.lj.business.member.dto.FindInterestPmPageDto)
	 */
	@Override
	public List<FindInterestPmPageDto> findInterestPms(FindInterestPmPageDto findInterestPmPageDto) {
		AssertUtils.notNull(findInterestPmPageDto);
		List<FindInterestPmPageDto> returnList= null;
		try {
			returnList = InterestPmDao.findInterestPms(findInterestPmPageDto);
		}  catch (Exception e) {
			logger.error("查找客户兴趣指数表信息错误",e);
			throw new TsfaServiceException(ErrorCode.INTERESTPM_FIND_ERROR,"查找客户兴趣指数表信息错误.！",e);
		}
		return  returnList;
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IInterestPmService#findInterestPmPage(com.lj.business.member.dto.FindInterestPmPageDto)
	 */
	@Override
	public Page<FindInterestPmPageDto> findInterestPmPage(FindInterestPmPageDto findInterestPmPageDto) {
		logger.debug("findInterestPmPageDto(FindInterestPmPageDto findInterestPmPageDto) ) - start", findInterestPmPageDto); 

		AssertUtils.notNull(findInterestPmPageDto);
		List<FindInterestPmPageDto> returnList;
		int count = 0;
		try {
			returnList = InterestPmDao.findInterestPmPage(findInterestPmPageDto);
			count = InterestPmDao.findInterestPmPageCount(findInterestPmPageDto);
		}  catch (Exception e) {
			logger.error("客户兴趣指数表表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.INTERESTPM_FIND_PAGE_ERROR,"客户兴趣指数表表信息分页查询错误.！",e);
		}
		Page<FindInterestPmPageDto> returnPage = new Page<FindInterestPmPageDto>(returnList, count, findInterestPmPageDto);

		logger.debug("findInterestPmPageDto(FindInterestPmPageDto) - end - return value={}", returnPage); 
		return  returnPage;
	}


}
