package com.lj.business.member.dao;

import java.util.List;

import com.lj.business.member.domain.MemLine;
import com.lj.business.member.dto.FindMemLinePage;
import com.lj.business.member.dto.MemLineDto;

public interface IMemLineDao {

	int insert(MemLine record);
 
	MemLine selectByPrimaryKey(String code);

	int updateByPrimaryKeySelective(MemLine record);

    List<MemLineDto> findMemLinePage(
    		MemLineDto memLineDto);

    int findMemLinePageCount(MemLineDto memLineDto);
    
    MemLine findMemLine(MemLine memLine);
    
    List<MemLine> inqueryMemberJobInfo();
    
    MemLineDto selectByName(MemLineDto memLineDto);
}