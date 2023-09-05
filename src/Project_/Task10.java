package Project_;

import Utilites.BaseDriver;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Task10 extends BaseDriver {



    @Test
    public void AdduserDisplay(){

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

        WebElement AddUser = driver.findElement(By.xpath("//h6[text()='Add User']"));

        assert AddUser.isDisplayed() ;
        System.out.println("The 'Add User' heading is displayed.");
//        if (AddUser.isDisplayed()) {
//            System.out.println("The 'Add User' heading is displayed.");
//        } else {
//            System.out.println("The 'Add User' heading is not displayed.");
//        }
    }
    }

