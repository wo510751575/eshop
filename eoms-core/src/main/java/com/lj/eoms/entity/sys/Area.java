package com.lj.eoms.entity.sys;


import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import com.ape.common.utils.IdGen;
import com.lj.eoms.entity.TreeEntity;
import com.lj.eoms.utils.UserUtils;

/**
 * 区域Entity
 */
public class Area extends TreeEntity<Area> {

	private static final long serialVersionUID = 1L;
	public static final String CACHE_AREA_VERSION = "areaVersion";
	private String code; // 区域编码
	private String type; // 区域类型（1：国家；2：省份、直辖市；3：地市；4：区县）
	private String zone; // 区域地带(0：华东；1：华北；2：华中；3： 华南；4：西南；5：西北；6：东北；7：港澳台)

	public Area() {
		super();
		this.sort = 30;
	}

	public Area(String id) {
		super(id);
	}

	public Area getParent() {
		return parent;
	}

	public void setParent(Area parent) {
		this.parent = parent;
	}

	@Length(min = 1, max = 1)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Length(min = 0, max = 100)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String toString() {
		return name;
	}
	
	@Length(min = 1, max = 1)
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	@Override
	public void preInsert() {
		super.preInsert();
		if (!this.isNewRecord){
			setId(IdGen.uuid());
		}
		User user = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getId())){
			this.updateBy = user;
			this.createBy = user;
		}
	}
	
	@Override
	public void preUpdate(){
		super.preUpdate();
		User user = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getId())){
			this.updateBy = user;
		}
	}
	
}