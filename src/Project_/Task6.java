package Project_;

import Utilites.BaseDriver;
import Utilites.MyMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task6 extends BaseDriver {

    @Test
    void test6(){

            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            WebElement userName = driver.findElement(By.xpath("//*[@name=\"username\"]"));
            userName.sendKeys("Admin");

            WebElement password = driver.findElement(By.xpath("//*[@name=\"password\"]"));
            password.sendKeys("admin123");

            WebElement login = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
            login.click();

            driver.findElement(By.xpath("//*[text()='Admin']")).click();

            WebElement addButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
            addButton.click();

            MyMethods.myWait(2);

            WebElement userNameNew = driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])[1]"));
            userNameNew.sendKeys("1234");

            WebElement errMessage = driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])[1]/.. /following-sibling::span"));

            Assert.assertTrue(errMessage.isDisplayed());

            driver.quit();
    }
}
