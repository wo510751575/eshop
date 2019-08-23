package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Suggestion;
import com.lj.eshop.dto.FindSuggestionPage;
import com.lj.eshop.dto.SuggestionDto;

public interface ISuggestionDao {
    int insertSelective(Suggestion record);

    Suggestion selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Suggestion record);

    List<SuggestionDto> findSuggestionPage(FindSuggestionPage findSuggestionPage);

   	int findSuggestionPageCount(FindSuggestionPage findSuggestionPage);
   	
   	List<SuggestionDto> findSuggestions(FindSuggestionPage findSuggestionPage);
}