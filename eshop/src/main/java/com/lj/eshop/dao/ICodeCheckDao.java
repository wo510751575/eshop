package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.CodeCheck;
import com.lj.eshop.dto.CodeCheckDto;
import com.lj.eshop.dto.FindCodeCheckPage;

public interface ICodeCheckDao {

    int insertSelective(CodeCheck record);

    CodeCheck selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(CodeCheck record);

    List<CodeCheckDto> findCodeCheckPage(FindCodeCheckPage findCodeCheckPage);

   	int findCodeCheckPageCount(FindCodeCheckPage findCodeCheckPage);
   	
   	List<CodeCheckDto> findCodeChecks(FindCodeCheckPage findCodeCheckPage);
}