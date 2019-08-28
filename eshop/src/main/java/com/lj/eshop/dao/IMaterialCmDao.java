package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.MaterialCm;
import com.lj.eshop.dto.FindMaterialCmPage;
import com.lj.eshop.dto.MaterialCmDto;

public interface IMaterialCmDao {
    int insert(MaterialCm record);

    int insertSelective(MaterialCm record);

	List<MaterialCmDto> findMaterialCms(FindMaterialCmPage findMaterialCmPage);

	int updateByPrimaryKeySelective(MaterialCm materialCm);

	int updateByPrimaryKey(MaterialCm materialCm);

	List<MaterialCmDto> findMaterialCmPage(FindMaterialCmPage findMaterialCmPage);

	int findMaterialCmPageCount(FindMaterialCmPage findMaterialCmPage);

	MaterialCm selectByPrimaryKey(String code);

	int deleteByPrimaryKey(String code);
}