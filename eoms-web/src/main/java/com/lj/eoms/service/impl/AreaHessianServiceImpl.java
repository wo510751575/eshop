package com.lj.eoms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ape.common.utils.CacheUtils;
import com.lj.eoms.entity.sys.Area;
import com.lj.eoms.entity.sys.Dict;
import com.lj.eoms.service.AreaHessianService;
import com.lj.eoms.service.sys.AreaService;
import com.lj.eoms.utils.DictUtils;

/**
 * 
 * 
 * 类说明：开放省市区接口实现类
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年7月11日
 */
@Service("areaHessianServiceImpl")
public class AreaHessianServiceImpl implements AreaHessianService {

	@Autowired
	private AreaService areaService;
	
	@Override
	public List<Area> selectProvince() {
		return areaService.selectProvince();
	}
	/**
	 * 查询所有的省市区信息
	 */
	@Override
	public List<Area> FindProvinceAndCityarea() {
		return areaService.FindProvinceAndCityarea();
	}

	@Override
	public List<Area> selectAreaByParentId(String parentId) {
		return areaService.selectAreaByParentId(parentId);
	}
	
	@Override
	public List<Dict> selectAreaCode() {
		return DictUtils.getDictList("erp_dict_1");
	}

	@Override
	public String getAreaNameByCode(String code) {
		return DictUtils.getDictLabel(code, "erp_dict_1", "");
	}
	@Override
	public List<Area> findAllList() {
		return areaService.findAll();
	}
	@Override
	public int getAreaVersion() {
		Integer version = (Integer)CacheUtils.get(Area.CACHE_AREA_VERSION);
		if(version==null){
			version =1;
			CacheUtils.put(Area.CACHE_AREA_VERSION,version);
		}
		return version;
	}
	
	public Area get(String id) {
		return areaService.get(id);
	}
}
