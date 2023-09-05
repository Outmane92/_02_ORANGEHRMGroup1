package Project_;
import Utilites.BaseDriver;
import Utilites.MyMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Task1 extends BaseDriver {

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

        WebElement userRole = driver.findElement(By.xpath("(//div[@tabindex=\"0\"])[1]"));
        Actions actions1 = new Actions(driver);
        Action action = actions1.click(userRole).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).release().build();
        action.perform();

        WebElement status = driver.findElement(By.xpath("(//div[@tabindex=\"0\"])[2]"));
        Action actionStatus = actions1.click(status).keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build();
        actionStatus.perform();

        WebElement employeeName = driver.findElement(By.cssSelector("input[placeholder=\"Type for hints...\"]"));
        Action actionEmployee = actions1.click(employeeName).sendKeys("Li").build();
        actionEmployee.perform();

        MyMethods.myWait(4);

        actionEmployee = actions1.sendKeys(Keys.ARROW_DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build();
        actionEmployee.perform();

        WebElement userNameNew = driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])[1]"));
        String newUserName = "NjxNjx";
        userNameNew.sendKeys(newUserName);

        WebElement passwordNew = driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])[2]"));
        String newPassword = "NoxNox123";
        passwordNew.sendKeys(newPassword);

        WebElement confirmPassword = driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])[3]"));
        confirmPassword.sendKeys(newPassword);

        WebElement saveButton = driver.findElement(By.xpath("//button[text()=\" Save \"]"));
        saveButton.click();

        MyMethods.myWait(2);

        WebElement checkUserName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
        checkUserName.sendKeys(newUserName);

        WebElement userRoleCheck = driver.findElement(By.xpath("(//div[@tabindex=\"0\"])[1]"));
        Actions actions2 = new Actions(driver);
        Action action1 = actions2.click(userRoleCheck).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).release().build();
        action1.perform();


        WebElement SearchButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
        SearchButton.click();
        MyMethods.myWait(3);

        WebElement UserNameCheck = driver.findElement(By.xpath("//div[text()=\"NjxNjx\"]"));
        UserNameCheck.isDisplayed();


        Assert.assertEquals(UserNameCheck.getText(),newUserName);

        WebElement DeleteUserNameButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[1]/div/label/span/i"));
        DeleteUserNameButton.click();

        WebElement DeleteButton = driver.findElement(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin\"]"));
        DeleteButton.click();

        WebElement DeleteButton1 = driver.findElement(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]"));
        DeleteButton1.click();



        MyMethods.myWait(4);
//        waitAndquit();
    }
}
