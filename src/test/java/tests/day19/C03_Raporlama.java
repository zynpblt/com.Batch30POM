package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.lang.reflect.Array;

public class C03_Raporlama extends TestBaseRapor {

    @Test
    public void test1(){
        extentTest=extentReports.createTest("Nutella testi","Sonuc sayisi 1000 den az olmali");
    //amazon sayfasina gidip
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon sayfasina gidildi");
        //nutella icin arama yapalim
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.sendKeys(ConfigReader.getProperty("amazonArananKelime")+ Keys.ENTER);
        extentTest.info("Nutella icin arama yapildi");
        //sonuc sayisinin 1000 den az oldugunu test edelim.
        WebElement sonucYazisiElementi=Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));

        String sonucYazisi=sonucYazisiElementi.getText();
        String  sonucArrayi[]=sonucYazisi.split(" ");
        int sonucSayisi=Integer.parseInt(sonucArrayi[2]);

        extentTest.info("sonuc yazisi in haline getirildi");
        Assert.assertTrue(sonucSayisi<1000);
        extentTest.pass("sonuc sayisinin 1000'den az oldugu test edildi");
    }

    @Test
    public void test2(){
        //amazon sayfasina gidip
        //samsung icin arama yapalim
        //sonuc sayisinin 1000 den az oldugunu test edelim.
        extentTest=extentReports.createTest("Samsung testi","Sonuc sayisi 1000 den az olmali");
        //amazon sayfasina gidip
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon sayfasina gidildi");
        //nutella icin arama yapalim
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.sendKeys("Samsung"+ Keys.ENTER);
        extentTest.info("Samsung icin arama yapildi");
        //sonuc sayisinin 1000 den az oldugunu test edelim.
        WebElement sonucYazisiElementi=Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));

        String sonucYazisi=sonucYazisiElementi.getText();
        String  sonucArrayi[]=sonucYazisi.split(" ");

        String sonucAdedi=sonucArrayi[3];
        sonucAdedi=sonucAdedi.replace(",","");
        int sonucSayisi=Integer.parseInt(sonucAdedi);

        extentTest.info("sonuc yazisi in haline getirildi");
        Assert.assertTrue(sonucSayisi<1000);
        extentTest.pass("sonuc sayisinin 1000'den az oldugu test edildi");
    }

    @Test
    public void test3(){
        //amazon sayfasina gidip
        //electronic kategorisinde java  icin arama yapalim
        //cikan sonuclardan ilkinin isminde java oldugunu test edelim
    }
}
