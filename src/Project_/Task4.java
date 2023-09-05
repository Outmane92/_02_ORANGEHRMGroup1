package Project_;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Utilites.BaseDriver;
import org.junit.Test;

public class Task4 extends BaseDriver {


    @Test
    public void PasswordNotMatching() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userName = driver.findElement(By.xpath("//*[@name=\"username\"]"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//*[@name=\"password\"]"));
        password.sendKeys("admin123");
        WebElement login = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        login.click();

        WebElement adm = driver.findElement(By.linkText("Admin"));
        adm.click();

       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

        WebElement addButton = driver.findElement(By.xpath("//button[@type=\"button\"and contains(@class,\"oxd-button oxd-button--medium\")]//i"));
        addButton.click();

        WebElement passwordFieldForm = driver.findElement(By.xpath("//form/div[2]/div/div[1]/div/div[2]/input"));
        WebElement confirmPasswordFieldForm = driver.findElement(By.xpath("//form/div[2]/div/div[2]/div/div[2]/input"));

        passwordFieldForm.sendKeys("Admin123");
        confirmPasswordFieldForm.sendKeys("Admin321");

       WebElement notificationMessage = driver.findElement(By.xpath("//span[text()='Passwords do not match']"));


        assert notificationMessage.isDisplayed() : "Notification message is not displayed.";
        assert notificationMessage.getText().equals("Passwords do not match") : "Notification message text is incorrect.";


       System.out.println("Test Passed: Password not match notification is displayed.");



    }
}