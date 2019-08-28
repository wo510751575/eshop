package com.lj.business.weixin.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.encryption.Base64;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.weixin.constant.ErrorCode;
import com.lj.business.weixin.dao.IWxLikeInfoDao;
import com.lj.business.weixin.domain.WxLikeInfo;
import com.lj.business.weixin.dto.AddWxLikeInfo;
import com.lj.business.weixin.dto.AddWxLikeInfoReturn;
import com.lj.business.weixin.dto.FindWxLikeInfo;
import com.lj.business.weixin.dto.FindWxLikeInfoReturn;
import com.lj.business.weixin.dto.UpdateWxLikeInfo;
import com.lj.business.weixin.dto.UpdateWxLikeInfoReturn;
import com.lj.business.weixin.service.IWxLikeInfoService;

/**
 * 
 * 
 * 类说明：朋友圈点赞服务实现类
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年7月21日
 */
@Service
public class WxLikeInfoServiceImpl implements IWxLikeInfoService {

	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(WxLikeInfoServiceImpl.class);
	

	@Resource
	private IWxLikeInfoDao wxCommentInfoDao;
	
	/**
	 *新增朋友圈评论
	 *return addWxLikeInfoReturn
	 *@param AddWxLikeInfo
	 */
	@Override
	public AddWxLikeInfoReturn addWxLikeInfo(
			AddWxLikeInfo addWxLikeInfo) throws TsfaServiceException {
		logger.debug("addWxLikeInfo(AddWxLikeInfo addWxLikeInfo={}) - start", addWxLikeInfo); 

		AssertUtils.notNull(addWxLikeInfo);
		try {
			WxLikeInfo wxCommentInfo = new WxLikeInfo();
			//add数据录入
			wxCommentInfo.setCode(GUID.generateByUUID());
			wxCommentInfo.setCodeWfi(addWxLikeInfo.getCodeWfi());
			wxCommentInfo.setMemberNo(addWxLikeInfo.getMemberNo());
			wxCommentInfo.setMemberName(addWxLikeInfo.getMemberName());
			wxCommentInfo.setIdWx(addWxLikeInfo.getIdWx());
			wxCommentInfo.setUsername(addWxLikeInfo.getUsername());
			wxCommentInfo.setNickname(addWxLikeInfo.getNickname());
			wxCommentInfo.setCreateDate(new Date());
			wxCommentInfoDao.insertSelective(wxCommentInfo);
			AddWxLikeInfoReturn addWxLikeInfoReturn = new AddWxLikeInfoReturn();
			
			logger.debug("addWxLikeInfo(AddWxLikeInfo) - end - return value={}", addWxLikeInfoReturn); 
			return addWxLikeInfoReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增微信朋友圈点赞信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WX_COMMENT_INFO_ADD_ERROR,"新增微信朋友圈点赞信息错误！",e);
		}
	}
	
	

	@Override
	public UpdateWxLikeInfoReturn updateWxLikeInfo(
			UpdateWxLikeInfo updateWxLikeInfo)
			throws TsfaServiceException {
		logger.debug("updateWxLikeInfo(UpdateWxLikeInfo updateWxLikeInfo={}) - start", updateWxLikeInfo); //$NON-NLS-1$

		AssertUtils.notNull(updateWxLikeInfo);
		AssertUtils.notNullAndEmpty(updateWxLikeInfo.getCode(),"ID不能为空");
		try {
			WxLikeInfo wxCommentInfo = new WxLikeInfo();
			//update数据录入
			
			wxCommentInfo.setCode(updateWxLikeInfo.getCode());
			wxCommentInfo.setCodeWfi(updateWxLikeInfo.getCodeWfi());
			wxCommentInfo.setMemberNo(updateWxLikeInfo.getMemberNo());
			wxCommentInfo.setMemberName(updateWxLikeInfo.getMemberName());
			wxCommentInfo.setIdWx(updateWxLikeInfo.getIdWx());
			wxCommentInfo.setUsername(updateWxLikeInfo.getUsername());
			wxCommentInfo.setNickname(updateWxLikeInfo.getNickname());
			wxCommentInfo.setCreateDate(updateWxLikeInfo.getCreateDate());
			AssertUtils.notUpdateMoreThanOne(wxCommentInfoDao.updateByPrimaryKeySelective(wxCommentInfo));
			UpdateWxLikeInfoReturn updateWxLikeInfoReturn = new UpdateWxLikeInfoReturn();

			logger.debug("updateWxLikeInfo(UpdateWxLikeInfo) - end - return value={}", updateWxLikeInfoReturn); //$NON-NLS-1$
			return updateWxLikeInfoReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("微信朋友圈点赞信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WX_COMMENT_INFO_UPDATE_ERROR,"微信朋友圈点赞信息更新信息错误！",e);
		}
	}

	

	@Override
	public FindWxLikeInfoReturn findWxLikeInfo(
			FindWxLikeInfo findWxLikeInfo) throws TsfaServiceException {
		logger.debug("findWxLikeInfo(FindWxLikeInfo findWxLikeInfo={}) - start", findWxLikeInfo); //$NON-NLS-1$

		AssertUtils.notNull(findWxLikeInfo);
		AssertUtils.notAllNull(findWxLikeInfo.getCode(),"ID不能为空");
		try {
			WxLikeInfo wxCommentInfo = wxCommentInfoDao.selectByPrimaryKey(findWxLikeInfo.getCode());
			if(wxCommentInfo == null){
				throw new TsfaServiceException(ErrorCode.WX_COMMENT_INFO_NOT_EXIST_ERROR,"微信朋友圈点赞信息不存在");
			}
			FindWxLikeInfoReturn findWxLikeInfoReturn = new FindWxLikeInfoReturn();
			//find数据录入
			findWxLikeInfoReturn.setCode(wxCommentInfo.getCode());
			findWxLikeInfoReturn.setCodeWfi(wxCommentInfo.getCodeWfi());
			findWxLikeInfoReturn.setMemberNo(wxCommentInfo.getMemberNo());
			findWxLikeInfoReturn.setMemberName(wxCommentInfo.getMemberName());
			findWxLikeInfoReturn.setIdWx(wxCommentInfo.getIdWx());
			wxCommentInfo.setUsername(wxCommentInfo.getUsername());
			wxCommentInfo.setNickname(wxCommentInfo.getNickname());
			findWxLikeInfoReturn.setCreateDate(wxCommentInfo.getCreateDate());
			
			logger.debug("findWxLikeInfo(FindWxLikeInfo) - end - return value={}", findWxLikeInfoReturn); //$NON-NLS-1$
			return findWxLikeInfoReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找微信朋友圈点赞信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WX_COMMENT_INFO_FIND_ERROR,"查找微信朋友圈点赞信息信息错误！",e);
		}


	}

	@Override
	public List<Map<String, String>> findWxLikeInfos(Map<String, Object> map) {
		logger.debug("findWxLikeInfos(findWxLikeInfos map={}) - start", map); //$NON-NLS-1$
		AssertUtils.notNull(map);
		try {
			List<Map<String,String>> maps = wxCommentInfoDao.findWxLikeInfos(map);
			//内容转码，因emoji表情无法存库，使用base64转码
			/*if(maps!=null && maps.size()>0){
				for (Map<String,String> item : maps) {
					item.put("NICKNAME", new String(Base64.decode2(item.get("NICKNAME"))));
				}
			}*/
			return maps;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找微信朋友圈点赞信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WX_COMMENT_INFO_FIND_ERROR,"查找微信朋友圈点赞信息信息错误！",e);
		}
	}
}
