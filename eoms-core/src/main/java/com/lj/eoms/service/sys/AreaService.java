package com.lj.eoms.service.sys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lj.eoms.dao.sys.AreaDao;
import com.lj.eoms.entity.sys.Area;
import com.lj.eoms.service.TreeService;
import com.lj.eoms.utils.UserUtils;

/**
 * 区域Service
 */
@Service
@Transactional(readOnly = true)
public class AreaService extends TreeService<AreaDao, Area> {
	
	@Autowired
	private AreaDao areaDao;

	public Area get(String id) {
		return super.get(id);
	}
	
	public List<Area> findAll() {
		return UserUtils.getAreaList();
	}
	
	@Override
	@Transactional(readOnly = false)
	public void save(Area area) {
		super.save(area);
		//更新版本号
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Area area) {
		super.delete(area);
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}
	
	/**
	 * 获取所有的省份
	 * @return
	 */
	public List<Area> selectProvince() {
		return this.areaDao.selectProvince();
	}
	
	/**
	 * 获取所有省市区信息
	 * @return
	 */
	public List<Area> FindProvinceAndCityarea() {
		return this.areaDao.FindProvinceAndCityarea();
	}

	/**
	 * 获取字节点
	 * @param parentId 父节点ID
	 * @return
	 */
	public List<Area> selectAreaByParentId(String parentId) {
		return this.areaDao.selectAreaByParentId(parentId);
	}

	/**
	 * 查询区域地址
	 * @param areaId
	 * @return
	 */
	public String getAreaDown(String areaId) {
		String parentidsstr = this.areaDao.selectAreaById(areaId);
		// 去掉地区root节点的“中国”
		if (parentidsstr.startsWith("0,100000,")) {
			parentidsstr = parentidsstr.substring(9);
		}
		parentidsstr += areaId + ",";
		final String[] parentids = parentidsstr.split(",");
		String strs = "";
		for (final String parentid : parentids) {
			final String str = this.areaDao.selectAreaNameByParentId(parentid);
			if (str != null) {
				strs = strs + str;
			}
		}
		return strs;
	}

	/**
	 * 级联查询区域信息
	 * @param areaId
	 * @return
	 */
	public List<String> cascadeQueryArea(String areaId) {
		String parentidsstr = this.areaDao.selectAreaById(areaId);
		// 去掉地区root节点的“中国”
		if (parentidsstr.startsWith("0,100000,")) {
			parentidsstr = parentidsstr.substring(9);
		}
		parentidsstr += areaId + ",";
		final String[] parentids = parentidsstr.split(",");
		final List<String> address = new ArrayList<String>();
		for (final String parentid : parentids) {
			final String str = this.areaDao.selectAreaNameByParentId(parentid);
			if (StringUtils.isNotBlank(str)) {
				address.add(str);
			}
		}
		return address;
	}

	/**
	 * 查询区域地址
	 * @param areaId
	 * @return
	 */
	public String getFullAreaName(String areaId) {
		final Area area = this.areaDao.get(areaId);
		if (area != null) {
			String parentidsstr = area.getParentIds();
			// 去掉地区root节点的“中国”
			if (parentidsstr.startsWith("0,100000,")) {
				parentidsstr = parentidsstr.substring(9);
			}
			//parentidsstr += areaId + ",";
			final String[] parentids = parentidsstr.split(",");
			String strs = "";
			for (final String parentid : parentids) {
				final String str = this.areaDao.selectAreaNameByParentId(parentid);
				if (str != null) {
					strs = strs + str;
				}
			}
			return strs + area.getName();
		}
		return "";
	}
	/**
	 * 查询区域地址第一父类
	 * @param areaId
	 * @return
	 */
	public String getFirstAreaName(String areaId) {
		final Area area = this.areaDao.get(areaId);
		if (area != null) {
			String parentidsstr = area.getParentIds();
			// 去掉地区root节点的“中国”
			if (parentidsstr.startsWith("0,100000,")) {
				parentidsstr = parentidsstr.substring(9);
			}
			//parentidsstr += areaId + ",";
			final String[] parentids = parentidsstr.split(",");
			String strs = "";
			if(parentids.length>2){
				final String str = this.areaDao.selectAreaNameByParentId(parentids[1]);
				if (str != null) {
					strs = strs + str;
				}
			}
			return strs;
		}
		return "";
	}
	
	/**
	 * 查询当前区域同一级别的其它区域信息
	 * @param areaId
	 * @return
	 */
	public Map selectCurrentLevelByAreaId(String areaId) {
		
		final Map datas = this.areaDao.selectInfoByAreaId(areaId);

		return datas;
	}
	/**
	 * 查询当前的子 id值为父id
	 * @param areaId
	 * @return
	 */
	public List<Area> getChildById(String id) {
		 List<Area> list=areaDao.getChildById(id);
		return list;
	}
}
