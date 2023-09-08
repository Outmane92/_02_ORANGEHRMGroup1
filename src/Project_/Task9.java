package Project_;

import Utilites.BaseDriver;
import Utilites.MyMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task9 extends BaseDriver {

    @Test
    void test9(){
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

        WebElement userRole = driver.findElement(By.xpath("(//div[@tabindex=\"0\"])[1]"));
        WebElement status = driver.findElement(By.xpath("(//div[@tabindex=\"0\"])[2]"));
        WebElement employeeName = driver.findElement(By.cssSelector("input[placeholder=\"Type for hints...\"]"));
        WebElement userNameNew = driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])[1]"));
        WebElement passwordNew = driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])[2]"));
        WebElement confirmpassword = driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])[3]"));
        WebElement cancelButton = driver.findElement(By.xpath("(//button[@type=\"button\"])[3]"));
        WebElement saveButton = driver.findElement(By.xpath("(//button[@type=\"submit\"])"));

        Assert.assertTrue(userRole.isDisplayed(),"userrole is not displayed");
        Assert.assertTrue(status.isDisplayed(),"status is not displayed");
        Assert.assertTrue(employeeName.isDisplayed(),"employeename is not displayed");
        Assert.assertTrue(userNameNew.isDisplayed(),"username is not displayed");
        Assert.assertTrue(passwordNew.isDisplayed(),"password is not displayed");
        Assert.assertTrue(confirmpassword.isDisplayed(),"confirm password is not displayed");
        Assert.assertTrue(cancelButton.isDisplayed(),"cancel button is not displayed");
        Assert.assertTrue(saveButton.isDisplayed(),"save button is not displayed");

        driver.quit();


    }
}
