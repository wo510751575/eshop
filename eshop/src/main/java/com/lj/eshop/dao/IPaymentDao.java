package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Payment;
import com.lj.eshop.dto.FindPaymentPage;
import com.lj.eshop.dto.PaymentDto;

public interface IPaymentDao {

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Payment record);
    
    List<PaymentDto> findPaymentPage(FindPaymentPage findPaymentPage);

   	int findPaymentPageCount(FindPaymentPage findPaymentPage);
   	
   	List<PaymentDto> findPayments(FindPaymentPage findPaymentPage);
}