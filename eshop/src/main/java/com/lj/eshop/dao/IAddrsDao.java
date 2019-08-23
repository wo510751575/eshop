package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Addrs;
import com.lj.eshop.dto.AddrsDto;
import com.lj.eshop.dto.FindAddrsPage;

public interface IAddrsDao {

    int insertSelective(Addrs record);

    Addrs selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Addrs record);
    
    int updateByMbrcode(Addrs record);
    
    List<AddrsDto> findAddrsPage(FindAddrsPage findAddrsPage);

  	int findAddrsPageCount(FindAddrsPage findAddrsPage);
  	
  	List<AddrsDto> findAddrss(FindAddrsPage findAddrsPage);
}