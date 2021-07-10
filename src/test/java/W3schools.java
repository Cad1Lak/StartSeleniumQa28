import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class W3schools {

    WebDriver wd;

    @BeforeMethod
    public void precondition(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }
    @Test
    public void w3schoolTest(){
            //numbers of rows
        List<WebElement> rows = wd.findElements(By.cssSelector("#customers tr"));
        int numbOfRows = rows.size();
        System.out.println("Number of rows is: " + numbOfRows);

            //numbers of columns
        List<WebElement> columns = wd.findElements(By.cssSelector("tr:first-child th"));
        int numberOfColumns = columns.size();
        System.out.println("Number of columns is: " + numberOfColumns);

            //print rows 3
        List<WebElement> printRow3 = wd.findElements(By.cssSelector("tr:nth-child(3) td"));
        for(WebElement web:printRow3){
            System.out.println("Row 3: " + web.getText());
        }

            //print lastColumns
        List<WebElement> lastColumn = wd.findElements(By.cssSelector("td:last-child"));
        for(WebElement web: lastColumn){
            System.out.println("Last column: " + web.getText());
        }

            //print Maria
        WebElement web = wd.findElement(By.cssSelector("tr:nth-child(2) td:nth-child(2)"));
        System.out.println(web.getText());
    }

    @AfterMethod
    public void postcondition() throws InterruptedException {
        Thread.sleep(3000);
        wd.close();
    }

}
