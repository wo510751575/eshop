package com.lj.business.member.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IMemLineDao;
import com.lj.business.member.domain.MemLine;
import com.lj.business.member.dto.MemLineDto;
import com.lj.business.member.service.IMemLineService;


/**
 * 类说明：会员登录
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author LeoPeng
 * 
 * 
 * CreateDate: 2017-6-4
 */
@Service
public class MemLineServiceImpl implements IMemLineService {

	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MemLineServiceImpl.class);

	/** 导购. */
	@Resource
	private IMemLineDao memLineDao;

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IMemLineService#addMemLine(com.lj.business.member.dto.MemLineDto)
	 */
	@Override
	public int addMemLine(MemLineDto memLineDto) throws TsfaServiceException {
		
		MemLine memLine = new MemLine();
		memLine.setCode(GUID.getPreUUID());
		memLine.setName(memLineDto.getName());
		memLine.setRemark(memLineDto.getRemark());
		return memLineDao.insert(memLine);
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IMemLineService#updateMemLine(com.lj.business.member.dto.MemLineDto)
	 */
	@Override
	public int updateMemLine(MemLineDto memLineDto) throws TsfaServiceException {
		
		MemLine memLine = new MemLine();
		memLine.setCode(memLineDto.getCode());
		memLine.setName(memLineDto.getName());
		memLine.setRemark(memLineDto.getRemark());
		return memLineDao.updateByPrimaryKeySelective(memLine);
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IMemLineService#findMemLinePage(com.lj.business.member.dto.MemLineDto)
	 */
	@Override
	public Page<MemLineDto> findMemLinePage(MemLineDto memLineDto) throws TsfaServiceException {
		
		logger.debug("findMemLinePage(MemLineDto memLine={}) - start", memLineDto); //$NON-NLS-1$

		AssertUtils.notNull(memLineDto);
		List<MemLineDto> returnList = null;
		int count = 0;
		try {
			returnList = memLineDao.findMemLinePage(memLineDto);
			count = memLineDao.findMemLinePageCount(memLineDto);
		}  catch (Exception e) {
			logger.error("行业表信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_FIND_PAGE_ERROR,"行业表信息不存在错误.！",e);
		}
		Page<MemLineDto> returnPage = new Page<MemLineDto>(returnList, count, memLineDto);

		logger.debug("findMemLinePage(findMemLinePage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IMemLineService#findMemLine(com.lj.business.member.dto.MemLineDto)
	 */
	@Override
	public MemLineDto findMemLine(MemLineDto memLine) throws TsfaServiceException {
		AssertUtils.notNull(memLine.getCode(),"行业编号不能为空");
		try {
			MemLine memL = memLineDao.selectByPrimaryKey(memLine.getCode());
			memLine.setName(memL.getName());
			memLine.setRemarks(memL.getRemark());
			return memLine;
		} catch (Exception e) {
			logger.error("行业表信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_FIND_PAGE_ERROR,"行业表信息不存在错误.！",e);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IMemLineService#inqueryMemberJobInfo(java.lang.String)
	 */
	@Override
	public List<MemLine> inqueryMemberJobInfo(String merchantNo) throws TsfaServiceException {
		List<MemLine> li = memLineDao.inqueryMemberJobInfo();
		/*for(MemLine ml:li){
			MemLineDto dto = new MemLineDto();
			dto.setCode(ml.getCode());
			dto.setName(ml.getName());
			dto.setRemarks(ml.getRemark());
			list.add(dto);
		}*/
		return li;
	}

	public MemLineDto selectByName(MemLineDto memLineDto) throws TsfaServiceException {
		try {
			MemLineDto  memLine=memLineDao.selectByName(memLineDto);
			  return memLine;
		} catch (Exception e) {
			logger.error("行业表信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_FIND_PAGE_ERROR,"行业表信息不存在错误.！",e);
		}
		  
	}
	
}
