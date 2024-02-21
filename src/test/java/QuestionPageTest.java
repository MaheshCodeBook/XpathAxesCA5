import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuestionPageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qaquestion.ccbp.tech/");

            WebElement qaText = driver.findElement(By.xpath("//form[@id='questionsForm']/child::h1"));
            String actualQA = qaText.getText();
            String expectedQA = "What is the capital of India?";
            if(actualQA.equals(expectedQA)){
                System.out.println("Question Checked");
            }else{
                System.out.println("Mismatch Found in Question");

            }

            WebElement submitButton = driver.findElement(By.xpath("//form[@id='questionsForm']/child::div[2]/button"));
            submitButton.click();

            WebElement plsSelectText = driver.findElement(By.xpath("//form[@id='questionsForm']/child::div[2]/p"));
            String text = plsSelectText.getText();
            String expectedText = "Please select the City!";
            if (text.equals(expectedText)){
                System.out.println("Missing Option Case Checked");
            }else{
                System.out.println("Error Occured for Missing Option Case");

            }

            WebElement radioButton1 = driver.findElement(By.xpath("//form[@id='questionsForm']/descendant::input[@value='Hyderabad']"));
            WebElement radioButton2 = driver.findElement(By.xpath("//form[@id='questionsForm']/descendant::input[@value='Chennai']"));
            WebElement radioButton3 = driver.findElement(By.xpath("//form[@id='questionsForm']/descendant::input[@value='Delhi']"));
            WebElement radioButton4 = driver.findElement(By.xpath("//form[@id='questionsForm']/descendant::input[@value='Mumbai']"));

            radioButton1.click();
            submitButton.click();

            WebElement resultText = driver.findElement(By.xpath("//form[@id='questionsForm']/descendant::p"));
            String actualResult = resultText.getText();
            String expectedResult = "Correct Answer!";
            if (actualResult.equals(expectedResult)){
                System.out.println("Correct Answer!");
            }else{
                System.out.println("Wrong Answer!");
            }

            radioButton2.click();
            submitButton.click();

            resultText = driver.findElement(By.xpath("//form[@id='questionsForm']/descendant::p"));
            actualResult = resultText.getText();
            expectedResult = "Correct Answer!";
            if (actualResult.equals(expectedResult)){
                System.out.println("Correct Answer!");
            }else{
                System.out.println("Wrong Answer!");
            }

            radioButton3.click();
            submitButton.click();

            resultText = driver.findElement(By.xpath("//form[@id='questionsForm']/descendant::p"));
            actualResult = resultText.getText();
            expectedResult = "Correct Answer!";
            if (actualResult.equals(expectedResult)){
                System.out.println("Correct Answer!");
            }else{
                System.out.println("Wrong Answer!");
            }

            radioButton4.click();
            submitButton.click();

            resultText = driver.findElement(By.xpath("//form[@id='questionsForm']/descendant::p"));
            actualResult = resultText.getText();
            expectedResult = "Correct Answer!";
            if (actualResult.equals(expectedResult)){
                System.out.println("Correct Answer!");
            }else{
                System.out.println("Wrong Answer!");
            }


            Thread.sleep(4000);
            driver.quit();

        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
