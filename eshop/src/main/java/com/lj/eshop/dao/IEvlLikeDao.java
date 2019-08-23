package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.EvlLike;
import com.lj.eshop.dto.EvlLikeDto;
import com.lj.eshop.dto.FindEvlLikePage;

public interface IEvlLikeDao {
    int insertSelective(EvlLike record);

    EvlLike selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(EvlLike record);

    List<EvlLikeDto> findEvlLikePage(FindEvlLikePage findEvlLikePage);

   	int findEvlLikePageCount(FindEvlLikePage findEvlLikePage);
   	
   	List<EvlLikeDto> findEvlLikes(FindEvlLikePage findEvlLikePage);
}