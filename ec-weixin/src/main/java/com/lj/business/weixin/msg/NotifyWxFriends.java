/*package com.lj.business.weixin.msg;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lj.business.cf.dto.socialTask.AddSocialTask;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.emus.MemberType;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.distributecache.IDistributeCache;
import com.lj.messagecenter.emus.SendType;
import com.lj.messagecenter.msg.dto.AddNotifyInfo;
import com.lj.messagecenter.msg.enums.MsgSystemType;
import com.lj.messagecenter.msg.service.INotifyService;

*//**
 * 微信朋友圈更新通知
 * @author 梅宏博
 *
 *//*
@Component
public class NotifyWxFriends {
	
	*//** Logger for this class. *//*
	private static final Logger logger = LoggerFactory.getLogger(NotifyWxFriends.class);
	
	@Resource 
	private IDistributeCache distributeCache;
	
	@Autowired
	private INotifyService notifyService;
	
	@Autowired
	private IGuidMemberService guidMemberService;
	
	private static final int TIME_SPACE = 60;//时间间隔，分钟
	
	private static final String COMMAND_PER = "WX_FRIENDS_";//缓存key前缀
	
	private static final String STATUS_NEED_SEND = "0";//需要发送
	
	private static final String STATUS_SEND = "1";//已发送
	
	private static final String MSG_CONTENT = "你有朋友圈已更新，需要去评论";//短信内容
	
	public void notifyGm(AddSocialTask addSocialTask){
		logger.info("notifyGm(AddSocialTask addSocialTask={}) - start", addSocialTask);
		
		try {
			
			if (addSocialTask == null) {//当消息为空时直接返回
				return;
			}
			
			//从redis中获取发送字符串
			String sendCommand = distributeCache.get(COMMAND_PER + addSocialTask.getMemberNoGm());
			
			//当该导购未在缓存中存储，则为第一条，需发送
			if (StringUtils.isBlank(sendCommand)) {
				sendCommand = new Date().getTime() + "_" + addSocialTask.getFriendUpdateDate().getTime() + "_" + STATUS_SEND;
				distributeCache.set(COMMAND_PER + addSocialTask.getMemberNoGm(), sendCommand);
				sendMsg(addSocialTask);//发送通知
				return;
			}
			
			String[] commands = sendCommand.split("_");
			long sendTime = Long.valueOf(commands[0]);//发送时间
			long lastFriendUpdateTime = Long.valueOf(commands[1]);//最后一次更新朋友圈时间
			String status = commands[2];//发送状态
			
			//当该次朋友圈时间大于最后一次发送时间，则更新发送时间，且修改发送状态
			if (addSocialTask.getFriendUpdateDate().getTime() > lastFriendUpdateTime) {
				lastFriendUpdateTime = addSocialTask.getFriendUpdateDate().getTime();
				status = STATUS_NEED_SEND;
			}
			
			//当该次朋友圈发送时间超过一小时，且发送状态为需要发送，则发送消息，且修改发送时间和状态
			if (status.equals(STATUS_NEED_SEND) && new Date().getTime() >= (sendTime + TIME_SPACE * 60 * 1000)) {
				sendMsg(addSocialTask);
				sendTime = new Date().getTime();
				status = STATUS_SEND;
			}
			
			//更新缓存
			sendCommand = sendTime + "_" + lastFriendUpdateTime + "_" + status;
			distributeCache.set(COMMAND_PER + addSocialTask.getMemberNoGm(), sendCommand);
			logger.info("notifyGm - end");
		} catch (Exception e) {
			logger.error("朋友圈消息通知错误", e);
		}
	}


	private void sendMsg(AddSocialTask addSocialTask) {
		FindGuidMember findGuidMember = new FindGuidMember();
		findGuidMember.setMemberNo(addSocialTask.getMemberNoGm());
		FindGuidMemberReturn guidMember = guidMemberService.findGuidMember(findGuidMember);
		
		AddNotifyInfo addNotifyInfo = new AddNotifyInfo();
		addNotifyInfo.setSendType(SendType.SINGLE.toString());
		addNotifyInfo.setMerchantNo(addSocialTask.getMerchantNo());
		addNotifyInfo.setMemberNo(addSocialTask.getMemberNoGm());
		addNotifyInfo.setMemberName(addSocialTask.getMemberNameGm());
		addNotifyInfo.setMemberType(MemberType.GUID.toString());
		addNotifyInfo.setContent(MSG_CONTENT);
		addNotifyInfo.setMobile(guidMember.getMobile());
		addNotifyInfo.setSysType(MsgSystemType.ALL.toString());
		notifyService.sendMsgInfo(addNotifyInfo);
	}
}
*/