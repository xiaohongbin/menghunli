package com.menghunli.cms.testcase;

import com.menghunli.cms.check.CMSCheck;
import com.menghunli.cms.driver.Driver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestCase extends Driver {
    public String username = "xiaohongbin";
    public String passwd = "xiaohongbin123";

    @Test(description = "CMS用户登录")
    public  void checkCmsLogin() throws Exception{
        CMSCheck cmsCheck = PageFactory.initElements(ThreadDriver.get(),CMSCheck.class);
        cmsCheck.cmsLogin(ThreadDriver.get(),username,passwd);
    }
    @Test(description = "审核管理-入驻申请-检查电话搜索条件")
    public  void checkRzsqSearchCityPhone() throws Exception{
        CMSCheck cmsCheck = PageFactory.initElements(ThreadDriver.get(),CMSCheck.class);
        cmsCheck.rzsqSearchCityPhone(ThreadDriver.get(),username,passwd,"13350143106");
    }
    @Test(description = "审核管理-入驻申请-商家类型搜索条件")
    public  void checkRzsqSearchSeller() throws Exception{
        CMSCheck cmsCheck = PageFactory.initElements(ThreadDriver.get(),CMSCheck.class);
        cmsCheck.rzsqSearchSeller(ThreadDriver.get(),username,passwd);

    }


}
//class SingletonDemo1 extends CMSCheck{
//
////    private  static WebDriver driver=;
//    private  static SingletonDemo1 instance = new SingletonDemo1();
//    private  SingletonDemo1() {
////        this.driver = driver;
//        CMSCheck cmsCheck = PageFactory.initElements( Driver.driver,CMSCheck.class);
//
//    }
//
//    public  static SingletonDemo1 getInstance() {
////        this.driver = driver;
//        return instance;
//    }
//
//}
