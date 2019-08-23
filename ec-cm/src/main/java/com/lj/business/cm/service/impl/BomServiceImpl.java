package com.lj.business.cm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaContextServiceException;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cm.constant.ErrorCode;
import com.lj.business.cm.dao.IBomDao;
import com.lj.business.cm.domain.Bom;
import com.lj.business.cm.dto.EditBomDto;
import com.lj.business.cm.dto.FindBomPageDto;
import com.lj.business.cm.service.IBomService;



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
 * CreateDate: 2017年6月30日
 */
@Service
public class BomServiceImpl implements IBomService {
	
	/** The bom dao. */
	@Resource
	private IBomDao bomDao;
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(BomServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.IBomService#addBom(com.lj.business.cm.dto.EditBomDto)
	 */
	@Override
	public EditBomDto addBom(EditBomDto bom) {
		try {
			
			EditBomDto editBomDto = new EditBomDto();
			editBomDto.setCode(GUID.generateByUUID());
			editBomDto.setBomCode(GUID.getPreUUID());
			editBomDto.setBomName(bom.getBomName());
			editBomDto.setRemark(bom.getRemark());
			editBomDto.setRemark2(bom.getRemark2());
			editBomDto.setRemark3(bom.getRemark3());
			editBomDto.setRemark4(bom.getRemark4());
			editBomDto.setCreateId(bom.getCreateId());
			editBomDto.setCreateDate(bom.getCreateDate());
			bomDao.addBom(editBomDto);
			return editBomDto;
		} catch (TsfaContextServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增产品表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.BOM_ADD_ERROR,"新增产品表信息错误！",e);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.IBomService#editBom(com.lj.business.cm.dto.EditBomDto)
	 */
	@Override
	public EditBomDto editBom(EditBomDto bom) {
		try {
			
			EditBomDto editBomDto = new EditBomDto();
			editBomDto.setCode(bom.getCode());
			editBomDto.setBomCode(bom.getBomCode());
			editBomDto.setBomName(bom.getBomName());
			editBomDto.setCreateId(bom.getCreateId());
			editBomDto.setCreateDate(bom.getCreateDate());
			editBomDto.setRemark(bom.getRemark());
			editBomDto.setRemark2(bom.getRemark2());
			editBomDto.setRemark3(bom.getRemark3());
			editBomDto.setRemark4(bom.getRemark4());
			bomDao.editBom(editBomDto);
			return editBomDto;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("编辑产品表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.BOM_EDIT_ERROR,"编辑产品表信息错误！",e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.IBomService#selectByCode(java.lang.String)
	 */
	@Override
	public EditBomDto selectByCode(String code) {
		try {
			Bom bom  = bomDao.selectByCode(code);
			EditBomDto editBomDto = new EditBomDto();
			editBomDto.setCode(bom.getCode());
			editBomDto.setBomCode(bom.getBomCode());
			editBomDto.setBomName(bom.getBomName());
			editBomDto.setCreateId(bom.getCreateId());
			editBomDto.setCreateDate(bom.getCreateDate());
			editBomDto.setRemark(bom.getRemark());
			editBomDto.setRemark2(bom.getRemark2());
			editBomDto.setRemark3(bom.getRemark3());
			editBomDto.setRemark4(bom.getRemark4());
			return editBomDto;
		}  catch (Exception e) {
			logger.error("查找产品表信息错误",e);
			throw new TsfaServiceException(ErrorCode.BOM_FIND_ERROR,"查找产品表信息错误！",e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.IBomService#findBoms(com.lj.business.cm.dto.FindBomPageDto)
	 */
	@Override
	public List<FindBomPageDto> findBoms(FindBomPageDto findBomPageDto) {
		AssertUtils.notNull(findBomPageDto);
		List<FindBomPageDto> returnList;
		try {
			returnList = bomDao.findBoms(findBomPageDto);
		}  catch (Exception e) {
			logger.error("查找产品表信息错误",e);
			throw new TsfaServiceException(ErrorCode.BOM_FIND_ERROR,"查找产品表信息错误.！",e);
		}
		return  returnList;
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.IBomService#findBomPage(com.lj.business.cm.dto.FindBomPageDto)
	 */
	@Override
	public Page<FindBomPageDto> findBomPage(FindBomPageDto findBomPageDto) {
		logger.debug("findBomPageDto(FindBomPageDto findBomPageDto) ) - start", findBomPageDto); 

		AssertUtils.notNull(findBomPageDto);
		List<FindBomPageDto> returnList;
		int count = 0;
		try {
			returnList = bomDao.findBomPage(findBomPageDto);
			count = bomDao.findBomPageCount(findBomPageDto);
		}  catch (Exception e) {
			logger.error("产品表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.BOM_FIND_ERROR,"产品表信息分页查询错误.！",e);
		}
		Page<FindBomPageDto> returnPage = new Page<FindBomPageDto>(returnList, count, findBomPageDto);

		logger.debug("findBomPageDto(FindBomPageDto) - end - return value={}", returnPage); 
		return  returnPage;
	}
}
