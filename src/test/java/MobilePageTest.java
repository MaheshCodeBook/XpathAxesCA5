import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MobilePageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.get("https://qamobilespecs.ccbp.tech/");

            List<WebElement> ramSpec = driver.findElements(By.xpath("//li[text()='3 GB RAM']/following-sibling::li"));
            ArrayList<String> specList = new ArrayList<String>();

            for (WebElement i : ramSpec){
                String list = i.getText();
                specList.add(list);
            }
            // expected string Array
            String[] expectedArray = {"5.80 Super Retina HD OLED Display","Front Camera 7MP", "Rear Camera 12MP + 12MP", "Apple A11 Bionic Processor", "Battery Capacity 2716mAH"};

            int i;
            for (i=0; i<5; i++){
                if (!expectedArray[i].equals(specList.get(i))){
                    System.out.println("Mismatch Found in Specifications");
                    break;
                }
            }
            if (i == 5){
                System.out.println("Verified Specifications");
            }

            WebElement headingEle = driver.findElement(By.xpath("//li[text()='3 GB RAM']/preceding::h1[@class='details-heading']"));
            String actualHeading = headingEle.getText();
            String expectedHeading = "Specifications:";

            if (actualHeading.equals(expectedHeading)){
                System.out.println("Verified Heading");
            }else {
                System.out.println("Mismatch Found in Heading");
            }
            //finding button element
            WebElement button = driver.findElement(By.xpath("//li[text()='3 GB RAM']/following::button[@class='btn btn-primary']"));
            button.click();
            System.out.println("Button Clicked");

            Thread.sleep(4000);
            driver.quit();

        }catch (Exception e ){
            System.out.println("The Exception is: "+e);
        }
    }
}