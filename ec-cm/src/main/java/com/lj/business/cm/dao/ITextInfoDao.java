package com.lj.business.cm.dao;

import java.util.List;

import com.lj.business.cm.domain.TextInfo;
import com.lj.business.cm.dto.textInfo.FindTextInfo;
import com.lj.business.cm.dto.textInfo.FindTextInfoPage;
import com.lj.business.cm.dto.textInfo.FindTextInfoPageReturn;

public interface ITextInfoDao {
    int deleteByPrimaryKey(String code);

    int insert(TextInfo record);

    int insertSelective(TextInfo record);

    TextInfo selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(TextInfo record);

    int updateByPrimaryKey(TextInfo record);
    
    List<FindTextInfoPageReturn> findTextInfoPage(FindTextInfoPage findTextInfoPage);

	int findTextInfoPageCount(FindTextInfoPage findTextInfoPage);
	
	 FindTextInfoPageReturn findTextInfoReturnContent(FindTextInfo findTextInfo);	 
}