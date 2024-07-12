package optional_task3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;

public class Task3 {
    @Test
    public void print() throws InterruptedException, AWTException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://cloud.google.com/products/calculator");

        driver.findElement(By.xpath("//button//*[text()='Add to estimate']")).click();

        driver.findElement(By.xpath("//h2[text()='Compute Engine'][contains(@class,'honxjf')]")).click();

        for (int i=0;i<3;i++)
            driver.findElement(By.xpath("(//button[@class='wX4xVc-Bz112c-LgbsSe CXjg4d'])[2]")).click();

        //operating system
        driver.findElement(By.xpath("(//div[@class='VfPpkd-aPP78e'])[4]")).click();
        Thread.sleep(500L);
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);



        driver.findElement(By.xpath("(//label[normalize-space()='Regular'])[1]")).click();
        Thread.sleep(1000L);


        //MACHINE FAMILY
        driver.findElement(By.xpath("(//div[@class='VfPpkd-aPP78e'])[5]")).click();
        Thread.sleep(100L);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //SERIES
        driver.findElement(By.xpath("(//div[@class='VfPpkd-aPP78e'])[6]")).click();
        Thread.sleep(100L);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //machine type
        driver.findElement(By.xpath("(//div[@class='VfPpkd-aPP78e'])[7]")).click();
        Thread.sleep(500L);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //gpu click
        driver.findElement(By.xpath("(//span[@class='eBlXUe-hywKDc'])[6]")).click();
        Thread.sleep(500L);

        //cpu model
        driver.findElement(By.xpath("(//div[@class='VfPpkd-aPP78e'])[8]")).click();
        Thread.sleep(500L);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        //no of cpus
        driver.findElement(By.xpath("(//div[@class='VfPpkd-aPP78e'])[9]")).click();
        Thread.sleep(500L);


        driver.findElement(By.xpath("(//div[@class='VfPpkd-aPP78e'])[10]")).click();
        Thread.sleep(500L);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        driver.findElement(By.xpath("(//div[@class='VfPpkd-aPP78e'])[11]")).click();
        Thread.sleep(500L);

        for(int i=0;i<4;i++)
        {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
        //1 year
        driver.findElement(By.xpath("(//label[normalize-space()='1 year'])[1]")).click();
        Thread.sleep(5000L);

        //start
        driver.findElement(By.xpath("//span[@class='FOBRw-RLmnJb']")).click();
        Thread.sleep(5000L);

        //open estimated summary
        driver.findElement(By.xpath("//a[text()='Open estimate summary']")).click();
        Thread.sleep(3000L);

        //switching

        ArrayList<String> list=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(1));

        //step4
        //checking no of instances
        Thread.sleep(2000);
        // checking number of instances
        String expectedNumberOfInstances = "4";
        String actualNumberOfInstances = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[7]/span/span[1]/span[2]")).getText();
        Assert.assertEquals( expectedNumberOfInstances , actualNumberOfInstances );


        // checking number of instances
        String expectedOperatingSystem = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
        String actualOperatingSystem = driver.findElement(By.xpath("(//span[@class='Kfvdz'])[11]")).getText() ;
        Assert.assertEquals( expectedOperatingSystem , actualOperatingSystem);

        // checking provisioning model
        String expectedProvisioningModel = "Regular";
        String actualProvisioningModel = driver.findElement(By.xpath("(//span[@class='Kfvdz'])[12]")).getText() ;
        Assert.assertEquals(expectedProvisioningModel, actualProvisioningModel);

        // checking machine type
        String expectedMachineType = "n1-standard-8, vCPUs: 8, RAM: 30 GB";
        String actualMachineType = driver.findElement(By.xpath("(//span[@class='Kfvdz'])[3]")).getText() ;
        Assert.assertEquals(expectedMachineType, actualMachineType);

        // checking Select GPU Toggle
        String expectedGpuToggle = "true";
        String actualGpuToggle = driver.findElement(By.xpath("(//span[@class='Kfvdz'])[16]")).getText() ;
        Assert.assertEquals(expectedGpuToggle, actualGpuToggle);

        // checking Gpu Type
        String expectedGpuType = "NVIDIA V100";
        String actualGpuType = driver.findElement(By.xpath("(//span[@class='Kfvdz'])[5]")).getText() ;
        Assert.assertEquals(expectedGpuType, actualGpuType);

        // checking Number of Gpus
        String expectedNumberOfGpus = "1";
        String actualNumberOfGpus = driver.findElement(By.xpath("(//span[@class='Kfvdz'])[6]")).getText() ;
        Assert.assertEquals(expectedNumberOfGpus, actualNumberOfGpus);

        // checking Local SSD
        String expectedLocalSsd = "2x375 GB";
        String actualLocalSsd = driver.findElement(By.xpath("(//span[@class='Kfvdz'])[7]")).getText() ;
        Assert.assertEquals(expectedLocalSsd, actualLocalSsd);

        // checking Region
        String expectedRegion = "Netherlands (europe-west4)";
        String actualRegion = driver.findElement(By.xpath("(//span[@class='Kfvdz'])[18]")).getText() ;
        Assert.assertEquals(expectedRegion, actualRegion);

        // checking Commited use discount options
        String expectedCommitedUse = "1 year";
        String actualCommitedUse = driver.findElement(By.xpath("(//span[@class='Kfvdz'])[19]")).getText() ;
        Assert.assertEquals(expectedCommitedUse, actualCommitedUse);


        driver.quit();

    }
}
