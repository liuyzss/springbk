package com.blueknight.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import qufenqi.pay.billing.api.facade.CompanyInfoFacade;
import qufenqi.pay.billing.api.facade.ShareProfitFacade;
import qufenqi.pay.billing.api.vo.BankRedecreaseRequestVo;
import qufenqi.pay.billing.api.vo.BankRedecreaseResponseVo;
import qufenqi.pay.billing.api.vo.HessianCompanyListVo;

import javax.annotation.Resource;

/**
 * liuyang
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration(locations = {"classpath*:config/spring/applicationContext-*.xml"})
public class CompanyRuleTest{

	@Resource
	private CompanyInfoFacade companyInfoFacade;

	@Resource
	private ShareProfitFacade shareProfitFacade;

	@Test
	public void testCrud() {
//		rule.setBorrowerId(1L);
//		rule.setLenderId(2L);
//		rule.setBorrowerName("hello");
		//HessianCompanyListVo vo = companyInfoFacade.queryCompanyInfos();
		BankRedecreaseRequestVo bankRedecreaseRequestVo = new BankRedecreaseRequestVo();

		bankRedecreaseRequestVo.setOrderNo("1000001112");
		bankRedecreaseRequestVo.setLenderId(35l);
		bankRedecreaseRequestVo.setBorrowerId(16l);
		bankRedecreaseRequestVo.setFirstAmount(100l);
		bankRedecreaseRequestVo.setOrderAmount(11000l);
		bankRedecreaseRequestVo.setBussinessLine("laifenqi");
		bankRedecreaseRequestVo.setBussinessType("1");
		bankRedecreaseRequestVo.setCallBackType("6");
		bankRedecreaseRequestVo.setIsMashang("2");

		BankRedecreaseResponseVo vo = shareProfitFacade.bankRedecrease(bankRedecreaseRequestVo);
		System.out.println("@@@@@@@@@@@@@@@@@@@");
	}

	@Test
	public void testCompany() {
		HessianCompanyListVo vo = companyInfoFacade.queryCompanyInfos();
		System.out.println(vo);
	}
}
