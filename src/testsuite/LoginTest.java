package testsuite;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm/";

    @Before

    public void setUp() {
         openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter valid username
        sendTextToElement(By.name("username"),"Abc1234");

        // Enter valid password
        sendTextToElement(By.name("password"),"Xyz1234");

        // Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value='Log In']"));

        // Verify the ‘Accounts Overview’ text is display
        //Expected message
        String expectMessage ="Accounts Overview";

        //Find the welcome text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//a[contains(text(),'Accounts Overview')]"));
        String actualMessage = actualTextMessageElement.getText();

        // Validate actual and expected message
        Assert.assertEquals("No such message displayed", expectMessage, actualMessage);
    }
    @Test
    public void verifyTheErrorMessage() {
        //Enter invalid username
        sendTextToElement(By.name("username"),"Abc123456");
        //Enter invalid password
        sendTextToElement(By.name("password"),"Xyz123456");
        //Click on Login button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //Verify the error message ‘The username and password could not be verified.’
        //Expected message
        String expectMessage ="Accounts Overview";
        //Find the welcome text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//a[contains(text(),'Accounts Overview')]"));
        String actualMessage = actualTextMessageElement.getText();
        // Validate actual and expected message
        Assert.assertEquals("No such message displayed", expectMessage, actualMessage);

    }
    @Test
    public void userShouldLogOutSuccessfully() {
        // Enter valid username
        sendTextToElement(By.name("username"),"Abc1234");

        //Enter valid password
        sendTextToElement(By.name("password"),"Xyz1234");

        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value='Log In']"));

        //Click on ‘Log Out’ link
        clickOnElement(By.xpath(" "));
        // Verify the text ‘Customer Login’
        String expectMessage ="Customer Login";
        //Find the welcome text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath(""));
        String actualMessage = actualTextMessageElement.getText();
        // Validate actual and expected message
        Assert.assertEquals("No such message displayed", expectMessage, actualMessage);

    }
    @After
    public void tearDown() {

        closeBrowser();
    }
}
