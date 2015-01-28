package com.alperen.seleniumtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumLoginTest {
    
    public SeleniumLoginTest() {
    }
    
    private final static WebDriver driver = new FirefoxDriver();
    private final static String link = "http://www.n11.com";
    
    @Before
    public void setUp() {
        driver.get(link);
    }
    
    @After
    public void tearDown() {
        driver.close();
    }
    
    @Test
    public void testMainPage() throws InterruptedException
    {
        System.out.print("Ana sayfa deneniyor...");
        SeleniumLogin seHome = new SeleniumLogin(driver);
        assertTrue(seHome.getTitle().contains("Alışverişin Uğurlu Adresi"));
        System.out.println("...OK");
        
        System.out.print("Login sayfası deneniyor...");
        seHome.signInClicker();
        assertTrue(seHome.getTitle().contains("Giriş Yap"));
        System.out.println("...OK");
        
        System.out.print("Login olunuyor...");
        SeleniumSearch seSearch = seHome.login("alpunutur@gmail.com", "ALPalp123456");
        assertTrue(seSearch.getAccount().contains("Sepetim"));
        System.out.println("...OK");
        
        System.out.print("Arama yapılıyor...");
        assertTrue(seSearch.searchKeyword("samsung").contains("Samsung"));
        System.out.println("...OK");
        
        System.out.print("2. sayfaya geçiliyor...");
        assertTrue(seSearch.clickNext().contains("2/"));
        System.out.println("...OK");
        
        System.out.print("Ürün favorilere ekleniyor...");
        String productName =  seSearch.findProduct();
        System.out.println("...OK");
        
        SeleniumAccount seAccount = new SeleniumAccount(driver); 
        
        System.out.print("Hesap sayfası açılıyor...");
        assertTrue(seAccount.accountClicker().contains("Hesabım"));
        System.out.println("...OK");
        
        System.out.print("Favorilerim'e tıklanıyor...");
        assertTrue(seAccount.favouritesClicker().contains("Favorilerim"));
        System.out.println("...OK");
        
        System.out.print("Ürünler kontrol ediliyor");
        assertEquals(productName,seAccount.getProductName());
        System.out.println("...OK");
        
        System.out.print("Ürün favorilerden kaldırılıyor...");
        assertTrue(seAccount.removeProduct().contains("0"));
        System.out.println("...OK");
        
        System.out.println("Test başarı ile tamamlandı.");
        
    }
    
}
