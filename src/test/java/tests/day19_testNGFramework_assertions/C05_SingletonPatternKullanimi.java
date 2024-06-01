package tests.day19_testNGFramework_assertions;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SingletonPatternKullanimi {

    @Test
    public void aramaTesti(){

        // Driver.driver.get(ConfigReader.getProperty("toUrl"));
        /*
            Yukardaki yontemle driver variable'ini kullanmak istedigimizde
            baslangicta driver'a bir deger atanmadigi icin
            null olarak isaretlendiginden
            null olarak isaretlenen bir objeyi method ile kullanmak istersek
            NullPointerException verir
         */

        // Pekii getDriver() 'unu obje olusturarak kullanabilir miyiz ?
        // Driver driver = new Driver();
        // driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        /*
            bu kullanim mumkundur
            ama TestNG'yi dizayn edenler
            WebDriver objesini static yontemle
            Driver.getDriver() seklinde kullanilmasini ZORUNLU HALE getirmek icin
            Driver class'ini singleton pattern kullanarak sinirlamislardir.

            Singleton Pattern,
            bir class'dan obje olusturulmasini engelleyen yontemlerden birisidir
            ve soyle calisir
            Bir class'dan obje olusturmak icin, o class'in constructor'i calistirilmalidir
            Eger o class'in constructor'ina kimse ulasamazsa
            o zaman o class'dan kimse obje olusturamaz


         */



        // Testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // belirlenen kelime icin arama yapin


        // arama sonucunda urun bulunabildigini test edin


        // sayfayi kapatin
        Driver.quitDriver();

    }
}
