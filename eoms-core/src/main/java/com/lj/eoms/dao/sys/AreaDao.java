package com.lj.eoms.dao.sys;

import java.util.List;
import java.util.Map;

import com.ape.common.persistence.annotation.MyBatisDao;
import com.lj.eoms.dao.TreeDao;
import com.lj.eoms.entity.sys.Area;

/**
 * 
 * 
 * 类说明：地区Dao
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年7月28日
 */
@MyBatisDao
public interface AreaDao extends TreeDao<Area> {
    List<Area> selectProvince();
    /**
     * 
     *
     * 方法说明：查找所有省市区信息
     *
     * @return
     *
     * @author 邹磊 CreateDate: 2017年8月3日
     *
     */
    List<Area> FindProvinceAndCityarea();
    
    List<Area> selectAreaByParentId(String id);
    
    String selectAreaById(String id);
    
    String selectAreaNameByParentId(String id);
    
    Map selectInfoByAreaId(String id);

	List<Area> getChildById(String pid);
	
	public int batchInsert(List<Map<String,Object>> list);
	
	public int batchUpdate(List<Map<String,Object>> list);
	
	public Area getByCode(String code);
}
