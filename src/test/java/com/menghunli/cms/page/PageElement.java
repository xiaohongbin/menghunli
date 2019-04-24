package com.menghunli.cms.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class PageElement {
    //登录页面元素
    @FindBy(xpath="html/body/div/div/section/div/input[1]")
    @CacheLookup
    public WebElement input_username;

    @FindBy(xpath="html/body/div/div/section/div/input[2]")
    @CacheLookup
    public WebElement input_passwd;

    @FindBy(xpath="html/body/div/div/section/div/span")
    @CacheLookup
    public WebElement queren;
    @FindBy(className = "modify")
    @CacheLookup
    public WebElement modify;
    @FindBy(className="login")
    @CacheLookup
    public WebElement login;
    /**
     * 审核管理模块元素
     */
    //入驻申请，搜索条件元素
    @FindBy(xpath="/html/body/div/div/div[2]/ul/li[1]/span")
    @CacheLookup
    public WebElement shgl;
    @FindBy(xpath="html/body/div/div/div[2]/ul/li[1]/ul/li[1]/span/a")
    @CacheLookup
    public WebElement rzsq;
    @FindBy(className="city")
    @CacheLookup
    public WebElement city;
    @FindBy(className="search")
    @CacheLookup
    public WebElement search;
    @FindBy(className="blue_button")
    @CacheLookup
    public WebElement blue_button;
    @FindBy(xpath="html/body/div/div/div[4]/div/div[2]/nav/ul/li[2]/span[3]")
    @CacheLookup
    public WebElement phone_result;
    @FindBy(className="input")
    public WebElement shengqingDate;
    @FindBy(xpath="html/body/div/div/div[4]/div/div[1]/div[2]/div/div[2]/div[5]/ul[2]/li[22]/div/span")
    public WebElement shiba;
    @FindBy(className = "cancel-btn")
    public WebElement cancel_btn;
    //搜索结果,相对路径，双斜杠开头
    @FindBy(xpath="//div[4]/div/div[2]/nav/ul/li[2]/span[7]")
    public WebElement shibas;
    @FindBy(xpath="//li[2]/span[4]")
    public WebElement seller_result;
    @FindBy(xpath="//li[2]/span[9]")
    public WebElement approver_result;
    //入驻申请，按照商家类型搜索元素
    @FindBy(className="seller-select")
    @CacheLookup
    public WebElement seller_select;
    @FindBy(xpath="//li[2]/span[5]")
    @CacheLookup
    public WebElement seller_select_result;






}
