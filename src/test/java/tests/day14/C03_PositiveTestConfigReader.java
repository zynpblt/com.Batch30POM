package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C03_PositiveTestConfigReader extends TestBase {
    @Test
    public void positiveTestConfig(){
        ////1 ) Bir Class olustur : PositiveTest
        //        //2) Bir test method olustur positiveLoginTest()
        //        // https://www.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHUrl"));

        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        // login butonuna bas
        concortHotelPage.ilkLoginLinki.click();
        // test data username: manager ,
        concortHotelPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHValidUserName"));
        // test data password : Manager1!
        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHotelPage.loginButonu.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(concortHotelPage.basariliGirisYaziElementi.isDisplayed());
    }
}
