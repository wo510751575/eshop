package com.lj.business.member.service.impl.job;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lj.base.mvc.web.test.SpringTestCase;

/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 杨杰
 *   
 * CreateDate: 2017年9月7日
 */
public class FindPersonUngroupServiceImplTest extends SpringTestCase {

	@Autowired
	private FindPersonUngroupServiceImpl findPersonUngroupServiceImpl;
	
	@Test
	public void findPersonUngroup() {
		findPersonUngroupServiceImpl.runJob();
	}
}
