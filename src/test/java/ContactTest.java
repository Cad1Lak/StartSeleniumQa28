import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactTest {
    WebDriver wd;

    @BeforeMethod
    public void precondition(){
        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
    }
    @Test
    public void loginTest(){
        // WebElement LOGIN = wd.findElement(By.xpath("//a[normalize-space()='LOGIN']"));
        // LOGIN.click();
        List<WebElement> list = wd.findElements(By.tagName("a"));
        int last = list.size()-1;
        WebElement element = list.get(last);
        element.click();
        list.get(1).click();
        list.get(0).click();
        //System.out.println(list.size());


    }
    @Test
    public void locatorTest() {
    wd.findElement(By.linkText("LOGIN")).click();
        List <WebElement> list = wd.findElements(By.tagName("input"));
        WebElement email = list.get(0);
        WebElement password = list.get(1);

        email.click();
        email.clear();
        email.sendKeys("VASYA911@gmail.com");

        password.click();
        password.clear();
        password.sendKeys("Lola12345$");

        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        buttons.get(1).click();
    }

    @AfterMethod
    public void postCondition(){
        //wd.quit();
    }
}
