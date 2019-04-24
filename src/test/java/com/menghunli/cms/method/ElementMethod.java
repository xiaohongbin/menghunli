package com.menghunli.cms.method;

import com.aventstack.extentreports.ExtentTest;
import com.menghunli.cms.listener.ExtentTestNGITestListener;
import com.menghunli.cms.page.PageElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementMethod extends PageElement {
    ExtentTestNGITestListener el = new ExtentTestNGITestListener();
    ExtentTest log = el.getlog();
    public void sendUsername(String username){
        log.info("输入用户名");
        input_username.click();
        input_username.clear();
        input_username.sendKeys(username);
    }
    public void sendPasswd(String passwd){
        log.info("输入密码");
        input_passwd.click();
        input_passwd.clear();
        input_passwd.sendKeys(passwd);
    }
    public void clickBtnOK(){
        log.info("点击确定按钮");
        queren.click();
    }

    public void clickShgl(){
        log.info("点击审核管理");
        shgl.click();
    }
    public void clickRzsq(){
        log.info("点击审核管理-入驻申请");
        rzsq.click();
    }
    public void clickCity(){
        log.info("点击搜索条件");
        city.click();
    }
    public void selectCityPhone(){
        log.info("选择联系人电话");
        Select downlist = new Select(city);
        downlist.selectByValue("1");
    }
    public void selectApprover(){
        log.info("选择处理人");
        Select downlist = new Select(city);
        downlist.selectByValue("2");
    }
    public void sendSellerName(String sellername){
        log.info("搜索条件输入指定商家名称");
        search.click();
        search.clear();
        search.sendKeys(sellername);
    }
    public void sendAppover(String approver){
        log.info("搜索条件输入搜索内容");
        search.click();
        search.clear();
        search.sendKeys(approver);
    }

    public void sendPhone(String phone){
        log.info("搜索条件输入电话");
        search.click();
        search.clear();
        search.sendKeys(phone);
    }
    public void clickSearchBtn(){
        log.info("点击搜索按钮");
        blue_button.click();
    }
    public String getPhoneResultText(){
        log.info("获取搜索结果列表电话文本");
        return phone_result.getText();
    }
    public String getSellerResultText(){
        log.info("获取搜索结果列表商家文本");
        return seller_result.getText();
    }
    public String getApproverResultText(){
        log.info("获取搜索结果列表处理人文本");
        return approver_result.getText();
    }

    public void clickShenQingDate(){
        log.info("点击申请时间");
        shengqingDate.click();
    }
    public void sendBeginDate(String date){
        log.info("输入开始日期");
        shengqingDate.sendKeys(date);

    }
    public void clickShiba(){
        log.info("点击18号");
        shiba.click();
    }
    public void clickCanceDate(){
        log.info("取消选中的日期");
        cancel_btn.click();
    }
    public String getShibasInfo(){
        log.info("获取搜索结果日期文本");
        return shibas.getText();
    }
    public void clickSellerSelect(){
        log.info("商家类型，点击 全部");
        seller_select.click();
    }
    public String selectSeller(String value){
        log.info("商家类型，选择一种商家");
        Select downlist = new Select(seller_select);
        switch(value){
            case "1":
                log.info("选择 婚礼策划 类商家");
                downlist.selectByValue("1");
                return "婚礼策划";
//                break;
            case "2":
                log.info("选择 婚礼场地 类商家");
                downlist.selectByValue("2");
                return "婚礼场地";
//                break;
            case "3":
                log.info("选择 婚礼主持 类商家");
                downlist.selectByValue("3");
                return "婚礼主持";
//                break;
            case "4":
                log.info("选择 婚礼摄影 类商家");
                downlist.selectByValue("4");
                return "婚礼摄影";
//                break;
            default:
                log.info("默认选中全部");
                downlist.selectByValue("null");
                return "全部";

        }
    }
    public String getSellerSelectResultInfo(){
        log.info("获取按照商家类型搜索条件，搜索结果店铺类别");
        return seller_select_result.getText();
    }




    public void waitElement(WebDriver driver, WebElement webelement) throws Exception {
//        try{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webelement));
//        }catch (Exception e){
//            log.info("报错信息！元素："+webelement+" 没有找到");
//            e.printStackTrace();
//        }

    }
    //    通用判断元素是否存在
    public boolean doesWebElementExist(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    //滑动鼠标到指定元素
    public void moveToElement(WebDriver driver,WebElement webElement){
        log.info("移动鼠标到元素"+webElement);
        Actions action=new Actions(driver);
        action.moveToElement(webElement).perform();
    }
    //操作网页前进、后退、刷新
    public void refresh(WebDriver driver){
        log.info("刷新当前页面");
        driver.navigate().refresh();
    }
    public void back(WebDriver driver){
        log.info("回退到上一页面");
        driver.navigate().back();
    }
    public void forward(WebDriver driver){
        log.info("前进到上一页面");
        driver.navigate().forward();
    }
}
