package testsuite;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm/";

    @Before

    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        // click on register link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        // expected string
        String expectMessage = "Signing up is easy!";

        //Find the welcome text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[text()='Signing up is easy!']"));
        String actualMessage = actualTextMessageElement.getText();

        // Validate actual and expected message
        Assert.assertEquals("No such message displayed", expectMessage, actualMessage);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //Enter First name
        sendTextToElement(By.name("customer.firstName"), "Abc");
        // Enter Last name
        sendTextToElement(By.name("customer.lastName"), "Xyz");
        //Enter Address
        sendTextToElement(By.id("customer.address.street"), "Flat 1, London");
        //Enter City
        sendTextToElement(By.id("customer.address.city"), "Pinner");
        // Enter State
        sendTextToElement(By.id("customer.address.state"), "United Kingdom");
        // Enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"), "H121");
        // Enter Phone
        sendTextToElement(By.id("customer.phoneNumber"), "12345678900");
        // Enter SSN
        sendTextToElement(By.id("customer.ssn"), "23420145622");
        // Enter Username
        sendTextToElement(By.id("customer.username"), "Abc1234");
        // Enter Password
        sendTextToElement(By.id("customer.password"), "Xyz1234");
        // Enter Confirm
        sendTextToElement(By.id("repeatedPassword"), "Xyz1234");
        // Click on register
        clickOnElement(By.xpath("//input[@value='Register']"));


        //Expected message

        String expectMessage = "Your account was created successfully. You are now logged in.";
        //Find the welcome text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));
        String actualMessage = actualTextMessageElement.getText();

        // Validate actual and expected message
        Assert.assertEquals("No such message displayed", expectMessage, actualMessage);

    }

    @After
    public void tearDown() {

        closeBrowser();
    }
}
