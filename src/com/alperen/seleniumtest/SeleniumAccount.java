
package com.alperen.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SeleniumAccount {
    
    private final WebDriver fxdriver;
    private WebElement elem;
    
    By accountFinder = By.className("username");
    By favouriteFinder = By.xpath("//*[@id=\"myNavigation\"]/li[3]/a");
    By productNameFinder = By.xpath("//*[@id=\"watchList\"]/tbody/tr/td[3]/p/a");
    By removeFinder = By.className("removeSelectedProduct");
    By pageCountFinder = By.xpath("//*[@id=\"pageCount\"]");
    
    public SeleniumAccount(WebDriver fxdriver)
    {
        this.fxdriver = fxdriver;
    }
    
    public String accountClicker()
    {
        elem = fxdriver.findElement(accountFinder);
        String link = elem.getAttribute("href");
        fxdriver.get(link);
        
        return fxdriver.getTitle();
    }
    
    public String favouritesClicker()
    {
        elem = fxdriver.findElement(favouriteFinder);
        String link = elem.getAttribute("href");
        fxdriver.get(link);
        
        return fxdriver.getTitle();
    }
    
    public String getProductName()
    {
        elem = fxdriver.findElement(productNameFinder);
        return elem.getText();
    }
    
    public String removeProduct()
    {
        elem = fxdriver.findElement(removeFinder);
        elem.click();
        elem = fxdriver.findElement(pageCountFinder);
       
        return elem.getAttribute("value");
    } 
}
