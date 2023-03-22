import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class STCTV {



    WebDriver driver = null;

    @BeforeMethod
    public void openBrowser() throws InterruptedException {

        String chrompath =System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chrompath);
        driver = new ChromeDriver();
        driver.navigate().to("https://www.stctv.com/sa-en");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }


    @Test
    public void Subscribe_KSA() throws InterruptedException {
        driver.findElement(By.className("country-current")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("sa")).click(); // KSA Country
        Thread.sleep(3000);
        driver.findElement(By.id("email-mobile")).sendKeys("1270668447");
        Thread.sleep(3000);
        driver.findElement(By.id("cta-label")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("translation-btn")).click();
        Thread.sleep(3000);
        String expectedresult1 = "CLASSIC"; // Check for Type
        String actualresult1 = driver.findElement(By.className("trial-description")).getText();
        Assert.assertTrue(actualresult1.contains(expectedresult1));
        String expectedresult2 = "7.00"; //Check for Price
        String actualresult2 = driver.findElement(By.className("trial-cost")).getText();
        Assert.assertTrue(actualresult2.contains(expectedresult2));
        String expectedresult0 = " Egyptian pound/month"; //Check for Currency
        String actualresult0= driver.findElement(By.className("trial-cost")).getText();
        Assert.assertTrue(actualresult0.contains(expectedresult0));







    }
    @Test
    public void Subscribe_Bahrain() throws InterruptedException {
        driver.findElement(By.className("country-current")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("bh")); //Bahrain Country
        Thread.sleep(3000);
        driver.findElement(By.id("email-mobile")).sendKeys("1270668447");
        Thread.sleep(3000);
        driver.findElement(By.id("sub_form"));
        Thread.sleep(3000);
        String expectedresult3 = "Classic";  // Check for Type
        String actualresult3 = driver.findElement(By.id("name-classic")).getText();
        Assert.assertTrue(actualresult3.contains(expectedresult3));
        String expectedresult4 = "3";  //Check for Price
        String actualresult4 = driver.findElement(By.className("price")).getText();
        Assert.assertTrue(actualresult4.contains(expectedresult4));
        String expectedresult5 = "BHD"; //Check for Currency
        String actualresult5 = driver.findElement(By.className("price")).getText();
        Assert.assertTrue(actualresult5.contains(expectedresult5));



    }

    @Test
    public void Subscribe_Kuawit() throws InterruptedException {
        driver.findElement(By.className("country-current")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("kw")); // Kuwait Country
        Thread.sleep(3000);
        driver.findElement(By.id("email-mobile")).sendKeys("1270668447");
        driver.findElement(By.id("sub_form"));
        Thread.sleep(3000);
        String expectedresult6 = "Classic";  //Check for Type
        String actualresult6 = driver.findElement(By.id("name-classic")).getText();
        Assert.assertTrue(actualresult6.contains(expectedresult6));
        String expectedresult7 = "2.5"; // Check for price
        String actualresult7 = driver.findElement(By.className("price")).getText();
        Assert.assertTrue(actualresult7.contains(expectedresult7));
        String expectedresult8 = "KWD"; //Check for Currency
        String actualresult8 = driver.findElement(By.className("price")).getText();
        Assert.assertTrue(actualresult8.contains(expectedresult8));





    }

    @AfterTest
    public void closedriver() throws InterruptedException {

        Thread.sleep(10000);

        driver.close();
    }


}
