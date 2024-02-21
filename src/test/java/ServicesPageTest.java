import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.synth.SynthStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ServicesPageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qaservicesect.ccbp.tech/");

            // verifying the titles
            List<WebElement> titles = driver.findElements(By.xpath("//h1[text()='Online Support 24/7']/ancestor::div[2]/preceding::h1[@class='services-card-title']"));
            ArrayList<String> arrayTitles = new ArrayList<String>();

            for (WebElement i : titles){
                String twoTiles = i.getText();
                arrayTitles.add(twoTiles);
            }

            String[] expectedArrayList = {"Fast and Free Delivery", "100% Money back guarantee"};
            int i;
            for (i=0; i<2; i++){
                if (!expectedArrayList[i].equals(arrayTitles.get(i))){
                    System.out.println("Mismatch Found in Titles");
                    break;
                }
            }
            if(i == 2){
                System.out.println("Titles Checked");
            }

            // verifying the description
            List<WebElement> description = driver.findElements(By.xpath("//h1[text()='Online Support 24/7']/ancestor::div[2]/preceding::p[@class='services-card-description']"));
            ArrayList<String> arrayDescription = new ArrayList<String>();

            for (WebElement des : description){
                String twoDescri = des.getText();
                arrayDescription.add(twoDescri);
            }

            String[] expectedArrayListDescrip = {"Fast, free, and convenient delivery choices on millions of items.", "This is probably the most popular guarantee in the world."};
            for (i=0; i<2; i++){
                if (!expectedArrayListDescrip[i].equals(arrayDescription.get(i))){
                    System.out.println("Mismatch Found in Descriptions");
                    break;
                }
            }
            if(i == 2){
                System.out.println("Descriptions Checked");
            }

            //verifying Heading and description
            List<WebElement> headingDescrip = driver.findElements(By.xpath("//h1[text()='Online Support 24/7']/ancestor::div[2]/preceding::div[5]/child::*"));
            ArrayList<String> arrayheadingDescrip = new ArrayList<String>();

            for (WebElement headDes : headingDescrip){
                String hd = headDes.getText();
                arrayheadingDescrip.add(hd);
            }

            String[] expectedArrayHeadDescrip = {"Our Services","Most online stores offer lower prices. Online shopping makes price comparison simpler and quicker. It is very convenient to shop from where you are located. It saves you the cost of driving to stores, as well as parking fees."};
            for (i=0; i<2; i++){
                if (!expectedArrayHeadDescrip[i].equals(arrayheadingDescrip.get(i))){
                    System.out.println("Mismatch Found in Section Header");
                    break;

                }
            }
            if(i == 2){
                System.out.println("Section Header Checked");
            }


            Thread.sleep(4000);
            driver.quit();

        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
