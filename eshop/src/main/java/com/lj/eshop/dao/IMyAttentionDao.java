package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.MyAttention;
import com.lj.eshop.dto.FindMyAttentionPage;
import com.lj.eshop.dto.MyAttentionDto;

public interface IMyAttentionDao {
    int insertSelective(MyAttention record);

    MyAttention selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(MyAttention record);

    List<MyAttentionDto> findMyAttentionPage(FindMyAttentionPage findMyAttentionPage);

   	int findMyAttentionPageCount(FindMyAttentionPage findMyAttentionPage);
   	
   	List<MyAttentionDto> findMyAttentions(FindMyAttentionPage findMyAttentionPage);
}