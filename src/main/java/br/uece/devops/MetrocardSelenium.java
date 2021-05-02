package br.uece.devops;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class MetrocardSelenium {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10L);

        try {
            driver.get("http://localhost:8080/metrocard");
            driver.findElement(By.name("username")).sendKeys("Bob" + Keys.TAB);
            driver.findElement(By.name("password")).sendKeys("1234" + Keys.ENTER);

            WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3")));
            System.out.println(firstResult.getAttribute("textContent"));

            List<WebElement> spanList = driver.findElements(By.tagName("span"));
            spanList.stream().map(el -> el.getAttribute("textContent")).forEach(System.out::println);
        } finally {
            driver.quit();
        }
    }

}
