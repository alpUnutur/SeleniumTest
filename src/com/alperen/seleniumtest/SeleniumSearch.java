
package com.alperen.seleniumtest;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumSearch {
    
    private final WebDriver fxdriver;
    
    By searchBarFinder = By.xpath("//input[@id='searchData']");
    By searchButtonFinder = By.className("searchBtn");
    By nextButtonFinder = By.className("next");
    By listFinder = By.xpath("//*[@id='contentListing']/div/div/div[2]/section"); //chrome tarafindan yaratilan xpath.
    By listItemFinder = By.xpath("//*[@id='view']/ul/li");
    By favoriteButtonFinder = By.cssSelector("span.textImg.followBtn");
    
    public SeleniumSearch(WebDriver fxdriver) throws InterruptedException
    {
        this.fxdriver = fxdriver;
    }
    
    public String getAccount()
    {
        WebElement elem = fxdriver.findElement(By.className("myBasket"));
        return elem.getAttribute("title");
    }
    
    public String searchKeyword(String keyword)
    {
        fxdriver.findElement(searchBarFinder).sendKeys(keyword);
        fxdriver.findElement(searchButtonFinder).click();
        return fxdriver.getTitle();
    }
    
    public String clickNext()
    {
        fxdriver.findElement(nextButtonFinder).click();
        return fxdriver.getTitle();
    }
    
    public String findProduct() throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(fxdriver,10);
        WebElement elemProduct = fxdriver.findElement(listFinder);
        List<WebElement> products = elemProduct.findElements(listItemFinder);
        
        String productName = "";
        int index = 0;
        WebElement elem = null;
        
        for(WebElement product: products)
        {
            if(index== 2){
                elem = wait.until(ExpectedConditions.elementToBeClickable(product.findElement(favoriteButtonFinder)));
                productName = product.findElement(By.className("plink")).getAttribute("title");
                break;
            }
            else
                index++;
            
        }
        
        JavascriptExecutor executor = (JavascriptExecutor)fxdriver;
        executor.executeScript("arguments[0].click();", elem);
        
        return productName;
    }
    
}
