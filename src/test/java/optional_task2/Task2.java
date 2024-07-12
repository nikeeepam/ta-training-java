package optional_task2;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task2 {

    private static WebElement textArea;
    private static WebElement syntaxHighlitingDropDown;
    private static WebElement syntaxHighlight;
    private static WebElement title;
    private static WebElement pageExpirationDropDown;
    private static WebElement pageExpiration;
    private static WebElement createPasteButton;
    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver=new EdgeDriver();
        driver.get("https://pastebin.com/");
        driver.manage().window().maximize();
        textArea = driver.findElement(By.id("postform-text"));
        textArea.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

        // Select 'Bash' for syntax highlighting
        syntaxHighlitingDropDown = driver.findElement(By.xpath("(//span[@class='select2-selection__arrow'])[2]"));
        syntaxHighlitingDropDown.click();
        syntaxHighlight = driver.findElement(By.xpath("//li[text()='Bash']"));
        syntaxHighlight.click();

        // Set paste expiration to '10 Minutes'
        pageExpirationDropDown = driver.findElement(By.xpath("(//span[@class='select2-selection__arrow'])[3]"));
        pageExpirationDropDown.click();
        pageExpiration = driver.findElement(By.xpath("//li[text()='10 Minutes']"));
        pageExpiration.click();

        // Input the paste name/title
        title = driver.findElement(By.id("postform-name"));
        title.sendKeys(" how to gain dominance among developers");

        // Submit create new paste button
        createPasteButton = driver.findElement(By.xpath("//button[@class='btn -big']"));
        createPasteButton.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bash")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("ol")));
    }



    @Test
    public void testTitle(){
        String actualTitle = driver.findElement(By.tagName("h1")).getText();
        String expectedTitle = "how to gain dominance among developers";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void testSyntax(){
        String actual = driver.findElement(By.linkText("Bash")).getText();
        String expected = "Bash";
        Assert.assertEquals(actual, expected);
//        String actualBash=driver.findElement()
    }

    @Test
    public void testParagraph(){
        String actual = driver.findElement(By.tagName("ol")).getText();
        String expected = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        Assert.assertEquals(actual,expected);
    }

    @AfterClass
    public static void close(){
        driver.close();
    }

}
