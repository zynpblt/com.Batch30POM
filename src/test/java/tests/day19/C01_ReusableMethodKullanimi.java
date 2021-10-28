package tests.day19;

import javafx.scene.effect.SepiaTone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_ReusableMethodKullanimi {
    @Test
    public void test(){
        //https://the-internet.herokuapp.com/windows adresr gidelim
        //click here yazisina basalim
        //yeni sayfada New Window yazisinin gorundugunu test edelim

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaHandleDegeri=Driver.getDriver().getWindowHandle();

        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        Set<String> windowHandleKumesi=Driver.getDriver().getWindowHandles();

        String ikinciSayfaHandleDegeri="";
        for (String each:windowHandleKumesi) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandleDegeri);
        System.out.println(Driver.getDriver().getTitle());

        //Yeni sayfada New Window yazisinin goruntulendigini test et
        WebElement newWindowYazisi=Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindowYazisi.isDisplayed());
        Driver.closeDriver();

    }
    @Test
    public void testReusablelle(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");
        WebElement newWindowYazisi=Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindowYazisi.isDisplayed());
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }
}






