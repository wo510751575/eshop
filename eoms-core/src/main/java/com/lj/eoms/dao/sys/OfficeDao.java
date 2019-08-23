package com.lj.eoms.dao.sys;

import com.ape.common.persistence.annotation.MyBatisDao;
import com.lj.eoms.dao.TreeDao;
import com.lj.eoms.entity.sys.Office;

/**
 * 机构DAO接口
 */
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
	
}
