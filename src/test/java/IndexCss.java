import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IndexCss {

    WebDriver wd;


    @BeforeMethod
    public void preCondition(){

        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("file:///C:/Users/Cad1/Downloads/index.html");


    }
    @Test
    public void itemTest(){
        WebElement item1 = wd.findElement(By.cssSelector("#nav ul li:first-child"));
        item1.click();
        String item1Text = item1.getText();

        WebElement alert = wd.findElement(By.cssSelector("#alert"));
        String alertText = alert.getText();
//        if(alertText.contains(item1Text)){
//            System.out.println("Passed");
//        }else {
//            System.out.println("Failed");
//        }
//
        Assert.assertTrue(alertText.contains(item1Text));


    }
    @Test
    public void formTest(){
        WebElement name = wd.findElement(By.name("name"));
        name.click();
        name.clear();
        name.sendKeys("Hello");
        WebElement surename = wd.findElement(By.cssSelector("[name = 'surename'"));
        surename.click();
        surename.click();
        surename.sendKeys("Hello");

        wd.findElement(By.cssSelector("button.btn")).click();

        WebElement alert = wd.findElement(By.cssSelector("#alert"));
        String alertText  = alert.getText();
        Assert.assertTrue(alertText.contains("Hello"));

    }

    @Test
    public void tableTest(){
        List<WebElement> rows = wd.findElements(By.cssSelector("#country-table tr"));
        int numberofRows = rows.size();
        System.out.println("Rows in table " + numberofRows);

        List<WebElement> columns = wd.findElements(By.cssSelector("tr:first-child td"));
        System.out.println("Column in table " + columns.size());

        String  text = wd.findElement(By.cssSelector("tr:last-child td:nth-child(2)")).getText();
        //String  text = wd.findElement(By.xpath("//td[.='Chine']")).getText();
        Assert.assertEquals(text, "Chine");
        List<WebElement> lastRow = wd.findElements(By.cssSelector("tr:last-child td"));

        for(WebElement el: lastRow){
            System.out.println(el.getText());
        }
        System.out.println();
        List<WebElement> lastColumn = wd.findElements(By.cssSelector("td:last-child"));
        for(WebElement elC: lastColumn){
            System.out.println(elC.getText());
        }

    }


    @AfterMethod
    public void postCondition(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wd.close();
    }

}
