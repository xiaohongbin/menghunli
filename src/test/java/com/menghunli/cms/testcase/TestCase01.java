package com.menghunli.cms.testcase;

import com.menghunli.cms.driver.Driver;
import org.testng.annotations.Test;

public class TestCase01 extends Driver {
    public String username = "xiaohongbin";
    public String passwd = "xiaohongbin123";
//    public CMSCheck cmsCheck;
//    public TestCase instance =new TestCase();
    Long start = System.currentTimeMillis();

//    public TestCase() {
////        CMSCheck cmsCheck;
//        cmsCheck = PageFactory.initElements(driver,CMSCheck.class);
//    }

//    public TestCase(CMSCheck cmsCheck) {
//        this.cmsCheck = cmsCheck;
//    }

//    public CMSCheck cmscheck(){
//        cmsCheck = PageFactory.initElements(driver,CMSCheck.class);
//        System.out.println("***********"+cmsCheck);
//        return cmsCheck;
//
//    }
    @Test(description = "加载页面元素方法类")
    public  void loadPageclass() throws Exception{
//         cmsCheck = PageFactory.initElements(driver,CMSCheck.class);
//        cmsCheck = (CMSCheck)(PageFactory.initElements(driver,PageElement.class));
    }
    @Test(description = "CMS用户登录")
    public  void checkCmsLogin() throws Exception{
//        cmsCheck = PageFactory.initElements(driver,CMSCheck.class);
//        SingletonDemo1 aaa = SingletonDemo1.getInstance();
//        aaa.cmsLogin(driver,username,passwd);
    }
//    @Test(description = "审核管理-入驻申请-检查电话搜索条件")
//    public  void checkRzsqSearchCityPhone() throws Exception{
////        CMSCheck cmsCheck = PageFactory.initElements(driver,CMSCheck.class);
//        cmsCheck.rzsqSearchCityPhone(driver,username,passwd,"13350143106");
//    }
//    @Test(description = "审核管理-入驻申请-商家类型搜索条件")
//    public  void checkRzsqSearchSeller() throws Exception{
////        CMSCheck cmsCheck = PageFactory.initElements(driver,CMSCheck.class);
////        cmsCheck.rzsqSearchSeller(driver,username,passwd);
//        cmscheck().rzsqSearchSeller(driver,username,passwd);
//        Long end = System.currentTimeMillis();
//        System.out.println("*************"+(end-start));
//    }


}
