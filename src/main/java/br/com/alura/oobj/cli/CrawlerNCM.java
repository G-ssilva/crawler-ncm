package br.com.alura.oobj.cli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CrawlerNCM {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.navigate().to("https://cosmos.bluesoft.com.br/ncms/22021000");
        WebElement conjuntoDeNCM = browser.findElement(By.cssSelector("body > div > section > div > div > ul"));

        List<WebElement> listaDeNCM = conjuntoDeNCM.findElements(By.tagName("li"));

        for (WebElement NCM : listaDeNCM) {
            System.out.println(NCM.getText());
        }

        browser.close();
    }
}
