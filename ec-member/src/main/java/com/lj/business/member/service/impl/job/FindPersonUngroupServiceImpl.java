package com.lj.business.member.service.impl.job;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.domain.GuidMember;
import com.lj.business.member.dto.ManagerMemberDto;
import com.lj.business.member.dto.ManagerMemberReturnDto;
import com.lj.business.member.emus.MemberType;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.business.member.service.IManagerMemberService;
import com.lj.cc.clientintf.IJob;

/**
 * 
 * 
 * 类说明：获取每个导购未分组的人数
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 杨杰
 * 
 *         CreateDate: 2017年9月7日
 */
@Service
public class FindPersonUngroupServiceImpl implements IJob {
	private static final Logger logger = LoggerFactory.getLogger(FindPersonUngroupServiceImpl.class);

	@Resource
	private IGuidMemberService guidMemberService;


	@Resource
	private IManagerMemberService managerMemberService;

	@Override
	public void runJob() {
		this.triggerFindPersonUngroupJob();
	}

	public synchronized void triggerFindPersonUngroupJob() throws TsfaServiceException {
		GuidMember query = new GuidMember();
		List<GuidMember> list = guidMemberService.findGuidMember(query);
		logger.debug("当前共有" + list.size() + "导购.");
		for (GuidMember guidMember : list) {
			query.setMemberNo(guidMember.getMemberNo());
			// 根据memberNo获取当前没有分组用户count
			int count = guidMemberService.findPersonUngroupCount(query);
			if (count > 0) {
				
			}
		}
	}

}
