package Project_;

import Utilites.MyMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static Utilites.BaseDriver.driver;
import static Utilites.BaseDriver.waitAndquit;

public class Task3 {
    @Test
    public void TestOne() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        MyMethods.myWait(1);
        WebElement Username = driver.findElement(By.xpath("//*[@name=\"username\"]"));
        Username.sendKeys("Admin");
        MyMethods.myWait(1);
        WebElement Password = driver.findElement(By.xpath("//*[@name=\"password\"]"));
        Password.sendKeys("admin123");

        driver.findElement(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
        MyMethods.myWait(2);

        WebElement UserManagementButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span"));
        UserManagementButton.click();

        WebElement AddButton = driver.findElement(By.xpath("//*[@class=\"oxd-icon bi-plus oxd-button-icon\"]"));
        AddButton.click();


        WebElement saveButton = driver.findElement(By.xpath("//button[text()=\" Save \"]"));
        saveButton.click();

        MyMethods.myWait(2);

        WebElement UserRoleErrorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/span"));
        UserRoleErrorMessage.isDisplayed();

        WebElement EmployeeNameErrorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/span"));
        EmployeeNameErrorMessage.isDisplayed();

        WebElement StatusNameErrorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/span"));
        StatusNameErrorMessage.isDisplayed();

        WebElement UsernameErrorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/span"));
        UsernameErrorMessage.isDisplayed();

        WebElement PassWordErrorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/span"));
        PassWordErrorMessage.isDisplayed();

        WebElement ConfirmPasswordErrorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/span"));
        ConfirmPasswordErrorMessage.isDisplayed();


        Assert.assertEquals(UserRoleErrorMessage.getText(),"Required");
        Assert.assertEquals(EmployeeNameErrorMessage.getText(),"Required");
        Assert.assertEquals(StatusNameErrorMessage.getText(),"Required");
        Assert.assertEquals(UsernameErrorMessage.getText(),"Required");
        Assert.assertEquals(PassWordErrorMessage.getText(),"Required");
        Assert.assertEquals(ConfirmPasswordErrorMessage.getText(),"Required");

        MyMethods.myWait(4);
        waitAndquit();
    }
}
