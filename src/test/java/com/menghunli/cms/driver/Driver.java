package com.menghunli.cms.driver;

import com.menghunli.cms.listener.ScreenScr;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

//import io.appium.java_client.android.AndroidDriver;

public class Driver {

    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();

    public void setdriver(WebDriver driver) {
        this.driver = driver;
    }

    //截屏
    public void takescreen(String filename) {
        ScreenScr.getScreen((TakesScreenshot) driver, filename);
    }

    /**
     * 通过getDriver()方法可直接调用对应driver，如果两个测试用例分别都创建浏览器driver，同时在TestNG的.xml文件中配置多线程并发执行，
     * 此时两浏览器执行的操作虽然分别在不同线程中，但因为引用的是同一个driver，因此会出现两浏览器相互跳跃操作的情况，
     * 即本该在浏览器1中的操作跳跃到浏览器2中执行，从而报错，解决办法是使用ThreadLocal来保证线程安全
     * 启动driver后，set到ThreadDriver，实际调用时，通过ThreadDriver.get()获取
     */
    public ThreadLocal<WebDriver> ThreadDriver = new ThreadLocal<WebDriver>();
//    public static WebDriver driver = ThreadDriver.get();
    public  static  WebDriver driver;


    /**
     * 指定参数，从testng.xml中获取
     * getDriver()方法不能设置同步，需要同时打开不同浏览器
     */
    @Parameters({"BrowserName", "url"})
    @BeforeClass
    public   void getDriver(String BrowserName, String url) throws MalformedURLException {
//        ThreadDriver = new ThreadLocal<WebDriver>();
        if (BrowserName.equalsIgnoreCase("Chrome") && url.equalsIgnoreCase("http://cms.testenv.menghunli.com/login")) {
            System.out.println(" Executing on 谷歌浏览器下 测试环境cms后台");
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("browserName", BrowserName);
//            capabilities.setCapability("platform", "WINDOWS");
//            capabilities.setCapability("version", "10");
//            capabilities.setCapability("javascriptEnabled", true);
//            capabilities.setCapability("webdriver.chrome.driver",".\\Tools\\chromedriver.exe");
//            capabilities.setCapability("automationName","UiAutomator2");
            System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            ThreadDriver.set(driver);
//            driver = ThreadDriver.get();
//            System.out.println("********************************************"+ThreadDriver.get());
        } else if(BrowserName.equalsIgnoreCase("Firefox") && url.equalsIgnoreCase("http://cms.testenv.menghunli.com/login")) {
            System.out.println(" Executing on 火狐浏览器下 测试环境cms后台");//
            System.setProperty("webdriver.gecko.driver",".\\Tools\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            ThreadDriver.set(driver);
//            driver = ThreadDriver.get();
//            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+ThreadDriver.get());
        }
        /**
         * 需要的同学，可继续添加需要驱动（同时pom.xml中需要引入）
         */
        else {
            throw new IllegalArgumentException("The device Type is Undefined");
        }

    }

    @AfterTest
//    @AfterClass
//    @AfterMethod
    public  synchronized void closeBrowser() {
        System.out.println("@@@@@@@@@@@@@@@@@@@"+ThreadDriver.get());

//        ThreadDriver.get().close();
        ThreadDriver.get().quit();
    }
}
