package com.lj.eoms.service;

import java.util.List;

import com.lj.eoms.entity.sys.Area;
import com.lj.eoms.entity.sys.Dict;

/**
 * 
 * 
 * 类说明：省市区开放接口
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年7月11日
 */
public interface AreaHessianService {
		 
	/**
	 * 获取所有的省份
	 * @return
	 */
	public List<Area> selectProvince();
	
	/**
	 * 
	 *
	 * 方法说明：查询所有省市区信息
	 *
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年8月3日
	 *
	 */
	public List<Area> FindProvinceAndCityarea();  
	
	/**
	 * 获取字节点
	 * @param parentId 父节点ID
	 * @return
	 */
	public List<Area> selectAreaByParentId(String parentId);
	       
	/**
	 * 
	 *
	 * 方法说明：获取所在区域列表
	 *
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月27日
	 *
	 */
	public List<Dict> selectAreaCode();    
	      
	/**
	 * 
	 *
	 * 方法说明：根据区域Code获取显示值
	 *
	 * @param code
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月3日
	 *
	 */
	public String getAreaNameByCode(String code);
	
	/**
	 * 
	 *
	 * 方法说明：获取所有
	 *
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月4日
	 *
	 */
	public List<Area> findAllList();  
	
	/**
	 * 
	 *
	 * 方法说明：获取区域版本号，每次修改区域版本+1
	 *
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月4日
	 *
	 */
	public int getAreaVersion();
	
	public Area get(String id);
	
}
