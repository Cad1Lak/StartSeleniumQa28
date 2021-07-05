import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin {

    WebDriver wd;


    @BeforeMethod
    public void precondition() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.get("https://contacts-app.tobbymarshall815.vercel.app/home");
    }
    @Test
    public void easyLogin(){

        wd.findElement(By.cssSelector("[href='/login']")).click();
        wd.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("TestIdea@gmail.com");
        wd.findElement(By.cssSelector("input[placeholder='Password'")).sendKeys("Qwerty123$");
        wd.findElement(By.cssSelector("button:nth-child(4)")).click();

    }
    @AfterMethod
    public void postCondition(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            wd.quit();
        }

    }
}