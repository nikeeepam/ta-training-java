package optional_task1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Task1 {
    @Test
    public void print() throws AWTException {
        Robot robot = new Robot();
        WebDriver webDriver=new EdgeDriver();
//        WebDriver webDriver=new ChromeDriver();
        webDriver.get("https://pastebin.com/");
        webDriver.manage().window().maximize();

        WebElement textArea =  webDriver.findElement(By.id("postform-text"));
        textArea.sendKeys("Hello from WebDriver");

        WebElement expirationDropdown = webDriver.findElement(By.xpath("(//span[@class='select2-selection__arrow'])[3]"));

        expirationDropdown.click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement titleInput = webDriver.findElement(By.id("postform-name"));
        titleInput.sendKeys("helloweb");

        WebElement submitButton = webDriver.findElement(By.cssSelector("button[type=submit]"));

        submitButton.click();

        webDriver.close();


    }
}
