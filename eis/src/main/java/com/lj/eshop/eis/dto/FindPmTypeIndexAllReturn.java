package com.lj.eshop.eis.dto;

import java.io.Serializable;
import java.util.Collection;

import com.lj.business.member.dto.FindPmTypeIndexPageReturn;
import com.lj.business.member.dto.FindPmTypeIndexReturn;

/**
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @Company: 领居科技有限公司
 * @author 彭阳
 * 
 * CreateDate: 2017年7月1日
 */
public class FindPmTypeIndexAllReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3189595484632661559L;
	
	/** 分类信息. */
	private FindPmTypeIndexReturn pmTye;
	
	/** 所属分类明细. */
	private Collection<FindPmTypeIndexPageReturn> detail;

	/**
	 * Gets the 分类信息.
	 *
	 * @return the 分类信息
	 */
	public FindPmTypeIndexReturn getPmTye() {
		return pmTye;
	}

	/**
	 * Sets the 分类信息.
	 *
	 * @param pmTye the new 分类信息
	 */
	public void setPmTye(FindPmTypeIndexReturn pmTye) {
		this.pmTye = pmTye;
	}

	/**
	 * Gets the 所属分类明细.
	 *
	 * @return the 所属分类明细
	 */
	public Collection<FindPmTypeIndexPageReturn> getDetail() {
		return detail;
	}

	/**
	 * Sets the 所属分类明细.
	 *
	 * @param detail the new 所属分类明细
	 */
	public void setDetail(Collection<FindPmTypeIndexPageReturn> detail) {
		this.detail = detail;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindPmTypeIndexAllReturn [pmTye=").append(pmTye)
				.append(", detail=").append(detail).append("]");
		return builder.toString();
	}
	
	

}
