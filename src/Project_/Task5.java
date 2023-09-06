package Project_;

import Utilites.BaseDriver;
import Utilites.MyMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task5 extends BaseDriver {

    /*

    As an Admin user I should be able to see notification messages displayed, when I enter an invalid Admin name in to the Employee name field.
Step 1 – I login as an Admin
Step 2 – I navigate to Admin / User Management page.
Step 3 – I click on Add button
Step 4 – I enter an invalid name in to the Employee name field
Step 5 – I verify that notification messages “no records found” and “invalid” in red color displayed.


    */
    @Test
    public void  Test5(){


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

        MyMethods.myWait(3);


        driver.findElement(By.xpath("//*[@placeholder='Type for hints...']")).sendKeys("testing");

WebElement NoRecordFound = driver.findElement(By.xpath("//*[text()='No Records Found']"));
        MyMethods.myWait(2);

        if(NoRecordFound.isDisplayed()){
            System.out.println("NoRecordFound = " + NoRecordFound);
        } else {
            System.out.println(" No message displayed ");
        }
        MyMethods.myWait(2);
        Assert.assertTrue(NoRecordFound.isDisplayed());

        MyMethods.myWait(2);
        driver.findElement(By.xpath("//*[text()='Add User']")).click();

 MyMethods.myWait(2);

 WebElement InvalidDisplayed = driver.findElement(By.xpath("//*[text()='Invalid']"));

        MyMethods.myWait(2);

        if(InvalidDisplayed.isDisplayed()){
            System.out.println("InvalidDisplayed = " + InvalidDisplayed);
        } else {
            System.out.println(" No message displayed ");
        }
        MyMethods.myWait(2);
        Assert.assertTrue(InvalidDisplayed.isDisplayed());

        MyMethods.myWait(3);
        driver.quit();
























// //*[text()='No Records Found']
        // //*[text()='Invalid']
        // //*[@placeholder='Type for hints...']
    }
}
