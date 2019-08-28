package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Message;
import com.lj.eshop.dto.FindMessagePage;
import com.lj.eshop.dto.MessageDto;

public interface IMessageDao {
    int insertSelective(Message record);

    Message selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Message record);

    List<MessageDto> findMessagePage(FindMessagePage findMessagePage);

   	int findMessagePageCount(FindMessagePage findMessagePage);
   	
   	List<MessageDto> findMessages(FindMessagePage findMessagePage);
   	
   	int updateByRecevier(Message record);
}