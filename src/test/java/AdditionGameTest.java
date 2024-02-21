import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AdditionGameTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qaadditiongame.ccbp.tech/");

            WebElement element1 = driver.findElement(By.xpath("//input[@id='userInput']/preceding-sibling::span[4]"));
            WebElement element2 = driver.findElement(By.xpath("//input[@id='userInput']/preceding-sibling::span[2]"));

            String a = element1.getText();
            String b = element2.getText();

            //converting String to Int
            int val1 = Integer.parseInt(a);
            int val2 = Integer.parseInt(b);

            //sum of 2 random inputs
            int sum = val1+val2;

            //converting Int to String
            String sumString = String.valueOf(sum);


            WebElement inputField = driver.findElement(By.xpath("//input[@id='userInput']"));
            inputField.sendKeys(sumString);

            //finding check button element
            WebElement checkButton = driver.findElement(By.xpath("//input[@id='userInput']/following::button[@id='checkButton']"));
            WebElement restartButton = driver.findElement(By.xpath("//input[@id='userInput']/following::button[@id='restartButton']"));

            checkButton.click();

            WebElement resultStatus = driver.findElement(By.xpath("//input[@id='userInput']/following-sibling::p"));
            String result = resultStatus.getText();
            String expectedResult = "Congratulations! You got it right.";
            if (result.equals(expectedResult)){
                System.out.println("Success Case Checked");
            }else{
                System.out.println("Error at Success Case");
            }

            restartButton.click();

            String aa = element1.getText();
            String bb = element2.getText();

            //converting String to Int
            int val11 = Integer.parseInt(aa);
            int val22 = Integer.parseInt(bb);

            //sum of 2 random inputs
            int sum2 = val11-val22;

            //converting Int to String
            String sumString2 = String.valueOf(sum2);
            inputField.sendKeys(sumString2);

            checkButton.click();

            String result2 = resultStatus.getText();
            String expectedResult2 = "Please Try Again!";
            if (result2.equals(expectedResult2)){
                System.out.println("Failure Case Checked");
            }else{
                System.out.println("Error at Failure Case");
            }



            //In both the above cases, if application is working good, print "Addition Game Working as Expected".

            Thread.sleep(4000);
            driver.quit();

        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
