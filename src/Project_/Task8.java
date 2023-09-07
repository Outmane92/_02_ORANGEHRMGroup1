package Project_;

import Utilites.BaseDriver;
import Utilites.MyMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task8 extends BaseDriver {


@Test
    public void Test8(){

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
MyMethods.myWait(1);

//if(AddButtonDisplay.isDisplayed()){
//    System.out.println("the add button is displayed ");
//
//} else {
//    System.out.println("nooo ");
//}

    Assert.assertTrue(AddButtonDisplay.isDisplayed());
    MyMethods.myWait(2);
driver.quit();




}






}
