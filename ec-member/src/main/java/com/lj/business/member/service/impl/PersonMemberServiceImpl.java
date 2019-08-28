package com.lj.business.member.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.DistanceUtil;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.UpdateWorkTaskFinishNum;
import com.lj.business.cf.dto.clientFollow.AddClientFollow;
import com.lj.business.cf.dto.clientFollowSummary.AddPmClientFollowFirstDto;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryReturn;
import com.lj.business.cf.dto.clientFollowSummary.UpdateClientFollowSummary;
import com.lj.business.cf.dto.comTask.AddComTask;
import com.lj.business.cf.dto.comTask.UpdateComTaskFi;
import com.lj.business.cf.dto.comTaskChoose.ComTaskChooseReturnDto;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChoose;
import com.lj.business.cf.dto.comTaskList.FindComTaskList;
import com.lj.business.cf.dto.comTaskList.FindComTaskListReturn;
import com.lj.business.cf.emus.ComTaskFinish;
import com.lj.business.cf.emus.ComTaskType;
import com.lj.business.cf.emus.DealType;
import com.lj.business.cf.emus.FollowNoType;
import com.lj.business.cf.emus.FollowType;
import com.lj.business.cf.emus.MemerSourceType;
import com.lj.business.cf.emus.Status;
import com.lj.business.cf.emus.TaskType;
import com.lj.business.cf.service.IClientFollowService;
import com.lj.business.cf.service.IClientFollowSummaryService;
import com.lj.business.cf.service.IComTaskChooseService;
import com.lj.business.cf.service.IComTaskListService;
import com.lj.business.cf.service.IComTaskService;
import com.lj.business.cf.service.IWorkTaskChooseService;
import com.lj.business.cf.service.IWorkTaskService;
import com.lj.business.common.CommonConstant;
import com.lj.business.member.common.MemberUtils;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IGuidMemberDao;
import com.lj.business.member.dao.IPersonMemberBaseDao;
import com.lj.business.member.dao.IPersonMemberDao;
import com.lj.business.member.dao.IPmTypeDao;
import com.lj.business.member.dao.IPmTypePmDao;
import com.lj.business.member.domain.GuidMember;
import com.lj.business.member.domain.PersonMember;
import com.lj.business.member.domain.PersonMemberBase;
import com.lj.business.member.domain.PmType;
import com.lj.business.member.domain.PmTypePm;
import com.lj.business.member.dto.AddPersonMember;
import com.lj.business.member.dto.AddPersonMemberAll;
import com.lj.business.member.dto.AddPersonMemberBase;
import com.lj.business.member.dto.AddPersonMemberReturn;
import com.lj.business.member.dto.AddPmTypePmDto;
import com.lj.business.member.dto.ChangePmTypeApp;
import com.lj.business.member.dto.CountPersonMemberReturn;
import com.lj.business.member.dto.DelPersonMember;
import com.lj.business.member.dto.DelPersonMemberReturn;
import com.lj.business.member.dto.DoRepeatMemberDto;
import com.lj.business.member.dto.EditPersonMember;
import com.lj.business.member.dto.FindCountPersonMember;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.FindMemberInfoReturn;
import com.lj.business.member.dto.FindMemberRecord;
import com.lj.business.member.dto.FindMerchantDto;
import com.lj.business.member.dto.FindMerchantReturnDto;
import com.lj.business.member.dto.FindNewPmCountDto;
import com.lj.business.member.dto.FindNewPmPage;
import com.lj.business.member.dto.FindNewPmPageReturn;
import com.lj.business.member.dto.FindPersonMember;
import com.lj.business.member.dto.FindPersonMemberAgeStatisticsReturn;
import com.lj.business.member.dto.FindPersonMemberBase;
import com.lj.business.member.dto.FindPersonMemberBaseReturn;
import com.lj.business.member.dto.FindPersonMemberInterestStatisticsReturn;
import com.lj.business.member.dto.FindPersonMemberLineStatisticsReturn;
import com.lj.business.member.dto.FindPersonMemberPage;
import com.lj.business.member.dto.FindPersonMemberPageReturn;
import com.lj.business.member.dto.FindPersonMemberReturn;
import com.lj.business.member.dto.FindPersonMemberReturnList;
import com.lj.business.member.dto.FindPersonMemberSexStatisticsReturn;
import com.lj.business.member.dto.FindPmInfoAll;
import com.lj.business.member.dto.FindPmInfoAllReturn;
import com.lj.business.member.dto.FindPmSeachPage;
import com.lj.business.member.dto.FindPmSeachPageReturn;
import com.lj.business.member.dto.FindPmType;
import com.lj.business.member.dto.FindPmTypeIndexPage;
import com.lj.business.member.dto.FindPmTypeIndexPageReturn;
import com.lj.business.member.dto.FindPmTypeReturn;
import com.lj.business.member.dto.FindPmWxBpInfo;
import com.lj.business.member.dto.FindPmWxBpInfoReturn;
import com.lj.business.member.dto.FindPmWxInfo;
import com.lj.business.member.dto.FindPmWxInfoReturn;
import com.lj.business.member.dto.FindShop;
import com.lj.business.member.dto.FindShopReturn;
import com.lj.business.member.dto.FindTodayManageShop;
import com.lj.business.member.dto.FindTodayManageShopReturn;
import com.lj.business.member.dto.FindUnContactMember;
import com.lj.business.member.dto.FindUnContactMemberReturn;
import com.lj.business.member.dto.FindUrgentMbrPage;
import com.lj.business.member.dto.FindUrgentMbrPageReturn;
import com.lj.business.member.dto.MemLineDto;
import com.lj.business.member.dto.PersonMemberRateDto;
import com.lj.business.member.dto.UpdatePersonMember;
import com.lj.business.member.dto.UpdatePersonMemberBase;
import com.lj.business.member.dto.UpdatePersonMemberBaseRatioClientInfoDto;
import com.lj.business.member.dto.UpdatePersonMemberReturn;
import com.lj.business.member.dto.behaviorPm.AddBehaviorPm;
import com.lj.business.member.dto.behaviorPm.FindBehaviorPm;
import com.lj.business.member.dto.behaviorPm.FindBehaviorPmReturn;
import com.lj.business.member.dto.guidMemberIntegral.GuidMemberIntegralDto;
import com.lj.business.member.dto.guidmemberActionInfo.AddGuidmemberActionInfo;
import com.lj.business.member.emus.FirstIntroduce;
import com.lj.business.member.emus.GuidmemberActionType;
import com.lj.business.member.emus.IntegralType;
import com.lj.business.member.emus.MemberStatus;
import com.lj.business.member.emus.NameAuthFlag;
import com.lj.business.member.emus.PmTypeType;
import com.lj.business.member.emus.SpruceUpType;
import com.lj.business.member.emus.UnContactCodeEnum;
import com.lj.business.member.emus.UrgentFlagType;
import com.lj.business.member.service.IBehaviorPmService;
import com.lj.business.member.service.IGuidMemberIntegralService;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.business.member.service.IGuidmemberActionInfoService;
import com.lj.business.member.service.IMemLineService;
import com.lj.business.member.service.IMerchantService;
import com.lj.business.member.service.IPersonMemberBaseService;
import com.lj.business.member.service.IPersonMemberService;
import com.lj.business.member.service.IPmTypeService;
import com.lj.business.member.service.IShopService;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;

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
 *         CreateDate: 2017-06-14
 */
@Service
public class PersonMemberServiceImpl implements IPersonMemberService {

	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(PersonMemberServiceImpl.class);

	/** The person member dao. */
	@Resource
	private IPersonMemberDao personMemberDao;

	/** The ipm type pm dao. */
	@Resource
	private IPmTypePmDao ipmTypePmDao;

	/** The pm type dao. */
	@Resource
	private IPmTypeDao pmTypeDao;

	/** The iguidMember dao. */
	@Resource
	private IGuidMemberDao iguidMemberDao;

	/** The iperson member base dao. */
	@Resource
	private IPersonMemberBaseDao personMemberBaseDao;

	/** The I client follow summary service. */
	@Resource
	private IClientFollowSummaryService clientFollowSummaryService;

	/** The pm type service. */
	@Resource
	private IPmTypeService pmTypeService;

	/** The behavior pm service. */
	@Resource
	private IBehaviorPmService behaviorPmService;

	/** The person member base service. */
	@Resource
	private IPersonMemberBaseService personMemberBaseService;

	/** The guid member service. */
	@Resource
	private IGuidMemberService guidMemberService;

	/** The merchant service. */
	@Resource
	private IMerchantService merchantService;

	/** The mem line service. */
	@Resource
	private IMemLineService memLineService;

	@Resource
	private IWorkTaskService workTaskService;

	@Resource
	private IWorkTaskChooseService workTaskChooseService;

	@Resource
	private IGuidMemberIntegralService guidMemberIntegralService;

	@Resource
	private IComTaskListService comTaskListService;

	@Resource
	private IComTaskService comTaskService;


	@Resource
	private IClientFollowService clientFollowService;

	@Resource
	private IComTaskChooseService comTaskChooseService;

	@Resource
	private IGuidmemberActionInfoService guidmemberActionInfoService;

	@Resource
	private IPersonMemberService personMemberService;

	@Resource
	private IShopService shopService;

	@Resource
	private LocalCacheSystemParamsFromCC localCacheSystemParams;
	private ExecutorService taskExecutor= Executors.newCachedThreadPool();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#findPmInfoAll(com
	 * .lj.business.member.dto.FindPmInfoAll)
	 */
	@Override
	public FindPmInfoAllReturn findPmInfoAll(FindPmInfoAll findPmInfoAll) throws TsfaServiceException {
		logger.debug("findPmInfoAll(FindPmInfoAll findPmInfoAll={}) - start", findPmInfoAll); //$NON-NLS-1$

		AssertUtils.notNull(findPmInfoAll);
		AssertUtils.notAllNull(findPmInfoAll.getMemberNo(), "客户编号不能为空");
		AssertUtils.notAllNull(findPmInfoAll.getMemberNoGm(), "导购编号不能为空");
		try {
			FindPersonMemberBase findPersonMemberBaseQuery = new FindPersonMemberBase();
			findPersonMemberBaseQuery.setMemberNo(findPmInfoAll.getMemberNo());
			PersonMemberBase personMemberBase = personMemberBaseDao.selectByParams(findPersonMemberBaseQuery);
			PersonMember personMemberQuery = new PersonMember();
			personMemberQuery.setMemberNo(findPmInfoAll.getMemberNo());
			personMemberQuery.setMemberNoGm(findPmInfoAll.getMemberNoGm());
			PersonMember personMember = personMemberDao.selectByParamKey(personMemberQuery);

			FindPmInfoAllReturn findPmInfoAllReturn = new FindPmInfoAllReturn();

			findPmInfoAllReturn.setCodePm(personMember.getCode());
			findPmInfoAllReturn.setMemberNo(personMemberBase.getMemberNo());
			findPmInfoAllReturn.setMemberName(personMember.getMemberName());
			findPmInfoAllReturn.setMemberNoGm(personMember.getMemberNoGm());
			findPmInfoAllReturn.setMemberNameGm(personMember.getMemberNameGm());
			findPmInfoAllReturn.setShopNo(personMember.getShopNo());
			findPmInfoAllReturn.setShopName(personMember.getShopName());
			findPmInfoAllReturn.setMerchantNo(personMember.getMerchantNo());
			findPmInfoAllReturn.setMerchantName(personMember.getMerchantName());
			findPmInfoAllReturn.setSpruceUp(personMember.getSpruceUp());
			if (!StringUtils.isEmpty(personMember.getSpruceUp()))
				findPmInfoAllReturn.setSpruceUpName(SpruceUpType.valueOf(personMember.getSpruceUp()).getName());
			findPmInfoAllReturn.setHouses(personMember.getHouses());
			findPmInfoAllReturn.setUrgencyPm(personMember.getUrgencyPm());
			findPmInfoAllReturn.setBomCode(personMember.getBomCode());
			findPmInfoAllReturn.setBomName(personMember.getBomName());
			findPmInfoAllReturn.setNickNameRemarkWx(personMember.getNickNameRemarkWx());
			findPmInfoAllReturn.setNickNameRemarkLocal(personMember.getNickNameRemarkLocal());
			findPmInfoAllReturn.setBrandCompare(personMember.getBrandCompare());
			findPmInfoAllReturn.setClientSpecial(personMember.getClientSpecial());
			findPmInfoAllReturn.setRemark(personMember.getRemark());
			findPmInfoAllReturn.setCodePmBase(personMemberBase.getCode());
			findPmInfoAllReturn.setMobile(personMemberBase.getMobile());
			findPmInfoAllReturn.setJob(personMemberBase.getJob());
			
			/*获取职业名称*/
			if (!StringUtils.isEmpty(personMemberBase.getJob())) {
				MemLineDto memLine = new MemLineDto();
				memLine.setCode(personMemberBase.getJob());
				MemLineDto memLineDto = memLineService.findMemLine(memLine);
				if (memLineDto != null) {
					findPmInfoAllReturn.setJobName(memLineDto.getName());
				}
			}
			findPmInfoAllReturn.setAge(personMemberBase.getAge());
			findPmInfoAllReturn.setSex(personMemberBase.getSex());
			findPmInfoAllReturn.setMemberSrc(personMemberBase.getMemberSrc());
			if (!StringUtils.isEmpty(personMemberBase.getMemberSrc()))
				findPmInfoAllReturn.setMemberSrcName(MemerSourceType.valueOf(personMemberBase.getMemberSrc()).getName());
			findPmInfoAllReturn.setNoWx(personMemberBase.getNoWx());
			findPmInfoAllReturn.setNickNameWx(personMemberBase.getNickNameWx());
			findPmInfoAllReturn.setHeadAddress(personMemberBase.getHeadAddress());
			findPmInfoAllReturn.setInterest(personMemberBase.getInterest());
			findPmInfoAllReturn.setAreaCode(personMemberBase.getAreaCode());
			findPmInfoAllReturn.setProvinceCode(personMemberBase.getProvinceCode());
			findPmInfoAllReturn.setCityCode(personMemberBase.getCityCode());
			findPmInfoAllReturn.setCityAreaCode(personMemberBase.getCityAreaCode());
			findPmInfoAllReturn.setBirthday(personMemberBase.getBirthday());
			
			/*获取动态描述*/
			FindBehaviorPm findBehaviorPm = new FindBehaviorPm();
			findBehaviorPm.setMemberNo(findPmInfoAll.getMemberNo());
			FindBehaviorPmReturn findBehaviorPmReturn = behaviorPmService.findBehaviorPm(findBehaviorPm);
			findPmInfoAllReturn.setBehaviorDesc(findBehaviorPmReturn.getBehaviorDesc());
			findPmInfoAllReturn.setBehaviorDate(findBehaviorPmReturn.getBehaviorDate());

			// 查找客户原来所属分类关联CODE
			Map<String, String> map = new HashMap<String, String>();
			map.put("merchantNo", personMember.getMerchantNo());
			map.put("codePm", personMember.getCode());
			Map<String, String> mapResult = pmTypeDao.selectByParamKey_changePmType(map);
			if (mapResult != null) {
				String pmTypePmCode = mapResult.get("CODE");
				String pmTypeCode = mapResult.get("PM_TYPE_CODE");
				String typeName = mapResult.get("TYPE_NAME");
				findPmInfoAllReturn.setPmTypeCode(pmTypeCode);
				findPmInfoAllReturn.setPmTypePmCode(pmTypePmCode);
				findPmInfoAllReturn.setTypeName(typeName);
			}

			logger.debug("findPmInfoAll(FindPmInfoAll) - end - return value={}", findPmInfoAllReturn); //$NON-NLS-1$
			return findPmInfoAllReturn;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户会员信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找客户会员信息信息错误！", e);
		}

	}

	// /LEOPENG 待完善
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#addPersonMemberAll
	 * (com.lj.business.member.dto.AddPersonMemberAll)
	 */
	@Override
	public void addPersonMemberAll(AddPersonMemberAll addPersonMemberAll) throws TsfaServiceException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#addPersonMember(com
	 * .lj.business.member.dto.AddPersonMember)
	 */
	@Override
	public AddPersonMemberReturn addPersonMember(AddPersonMember addPersonMember) throws TsfaServiceException {
		logger.debug("addPersonMember(AddPersonMember addPersonMember={}) - start", addPersonMember);

		AssertUtils.notNull(addPersonMember);
		try {
			PersonMember personMember = new PersonMember();
			// add数据录入
			personMember.setCode(GUID.getPreUUID());
			if (addPersonMember.getMemberNo() != null && !"".equals(addPersonMember.getMemberNo())) {
				personMember.setMemberNo(addPersonMember.getMemberNo());
			} else {
				personMember.setMemberNo(GUID.generateByUUID());
			}
			personMember.setMemberName(addPersonMember.getMemberName());
			personMember.setMemberNoGm(addPersonMember.getMemberNoGm());
			personMember.setMemberNameGm(addPersonMember.getMemberNameGm());
			personMember.setShopNo(addPersonMember.getShopNo());
			personMember.setShopName(addPersonMember.getShopName());
			personMember.setMerchantNo(addPersonMember.getMerchantNo());
			personMember.setMerchantName(addPersonMember.getMerchantName());
			personMember.setSpruceUp(addPersonMember.getSpruceUp());
			personMember.setHouses(addPersonMember.getHouses());
			personMember.setKeepEye(addPersonMember.getKeepEye());
			personMember.setUrgencyPm(addPersonMember.getUrgencyPm());
			personMember.setBomCode(addPersonMember.getBomCode());
			personMember.setBomName(addPersonMember.getBomName());
			personMember.setCreateId(addPersonMember.getCreateId());
			personMember.setRemark4(addPersonMember.getRemark4());
			personMember.setRemark3(addPersonMember.getRemark3());
			personMember.setRemark2(addPersonMember.getRemark2());
			personMember.setRemark(addPersonMember.getRemark());
			/* 扫码相关 */
			personMember.setLatitude(addPersonMember.getLatitude());
			personMember.setLongitude(addPersonMember.getLongitude());
			personMember.setScanAddress(addPersonMember.getScanAddress());
			personMemberDao.insertSelective(personMember);
			AddPersonMemberReturn addPersonMemberReturn = new AddPersonMemberReturn();

			logger.debug("addPersonMember(AddPersonMember) - end - return value={}", addPersonMemberReturn);
			return addPersonMemberReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增客户会员信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_ADD_ERROR, "新增客户会员信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#delPersonMember(com
	 * .lj.business.member.dto.DelPersonMember)
	 */
	@Override
	public DelPersonMemberReturn delPersonMember(DelPersonMember delPersonMember) throws TsfaServiceException {
		logger.debug("delPersonMember(DelPersonMember delPersonMember={}) - start", delPersonMember);

		AssertUtils.notNull(delPersonMember);
		AssertUtils.notNull(delPersonMember.getCode(), "ID不能为空！");
		try {
			personMemberDao.deleteByPrimaryKey(delPersonMember.getCode());
			DelPersonMemberReturn delPersonMemberReturn = new DelPersonMemberReturn();

			logger.debug("delPersonMember(DelPersonMember) - end - return value={}", delPersonMemberReturn); //$NON-NLS-1$
			return delPersonMemberReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("删除客户会员信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_DEL_ERROR, "删除客户会员信息错误！", e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#updatePersonMember
	 * (com.lj.business.member.dto.UpdatePersonMember)
	 */
	@Override
	public UpdatePersonMemberReturn updatePersonMember(UpdatePersonMember updatePersonMember) throws TsfaServiceException {
		logger.debug("updatePersonMember(UpdatePersonMember updatePersonMember={}) - start", updatePersonMember); //$NON-NLS-1$

		AssertUtils.notNull(updatePersonMember);
		AssertUtils.notNullAndEmpty(updatePersonMember.getCode(), "ID不能为空");
		try {
			PersonMember personMember = new PersonMember();
			// update数据录入
			personMember.setCode(updatePersonMember.getCode());
			personMember.setMemberNo(updatePersonMember.getMemberNo());
			personMember.setMemberName(updatePersonMember.getMemberName());
			personMember.setMemberNoGm(updatePersonMember.getMemberNoGm());
			personMember.setMemberNameGm(updatePersonMember.getMemberNameGm());
			personMember.setShopNo(updatePersonMember.getShopNo());
			personMember.setShopName(updatePersonMember.getShopName());
			personMember.setMerchantNo(updatePersonMember.getMerchantNo());
			personMember.setMerchantName(updatePersonMember.getMerchantName());
			personMember.setSpruceUp(updatePersonMember.getSpruceUp());
			personMember.setHouses(updatePersonMember.getHouses());
			personMember.setKeepEye(updatePersonMember.getKeepEye());
			personMember.setUrgencyPm(updatePersonMember.getUrgencyPm());
			personMember.setBomCode(updatePersonMember.getBomCode());
			personMember.setBomName(updatePersonMember.getBomName());
			personMember.setBrandCompare(updatePersonMember.getBrandCompare());
			personMember.setClientSpecial(updatePersonMember.getClientSpecial());
			personMember.setUpdateId(updatePersonMember.getUpdateId());
			personMember.setUpdateDate(updatePersonMember.getUpdateDate());
			personMember.setRemark4(updatePersonMember.getRemark4());
			personMember.setRemark3(updatePersonMember.getRemark3());
			personMember.setRemark2(updatePersonMember.getRemark2());
			personMember.setRemark(updatePersonMember.getRemark());
			personMember.setNickNameRemarkWx(updatePersonMember.getNickNameRemarkWx());
			/* 扫码相关 */
			personMember.setLatitude(updatePersonMember.getLatitude());
			personMember.setLongitude(updatePersonMember.getLongitude());
			personMember.setScanAddress(updatePersonMember.getScanAddress());
			// upate by 杨杰 2017-09-05
			personMember.setNickNameRemarkLocal(updatePersonMember.getNickNameRemarkLocal());

			AssertUtils.notUpdateMoreThanOne(personMemberDao.updateByPrimaryKeySelective(personMember));
			UpdatePersonMemberReturn updatePersonMemberReturn = new UpdatePersonMemberReturn();

			logger.debug("updatePersonMember(UpdatePersonMember) - end - return value={}", updatePersonMemberReturn); //$NON-NLS-1$
			return updatePersonMemberReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("客户会员信息更新信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_UPDATE_ERROR, "客户会员信息更新信息错误！", e);
		}
	}

	/**
	 * 修改用户名称 update by 杨杰(不破坏公共方法，改为重写方法)
	 * 
	 * @param updatePersonMember
	 * @param updatePersonMemberBase
	 * @return
	 * @throws TsfaServiceException
	 */
	public UpdatePersonMemberReturn updatePersonMember(UpdatePersonMember updatePersonMember, UpdatePersonMemberBase updatePersonMemberBase) throws TsfaServiceException {
		logger.debug("updatePersonMember(UpdatePersonMember updatePersonMember={}) - start", updatePersonMember); //$NON-NLS-1$

		AssertUtils.notNull(updatePersonMember);
		AssertUtils.notNullAndEmpty(updatePersonMember.getCode(), "ID不能为空");
		try {
			PersonMember personMember = new PersonMember();
			// update数据录入
			personMember.setCode(updatePersonMember.getCode());
			personMember.setMemberNo(updatePersonMember.getMemberNo());
			personMember.setMemberName(updatePersonMember.getMemberName());
			personMember.setMemberNoGm(updatePersonMember.getMemberNoGm());
			personMember.setMemberNameGm(updatePersonMember.getMemberNameGm());
			personMember.setShopNo(updatePersonMember.getShopNo());
			personMember.setShopName(updatePersonMember.getShopName());
			personMember.setMerchantNo(updatePersonMember.getMerchantNo());
			personMember.setMerchantName(updatePersonMember.getMerchantName());
			personMember.setSpruceUp(updatePersonMember.getSpruceUp());
			personMember.setHouses(updatePersonMember.getHouses());
			personMember.setKeepEye(updatePersonMember.getKeepEye());
			personMember.setUrgencyPm(updatePersonMember.getUrgencyPm());
			personMember.setBomCode(updatePersonMember.getBomCode());
			personMember.setBomName(updatePersonMember.getBomName());
			personMember.setBrandCompare(updatePersonMember.getBrandCompare());
			personMember.setClientSpecial(updatePersonMember.getClientSpecial());
			personMember.setUpdateId(updatePersonMember.getUpdateId());
			personMember.setUpdateDate(updatePersonMember.getUpdateDate());
			personMember.setRemark4(updatePersonMember.getRemark4());
			personMember.setRemark3(updatePersonMember.getRemark3());
			personMember.setRemark2(updatePersonMember.getRemark2());
			personMember.setRemark(updatePersonMember.getRemark());
			personMember.setNickNameRemarkWx(updatePersonMember.getNickNameRemarkWx());
			/* 扫码相关 */
			personMember.setLatitude(updatePersonMember.getLatitude());
			personMember.setLongitude(updatePersonMember.getLongitude());
			personMember.setScanAddress(updatePersonMember.getScanAddress());

			// update by 杨杰 begin
			String nickNameRemarkLocal = "";
			if (StringUtils.isNotEmpty(personMember.getMemberName())) {
				nickNameRemarkLocal += personMember.getMemberName();
			}
			if (StringUtils.isNotEmpty(updatePersonMemberBase.getMobile())) {
				nickNameRemarkLocal += ("-" + updatePersonMemberBase.getMobile());
			}
			if (StringUtils.isNotEmpty(personMember.getBomName())) {
				nickNameRemarkLocal += ("-" + personMember.getBomName());
			}
			personMember.setNickNameRemarkLocal(nickNameRemarkLocal);
			// update by 杨杰 end

			AssertUtils.notUpdateMoreThanOne(personMemberDao.updateByPrimaryKeySelective(personMember));
			UpdatePersonMemberReturn updatePersonMemberReturn = new UpdatePersonMemberReturn();

			logger.debug("updatePersonMember(UpdatePersonMember) - end - return value={}", updatePersonMemberReturn); //$NON-NLS-1$
			return updatePersonMemberReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("客户会员信息更新信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_UPDATE_ERROR, "客户会员信息更新信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#updatePersonMemberByMGM
	 * (com.lj.business.member.dto.UpdatePersonMember)
	 */
	@Override
	public UpdatePersonMemberReturn editPersonMember(EditPersonMember editPersonMember) throws TsfaServiceException {
		AssertUtils.notNull(editPersonMember);
		AssertUtils.notNullAndEmpty(editPersonMember.getCode(), "客户基础code不能为空");
		AssertUtils.notNullAndEmpty(editPersonMember.getCodePm(), "客户扩展code不能为空");
		AssertUtils.notNullAndEmpty(editPersonMember.getMerchantNo(), "商户号不能为空");
		AssertUtils.notNullAndEmpty(editPersonMember.getMemberNo(), "客户号不能为空");
		AssertUtils.notNullAndEmpty(editPersonMember.getMemberNoGm(), "导购号不能为空");
		AssertUtils.notNullAndEmpty(editPersonMember.getPmTypeCode(), "客户分类code不能为空");
		AssertUtils.notNullAndEmpty(editPersonMember.getPmTypePmCode(), "客户分类关联code不能为空");
//		AssertUtils.notNullAndEmpty(editPersonMember.getMemberSrc(), "客户来源不能为空");
		// AssertUtils.notNullAndEmpty(editPersonMember.getSex(), "客户性别不能为空");
		try {
			FindPersonMember findPersonMember = new FindPersonMember();
			findPersonMember.setCode(editPersonMember.getCodePm());
			FindPersonMemberReturn findPersonMemberReturn = findPersonMember(findPersonMember);
			if (findPersonMemberReturn != null) {
				// 如果修改了紧急调用客户分类修改 参数只能这么传
//				if (!editPersonMember.getUrgencyPm().equals(findPersonMemberReturn.getUrgencyPm())) {
//					ChangeUrgency changeUrgency = new ChangeUrgency();
//					changeUrgency.setMemberNo(editPersonMember.getMemberNo());
//					changeUrgency.setMemberNoGm(editPersonMember.getMemberNoGm());
//					changeUrgency.setUrgentFlagType(UrgentFlagType.valueOf(editPersonMember.getUrgencyPm()));
//					pmTypeService.changeUrgency(changeUrgency);
//				}

				// 客户分组change
				ChangePmTypeApp changePmTypeApp = new ChangePmTypeApp();
				changePmTypeApp.setMerchantNo(editPersonMember.getMerchantNo());
				changePmTypeApp.setMemberNo(editPersonMember.getMemberNo());
				changePmTypeApp.setMemberNoGm(editPersonMember.getMemberNoGm());
				changePmTypeApp.setCode(editPersonMember.getPmTypePmCode());
				changePmTypeApp.setPmTypeCode(editPersonMember.getPmTypeCode());
				pmTypeService.changePmType_app(changePmTypeApp);

				// 修改基础表
				FindPersonMemberBase findPersonMemberBase = new FindPersonMemberBase();
				findPersonMemberBase.setCode(editPersonMember.getCode());
				FindPersonMemberBaseReturn findPersonMemberBaseReturn = personMemberBaseService.findPersonMemberBase(findPersonMemberBase);

				UpdatePersonMemberBase updatePersonMemberBase = new UpdatePersonMemberBase();
				updatePersonMemberBase.setCode(editPersonMember.getCode());
				updatePersonMemberBase.setMemberNo(editPersonMember.getMemberNo());
				updatePersonMemberBase.setMemberName(editPersonMember.getMemberName());
				updatePersonMemberBase.setMobile(editPersonMember.getMobile());
				updatePersonMemberBase.setJob(editPersonMember.getJob());
				updatePersonMemberBase.setInterest(editPersonMember.getInterest());
				updatePersonMemberBase.setAge(editPersonMember.getAge());
				updatePersonMemberBase.setSex(editPersonMember.getSex());
				updatePersonMemberBase.setHeadAddress(editPersonMember.getHeadAddress());
				updatePersonMemberBase.setProvinceCode(editPersonMember.getProvinceCode());
				updatePersonMemberBase.setCityCode(editPersonMember.getCityCode());
				updatePersonMemberBase.setCityAreaCode(editPersonMember.getCityAreaCode());
				updatePersonMemberBase.setAreaCode(editPersonMember.getAreaCode());

				updatePersonMemberBase.setUpdateId(editPersonMember.getOperater());
				updatePersonMemberBase.setUpdateDate(new Date());
				updatePersonMemberBase.setBirthday(editPersonMember.getBirthday());
				if (findPersonMemberBaseReturn != null) {
					updatePersonMemberBase.setNoWx(findPersonMemberBaseReturn.getNoWx());
				}
				updatePersonMemberBase.setMemberSrc(editPersonMember.getMemberSrc());
				personMemberBaseService.updatePersonMemberBase(updatePersonMemberBase);

				// 修改扩展表
				UpdatePersonMember updatePersonMember = new UpdatePersonMember();
				updatePersonMember.setCode(editPersonMember.getCodePm());
				updatePersonMember.setMemberNo(editPersonMember.getMemberNo());
				updatePersonMember.setMemberName(editPersonMember.getMemberName());
				updatePersonMember.setMemberNoGm(editPersonMember.getMemberNoGm());
				updatePersonMember.setMemberNameGm(editPersonMember.getMemberNameGm());
				updatePersonMember.setShopNo(editPersonMember.getShopNo());
				updatePersonMember.setShopName(editPersonMember.getShopName());
				updatePersonMember.setMerchantNo(editPersonMember.getMerchantNo());
				updatePersonMember.setMerchantName(editPersonMember.getMerchantName());
				updatePersonMember.setSpruceUp(editPersonMember.getSpruceUp());
				updatePersonMember.setHouses(editPersonMember.getHouses());
				updatePersonMember.setUrgencyPm(editPersonMember.getUrgencyPm());
				updatePersonMember.setBomCode(editPersonMember.getBomCode());
				updatePersonMember.setBomName(editPersonMember.getBomName());
				updatePersonMember.setUpdateId(editPersonMember.getOperater());
				updatePersonMember.setUpdateDate(new Date());
				updatePersonMember.setBrandCompare(editPersonMember.getBrandCompare());
				updatePersonMember.setClientSpecial(editPersonMember.getClientSpecial());
				updatePersonMember.setRemark(editPersonMember.getRemark());

				updatePersonMember(updatePersonMember, updatePersonMemberBase);

				// 修改资料完成度
				FindPersonMemberBase findPersonMemberBase2 = new FindPersonMemberBase();
				findPersonMemberBase2.setCode(editPersonMember.getCode());
				FindPersonMemberBaseReturn findPersonMemberBaseReturn2 = personMemberBaseService.findPersonMemberBase(findPersonMemberBase2);

				FindPersonMember findPm = new FindPersonMember();
				findPm.setMemberNo(findPersonMemberBaseReturn2.getMemberNo());
				findPm.setMemberNoGm(editPersonMember.getMemberNoGm());
				FindPersonMemberReturn findPmReturn = findPersonMemberByMGM(findPm);

				computeRate(findPersonMemberBaseReturn2, findPmReturn);
			}
			UpdatePersonMemberReturn updatePersonMemberReturn = new UpdatePersonMemberReturn();
			return updatePersonMemberReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("客户会员信息更新信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_UPDATE_ERROR, "客户会员信息更新信息错误！", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#updatePersonMemberByMGM
	 * (com.lj.business.member.dto.UpdatePersonMember)
	 */
	public UpdatePersonMemberReturn updatePersonMemberByMGM(UpdatePersonMember updatePersonMember) throws TsfaServiceException {
		logger.debug("updatePersonMemberByMGM(UpdatePersonMember updatePersonMember={}) - start", updatePersonMember); //$NON-NLS-1$

		AssertUtils.notNull(updatePersonMember);
		AssertUtils.notNullAndEmpty(updatePersonMember.getMemberNo(), "客户号不能为空");
		AssertUtils.notNullAndEmpty(updatePersonMember.getMemberNoGm(), "导购号不能为空");
		try {
			PersonMember personMember = new PersonMember();
			// update数据录入
			// personMember.setCode(updatePersonMember.getCode());
			personMember.setMemberNo(updatePersonMember.getMemberNo());
			personMember.setMemberName(updatePersonMember.getMemberName());
			personMember.setMemberNoGm(updatePersonMember.getMemberNoGm());
			personMember.setMemberNameGm(updatePersonMember.getMemberNameGm());
			personMember.setShopNo(updatePersonMember.getShopNo());
			personMember.setShopName(updatePersonMember.getShopName());
			personMember.setMerchantNo(updatePersonMember.getMerchantNo());
			personMember.setMerchantName(updatePersonMember.getMerchantName());
			personMember.setSpruceUp(updatePersonMember.getSpruceUp());
			personMember.setHouses(updatePersonMember.getHouses());
			personMember.setKeepEye(updatePersonMember.getKeepEye());
			personMember.setUrgencyPm(updatePersonMember.getUrgencyPm());
			personMember.setBomCode(updatePersonMember.getBomCode());
			personMember.setBomName(updatePersonMember.getBomName());
			personMember.setFirstIntroduce(updatePersonMember.getFirstIntroduce());
			personMember.setUpdateId(updatePersonMember.getUpdateId());
			personMember.setUpdateDate(updatePersonMember.getUpdateDate());
			personMember.setRemark4(updatePersonMember.getRemark4());
			personMember.setRemark3(updatePersonMember.getRemark3());
			personMember.setRemark2(updatePersonMember.getRemark2());
			personMember.setRemark(updatePersonMember.getRemark());
			personMember.setContactDateLast(updatePersonMember.getContactDateLast());

			if (FirstIntroduce.N.toString().equals(updatePersonMember.getFirstIntroduce())) {
				logger.debug("初次介绍任务完成，意向客户产生邀约任务，非意向客户产生沟通任务");
				AddClientFollow addClientFollow = new AddClientFollow();
				PersonMember personMemberQuery = new PersonMember();
				personMemberQuery.setMemberNo(updatePersonMember.getMemberNo());
				personMemberQuery.setMemberNoGm(updatePersonMember.getMemberNoGm());
				PersonMember personMemberResult = personMemberDao.selectByParamKey(personMemberQuery);
				// 原表中初次介绍是Y，更新为N
				if (FirstIntroduce.Y.toString().equals(personMemberResult.getFirstIntroduce())) {
					logger.debug("查询跟进总表中导购和客户最后一条记录");
					FindClientFollowSummary findClientFollowSummary = new FindClientFollowSummary();
					findClientFollowSummary.setMerchantNo(personMemberResult.getMerchantNo());
					findClientFollowSummary.setMemberNoGm(personMemberResult.getMemberNoGm());
					findClientFollowSummary.setMemberNo(personMemberResult.getMemberNo());
					FindClientFollowSummaryReturn findClientFollowSummaryReturn = clientFollowSummaryService.findClientFollowSummaryLast(findClientFollowSummary);
					if (findClientFollowSummaryReturn != null) {
						logger.debug("查询跟进总表中导购和客户最后一条记录: " + findClientFollowSummaryReturn);
						addClientFollow.setCfNo(findClientFollowSummaryReturn.getCfNo());
					}

					ComTaskType comTaskType = ComTaskType.INVITE;
					logger.debug("获取客户所属分类");
					// 查找客户原来所属分类关联CODE
					Map<String, String> map = new HashMap<String, String>();
					map.put("merchantNo", personMemberResult.getMerchantNo());
					map.put("codePm", personMemberResult.getCode());
					Map<String, String> mapResult = pmTypeDao.selectByParamKey_changePmType(map);
//					String PM_TYPE_TYPE = mapResult.get("PM_TYPE_TYPE");
//					logger.debug("客户所属分类：" + PM_TYPE_TYPE);
//					if (PmTypeType.OTHER.toString().equals(PM_TYPE_TYPE)) {
//						comTaskType = ComTaskType.COM_TASK;
//					} else {
//						comTaskType = ComTaskType.INVITE;
//					}

					addClientFollow.setMerchantNo(personMemberResult.getMerchantNo());
					addClientFollow.setMemberNo(personMemberResult.getMemberNo());
					addClientFollow.setMemberNoGm(personMemberResult.getMemberNoGm());
					addClientFollow.setFollowType(FollowType.SYSTEM.toString());
					addClientFollow.setFollowInfo("初次介绍");
					addClientFollow.setComTaskType(comTaskType.toString());
					addClientFollow.setComTaskTypeCf(ComTaskType.FIRST_INTR.toString());

					// 获取 工作事项选择 对应的频率
					FindComTaskChoose findComTaskChoose = new FindComTaskChoose();
					findComTaskChoose.setMerchantNo(personMemberResult.getMerchantNo());
					findComTaskChoose.setComTaskType(ComTaskType.FIRST_INTR.toString());
					ComTaskChooseReturnDto comTaskChooseReturnDto = comTaskChooseService.findComTaskChoose(findComTaskChoose);
					Date now = new Date();
					Date followTime = DateUtils.addHours(now, Integer.valueOf(comTaskChooseReturnDto.getFreValue()));
					addClientFollow.setFollowTime(now);
					addClientFollow.setNextDate(followTime);

					FindComTaskList findComTaskList = new FindComTaskList();
					findComTaskList.setMerchantNo(personMemberResult.getMerchantNo());
					findComTaskList.setComTaskType(comTaskType);
					FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
					if (findComTaskListReturn != null) {
						addClientFollow.setTaskCode(findComTaskListReturn.getCode());
					}
					addClientFollow.setRemarkCom(CommonConstant.REPLACE_REMARK_COM + "初次介绍");
					addClientFollow.setLastResultDate(new Date());
					clientFollowService.addCFOrder(addClientFollow, "0", true, false);

					// 关闭初次介绍任务
					UpdateComTaskFi updateComTaskFi = new UpdateComTaskFi();
					updateComTaskFi.setMemberNo(personMemberResult.getMemberNo());
					updateComTaskFi.setMemberNoGm(personMemberResult.getMemberNoGm());
					updateComTaskFi.setFinish(ComTaskFinish.FINISH);
					updateComTaskFi.setFinishDate(now);
					comTaskService.updateComTaskFi(updateComTaskFi);

					// 添加积分
					GuidMemberIntegralDto guidMemberIntegralDto = new GuidMemberIntegralDto();
					guidMemberIntegralDto.setMerchantNo(updatePersonMember.getMerchantNo());
					guidMemberIntegralDto.setShopNo(updatePersonMember.getShopNo());
					guidMemberIntegralDto.setMemberNo(updatePersonMember.getMemberNoGm());

					FindGuidMember findGuidMember = new FindGuidMember();
					findGuidMember.setMemberNo(updatePersonMember.getMemberNoGm());
					FindGuidMemberReturn findGuidMemberReturn = guidMemberService.findGuidMember(findGuidMember);
					if (findGuidMemberReturn != null) {
						guidMemberIntegralDto.setAreaCode(findGuidMemberReturn.getAreaCode());
					}
					guidMemberIntegralDto.setIntegralType(IntegralType.COM_TASK.toString());
					guidMemberIntegralDto.setAmount(1d);
					guidMemberIntegralService.doIntegral(guidMemberIntegralDto);

				}
			}

			AssertUtils.notUpdateMoreThanOne(personMemberDao.updateByMGM(personMember));
			UpdatePersonMemberReturn updatePersonMemberReturn = new UpdatePersonMemberReturn();

			logger.debug("updatePersonMemberByMGM(UpdatePersonMember) - end - return value={}", updatePersonMemberReturn); //$NON-NLS-1$
			return updatePersonMemberReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("客户会员信息更新信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_UPDATE_ERROR, "客户会员信息更新信息错误！", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#findPersonMember(
	 * com.lj.business.member.dto.FindPersonMember)
	 */
	@Override
	public FindPersonMemberReturn findPersonMember(FindPersonMember findPersonMember) throws TsfaServiceException {
		logger.debug("findPersonMember(FindPersonMember findPersonMember={}) - start", findPersonMember); //$NON-NLS-1$

		AssertUtils.notNull(findPersonMember);
		AssertUtils.notAllNull(findPersonMember.getCode(), "Code不能为空");
		try {
			PersonMember personMemberQuery = new PersonMember();
			personMemberQuery.setCode(findPersonMember.getCode());
			personMemberQuery.setMemberNo(findPersonMember.getMemberNo());
			personMemberQuery.setMemberNoGm(findPersonMember.getMemberNoGm());
			personMemberQuery.setMerchantNo(findPersonMember.getMerchantNo());
			PersonMember personMember = personMemberDao.selectByParamKey(personMemberQuery);
			if (personMember == null) {
				throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_NOT_EXIST_ERROR, "客户会员信息不存在");
			}
			FindPersonMemberReturn findPersonMemberReturn = new FindPersonMemberReturn();
			// find数据录入
			findPersonMemberReturn.setCode(personMember.getCode());
			findPersonMemberReturn.setMemberNo(personMember.getMemberNo());
			findPersonMemberReturn.setMemberName(personMember.getMemberName());
			findPersonMemberReturn.setMemberNoGm(personMember.getMemberNoGm());
			findPersonMemberReturn.setMemberNameGm(personMember.getMemberNameGm());
			findPersonMemberReturn.setShopNo(personMember.getShopNo());
			findPersonMemberReturn.setShopName(personMember.getShopName());
			findPersonMemberReturn.setMerchantNo(personMember.getMerchantNo());
			findPersonMemberReturn.setMerchantName(personMember.getMerchantName());
			findPersonMemberReturn.setSpruceUp(personMember.getSpruceUp());
			findPersonMemberReturn.setHouses(personMember.getHouses());
			findPersonMemberReturn.setKeepEye(personMember.getKeepEye());
			findPersonMemberReturn.setUrgencyPm(personMember.getUrgencyPm());
			findPersonMemberReturn.setBomCode(personMember.getBomCode());
			findPersonMemberReturn.setBomName(personMember.getBomName());
			findPersonMemberReturn.setCreateId(personMember.getCreateId());
			findPersonMemberReturn.setCreateDate(personMember.getCreateDate());
			findPersonMemberReturn.setUpdateId(personMember.getUpdateId());
			findPersonMemberReturn.setUpdateDate(personMember.getUpdateDate());
			findPersonMemberReturn.setRemark4(personMember.getRemark4());
			findPersonMemberReturn.setRemark3(personMember.getRemark3());
			findPersonMemberReturn.setRemark2(personMember.getRemark2());
			findPersonMemberReturn.setRemark(personMember.getRemark());
			/* 扫码相关 */
			findPersonMemberReturn.setLatitude(personMember.getLatitude());
			findPersonMemberReturn.setLongitude(personMember.getLongitude());
			findPersonMemberReturn.setScanAddress(personMember.getScanAddress());
			logger.debug("findPersonMember(FindPersonMember) - end - return value={}", findPersonMemberReturn); //$NON-NLS-1$
			return findPersonMemberReturn;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户会员信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找客户会员信息信息错误！", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#findPersonMemberByMGM
	 * (com.lj.business.member.dto.FindPersonMember)
	 */
	@Override
	public FindPersonMemberReturn findPersonMemberByMGM(FindPersonMember findPersonMember) throws TsfaServiceException {
		logger.debug("findPersonMemberByMGM(FindPersonMember findPersonMember={}) - start", findPersonMember); //$NON-NLS-1$

		AssertUtils.notNull(findPersonMember);
		AssertUtils.notNullAndEmpty(findPersonMember.getMemberNo(), "客户号不能为空");
		AssertUtils.notNullAndEmpty(findPersonMember.getMemberNoGm(), "导购号不能为空");
		try {
			PersonMember personMember = personMemberDao.selectByMGM(findPersonMember);
			if (personMember == null) {
				return null;
				// throw new
				// TsfaServiceException(ErrorCode.PERSON_MEMBER_NOT_EXIST_ERROR,"客户会员信息不存在");
			}
			FindPersonMemberReturn findPersonMemberReturn = new FindPersonMemberReturn();
			// find数据录入
			findPersonMemberReturn.setCode(personMember.getCode());
			findPersonMemberReturn.setMemberNo(personMember.getMemberNo());
			findPersonMemberReturn.setMemberName(personMember.getMemberName());
			findPersonMemberReturn.setMemberNoGm(personMember.getMemberNoGm());
			findPersonMemberReturn.setMemberNameGm(personMember.getMemberNameGm());
			findPersonMemberReturn.setShopNo(personMember.getShopNo());
			findPersonMemberReturn.setShopName(personMember.getShopName());
			findPersonMemberReturn.setMerchantNo(personMember.getMerchantNo());
			findPersonMemberReturn.setMerchantName(personMember.getMerchantName());
			findPersonMemberReturn.setSpruceUp(personMember.getSpruceUp());
			findPersonMemberReturn.setHouses(personMember.getHouses());
			findPersonMemberReturn.setKeepEye(personMember.getKeepEye());
			findPersonMemberReturn.setUrgencyPm(personMember.getUrgencyPm());
			findPersonMemberReturn.setBomCode(personMember.getBomCode());
			findPersonMemberReturn.setBomName(personMember.getBomName());
			findPersonMemberReturn.setCreateId(personMember.getCreateId());
			findPersonMemberReturn.setCreateDate(personMember.getCreateDate());
			findPersonMemberReturn.setUpdateId(personMember.getUpdateId());
			findPersonMemberReturn.setUpdateDate(personMember.getUpdateDate());
			findPersonMemberReturn.setRemark4(personMember.getRemark4());
			findPersonMemberReturn.setRemark3(personMember.getRemark3());
			findPersonMemberReturn.setRemark2(personMember.getRemark2());
			findPersonMemberReturn.setRemark(personMember.getRemark());
			/* 扫码相关 */
			findPersonMemberReturn.setLatitude(personMember.getLatitude());
			findPersonMemberReturn.setLongitude(personMember.getLongitude());
			findPersonMemberReturn.setScanAddress(personMember.getScanAddress());
			findPersonMemberReturn.setBrandCompare(personMember.getBrandCompare());
			findPersonMemberReturn.setClientSpecial(personMember.getClientSpecial());

			logger.debug("findPersonMemberByMGM(FindPersonMember) - end - return value={}", findPersonMemberReturn); //$NON-NLS-1$
			return findPersonMemberReturn;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户会员信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找客户会员信息信息错误！", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#findPersonMemberPage
	 * (com.lj.business.member.dto.FindPersonMemberPage)
	 */
	@Override
	public Page<FindPersonMemberPageReturn> findPersonMemberPage(FindPersonMemberPage findPersonMemberPage) throws TsfaServiceException {
		logger.debug("findPersonMemberPage(FindPersonMemberPage findPersonMemberPage={}) - start", findPersonMemberPage); //$NON-NLS-1$

		AssertUtils.notNull(findPersonMemberPage);
		List<FindPersonMemberPageReturn> returnList = null;
		int count = 0;
		try {
			returnList = personMemberDao.findPersonMemberPage(findPersonMemberPage);
			count = personMemberDao.findPersonMemberPageCount(findPersonMemberPage);
		} catch (Exception e) {
			logger.error("客户会员信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_PAGE_ERROR, "客户会员信息不存在错误.！", e);
		}
		Page<FindPersonMemberPageReturn> returnPage = new Page<FindPersonMemberPageReturn>(returnList, count, findPersonMemberPage);

		logger.debug("findPersonMemberPage(FindPersonMemberPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#queryMbr(com.lj.business
	 * .member.dto.FindManagerMember)
	 */
	/*
	 * @Override public List<FindPersonMemberReturn> queryMbr(FindManagerMember
	 * findManagerMember) throws TsfaServiceException {
	 * logger.debug("queryMbr(queryMbr findPersonMember={}) - start",
	 * findManagerMember); //$NON-NLS-1$
	 * 
	 * if(findManagerMember == null){ throw new
	 * TsfaServiceException(ErrorCode.QUERY_CONDITION_EMPTY,"由于数据量大,故查询条件不能为空");
	 * } //手机号码、姓名、微信昵称中必须有一个 String param = "";
	 * if(!StringUtils.isEmpty(findManagerMember.getPhone())) param =
	 * findManagerMember.getPhone();
	 * 
	 * if(!StringUtils.isEmpty(findManagerMember.getName())) param =
	 * findManagerMember.getName();
	 * 
	 * if(!StringUtils.isEmpty(findManagerMember.getWxNo())) param =
	 * findManagerMember.getWxNo();
	 * 
	 * if(StringUtils.isEmpty(param)){ throw new
	 * TsfaServiceException(ErrorCode.QUERY_CONDITION_EMPTY,"由于数据量大,故查询条件不能为空");
	 * }
	 * 
	 * try { Map<String, String> map = new HashMap<String, String>();
	 * map.put("memberGMCode",findManagerMember.getCode());
	 * map.put("param",findManagerMember.getMemeberNo());
	 * List<FindPersonMemberReturn> personMembers =
	 * personMemberDao.selectByPhoneWxName(map); if(personMembers == null){
	 * throw new
	 * TsfaServiceException(ErrorCode.PERSON_MEMBER_NOT_EXIST_ERROR,"客户会员信息不存在"
	 * ); } logger.debug("queryMbr(queryMbr) - end - return value={}",
	 * personMembers); //$NON-NLS-1$ return personMembers; }catch
	 * (TsfaServiceException e) { throw e; } catch (Exception e) {
	 * logger.error("查找客户表信息信息错误！",e); throw new
	 * TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR,"查找客户信息信息错误！",e);
	 * } }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#urgentMbr(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public List<FindPersonMemberReturn> urgentMbr(String flag, String memberGMCode) throws TsfaServiceException {
		logger.debug("urgentMbr(urgentMbr urgentMbr={}) - start", flag); //$NON-NLS-1$

		if (!StringUtils.isEmpty(flag)) {
			throw new TsfaServiceException(ErrorCode.FLAG_EMPTY, "紧急客户标签条件不能为空");
		}
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberGMCode", memberGMCode);
			map.put("flag", flag);
			List<FindPersonMemberReturn> personMembers = personMemberDao.inqueryUngrentMember(map);
			if (personMembers == null) {
				throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_NOT_EXIST_ERROR, "紧急客户信息不存在");
			}
			logger.debug("urgentMbr(urgentMbr) - end - return value={}", personMembers); //$NON-NLS-1$
			return personMembers;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找紧急客户信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找紧急客户信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#urgentOpMbr(java.
	 * lang.String, java.lang.String)
	 */
	@Override
	public int urgentOpMbr(String code, String flag) throws TsfaServiceException {
		logger.debug("urgentOpMbr(urgentOpMbr urgentOpMbr={}) - start", code);

		if (!StringUtils.isEmpty(code)) {
			throw new TsfaServiceException(ErrorCode.FLAG_EMPTY, "客户代码不能为空");
		}
		PersonMember pm = personMemberDao.selectByPrimaryKey(code);
		if (pm == null) {
			throw new TsfaServiceException(ErrorCode.PERSON_ERROR_NOT_EXIST, "客户不存在");
		}
		try {

			PmTypePm ptp = ipmTypePmDao.selectByPrimaryKey(code);
			// ptp.setUngrantFlag(flag);
			int cnt = ipmTypePmDao.updateByPrimaryKey(ptp);
			logger.debug("urgentMbr(urgentMbr) - end - return value={}", cnt); //$NON-NLS-1$
			return cnt;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户表信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找客户信息信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#unGroupMbr(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public List<FindPersonMemberReturn> unGroupMbr(String flag, String memberGMCode) throws TsfaServiceException {
		logger.debug("urgentMbr(urgentMbr urgentMbr={}) - start", flag); //$NON-NLS-1$

		if (!StringUtils.isEmpty(flag)) {
			throw new TsfaServiceException(ErrorCode.FLAG_EMPTY, "未分组客户标签条件不能为空");
		}
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberGMCode", memberGMCode);
			map.put("flag", flag);
			List<FindPersonMemberReturn> personMembers = personMemberDao.inqueryUnGroupMember(map);
			if (personMembers == null) {
				throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_NOT_EXIST_ERROR, "客户信息不存在");
			}
			logger.debug("urgentMbr(urgentMbr) - end - return value={}", personMembers); //$NON-NLS-1$
			return personMembers;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("查找未分组客户信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找未分组客户信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#favorMbr(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public List<FindPersonMemberReturn> favorMbr(String code, String memberGMCode) throws TsfaServiceException {
		logger.debug("favorMbr(favorMbr favorMbr={}) - start", code); //$NON-NLS-1$

		if (!StringUtils.isEmpty(code)) {
			throw new TsfaServiceException(ErrorCode.FLAG_EMPTY, "意向客户标签条件不能为空");
		}
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberGMCode", memberGMCode);
			map.put("code", code);
			List<FindPersonMemberReturn> personMembers = personMemberDao.inqueryMemberByPmType(map);
			if (personMembers == null) {
				throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_NOT_EXIST_ERROR, "意向客户信息不存在");
			}
			logger.debug("favorMbr(favorMbr) - end - return value={}", personMembers); //$NON-NLS-1$
			return personMembers;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找意向客户信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找意向客户信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#unfavorMbr(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public List<FindPersonMemberReturn> unfavorMbr(String code, String memberGMCode) throws TsfaServiceException {
		logger.debug("favorMbr(unfavorMbr unfavorMbr={}) - start", code); //$NON-NLS-1$

		if (!StringUtils.isEmpty(code)) {
			throw new TsfaServiceException(ErrorCode.FLAG_EMPTY, "非意向客户标签条件不能为空");
		}
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberGMCode", memberGMCode);
			map.put("code", code);
			List<FindPersonMemberReturn> personMembers = personMemberDao.inqueryMemberByPmType(map);
			if (personMembers == null) {
				throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_NOT_EXIST_ERROR, "非意向客户信息不存在");
			}
			logger.debug("unfavorMbr(unfavorMbr) - end - return value={}", personMembers); //$NON-NLS-1$
			return personMembers;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找非意向客户信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找非意向客户信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#orderMbr(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public List<FindPersonMemberReturn> orderMbr(String code, String memberGMCode) throws TsfaServiceException {
		logger.debug("orderMbr(orderMbr orderMbr={}) - start", code); //$NON-NLS-1$

		if (!StringUtils.isEmpty(code)) {
			throw new TsfaServiceException(ErrorCode.FLAG_EMPTY, "成单客户标签条件不能为空");
		}
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberGMCode", memberGMCode);
			map.put("code", code);
			List<FindPersonMemberReturn> personMembers = personMemberDao.inqueryMemberByPmType(map);
			if (personMembers == null) {
				throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_NOT_EXIST_ERROR, "成单客户信息不存在");
			}
			logger.debug("orderMbr(orderMbr) - end - return value={}", personMembers); //$NON-NLS-1$
			return personMembers;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找成单客户信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找成单客户信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#abandonMbr(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public List<FindPersonMemberReturn> abandonMbr(String code, String memberGMCode) throws TsfaServiceException {
		logger.debug("abandonMbr(abandonMbr abandonMbr={}) - start", code); //$NON-NLS-1$

		if (!StringUtils.isEmpty(code)) {
			throw new TsfaServiceException(ErrorCode.FLAG_EMPTY, "放弃客户标签条件不能为空");
		}
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberGMCode", memberGMCode);
			map.put("code", code);
			List<FindPersonMemberReturn> personMembers = personMemberDao.inqueryMemberByPmType(map);
			if (personMembers == null) {
				throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_NOT_EXIST_ERROR, "弃户客户信息不存在");
			}
			logger.debug("abandonMbr(abandonMbr) - end - return value={}", personMembers); //$NON-NLS-1$
			return personMembers;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找放弃客户信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找放弃客户信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#repeatMbr(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public List<FindPersonMemberReturn> repeatMbr(String flag, String memberGMCode) throws TsfaServiceException {
		logger.debug("repeatMbr(repeatMbr repeatMbr={}) - start", flag); //$NON-NLS-1$

		if (!StringUtils.isEmpty(flag)) {
			throw new TsfaServiceException(ErrorCode.FLAG_EMPTY, "交叉客户标签条件不能为空");
		}
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberGMCode", memberGMCode);
			map.put("flag", flag);
			List<FindPersonMemberReturn> personMembers = personMemberDao.inqueryRepeatMember(map);
			if (personMembers == null) {
				throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_NOT_EXIST_ERROR, "交叉信息不存在");
			}
			logger.debug("repeatMbr(repeatMbr) - end - return value={}", personMembers); //$NON-NLS-1$
			return personMembers;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找交叉客户信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找交叉客户信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#addMemberForNonWxMember
	 * (com.lj.business.member.dto.AddPersonMemberBase)
	 */
	@Override
	public int addMemberForNonWxMember(AddPersonMemberBase addPersonMemberBase) throws TsfaServiceException {
		logger.debug("addMemberForNonWxMember(addMemberForNonWxMember addMemberForNonWxMember={}) - start", addPersonMemberBase); //$NON-NLS-1$
		boolean flag = false;
		if (StringUtils.isEmpty(addPersonMemberBase.getMobile()) || StringUtils.isEmpty(addPersonMemberBase.getMemberName()) || StringUtils.isEmpty(addPersonMemberBase.getPmTypeCode()))
			flag = true;

		if (flag) {
			throw new TsfaServiceException(ErrorCode.FLAG_EMPTY, "客户姓名,手机,客户分组不能为空");
		}
		AssertUtils.notNullAndEmpty(addPersonMemberBase.getMemberSrc(), "客户来源不能为空");
		String merchantNo = addPersonMemberBase.getMerchantNo();
		AssertUtils.notNullAndEmpty(merchantNo, "商户号不能为空");
		FindPersonMemberBase findPersonMemberBase = new FindPersonMemberBase();

		String memberNameGm = "";
		try {
			Date now = new Date();
			if (StringUtils.isEmpty(addPersonMemberBase.getUrgencyPm())) {
				addPersonMemberBase.setUrgencyPm(UrgentFlagType.N.toString());
			}
			findPersonMemberBase.setMobile(addPersonMemberBase.getMobile());
			// 插入客户基本表
			PersonMemberBase pmb = personMemberBaseDao.findByMobile(findPersonMemberBase);
			if (pmb == null) {
				logger.debug("插入客户基本表");
				pmb = new PersonMemberBase();
				pmb.setCode(GUID.getPreUUID());
				pmb.setMemberName(addPersonMemberBase.getMemberName());
				pmb.setMobile(addPersonMemberBase.getMobile());
				pmb.setSex(addPersonMemberBase.getSex());
				pmb.setAge(addPersonMemberBase.getAge());
				pmb.setJob(addPersonMemberBase.getJob());
				pmb.setMemberNo(GUID.generateByUUID());
				pmb.setProvinceCode(addPersonMemberBase.getProvinceCode());// 省
				pmb.setCityCode(addPersonMemberBase.getCityCode());// 市
				pmb.setCityAreaCode(addPersonMemberBase.getCityAreaCode());// 区
				pmb.setAreaCode(addPersonMemberBase.getAreaCode());

				pmb.setMemberSrc(addPersonMemberBase.getMemberSrc());
				pmb.setStatus(MemberStatus.NORMAL.toString());
				pmb.setNameAuthFlag(NameAuthFlag.N.toString());
				pmb.setCreateId(addPersonMemberBase.getMemberNoGm());
				pmb.setCreateDate(new Date());
				pmb.setBirthday(addPersonMemberBase.getBirthday());
				pmb.setHeadAddress(addPersonMemberBase.getHeadAddress());
				personMemberBaseDao.insertSelective(pmb);

				// 添加客户动态
				AddBehaviorPm addBehaviorPm = new AddBehaviorPm();
				addBehaviorPm.setMemberNo(pmb.getMemberNo());
				addBehaviorPm.setMemberName(pmb.getMemberName());
				addBehaviorPm.setBehaviorDesc("暂无动态");
				addBehaviorPm.setBehaviorDate(now);
				behaviorPmService.addBehaviorPm(addBehaviorPm);
			}

			FindPersonMember findPersonMember = new FindPersonMember();
			findPersonMember.setMemberNo(pmb.getMemberNo());
			findPersonMember.setMemberNoGm(addPersonMemberBase.getMemberNoGm());
			FindPersonMemberReturn findPersonMemberReturn = findPersonMemberByMGM(findPersonMember);
			PersonMember pm = new PersonMember();
			if (findPersonMemberReturn == null) {
				logger.debug("插入客户扩展表");
				pm.setCode(GUID.getPreUUID());
				pm.setMerchantNo(merchantNo);
				pm.setMemberNoGm(addPersonMemberBase.getMemberNoGm());
				pm.setMemberNo(pmb.getMemberNo());
				pm.setMemberName(addPersonMemberBase.getMemberName());
				FindGuidMemberReturn findGuidMemberReturn = null;
				// 导购名称
				if (StringUtils.isEmpty(addPersonMemberBase.getMemberNameGm())) {
					FindGuidMember findGuidMember = new FindGuidMember();
					findGuidMember.setMemberNo(addPersonMemberBase.getMemberNoGm());
					findGuidMemberReturn = guidMemberService.findGuidMember(findGuidMember);
					if (findGuidMemberReturn != null) {
						memberNameGm = findGuidMemberReturn.getMemberName();
					}
				} else {
					memberNameGm = addPersonMemberBase.getMemberNameGm();
				}
				pm.setMemberNameGm(memberNameGm);
				// 商户名称
				String merchantName = "";
				if (StringUtils.isEmpty(addPersonMemberBase.getMerchantName())) {
					FindMerchantDto findMerchantDto = new FindMerchantDto();
					findMerchantDto.setMerchantNo(merchantNo);
					FindMerchantReturnDto findMerchantReturnDto = merchantService.selectMerchant(findMerchantDto);
					if (findMerchantReturnDto != null) {
						merchantName = findMerchantReturnDto.getMerchantName();
					}
				} else {
					merchantName = addPersonMemberBase.getMerchantName();
				}
				pm.setMerchantName(merchantName);

				pm.setCreateId(addPersonMemberBase.getMemberNoGm());
				pm.setCreateDate(now);
				pm.setShopName(addPersonMemberBase.getShopName());
				pm.setShopNo(addPersonMemberBase.getShopNo());
				pm.setUpdateDate(now);
				pm.setUpdateId(addPersonMemberBase.getMemberNoGm());
				pm.setBomName(addPersonMemberBase.getBomName());
				pm.setHouses(addPersonMemberBase.getHouses());
				pm.setBrandCompare(addPersonMemberBase.getBrandCompare());
				pm.setUrgencyPm(addPersonMemberBase.getUrgencyPm());
				pm.setContactDateLast(new Date());
				pm.setClientSpecial(addPersonMemberBase.getClientSpecial());
				pm.setSpruceUp(addPersonMemberBase.getSpruceUp());

				// 修改为意向客户--初次介绍变更 update by leopeng 2017.08.03
				if (!StringUtils.isEmpty(addPersonMemberBase.getPmTypeCode())) {
					logger.debug("修改为没有微信客户没有初次介绍！");
					// if(PmTypeType.INTENTION.toString().equals(pmType.getPmTypeType())||
					// PmTypeType.OTHER.toString().equals(pmType.getPmTypeType())){
					pm.setFirstIntroduce(FirstIntroduce.N.toString());
					// }
				}

				// update by 杨杰 2017-09-05 begin
				String nickNameRemarkLocal = "";
				if (StringUtils.isNotEmpty(pmb.getMemberName())) {
					nickNameRemarkLocal += pmb.getMemberName();
				}
				if (StringUtils.isNotEmpty(pmb.getMobile())) {
					nickNameRemarkLocal += ("-" + pmb.getMobile());
				}
				if (StringUtils.isNotEmpty(pm.getBomName())) {
					nickNameRemarkLocal += ("-" + pm.getBomName());
				}
				pm.setNickNameRemarkLocal(nickNameRemarkLocal);
				// update by 杨杰 2017-09-05 end

				personMemberDao.insertSelective(pm);

				// 添加交叉客户
				DoRepeatMemberDto doRepeatMemberDto = new DoRepeatMemberDto();
				doRepeatMemberDto.setMemberNo(pmb.getMemberNo());
				doRepeatMemberDto.setMemberNoGm(addPersonMemberBase.getMemberNoGm());
				doRepeatMemberDto.setMerchantNo(merchantNo);
				doRepeatMember(doRepeatMemberDto);
			} else {
				throw new TsfaServiceException(ErrorCode.MEMBER_GM_REPERAT_ERROR, "客户已经关联过导购");
			}

			// 插入客户分类关联表
			// 意向/非意向 产生一条客户分类关联
			int cnt = 0;
			if (!StringUtils.isEmpty(addPersonMemberBase.getPmTypeCode())) {
				logger.debug("意向(到店)/意向(未到店)/非意向  产生一条客户分类关联");
				PmTypePm ptp = new PmTypePm();
				ptp.setCode(GUID.getPreUUID());
				ptp.setCodePm(pm.getCode());
				ptp.setPmTypeCode(addPersonMemberBase.getPmTypeCode());
				cnt = ipmTypePmDao.insert(ptp);
			} else {
				logger.debug("未分组，产生一条客户分类关联");
				PmTypePm ptp = new PmTypePm();
				ptp.setCode(GUID.getPreUUID());
				ptp.setCodePm(pm.getCode());

//				FindPmType findPmType = new FindPmType();
//				findPmType.setPmTypeType(PmTypeType.UNGROUP.toString());
//				findPmType.setMerchantNo(merchantNo);
//				FindPmTypeReturn findPmTypeReturn = pmTypeService.findPmTypeByMP(findPmType);
//				if (findPmTypeReturn != null) {
//					ptp.setPmTypeCode(findPmTypeReturn.getCode());
//					cnt = ipmTypePmDao.insert(ptp);
//				}
			}

			// 紧急 产生一条客户分类关联
			if (!StringUtils.isEmpty(addPersonMemberBase.getUrgencyPm()) && UrgentFlagType.Y.toString().equals(addPersonMemberBase.getUrgencyPm())) {
				logger.debug("紧急 产生一条客户分类关联");
				PmTypePm ptp2 = new PmTypePm();
				ptp2.setCode(GUID.getPreUUID());
				ptp2.setCodePm(pm.getCode());
				FindPmType findPmType = new FindPmType();
//				findPmType.setPmTypeType(PmTypeType.URGENCY.toString());
//				findPmType.setMerchantNo(merchantNo);
//				FindPmTypeReturn findPmTypeReturn = pmTypeService.findPmTypeByMP(findPmType);
//				if (findPmTypeReturn != null) {
//					ptp2.setPmTypeCode(findPmTypeReturn.getCode());
//					cnt = ipmTypePmDao.insert(ptp2);
//				}
			}

			// 产生跟进总表和第一条跟进明细记录
			AddPmClientFollowFirstDto addPmClientFollowFirstDto = new AddPmClientFollowFirstDto();
			addPmClientFollowFirstDto.setMerchantNo(merchantNo);
			addPmClientFollowFirstDto.setMemberNo(pmb.getMemberNo());
			addPmClientFollowFirstDto.setMemberName(addPersonMemberBase.getMemberName());
			addPmClientFollowFirstDto.setMemberNoGm(addPersonMemberBase.getMemberNoGm());
			addPmClientFollowFirstDto.setMemberNameGm(addPersonMemberBase.getMemberNameGm());
			addPmClientFollowFirstDto.setPmTypeCode(addPersonMemberBase.getPmTypeCode());
			String cfNo = clientFollowSummaryService.addSummaryWithClientFollow(addPmClientFollowFirstDto);

			// 未分组则产生分组任务
			if (StringUtils.isEmpty(addPersonMemberBase.getPmTypeCode())) {
				logger.debug("未分组则产生分组任务");
				// 查询客户分类频率
//				FindPmType findPmType = new FindPmType();
//				findPmType.setMerchantNo(merchantNo);
//				findPmType.setPmTypeType(PmTypeType.UNGROUP.toString());
//				FindPmTypeReturn ptp = pmTypeService.findPmTypeByMP(findPmType);
//				int hour = 0;
//				if (ptp == null || StringUtils.isEmpty(ptp.getFreValue())) {
//					hour = 0;
//				} else {
//					hour = Integer.valueOf(ptp.getFreValue());
//				}
				AddComTask addComTask = new AddComTask();
				addComTask.setMerchantNo(addPmClientFollowFirstDto.getMerchantNo());
				addComTask.setMemberNoGm(addPmClientFollowFirstDto.getMemberNoGm());
				addComTask.setMemberNo(pmb.getMemberNo());
				addComTask.setMemberName(pmb.getMemberName());
				addComTask.setCfNo(cfNo);
				addComTask.setNoType(FollowNoType.FOLLOW.toString());
//				addComTask.setWorkDate(DateUtils.addHours(new Date(), hour));
				addComTask.setWorkDate(new Date());
				addComTask.setComTaskType(ComTaskType.GROUP);
				addComTask.setRemarkCom(CommonConstant.REPLACE_REMARK_COM + "手工新增客户");
				addComTask.setLastResultDate(new Date());

				FindComTaskList findComTaskList = new FindComTaskList();
				findComTaskList.setMerchantNo(addPmClientFollowFirstDto.getMerchantNo());
				findComTaskList.setComTaskType(ComTaskType.GROUP);
				FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
				if (findComTaskListReturn != null) {
					addComTask.setCodeList(findComTaskListReturn.getCode());
					comTaskService.addComTask(addComTask);
				}
			} else {
				logger.debug("意向客户产生邀约任务，非意向客户产生沟通任务");
				// 用户所属分类
				PmType pmType = pmTypeDao.selectByPrimaryKey(addPersonMemberBase.getPmTypeCode());

				ComTaskType comTaskType = ComTaskType.INVITE;
//				if (PmTypeType.OTHER.toString().equals(pmType.getPmTypeType().toString())) {
//					logger.debug("非意向客户产生沟通任务");
//					comTaskType = ComTaskType.COM_TASK;
//				} else {
//					logger.debug("意向客户产生邀约任务");
//					comTaskType = ComTaskType.INVITE;
//				}

				// 产生业务任务
				AddComTask addComTask = new AddComTask();
				addComTask.setMerchantNo(merchantNo);
				addComTask.setMemberNoGm(addPersonMemberBase.getMemberNoGm());

				addComTask.setCfNo(cfNo);
				addComTask.setNoType(FollowNoType.FOLLOW.toString());
				addComTask.setComTaskType(comTaskType);
				addComTask.setRemarkCom(CommonConstant.REPLACE_REMARK_COM + "手工新增客户");
				addComTask.setLastResultDate(new Date());

				if (StringUtils.isEmpty(pmType.getFreValue())) {
					pmType.setFreValue("0");
				}

				addComTask.setWorkDate(DateUtils.addHours(new Date(), Integer.valueOf(pmType.getFreValue())));
				FindComTaskList findComTaskList_temp = new FindComTaskList();
				findComTaskList_temp.setMerchantNo(merchantNo);
				findComTaskList_temp.setComTaskType(comTaskType);
				FindComTaskListReturn findComTaskListReturn_temp = comTaskListService.findComTaskList(findComTaskList_temp);
				if (findComTaskListReturn_temp != null) {
					addComTask.setCodeList(findComTaskListReturn_temp.getCode());
					addComTask.setMemberNo(pmb.getMemberNo());
					addComTask.setMemberName(pmb.getMemberName());
					comTaskService.addComTask(addComTask);
				} else {
					logger.error("任务类型不存在！");
				}
			}

			// 增加客户新增的数量
			UpdateWorkTaskFinishNum updateWorkTaskFinishNum = new UpdateWorkTaskFinishNum();
			updateWorkTaskFinishNum.setMemberNoGm(addPersonMemberBase.getMemberNoGm());
			updateWorkTaskFinishNum.setMerchantNo(merchantNo);
			updateWorkTaskFinishNum.setTaskType(TaskType.XIN_ZENG);
			updateWorkTaskFinishNum.setFinishNum(1L);
			workTaskService.updateFinishNum(updateWorkTaskFinishNum);

			// 添加积分
			GuidMemberIntegralDto guidMemberIntegralDto = new GuidMemberIntegralDto();
			guidMemberIntegralDto.setMerchantNo(merchantNo);
			guidMemberIntegralDto.setShopNo(addPersonMemberBase.getShopNo());
			guidMemberIntegralDto.setMemberNo(addPersonMemberBase.getMemberNoGm());

			FindGuidMember findGuidMember = new FindGuidMember();
			findGuidMember.setMemberNo(addPersonMemberBase.getMemberNoGm());
			FindGuidMemberReturn findGuidMemberReturn = guidMemberService.findGuidMember(findGuidMember);
			if (findGuidMemberReturn != null) {
				guidMemberIntegralDto.setAreaCode(findGuidMemberReturn.getAreaCode());
			}
			guidMemberIntegralDto.setIntegralType(IntegralType.NEW.toString());
			guidMemberIntegralDto.setAmount(1d);
			guidMemberIntegralService.doIntegral(guidMemberIntegralDto);

			// 添加到导购行为统计表
			AddGuidmemberActionInfo addGuidmemberActionInfo = new AddGuidmemberActionInfo();
			addGuidmemberActionInfo.setCode(GUID.generateCode());
			addGuidmemberActionInfo.setActionType(GuidmemberActionType.NEW.toString());
			addGuidmemberActionInfo.setActionTime(new Date());
			addGuidmemberActionInfo.setCreateDate(new Date());
			addGuidmemberActionInfo.setMerchantNo(merchantNo);
			addGuidmemberActionInfo.setMemberNoGm(addPersonMemberBase.getMemberNoGm());

			if (findGuidMemberReturn != null) {
				addGuidmemberActionInfo.setMemberNameGm(findGuidMemberReturn.getMemberName());
				addGuidmemberActionInfo.setShopNo(addPersonMemberBase.getShopNo());
				addGuidmemberActionInfo.setShopName(findGuidMemberReturn.getShopName());
				addGuidmemberActionInfo.setActionDetail(findGuidMemberReturn.getMemberName() + "新增了一个用户");
			}
			guidmemberActionInfoService.addGuidmemberActionInfo(addGuidmemberActionInfo);

			// 修改资料完成度
			FindPersonMemberBase findMobile = new FindPersonMemberBase();
			findMobile.setMobile(addPersonMemberBase.getMobile());
			FindPersonMemberBaseReturn findPersonMemberBaseReturn = personMemberBaseService.findByMobile(findMobile);

			FindPersonMember findPm = new FindPersonMember();
			findPm.setMemberNo(pmb.getMemberNo());
			findPm.setMemberNoGm(addPersonMemberBase.getMemberNoGm());
			FindPersonMemberReturn findPmReturn = findPersonMemberByMGM(findPm);

			computeRate(findPersonMemberBaseReturn, findPmReturn);
			logger.debug("addMemberForNonWxMember(addMemberForNonWxMember) - end - return value={}", cnt); //$NON-NLS-1$
			return cnt;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("新增客户信息错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "新增客户信息错误！", e);
		}
	}

	@Override
	public void computeRate(FindPersonMemberBaseReturn findPersonMemberBaseReturn, FindPersonMemberReturn findPersonMemberReturn) throws TsfaServiceException {
		logger.debug(
				"computeRate(FindPersonMemberBaseReturn findPersonMemberBaseReturn={}, FindPersonMemberReturn findPersonMemberReturn={}) - start", findPersonMemberBaseReturn, findPersonMemberReturn); //$NON-NLS-1$

		// 拼装设置条件
		PersonMemberRateDto personMemberRateDto = new PersonMemberRateDto();
		personMemberRateDto.setBirthday(findPersonMemberBaseReturn.getBirthday());
		personMemberRateDto.setBomName(findPersonMemberReturn.getBomName());
		personMemberRateDto.setBrandCompare(findPersonMemberReturn.getBrandCompare());
		personMemberRateDto.setClientSpecial(findPersonMemberReturn.getClientSpecial());
		personMemberRateDto.setHeadAddress(findPersonMemberBaseReturn.getHeadAddress());
		personMemberRateDto.setHouses(findPersonMemberReturn.getHouses());
		personMemberRateDto.setJob(findPersonMemberBaseReturn.getJob());
		personMemberRateDto.setMemberName(findPersonMemberBaseReturn.getMemberName());
		personMemberRateDto.setMemberSrc(findPersonMemberBaseReturn.getMemberSrc());
		personMemberRateDto.setMobile(findPersonMemberBaseReturn.getMobile());
		personMemberRateDto.setNickNameWx(findPersonMemberBaseReturn.getNickNameWx());
		personMemberRateDto.setNoWx(findPersonMemberBaseReturn.getNoWx());
		personMemberRateDto.setSex(findPersonMemberBaseReturn.getSex());
		personMemberRateDto.setSpruceUp(findPersonMemberReturn.getSpruceUp());
		personMemberRateDto.setInterest(findPersonMemberBaseReturn.getInterest());
		personMemberRateDto.setRemark(findPersonMemberReturn.getRemark());
		
		logger.debug("computeRate(==== personMemberRateDto={}", personMemberRateDto); //$NON-NLS-1$

		// 计算完成度
		Double rate = MemberUtils.completeRateNew(personMemberRateDto);
		// 修改完成度
		UpdatePersonMemberBaseRatioClientInfoDto dto = new UpdatePersonMemberBaseRatioClientInfoDto();
		dto.setRatioClientInfo(rate);
		dto.setMemberNo(findPersonMemberBaseReturn.getMemberNo());
		personMemberBaseService.updatePersonMemberBaseRatioClientInfo(dto);

		logger.debug("computeRate() - end"); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#memberInfo(java.lang
	 * .String, java.lang.String)
	 */
	/*
	 * @Override public AddPersonMemberBase memberInfo(String code,String
	 * memberGMCode) throws TsfaServiceException { logger.debug(
	 * "AddPersonMemberBase(code-memberGMCode) - start - return value={}",
	 * code+'-'+memberGMCode); //$NON-NLS-1$ AddPersonMemberBase apm = new
	 * AddPersonMemberBase(); //查询基本表 PersonMemberBase pmb =
	 * personMemberBaseDao.selectByPrimaryKey(code); //查询扩展表 Map<String, String>
	 * map = new HashMap<String, String>(); map.put("memberNo",
	 * apm.getMemberNo()); map.put("memberGMCode", memberGMCode);
	 * List<PersonMember> pms = personMemberDao.selectByMemberNoGMCode(map);
	 * PersonMember pm = null; if(pms != null && pms.size() >0) pm = pms.get(0);
	 * //查询客户分类关联表 List<PmTypePm> ptps = ipmTypePmDao.selectByMemberNo(map);
	 * PmTypePm ptp = null; if(ptps != null && ptps.size() >0) ptp =
	 * ptps.get(0);
	 * 
	 * //组装客户信息 if(pmb != null){ apm.setAddress(pmb.getAddress());
	 * apm.setNickNameWx(pmb.getNickNameWx());
	 * apm.setHeadAddress(pmb.getHeadAddress());
	 * apm.setMemberName(pmb.getMemberName()); apm.setMobile(pmb.getMobile());
	 * apm.setSex(pmb.getSex()); apm.setAge(pmb.getAge());
	 * apm.setJob(pmb.getJob()); if(ptp != null)
	 * apm.setPmTypeCode(ptp.getPmTypeCode()); //apm.setUrgencyPm(pmb.get);
	 * apm.setBomName(pm.getBomName()); apm.setProvinceWx(pmb.getProvinceWx());
	 * apm.setCityWx(pmb.getCityWx());
	 * apm.setCityAreaCode(pmb.getCityAreaCode());
	 * apm.setSpruceUp(pm.getSpruceUp()); apm.setHouses(pm.getHouses());
	 * apm.setMemberSrc(pmb.getMemberSrc()); }
	 * logger.debug("AddPersonMemberBase(apm) - start - return value={}", apm);
	 * //$NON-NLS-1$ return apm; }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#getByCode(java.lang
	 * .String)
	 */
	@Override
	public FindPersonMemberPageReturn getByCond(Map<String, String> param) {
		AssertUtils.notNull(param);
		FindPersonMemberPageReturn findPersonMemberPageReturn = null;
		try {
			findPersonMemberPageReturn = personMemberDao.getByCond(param);
		} catch (Exception e) {
			logger.error("客户会员信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_PAGE_ERROR, "客户会员信息不存在错误.！", e);
		}
		return findPersonMemberPageReturn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#findPmTypeIndexPage
	 * (com.lj.business.member.dto.FindPmTypeIndexPage)
	 */
	@Override
	public Page<FindPmTypeIndexPageReturn> findPmTypeIndexPage(FindPmTypeIndexPage findPmTypeIndexPage) throws TsfaServiceException {
		logger.debug("findPmTypeIndexPage(FindPmTypeIndexPage findPmTypeIndexPage={}) - start", findPmTypeIndexPage); //$NON-NLS-1$

		AssertUtils.notNull(findPmTypeIndexPage);
		AssertUtils.notNullAndEmpty(findPmTypeIndexPage.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notAllNullAndEmpty(findPmTypeIndexPage.getShopNo(), findPmTypeIndexPage.getMemberNoGm());
		List<FindPmTypeIndexPageReturn> returnList = null;
		int count = 0;
		try {
			returnList = personMemberDao.findPmTypeIndexPage(findPmTypeIndexPage);
			count = personMemberDao.findPmTypeIndexPageCount(findPmTypeIndexPage);
		} catch (Exception e) {
			logger.error("客户管理首页分页查询错误!", e);
			throw new TsfaServiceException(ErrorCode.FIND_PMTYPE_INDEX_PAGE_ERROR, "客户管理首页分页查询错误!", e);
		}
		Page<FindPmTypeIndexPageReturn> returnPage = new Page<FindPmTypeIndexPageReturn>(returnList, count, findPmTypeIndexPage);

		logger.debug("findPmTypeIndexPage(FindPmTypeIndexPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#findPmSeachPage(com
	 * .lj.business.member.dto.FindPmSeachPage)
	 */
	@Override
	public Page<FindPmSeachPageReturn> findPmSeachPage(FindPmSeachPage findPmSeachPage) throws TsfaServiceException {
		logger.debug("findPmSeachPage(FindPmSeachPage findPmSeachPage={}) - start", findPmSeachPage); //$NON-NLS-1$

		AssertUtils.notNull(findPmSeachPage);
		AssertUtils.notNullAndEmpty(findPmSeachPage.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notAllNullAndEmpty(findPmSeachPage.getShopNo(), findPmSeachPage.getMemberNoGm());
		List<FindPmSeachPageReturn> returnList = null;
		int count = 0;
		try {
			returnList = personMemberDao.findPmSeachPage(findPmSeachPage);
			for (FindPmSeachPageReturn findPmSeachPageReturn : returnList) {
				findPmSeachPageReturn.setBehaviorDesc("客户资料完成" + (int)(findPmSeachPageReturn.getRatioClientInfo().doubleValue() * 100) + "%");
			}
			count = personMemberDao.findPmSeachPageCount(findPmSeachPage);
		} catch (Exception e) {
			logger.error("客户管理首页分页查询错误!", e);
			throw new TsfaServiceException(ErrorCode.FIND_PMTYPE_INDEX_PAGE_ERROR, "客户管理首页分页查询错误!", e);
		}
		Page<FindPmSeachPageReturn> returnPage = new Page<FindPmSeachPageReturn>(returnList, count, findPmSeachPage);

		logger.debug("findPmSeachPage(FindPmSeachPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#findUrgentMbrPage
	 * (com.lj.business.member.dto.FindUrgentMbrPage)
	 */
	@Override
	public Page<FindUrgentMbrPageReturn> findUrgentMbrPage(FindUrgentMbrPage findUrgentMbrPage) throws TsfaServiceException {
		logger.debug("findUrgentMbrPage(FindUrgentMbrPage findUrgentMbrPage={}) - start", findUrgentMbrPage); //$NON-NLS-1$

		AssertUtils.notNull(findUrgentMbrPage);
		AssertUtils.notNullAndEmpty(findUrgentMbrPage.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notAllNullAndEmpty(findUrgentMbrPage.getShopNo(), findUrgentMbrPage.getMemberNoGm());
		List<FindUrgentMbrPageReturn> returnList = null;
		int count = 0;
		try {
			returnList = personMemberDao.findUrgentMbrPage(findUrgentMbrPage);
			count = personMemberDao.findUrgentMbrPageCount(findUrgentMbrPage);
		} catch (Exception e) {
			logger.error("客户管理首页分页查询错误!", e);
			throw new TsfaServiceException(ErrorCode.FIND_PMTYPE_INDEX_PAGE_ERROR, "客户管理首页分页查询错误!", e);
		}
		Page<FindUrgentMbrPageReturn> returnPage = new Page<FindUrgentMbrPageReturn>(returnList, count, findUrgentMbrPage);

		logger.debug("findUrgentMbrPage(FindUrgentMbrPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;
	}

	public boolean isToShop(String shopLongitude, String shopLatitude, String pmLongitude, String pmLatitude, String distance) {
		boolean toShopFlag = false;
		if (!StringUtils.isEmpty(shopLongitude) && !StringUtils.isEmpty(shopLatitude) && !StringUtils.isEmpty(pmLongitude) && !StringUtils.isEmpty(pmLatitude) && !StringUtils.isEmpty(distance)) {
			double dis = DistanceUtil.getDistance(Double.valueOf(shopLongitude), Double.valueOf(shopLatitude), Double.valueOf(pmLongitude), Double.valueOf(pmLatitude));
			if (dis <= Double.valueOf(distance)) {
				toShopFlag = true;
			}

			logger.info("&&&&&&&&&&&&&&&&&&&&&:dis=" + dis + ",toShopFlag=" + toShopFlag);
		}
		return toShopFlag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#addPersonMemberFromHook
	 * (java.lang.String)
	 */
	@Override
	public void addPersonMemberFromHook(final String infos) throws TsfaServiceException {
		logger.debug("addPersonMemberFromHook(String infos={}) - start", infos); //$NON-NLS-1$
		
//		taskExecutor.execute(new Runnable() {
//			@Override
//			public void run() {
				try {
					// 先插入客户基础表
					JSONObject jsonObject = JSONObject.fromObject(infos);
					String noWxGM = jsonObject.getString("noWxGM");
					logger.debug("addPersonMemberFromHook(String noWxGM={})", noWxGM);
					JSONArray ja = jsonObject.getJSONArray("data");
					
					// 根据导购微信查询导购和门店信息
					GuidMember gm = new GuidMember();
					gm.setNoWx(noWxGM);
					GuidMember guidMember = iguidMemberDao.selectByParams(gm);

					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					PersonMemberBase personMemberBase = null;
					
					// 我的客户
					FindPmType findPmType = new FindPmType();
					findPmType.setMerchantNo(guidMember.getMerchantNo());
					findPmType.setPmTypeType(PmTypeType.MY.toString());
					FindPmTypeReturn ptp = pmTypeService.findPmTypeByMP(findPmType);

					// 获取店铺
					FindShop findShop = new FindShop();
					findShop.setShopNo(guidMember.getShopNo());
					FindShopReturn findShopReturn = shopService.findShopByShopNo(findShop);
					
					Date now = new Date();
					for (int i = 0; i < ja.size(); i++) {
						
						FindPersonMemberBase fmb = new FindPersonMemberBase();
						PersonMember addPersonMember = new PersonMember();

						JSONObject jObj = ja.getJSONObject(i);
						
						String noWx = jObj.containsKey("noWx") ? jObj.getString("noWx") : "";
						logger.debug("addPersonMemberFromHook(String noWx={})", noWx);
						String nickNameWx = jObj.containsKey("nickNameWx") ? jObj.getString("nickNameWx") : "";


						/* 扩展表参数 */
						String nickNameRemarkWx = jObj.containsKey("nickNameRemarkWx") ? jObj.getString("nickNameRemarkWx") : "";
						String longitude = jObj.containsKey("longitude") ? jObj.getString("longitude") : "";
						String latitude = jObj.containsKey("latitude") ? jObj.getString("latitude") : "";
						String scanAddress = jObj.containsKey("scanAddress") ? jObj.getString("scanAddress") : "";
						addPersonMember.setNickNameRemarkWx(nickNameRemarkWx);
						addPersonMember.setLatitude(latitude);
						addPersonMember.setLongitude(longitude);
						addPersonMember.setScanAddress(scanAddress);
						/* 扩展表参数 */

						fmb.setNoWx(noWx);
						personMemberBase = personMemberBaseDao.selectByParams(fmb);

						/* 客户基础数据存在 */
						if (personMemberBase != null) {
							logger.debug("基础数据存在");

							/* 修改客户微信昵称 */
							logger.debug("修改客户微信昵称--code={}--nickNameWx={}--start", personMemberBase.getCode(), nickNameWx);
							UpdatePersonMemberBase updatePersonMemberBase = new UpdatePersonMemberBase();
							updatePersonMemberBase.setCode(personMemberBase.getCode());
							updatePersonMemberBase.setNickNameWx(nickNameWx);
							personMemberBaseService.updatePersonMemberBase(updatePersonMemberBase);
							/* 修改客户微信昵称 */

							// 客户扩展表数据是否存在
							PersonMember personMember = new PersonMember();
							personMember.setMemberNo(personMemberBase.getMemberNo());
							personMember.setMemberNoGm(guidMember.getMemberNo());
							PersonMember personMemberTemp = personMemberDao.selectByParamKey(personMember);
							// update by 杨杰 2017-09-05 begin
							String nickNameRemarkLocal = "";
							if (StringUtils.isNotEmpty(personMemberBase.getMemberName())) {
								nickNameRemarkLocal += personMemberBase.getMemberName();
							}
							if (StringUtils.isNotEmpty(personMemberBase.getMobile())) {
								nickNameRemarkLocal += ("-" + personMemberBase.getMobile());
							}
							// update by 杨杰 2017-09-05 end
							if (personMemberTemp != null) {// 数据已存在
								logger.debug("客户扩展表数据已存在");

								logger.debug("修改客户微信昵称备注--code={}--nickNameRemarkWx={}--start", personMemberTemp.getCode(), nickNameRemarkWx);
								UpdatePersonMember updatePersonMember = new UpdatePersonMember();
								updatePersonMember.setCode(personMemberTemp.getCode());
								updatePersonMember.setNickNameRemarkWx(nickNameRemarkWx);
								// update by 杨杰 2017-09-05 begin
								if (StringUtils.isNotEmpty(personMemberTemp.getBomName())) {
									nickNameRemarkLocal += ("-" + personMemberTemp.getBomName());
								}
								updatePersonMember.setNickNameRemarkLocal(nickNameRemarkLocal);
								// update by 杨杰 2017-09-05 end
								personMemberService.updatePersonMember(updatePersonMember);
								continue;
							} else {
								logger.debug("插入客户扩展表数据");
								insertPm(guidMember, personMemberBase, addPersonMember);

								// 插入客户分类关联表 我的客户
								AddPmTypePmDto addPmTypePmDto = new AddPmTypePmDto();
								addPmTypePmDto.setCodePm(addPersonMember.getCode());
								addPmTypePmDto.setPmTypeCode(ptp.getCode());
								logger.debug("插入客户分类关联表！");
								pmTypeService.addPmTypePm(addPmTypePmDto);
							}
						} else {
							logger.debug("基础数据不存在");
							personMemberBase = new PersonMemberBase();
							personMemberBase.setCode(GUID.generateCode());
							personMemberBase.setMemberNo(GUID.generateByUUID());
							
							String mn = "";
							if(!StringUtils.isEmpty(nickNameRemarkWx)){
								mn = nickNameRemarkWx;
							}else if(!StringUtils.isEmpty(nickNameWx)){
								mn = nickNameWx;
							}
							personMemberBase.setMemberName(mn);
							
							personMemberBase.setSex(jObj.containsKey("sex") ? jObj.getString("sex") : "");
							personMemberBase.setCityWx(jObj.containsKey("cityWx") ? jObj.getString("cityWx") : "");
							personMemberBase.setCountryWx(jObj.containsKey("countryWx") ? jObj.getString("countryWx") : "");
							personMemberBase.setHeadAddress(jObj.getString("headAddress"));
							personMemberBase.setNickNameWx(nickNameWx);

							personMemberBase.setMemberSrc(MemerSourceType.NO_SHOP_SACN.toString());
							personMemberBase.setNoWx(jObj.getString("noWx"));
							try {
								personMemberBase.setSubsribeTime(df.parse(jObj.getString("subsribeTime")));
							} catch (ParseException e) {
								logger.error("addPersonMemberFromHook(String)", e); //$NON-NLS-1$
								throw new TsfaServiceException(ErrorCode.DATA_TRANS_ERROR, "时间转换错误!", e);
							}

							personMemberBase.setCreateDate(now);
							personMemberBase.setCreateId(guidMember.getMemberNo());
							personMemberBase.setUpdateDate(now);
							personMemberBase.setUpdateId(guidMember.getMemberNo());
							personMemberBase.setNameAuthFlag(NameAuthFlag.N.toString());
							personMemberBase.setStatus(MemberStatus.NORMAL.toString());
							personMemberBase.setRatioClientInfo(MemberUtils.completeRate(personMemberBase));

							personMemberBase.setAreaCode(findShopReturn.getAreaCode());
							personMemberBase.setAreaName(findShopReturn.getAreaName());
							personMemberBase.setProvinceCode(findShopReturn.getProvinceCode());
							personMemberBase.setCityCode(findShopReturn.getCityCode());
							personMemberBase.setCityAreaCode(findShopReturn.getCityAreaCode());
							personMemberBaseDao.insertSelective(personMemberBase);

							logger.debug("插入客户扩展表数据");
							insertPm(guidMember, personMemberBase, addPersonMember);
							
							// 插入客户分类关联表 我的客户
							AddPmTypePmDto addPmTypePmDto = new AddPmTypePmDto();
							addPmTypePmDto.setCodePm(addPersonMember.getCode());
							addPmTypePmDto.setPmTypeCode(ptp.getCode());
							logger.debug("插入客户分类关联表！");
							pmTypeService.addPmTypePm(addPmTypePmDto);

							// 添加客户动态
							AddBehaviorPm addBehaviorPm = new AddBehaviorPm();
							addBehaviorPm.setMemberNo(personMemberBase.getMemberNo());
							addBehaviorPm.setMemberName(personMemberBase.getMemberName());
							addBehaviorPm.setBehaviorDesc("");
							addBehaviorPm.setBehaviorDate(now);
							behaviorPmService.addBehaviorPm(addBehaviorPm);
						}

						// 修改资料完成度
						FindPersonMemberBase findNowx = new FindPersonMemberBase();
						findNowx.setNoWx(personMemberBase.getNoWx());
						FindPersonMemberBaseReturn findPersonMemberBaseReturn = personMemberBaseService.findPersonMemberBase(findNowx);

						FindPersonMember findPm = new FindPersonMember();
						findPm.setMemberNo(personMemberBase.getMemberNo());
						findPm.setMemberNoGm(guidMember.getMemberNo());
						FindPersonMemberReturn findPmReturn = findPersonMemberByMGM(findPm);

						computeRate(findPersonMemberBaseReturn, findPmReturn);
					}
					logger.debug("addPersonMemberFromHook(String) - end"); //$NON-NLS-1$
				} catch (Exception e) {
					logger.error("同步客户信息出错！", e);
					throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "同步客户信息出错！", e);
				}
//			}
//		});

	}

	public void innerProcess(boolean toShopFlag, GuidMember guidMember, PersonMemberBase personMemberBase, PersonMember addPersonMember, FindPmTypeReturn ptp, FindPmTypeReturn ptp2) {
		// 产生跟进总表和第一条跟进明细记录
		AddPmClientFollowFirstDto addPmClientFollowFirstDto = new AddPmClientFollowFirstDto();
		addPmClientFollowFirstDto.setMerchantNo(guidMember.getMerchantNo());
		addPmClientFollowFirstDto.setMemberNo(personMemberBase.getMemberNo());
		addPmClientFollowFirstDto.setMemberName(personMemberBase.getMemberName());
		addPmClientFollowFirstDto.setMemberNoGm(addPersonMember.getMemberNoGm());
		addPmClientFollowFirstDto.setMemberNameGm(addPersonMember.getMemberNameGm());
		addPmClientFollowFirstDto.setPmTypeCode(ptp.getCode());
		String cfNo = clientFollowSummaryService.addSummaryWithClientFollow(addPmClientFollowFirstDto);

		// 到店则添加意向(到店)
		if (toShopFlag) {
			// 插入客户分类关联表 意向(到店)
			AddPmTypePmDto addPmTypePmDto = new AddPmTypePmDto();
			addPmTypePmDto.setCodePm(addPersonMember.getCode());
			addPmTypePmDto.setPmTypeCode(ptp2.getCode());
			pmTypeService.addPmTypePm(addPmTypePmDto);

			// 添加跟进记录
			AddClientFollow addClientFollow = new AddClientFollow();
			addClientFollow.setCfNo(cfNo);
			addClientFollow.setMerchantNo(addPmClientFollowFirstDto.getMerchantNo());
			addClientFollow.setMemberNo(addPmClientFollowFirstDto.getMemberNo());
			addClientFollow.setMemberName(personMemberBase.getMemberName());
			addClientFollow.setMemberNoGm(addPmClientFollowFirstDto.getMemberNoGm());
			addClientFollow.setMemberNameGm(addPersonMember.getMemberNameGm());
			addClientFollow.setFollowNum(2);
			addClientFollow.setFollowTime(new Date());
			addClientFollow.setFollowInfo("客户分组到意向(到店)");
			addClientFollow.setDeal(DealType.N.toString());
			addClientFollow.setStatus(Status.NORMAL);
			addClientFollow.setComTaskType("SYSTEM");
			addClientFollow.setCreateId(addPmClientFollowFirstDto.getMemberNoGm());
			clientFollowService.addClientFollow(addClientFollow);

			// 更新跟踪总表数量
			UpdateClientFollowSummary updateClientFollowSummary = new UpdateClientFollowSummary();
			updateClientFollowSummary.setCfNo(cfNo);
			updateClientFollowSummary.setFollowNum(2);
			clientFollowSummaryService.updateClientFollowSummaryByCfNo(updateClientFollowSummary);

			// 产生初次介绍任务
			// 查询客户分类频率
			int hour = 0;
			if (ptp == null || StringUtils.isEmpty(ptp.getFreValue())) {
				hour = 0;
			} else {
				hour = Integer.valueOf(ptp.getFreValue());
			}
			AddComTask addComTask = new AddComTask();
			addComTask.setMerchantNo(addPmClientFollowFirstDto.getMerchantNo());
			addComTask.setMemberNoGm(addPmClientFollowFirstDto.getMemberNoGm());
			addComTask.setMemberNo(addPmClientFollowFirstDto.getMemberNo());
			addComTask.setMemberName(addPmClientFollowFirstDto.getMemberName());
			addComTask.setCfNo(cfNo);
			addComTask.setNoType(FollowNoType.FOLLOW.toString());
			addComTask.setWorkDate(DateUtils.addHours(new Date(), hour));
			addComTask.setComTaskType(ComTaskType.FIRST_INTR);
			addComTask.setRemarkCom(CommonConstant.REPLACE_REMARK_COM + "扫码新增意向到店客户");
			addComTask.setLastResultDate(new Date());

			FindComTaskList findComTaskList = new FindComTaskList();
			findComTaskList.setMerchantNo(addPmClientFollowFirstDto.getMerchantNo());
			findComTaskList.setComTaskType(ComTaskType.FIRST_INTR);
			FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
			if (findComTaskListReturn != null) {
				addComTask.setCodeList(findComTaskListReturn.getCode());
				addComTask.setFinishOrgComTask(false);
				comTaskService.addComTask(addComTask);
			}

		} else {
			// 插入客户分类关联表 未分组
			AddPmTypePmDto addPmTypePmDto = new AddPmTypePmDto();
			addPmTypePmDto.setCodePm(addPersonMember.getCode());
			addPmTypePmDto.setPmTypeCode(ptp.getCode());
			pmTypeService.addPmTypePm(addPmTypePmDto);

			// 未分组则产生分组任务
			// 查询客户分类频率
			int hour = 0;
			if (ptp == null || StringUtils.isEmpty(ptp.getFreValue())) {
				hour = 0;
			} else {
				hour = Integer.valueOf(ptp.getFreValue());
			}
			AddComTask addComTask = new AddComTask();
			addComTask.setMerchantNo(addPmClientFollowFirstDto.getMerchantNo());
			addComTask.setMemberNoGm(addPmClientFollowFirstDto.getMemberNoGm());
			addComTask.setMemberNo(addPmClientFollowFirstDto.getMemberNo());
			addComTask.setMemberName(addPmClientFollowFirstDto.getMemberName());
			addComTask.setCfNo(cfNo);
			addComTask.setNoType(FollowNoType.FOLLOW.toString());
			addComTask.setWorkDate(DateUtils.addHours(new Date(), hour));
			addComTask.setComTaskType(ComTaskType.GROUP);
			addComTask.setRemarkCom(CommonConstant.REPLACE_REMARK_COM + "扫码新增客户");
			addComTask.setLastResultDate(new Date());

			FindComTaskList findComTaskList = new FindComTaskList();
			findComTaskList.setMerchantNo(addPmClientFollowFirstDto.getMerchantNo());
			findComTaskList.setComTaskType(ComTaskType.GROUP);
			FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
			if (findComTaskListReturn != null) {
				addComTask.setCodeList(findComTaskListReturn.getCode());
				addComTask.setFinishOrgComTask(false);
				comTaskService.addComTask(addComTask);
			}
		}

		// 增加客户新增的数量
		UpdateWorkTaskFinishNum updateWorkTaskFinishNum = new UpdateWorkTaskFinishNum();
		updateWorkTaskFinishNum.setMemberNoGm(addPersonMember.getMemberNoGm());
		updateWorkTaskFinishNum.setMerchantNo(guidMember.getMerchantNo());
		updateWorkTaskFinishNum.setTaskType(TaskType.XIN_ZENG);
		updateWorkTaskFinishNum.setFinishNum(1L);
		workTaskService.updateFinishNum(updateWorkTaskFinishNum);

		// 添加积分
		GuidMemberIntegralDto guidMemberIntegralDto = new GuidMemberIntegralDto();
		guidMemberIntegralDto.setMerchantNo(guidMember.getMerchantNo());
		guidMemberIntegralDto.setShopNo(guidMember.getShopNo());
		guidMemberIntegralDto.setMemberNo(addPersonMember.getMemberNoGm());
		guidMemberIntegralDto.setAreaCode(guidMember.getAreaCode());
		guidMemberIntegralDto.setIntegralType(IntegralType.NEW.toString());
		guidMemberIntegralDto.setAmount(1d);
		guidMemberIntegralService.doIntegral(guidMemberIntegralDto);

		// 添加到导购行为统计表
		AddGuidmemberActionInfo addGuidmemberActionInfo = new AddGuidmemberActionInfo();
		addGuidmemberActionInfo.setCode(GUID.generateCode());
		addGuidmemberActionInfo.setActionType(GuidmemberActionType.NEW.toString());
		addGuidmemberActionInfo.setActionTime(new Date());
		addGuidmemberActionInfo.setCreateDate(new Date());
		addGuidmemberActionInfo.setMerchantNo(guidMember.getMerchantNo());
		addGuidmemberActionInfo.setMemberNoGm(guidMember.getMemberNo());
		addGuidmemberActionInfo.setMemberNameGm(guidMember.getMemberName());
		addGuidmemberActionInfo.setShopNo(guidMember.getShopNo());
		addGuidmemberActionInfo.setShopName(guidMember.getShopName());
		addGuidmemberActionInfo.setActionDetail(guidMember.getMemberName() + "新增了一个用户");
		guidmemberActionInfoService.addGuidmemberActionInfo(addGuidmemberActionInfo);
	}

	/**
	 * Insert pm.
	 *
	 * @param guidMember
	 *            the guid member
	 * @param personMemberBase
	 *            the person member base
	 * @param addPersonMember
	 *            the add person member
	 */
	private void insertPm(GuidMember guidMember, PersonMemberBase personMemberBase, PersonMember addPersonMember) {
		addPersonMember.setCode(GUID.generateCode());
		addPersonMember.setMemberNo(personMemberBase.getMemberNo());
		addPersonMember.setCreateId(guidMember.getMemberNo());
		addPersonMember.setKeepEye("Y");
		addPersonMember.setMemberName(personMemberBase.getMemberName());
		addPersonMember.setMemberNameGm(guidMember.getMemberName());
		addPersonMember.setMemberNoGm(guidMember.getMemberNo());
		addPersonMember.setMerchantName(guidMember.getMerchantName());
		addPersonMember.setMerchantNo(guidMember.getMerchantNo());
		addPersonMember.setShopName(guidMember.getShopName());
		addPersonMember.setShopNo(guidMember.getShopNo());
		addPersonMember.setUrgencyPm(UrgentFlagType.N.toString());
		addPersonMember.setFirstIntroduce(FirstIntroduce.Y.toString());
		// update by 杨杰 2017-09-05 begin
		String nickNameRemarkLocal = "";
		if (StringUtils.isNotEmpty(personMemberBase.getMemberName())) {
			nickNameRemarkLocal += personMemberBase.getMemberName();
		}
		if (StringUtils.isNotEmpty(personMemberBase.getMobile())) {
			nickNameRemarkLocal += ("-" + personMemberBase.getMobile());
		}
		if (StringUtils.isNotEmpty(addPersonMember.getBomName())) {
			nickNameRemarkLocal += ("-" + addPersonMember.getBomName());
		}
		addPersonMember.setNickNameRemarkLocal(nickNameRemarkLocal);
		// update by 杨杰 2017-09-05 end
		personMemberDao.insertSelective(addPersonMember);

		// 添加交叉客户
		DoRepeatMemberDto doRepeatMemberDto = new DoRepeatMemberDto();
		doRepeatMemberDto.setMerchantNo(guidMember.getMerchantNo());
		doRepeatMemberDto.setMemberNo(personMemberBase.getMemberNo());
		doRepeatMemberDto.setMemberNoGm(guidMember.getMemberNo());
		doRepeatMember(doRepeatMemberDto);
	}

	/**
	 * 查找该客户是和导购关联过.
	 *
	 * @param findPersonMember
	 *            the find person member
	 * @return the int
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 */
	@Override
	public int findCountByMemberNo(FindPersonMember findPersonMember) throws TsfaServiceException {
		logger.debug("findCountByMemberNo(FindPersonMember findPersonMember={}) - start", findPersonMember); //$NON-NLS-1$

		AssertUtils.notNull(findPersonMember);
		AssertUtils.notNullAndEmpty(findPersonMember.getMemberNo(), "客户号不能为空");
		int count = 0;
		try {
			count = personMemberDao.findCountByMemberNo(findPersonMember);
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找该客户是和导购关联过错误！", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找该客户是和导购关联过错误！", e);
		}

		logger.debug("findCountByMemberNo(FindPersonMember findPersonMember={}) - end", findPersonMember); //$NON-NLS-1$
		return count;
	}

	@Override
	public Page<FindUnContactMemberReturn> findUnContactMemberPage(FindUnContactMember findUnContactMember) throws TsfaServiceException {
		logger.debug("findUnContactMemberPage(findUnContactMemberPage={}) - start", findUnContactMember);
		AssertUtils.notNull(findUnContactMember);

		List<FindUnContactMemberReturn> returnList;
		int count = 0;
		try {
			// 计算开始日期和结束日期
			UnContactCodeEnum unContactCodeEnum = UnContactCodeEnum.getUnContactCodeEnum(findUnContactMember.getCodeUnContact());
			findUnContactMember.setStartDate(unContactCodeEnum.getStartDate());
			findUnContactMember.setEndDate(unContactCodeEnum.getEndDate());

			// 查询列表
			returnList = personMemberDao.findUnContactMember(findUnContactMember);
			if (!CollectionUtils.isEmpty(returnList)) {
				for (FindUnContactMemberReturn each : returnList) {
					// 客户姓名的顺序：微信备注 -> 微信昵称 -> 客户名称
					String memberName = StringUtils.isEmpty(each.getNickNameRemarkWx()) ? (StringUtils.isEmpty(each.getNickNameWx()) ? each.getMemberName() : each.getNickNameWx()) : each
							.getNickNameRemarkWx();
					each.setMemberName(memberName);
				}
			}
			count = personMemberDao.findUnContactMemberCount(findUnContactMember);
		} catch (Exception e) {
			logger.error("查询未联系客户分页时错误", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_BASE_FIND_ERROR, "查询未联系客户时错误.！", e);
		}
		Page<FindUnContactMemberReturn> returnPage = new Page<>(returnList, count, findUnContactMember);
		logger.debug("findUnContactMemberPage(findUnContactMemberPage) - end - return value={}", returnPage);
		return returnPage;
	}

	@Override
	public int findCountByMemberNoGm(String merchantNo, String memberNoGm) {
		logger.debug("findCountByMemberNoGm(merchantNo={} memberNoGm={}) - start", merchantNo, memberNoGm);
		return personMemberDao.findCountByMemberNoGm(merchantNo, memberNoGm);
	}

	@Override
	public int findUnContactMemberCount(FindUnContactMember findUnContactMember) {
		AssertUtils.notNull(findUnContactMember);

		// 计算开始日期和结束日期
		UnContactCodeEnum unContactCodeEnum = UnContactCodeEnum.getUnContactCodeEnum(findUnContactMember.getCodeUnContact());
		findUnContactMember.setStartDate(unContactCodeEnum.getStartDate());
		findUnContactMember.setEndDate(unContactCodeEnum.getEndDate());

		return personMemberDao.findUnContactMemberCount(findUnContactMember);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#findNewPmPage(com
	 * .lj.business.member.dto.FindNewPmPage)
	 */
	@Override
	public Page<FindNewPmPageReturn> findNewPmPage(FindNewPmPage findNewPmPage) throws TsfaServiceException {

		logger.debug("findNewPmPage(FindNewPmPage findNewPmPage={}) - start", findNewPmPage); //$NON-NLS-1$

		AssertUtils.notNull(findNewPmPage);
		AssertUtils.notNullAndEmpty(findNewPmPage.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notNullAndEmpty(findNewPmPage.getMemberNoGm(), "导购编号不能为空");
		List<FindNewPmPageReturn> returnList = null;
		int count = 0;
		try {
			returnList = personMemberDao.findNewPmPage(findNewPmPage);
			count = personMemberDao.findNewPmPageCount(findNewPmPage);
		} catch (Exception e) {
			logger.error("客户管理首页分页查询错误!", e);
			throw new TsfaServiceException(ErrorCode.FIND_PMTYPE_INDEX_PAGE_ERROR, "客户管理首页分页查询错误!", e);
		}
		Page<FindNewPmPageReturn> returnPage = new Page<FindNewPmPageReturn>(returnList, count, findNewPmPage);

		logger.debug("findNewPmPage(FindNewPmPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#findPmWxBpInfo(com
	 * .lj.business.member.dto.FindPmWxBpInfo)
	 */
	@Override
	public List<FindPmWxBpInfoReturn> findPmWxBpInfo(FindPmWxBpInfo findPmWxBpInfo) throws TsfaServiceException {
		logger.debug("findPmWxBpInfo(FindPmWxBpInfo findPmWxBpInfo={}) - start", findPmWxBpInfo); //$NON-NLS-1$
		AssertUtils.notNull(findPmWxBpInfo);
		AssertUtils.notNullAndEmpty(findPmWxBpInfo.getMemberNoGm(), "导购编号不能为空");
		AssertUtils.notNullAndEmpty(findPmWxBpInfo.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notNullAndEmpty(findPmWxBpInfo.getMemberNoAr(), "客户编号不能为空");
		try {
			List<FindPmWxBpInfoReturn> returnList = personMemberDao.findPmWxBpInfo(findPmWxBpInfo);
			logger.debug("findPmWxBpInfo(FindPmWxBpInfo) - end - return value={}", returnList); //$NON-NLS-1$
			return returnList;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户微信会员信息错误", e);
			throw new TsfaServiceException(ErrorCode.FIND_PMWXBP_INFO, "查找客户微信会员信息错误", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#findPmWxInfo(com.
	 * lj.business.member.dto.FindPmWxInfo)
	 */
	@Override
	public List<FindPmWxInfoReturn> findPmWxInfo(FindPmWxInfo findPmWxInfo) throws TsfaServiceException {
		logger.debug("findPmWxInfo(FindPmWxInfo findPmWxInfo={}) - start", findPmWxInfo); //$NON-NLS-1$
		AssertUtils.notNull(findPmWxInfo);
		AssertUtils.notNullAndEmpty(findPmWxInfo.getMemberNoGm(), "导购编号不能为空");
		AssertUtils.notNullAndEmpty(findPmWxInfo.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notNullAndEmpty(findPmWxInfo.getMemberNoAr(), "客户编号不能为空");
		try {
			List<FindPmWxInfoReturn> returnList = personMemberDao.findPmWxInfo(findPmWxInfo);
			logger.debug("findPmWxInfo(FindPmWxInfo) - end - return value={}", returnList); //$NON-NLS-1$
			return returnList;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户微信会员信息错误", e);
			throw new TsfaServiceException(ErrorCode.FIND_PMWXBP_INFO, "查找客户微信会员信息错误", e);
		}
	}

	@Override
	public int findPersonMemberSums(FindUrgentMbrPage findUrgentMbrPage) {
		AssertUtils.notNull(findUrgentMbrPage);
		AssertUtils.notNullAndEmpty(findUrgentMbrPage.getMerchantNo(), "商户编号不能为空");
		int count = 0;
		try {
			count = personMemberDao.findPersonMemberSums(findUrgentMbrPage);
		} catch (Exception e) {
			logger.error("统计客户数量信息错误", e);
			throw new TsfaServiceException(ErrorCode.FIND_PMWXBP_INFO, "统计客户数量信息错误", e);
		}
		return count;
	}

	@Override
	public List<FindPersonMemberSexStatisticsReturn> selectSexStatisticsByShopNo() {
		logger.debug("selectSexStatisticsByShopNo() - start"); //$NON-NLS-1$

		try {
			List<FindPersonMemberSexStatisticsReturn> result = new ArrayList<>();
			List<Map<String, Object>> sexStatisticsList = personMemberDao.selectSexStatisticsByShopNo();
			if (!CollectionUtils.isEmpty(sexStatisticsList)) {
				for (Map<String, Object> each : sexStatisticsList) {
					FindPersonMemberSexStatisticsReturn item = new FindPersonMemberSexStatisticsReturn();
					item.setAreaCode((String) each.get("areaCode"));
					item.setAreaName((String) each.get("areaName"));
					item.setMerchantNo((String) each.get("merchantNo"));
					item.setSex((String) each.get("sex"));
					Long sexCount = (Long) each.get("sexCount");
					item.setSexCount(sexCount == null ? 0 : sexCount.intValue());
					item.setShopName((String) each.get("shopName"));
					item.setShopNo((String) each.get("shopNo"));
					result.add(item);
				}
			}

			logger.debug("selectSexStatisticsByShopNo() - end - return value={}", result); //$NON-NLS-1$
			return result;
		} catch (Exception e) {
			logger.error("统计客户性别时错误", e);
			throw new TsfaServiceException(ErrorCode.FIND_PMWXBP_INFO, "统计客户性别时错误", e);
		}
	}

	@Override
	public List<FindPersonMemberAgeStatisticsReturn> selectAgeStatisticsByShopNo(String beginDate, String endDate) {
		try {
			List<FindPersonMemberAgeStatisticsReturn> result = new ArrayList<>();
			List<Map<String, Object>> ageStatisticsList = personMemberDao.selectAgeStatisticsByShopNo(beginDate, endDate);
			if (!CollectionUtils.isEmpty(ageStatisticsList)) {
				for (Map<String, Object> each : ageStatisticsList) {
					FindPersonMemberAgeStatisticsReturn item = new FindPersonMemberAgeStatisticsReturn();
					Long ageCount = (Long) each.get("ageCount");
					item.setAgeCount(ageCount == null ? 0 : ageCount.intValue());
					item.setShopNo((String) each.get("shopNo"));
					result.add(item);
				}
			}
			return result;
		} catch (Exception e) {
			logger.error("统计客户年龄时错误", e);
			throw new TsfaServiceException(ErrorCode.FIND_PMWXBP_INFO, "统计客户年龄时错误", e);
		}
	}

	@Override
	public List<FindPersonMemberLineStatisticsReturn> selectLineStatisticsByShopNo() {
		try {
			List<FindPersonMemberLineStatisticsReturn> result = new ArrayList<>();
			List<Map<String, Object>> lineStatisticsList = personMemberDao.selectLineStatisticsByShopNo();
			if (!CollectionUtils.isEmpty(lineStatisticsList)) {
				for (Map<String, Object> each : lineStatisticsList) {
					FindPersonMemberLineStatisticsReturn item = new FindPersonMemberLineStatisticsReturn();
					item.setAreaCode((String) each.get("areaCode"));
					item.setMerchantNo((String) each.get("merchantNo"));
					item.setShopName((String) each.get("shopName"));
					item.setShopNo((String) each.get("shopNo"));

					Long numLine = (Long) each.get("numLine");
					item.setNumLine(numLine == null ? 0 : numLine.intValue());
					item.setCodeLine((String) each.get("codeLine"));
					item.setLineName((String) each.get("lineName"));
					result.add(item);
				}
			}
			return result;
		} catch (Exception e) {
			logger.error("统计客户职业时错误", e);
			throw new TsfaServiceException(ErrorCode.FIND_PMWXBP_INFO, "统计客户职业时错误", e);
		}
	}

	@Override
	public List<FindPersonMemberInterestStatisticsReturn> selectInterestStatisticsByShopNo() {
		try {
			List<FindPersonMemberInterestStatisticsReturn> result = new ArrayList<>();
			List<Map<String, Object>> lineStatisticsList = personMemberDao.selectInterestStatisticsByShopNo();
			if (!CollectionUtils.isEmpty(lineStatisticsList)) {
				for (Map<String, Object> each : lineStatisticsList) {
					FindPersonMemberInterestStatisticsReturn item = new FindPersonMemberInterestStatisticsReturn();
					item.setAreaCode((String) each.get("areaCode"));
					item.setMerchantNo((String) each.get("merchantNo"));
					item.setShopName((String) each.get("shopName"));
					item.setShopNo((String) each.get("shopNo"));

					Long numInterest = (Long) each.get("numInterest");
					item.setNumInterest(numInterest == null ? 0 : numInterest.intValue());
					item.setCodeInterest((String) each.get("codeInterest"));
					item.setInterestName((String) each.get("interestName"));
					result.add(item);
				}
			}
			return result;
		} catch (Exception e) {
			logger.error("统计客户兴趣时错误", e);
			throw new TsfaServiceException(ErrorCode.FIND_PMWXBP_INFO, "统计客户兴趣时错误", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#doRepeatMember(com
	 * .lj.business.member.dto.DoRepeatMemberDto)
	 */
	@Override
	public void doRepeatMember(DoRepeatMemberDto doRepeatMemberDto) throws TsfaServiceException {
		FindPersonMember fp = new FindPersonMember();
		fp.setMemberNo(doRepeatMemberDto.getMemberNo());
		fp.setMerchantNo(doRepeatMemberDto.getMerchantNo());
		int count = findCountByMemberNo(fp);

//		if (count > 1) {
//			logger.debug("如果是交叉用户则插入客户分类");
//			FindPmType fpt = new FindPmType();
//			fpt.setPmTypeType(PmTypeType.REPEAT.toString());
//			fpt.setMerchantNo(doRepeatMemberDto.getMerchantNo());
//			FindPmTypeReturn fptr = pmTypeService.findPmTypeByMP(fpt);

//			List<FindPersonMemberReturn> list = findList(doRepeatMemberDto);
//			if (list != null && list.size() > 0) {
//				for (FindPersonMemberReturn pm : list) {
//					if (fptr != null) {
//						AddPmTypePmDto addPmTypePmDto = new AddPmTypePmDto();
//						addPmTypePmDto.setCodePm(pm.getCode());
//						addPmTypePmDto.setPmTypeCode(fptr.getCode());
//						pmTypeService.addPmTypePmRepeat(addPmTypePmDto);
//					}
//				}
//			}
//		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IPersonMemberService#findList(com.lj.business
	 * .member.dto.DoRepeatMemberDto)
	 */
	@Override
	public List<FindPersonMemberReturn> findList(DoRepeatMemberDto doRepeatMemberDto) throws TsfaServiceException {
		AssertUtils.notNull(doRepeatMemberDto);
		AssertUtils.notNullAndEmpty(doRepeatMemberDto.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notNullAndEmpty(doRepeatMemberDto.getMemberNo(), "客户编号不能为空");
		AssertUtils.notNullAndEmpty(doRepeatMemberDto.getMemberNoGm(), "导购编号不能为空");
		try {
			List<FindPersonMemberReturn> list = personMemberDao.findList(doRepeatMemberDto);
			return list;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户会员信息错误", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找客户会员信息错误", e);
		}
	}

	@Override
	public List<FindPersonMemberPageReturn> findPersonMemberList(FindPersonMemberPage findPersonMemberPage) throws TsfaServiceException {
		logger.debug("findPersonMemberPage(FindPersonMemberPage findPersonMemberPage={}) - start", findPersonMemberPage); //$NON-NLS-1$
		AssertUtils.notNull(findPersonMemberPage);
		List<FindPersonMemberPageReturn> returnList = null;
		try {
			returnList = personMemberDao.findPersonMemberPage(findPersonMemberPage);
		} catch (Exception e) {
			logger.error("客户会员信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_PAGE_ERROR, "客户会员信息不存在错误.！", e);
		}
		logger.debug("findPersonMemberPage(FindPersonMemberPage) - end - return value={}", returnList); //$NON-NLS-1$
		return returnList;
	}

	@Override
	public List<FindTodayManageShopReturn> todayManageShopNew(FindTodayManageShop findTodayManageShop) throws TsfaServiceException {
		AssertUtils.notNull(findTodayManageShop);
		AssertUtils.notNullAndEmpty(findTodayManageShop.getShopNo(), "分店编号不能为空");
		AssertUtils.notNullAndEmpty(findTodayManageShop.getMerchantNo(), "商户编号不能为空");
		try {
			List<FindTodayManageShopReturn> list = new ArrayList<FindTodayManageShopReturn>();
			list = personMemberDao.todayManageShopNew(findTodayManageShop);
			for (FindTodayManageShopReturn findTodayManageShopReturn : list) {
				BigDecimal big = new BigDecimal(findTodayManageShopReturn.getRatioWork());
				findTodayManageShopReturn.setRatioWork(big.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
			}
			return list;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找 导购信息错误", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_FIND_ERROR, "查找导购信息错误", e);
		}
	}

	@Override
	public long findCountPmAddByGmDay(String memberNo, Date date) {
		AssertUtils.notNullAndEmpty(memberNo, "导购号不能为空");
		AssertUtils.notNullAndEmpty(date, "查询时间不能为空");
		try {
			return personMemberDao.findCountPmAddByGmDay(memberNo, date);
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找 导购信息错误", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_ERROR, "查找客户会员信息错误", e);
		}
	}

	@Override
	public FindPersonMemberReturnList findPersonMemberTypeNum(FindPersonMember findPersonMember) throws TsfaServiceException {
		AssertUtils.notNullAndEmpty(findPersonMember.getMerchantNo(), "商户编号编号不能为空");
		AssertUtils.notNullAndEmpty(findPersonMember.getAreaCode(), "区域编号不能为空");
		FindPersonMemberReturnList memberReturnList = null;
		try {
			memberReturnList = personMemberDao.findPersonMemberTypeNum(findPersonMember);
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找 导购信息错误", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_FIND_ERROR, "查找导购信息错误", e);
		}
		return memberReturnList;
	}

	@Override
	public List<FindUrgentMbrPageReturn> findPersonMemberSexCount(FindPersonMember findPersonMember) throws TsfaServiceException {
		AssertUtils.notNull(findPersonMember);
		List<FindUrgentMbrPageReturn> findUrgentMbrPageReturn = null;
		try {
			findUrgentMbrPageReturn = personMemberDao.findPersonMemberSexCount(findPersonMember);
		} catch (Exception e) {
			logger.error("统计客户信息错误", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_FIND_ERROR, "统计客户息错误", e);
		}
		return findUrgentMbrPageReturn;
	}

	@Override
	public int findNewPmCount(FindNewPmCountDto findNewPmCountDto) throws TsfaServiceException {
		try {
			int count = personMemberDao.findNewPmCount(findNewPmCountDto);
			return count;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找 导购信息错误", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_FIND_ERROR, "查找导购信息错误", e);
		}
	}

	@Override
	public int findCountPmByType(FindPmType findPmType) {
		logger.debug("findCountPmByType(FindPmType findPmType={}) - start", findPmType);
		AssertUtils.notNull(findPmType);
		AssertUtils.notNullAndEmpty(findPmType.getMemberNo(), "导购编号不能为空");
		AssertUtils.notNullAndEmpty(findPmType.getPmTypeType(), "客户类型不能为空");
		int count = personMemberDao.findCountPmByType(findPmType);
		logger.debug("findCountPmByType(count = {}) - end", count);
		return count;
	}

	@Override
	public List<FindPersonMemberReturn> findPersonMemberByGm(FindPersonMember personMember) {
		try {
			List<FindPersonMemberReturn> list = personMemberDao.findPersonMemberByGm(personMember);
			return list;
		} catch (Exception e) {
			logger.error("查找 导购信息错误", e);
			throw new TsfaServiceException(ErrorCode.GUID_MEMBER_FIND_ERROR, "查找导购信息错误", e);
		}
	}

	@Override
	public List<FindPersonMemberReturnList> findPersonMemberTypeList(FindPersonMember findPersonMember) {
		logger.debug("findPersonMemberTypeList(FindPersonMember findPersonMember) - start");
		AssertUtils.notNull(findPersonMember);
		List<FindPersonMemberReturnList> list = null;
		try {
			list = personMemberDao.findPersonMemberTypeList(findPersonMember);
		} catch (Exception e) {
			logger.error("客户会员信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_PAGE_ERROR, "客户会员信息不存在错误.！", e);
		}
		return list;
	}

	@Override
	public int findPersonMemberTypeCount(FindPersonMember findPersonMember) {
		logger.debug("findPersonMemberTypeCount(FindPersonMember findPersonMember) - start");
		AssertUtils.notNull(findPersonMember);
		int count = 0;
		try {
			count = personMemberDao.findPersonMemberTypeCount(findPersonMember);
		} catch (Exception e) {
			logger.error("客户会员信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_PAGE_ERROR, "客户会员信息不存在错误.！", e);
		}
		return count;
	}

	@Override
	public List<FindMemberInfoReturn> findMemberRecord(FindMemberRecord findMemberRecord) {
		return personMemberDao.findMemberRecord(findMemberRecord);
	}

	@Override
	public List<CountPersonMemberReturn> findGroupCountByDay(FindCountPersonMember findCountPersonMember) {
		AssertUtils.notNull(findCountPersonMember);
		return personMemberDao.findGroupCountByDay(findCountPersonMember);
	}

	@Override
	public int findPersonMemberCont(FindPersonMember findPersonMember)
			throws TsfaServiceException {
		logger.debug("findPersonMemberTypeCount(FindPersonMember findPersonMember) - start");
		AssertUtils.notNull(findPersonMember);
		int count=0;
		try {
			count=personMemberDao.findPersonMemberCont(findPersonMember);
		} catch (Exception e) {
			logger.error("客户会员信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.PERSON_MEMBER_FIND_PAGE_ERROR, "客户会员信息不存在错误.！", e);
		}
		return count;
	}

}
