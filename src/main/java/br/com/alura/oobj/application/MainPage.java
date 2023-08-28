package br.com.alura.oobj.application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MainPage {
    private static final String URL_MAIN = "https://cosmos.bluesoft.com.br/ncms";
    private WebDriver browser;

    public MainPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_MAIN);
    }

    public void fechar(){
        this.browser.quit();
    }

    public String retornaNCMdefinido(int ncmDefinido) {
        WebElement conjuntoDeNCM = browser.findElement(By.cssSelector("body > div > section > ul"));
        List<WebElement> listaDeNCM = conjuntoDeNCM.findElements(By.tagName("li"));

        return listaDeNCM.get(ncmDefinido-1).getText();
    }
}
