package com.lj.eoms.dao.sys;

import com.ape.common.persistence.CrudDao;
import com.ape.common.persistence.annotation.MyBatisDao;
import com.lj.eoms.entity.sys.Log;

/**
 * 日志DAO接口
 */
@MyBatisDao
public interface LogDao extends CrudDao<Log> {

}
