package br.com.alura.oobj.application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.matches;

public class NcmPage {
    private static final String URL_NCMS = "https://cosmos.bluesoft.com.br/ncms/";
    private WebDriver browser;

    public NcmPage(String ncm) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        String ncmTratado = tratarNCM(ncm);
        String URL_NCM = URL_NCMS;
        URL_NCM += ncmTratado;
        this.browser.navigate().to(URL_NCM);
    }

    public void fechar(){
        this.browser.quit();
    }

    public String mostrarNCMdefinido(int ncmDefinido) {
        WebElement conjuntoDeNCM = browser.findElement(By.cssSelector("body > div > section > ul"));
        List<WebElement> listaDeNCM = conjuntoDeNCM.findElements(By.tagName("li"));

        return listaDeNCM.get(ncmDefinido-1).getText();
    }

    public void retornaItensDoNCM() {
        WebElement conjuntoDeNCM = browser.findElement(By.cssSelector("body > div > section > ul:nth-of-type(2)"));
        List<WebElement> listaDeNCM = conjuntoDeNCM.findElements(By.tagName("li"));

        for (WebElement NCM : listaDeNCM) {
            System.out.println(NCM.getText());
            System.out.println(URL_NCMS + tratarNCM(NCM.getText()));
        }
    }

    private String tratarNCM(String ncm){

        String ncmTratado = ncm.replaceAll("[^a-zA-Z0-9\\s\\p{L}]", "");
        ncmTratado = ncmTratado.replace("  ", "-");
        ncmTratado = ncmTratado.replace(" ", "-");

        ncmTratado = trocarLetrasAcentuadas(ncmTratado);

        return ncmTratado;
    }

    private static String trocarLetrasAcentuadas(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }


}
