package Project_;

import Utilites.BaseDriver;
import Utilites.MyMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task11 extends BaseDriver {
/*

Step 1 – I login as an Admin
Step 2 – I navigate to Admin / User Management page.
Step 3 – I click on Add button
Step 4 – I enter a value in to the Password field which is less than 8 characters
Step 5 – I verify that notification messages “Should have at least 8 characters” in red color displayed.

 */

    @Test
    public void Test11 (){

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        MyMethods.myWait(2);

        WebElement userName = driver.findElement(By.xpath("//*[@name=\"username\"]"));
        userName.sendKeys("Admin");
        MyMethods.myWait(2);

        WebElement password = driver.findElement(By.xpath("//*[@name=\"password\"]"));
        password.sendKeys("admin123");
        MyMethods.myWait(2);

        WebElement login = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        login.click();
        MyMethods.myWait(2);


        driver.findElement(By.xpath("//*[text()='Admin']")).click();

        WebElement AddButtonDisplay = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
AddButtonDisplay.click();

driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys("Cavour");
MyMethods.myWait(2);


WebElement MessageDisplay = driver.findElement(By.xpath("//*[text()='Should have at least 7 characters']"));

MyMethods.myWait(2);

if(MessageDisplay.isDisplayed()){
    System.out.println("MessageDisplay = " + MessageDisplay);
} else {
    System.out.println(" No message displayed ");
}

        Assert.assertTrue(MessageDisplay.isDisplayed());

MyMethods.myWait(1);
driver.quit();


    }
}
