package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.MarkSolution;
import com.lj.eshop.dto.FindMarkSolutionPage;
import com.lj.eshop.dto.MarkSolutionDto;

public interface IMarkSolutionDao {

    int insertSelective(MarkSolution record);

    MarkSolution selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(MarkSolution record);
    
    List<MarkSolutionDto> findMarkSolutionPage(FindMarkSolutionPage findMarkSolutionPage);

   	int findMarkSolutionPageCount(FindMarkSolutionPage findMarkSolutionPage);
   	
   	List<MarkSolutionDto> findMarkSolutions(FindMarkSolutionPage findMarkSolutionPage);

}