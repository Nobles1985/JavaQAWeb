package org.example.classfortesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private WebDriver driver;
    private Actions actions;

    public AbstractPage(WebDriver driver, Actions actions){
        this.driver = driver;
        this.actions = actions;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver(){
        return this.driver;
    }

    protected Actions getActions(){
        return this.actions;
    }
}