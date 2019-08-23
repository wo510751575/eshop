package com.lj.business.member.dto;

import java.io.Serializable;

public class FindAgreementAndMerchantReturnDto implements Serializable {

	/**
	 * Generate cron.
	 *
	 * @param
	 * @param
	 * @throws
	 */
	private static final long serialVersionUID = 2080007959134985358L;
	/**
	 * 商户
	 */
	private FindMerchantReturnDto findMerchantReturnDto;
	/**
	 * 服务
	 */
	private FindAgreementMerchantReturnDto findAgreementMerchantReturnDto;

	public FindMerchantReturnDto getFindMerchantReturnDto() {
		return findMerchantReturnDto;
	}

	public void setFindMerchantReturnDto(
			FindMerchantReturnDto findMerchantReturnDto) {
		this.findMerchantReturnDto = findMerchantReturnDto;
	}

	public FindAgreementMerchantReturnDto getFindAgreementMerchantReturnDto() {
		return findAgreementMerchantReturnDto;
	}

	public void setFindAgreementMerchantReturnDto(
			FindAgreementMerchantReturnDto findAgreementMerchantReturnDto) {
		this.findAgreementMerchantReturnDto = findAgreementMerchantReturnDto;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(
				"FindAgreementAndMerchantReturnDto [findMerchantReturnDto=")
				.append(findMerchantReturnDto)
				.append(", findAgreementMerchantReturnDto=")
				.append(findAgreementMerchantReturnDto).append("]");
		return builder.toString();
	}

}
