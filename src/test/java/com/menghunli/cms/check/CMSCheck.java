package com.menghunli.cms.check;

import com.aventstack.extentreports.ExtentTest;
import com.menghunli.cms.listener.ExtentTestNGITestListener;
import com.menghunli.cms.method.ElementMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CMSCheck extends ElementMethod {
    ExtentTestNGITestListener el = new ExtentTestNGITestListener();
    ExtentTest log = el.getlog();
//    public CMSCheck(WebDriver driver){
//        CMSCheck cmsCheck = PageFactory.initElements(driver,CMSCheck.class);
//    }
    public void cmsLogin(WebDriver driver,String username, String passwd) throws Exception{
        this.waitElement(driver,input_username);
        this.sendUsername(username);
        this.sendPasswd(passwd);
        this.clickBtnOK();
        log.info("检查是否登录成功");
        this.waitElement(driver,modify);
        if(!doesWebElementExist(modify)){
            Assert.fail("登录失败");
        }
        Thread.sleep(2000);
    }
    //审核管理-入驻申请，测试搜索条件
    public void rzsqSearchCityPhone(WebDriver driver,String username, String passwd,String phone) throws Exception{
        String sellername = "龙凤婚礼";
        String approver = "zhangq";
//        this.cmsLogin(driver,username,passwd);
        this.waitElement(driver,rzsq);
//        Thread.sleep(5000);
        this.clickRzsq();
        this.waitElement(driver,city);
        Thread.sleep(2000);
        log.info("检查，搜索条件-店铺名称，店铺:"+sellername+" 搜索是否正确");
        this.sendAppover(sellername);
        this.clickSearchBtn();
        Thread.sleep(2000);
        if(!sellername.equals(getSellerResultText())){
            log.info("实际搜索结果"+getSellerResultText());
            Assert.fail("搜索条件-店铺名称，店铺搜索结果不正确");
        }
        log.info("检查,搜索条件-处理人，处理人："+approver+" 搜索结果是否正确");
        this.clickCity();
        this.selectApprover();
        this.sendAppover(approver);
        this.clickSearchBtn();
        Thread.sleep(3000);
        if(!approver.equals(getApproverResultText())){
            log.info("实际搜索结果："+getApproverResultText());
            Assert.fail("搜索条件-处理人，处理人搜索结果不正确");
        }

        log.info("检查按照联系人电话搜索，搜索结果是否正确");
        this.clickCity();
        this.selectCityPhone();
        this.sendPhone(phone);
//        this.clickCanceDate();
        this.clickSearchBtn();

        Thread.sleep(1000);
        log.info(getPhoneResultText());
        if(!phone.equals(getPhoneResultText())){
            Assert.fail("联系人电话搜索失败");
        }
        Thread.sleep(1000);
        log.info("判断日期搜索结果是否正确");
//        JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;
//        //remove readonly attribute
//        removeAttribute.executeScript("var setDate=document.getElementsByClassName(\"input\");setDate.removeAttribute('readonly');") ;
        this.clickShenQingDate();
//        this.sendBeginDate("2019-03-18");
//        Thread.sleep(1000);
//        this.sendBeginDate("2019-03-18");
        this.clickShiba();
        this.clickShiba();
        this.search.clear();
        this.clickSearchBtn();
//        log.info(this.getShibasInfo());

//        if(!getShibasInfo().contains("17")){
//            Assert.fail("日期搜索结果不正确");
//        }


        Thread.sleep(2000);
    }
    //审核管理-入驻申请，测试商家类型搜索条件
    public void rzsqSearchSeller(WebDriver driver,String username, String passwd) throws Exception{
//        this.cmsLogin(driver,username,passwd);
//        this.waitElement(driver,rzsq);
//
        this.clickShgl();
        Thread.sleep(1000);
        this.clickRzsq();
        this.refresh(driver);
        this.waitElement(driver,seller_select);
//        this.moveToElement(driver,shengqingDate);
//        this.clickCanceDate();
        this.clickSellerSelect();
        String sellertype = this.selectSeller("2");
//        this.search.click();
//        this.search.clear();//clear后，数据回填？
        Thread.sleep(2000);
//        this.waitElement(driver,blue_button);
        this.clickSearchBtn();
        Thread.sleep(1000);
        log.info("检查，商家类型,选择"+sellertype+"搜索结果是否正确");
        if(!sellertype.equals(getSellerSelectResultInfo())){
            log.info("实际商家类型："+getSellerSelectResultInfo());
            Assert.fail("商家类型,选择 "+sellertype+" 搜索结果不正确");
        }

        Thread.sleep(2000);

    }
}
