
package com.alperen.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SeleniumLogin {

    private final WebDriver fxdriver;
    
    By signInFinder = By.className("btnSignIn");
    By usernameFinder = By.xpath("//input[@id='email']");
    By passwordFinder = By.xpath("//input[@id='password']");
    By loginFinder = By.id("loginButton");
    
    public SeleniumLogin(WebDriver fxdriver)
    {
        this.fxdriver = fxdriver;
    }
    
    public String getTitle()
    {
        return fxdriver.getTitle();
    }
    
    public SeleniumLogin usernameTyper(String username)
    {
        fxdriver.findElement(usernameFinder).sendKeys(username);
        return this;
    }
    
    public SeleniumLogin passwordTyper(String password)
    {
        fxdriver.findElement(passwordFinder).sendKeys(password);
        return this;
    }
    
    public void loginClicker()
    {
        fxdriver.findElement(loginFinder).click();
    }
    
    public void signInClicker()
    {
        fxdriver.findElement(signInFinder).click();
    }
    
    public SeleniumSearch login(String username, String password) throws InterruptedException
    {
        usernameTyper(username);
        passwordTyper(password);
        loginClicker();
        
        return new SeleniumSearch(fxdriver);
    }
    
}
