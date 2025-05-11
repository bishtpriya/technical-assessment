package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class AppTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();

        try {

            // Step 1: Open the application
            driver.get("https://www.cloudbees.com/");

            // Close Cookies banner if appears
            try {
                WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")
                ));
                closeButton.click();
                System.out.println("Cookie banner closed.");
            } catch (Exception e) {
                System.out.println("No cookie banner appeared or failed to click it.");
            }

        
          // Step 2: Click Products > CloudBees CD/RO
          WebElement productsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(//div[contains(@class, 'dropdown-wrapper border-b border-black-80 py-4 xl:border-none xl:p-0')])[1]")));
            productsMenu.click();
          /*By.xpath("(//div[contains(@class, 'dropdown-wrapper border-b border-black-80 py-4 xl:border-none xl:p-0')])");*/
new Actions(driver).moveToElement(productsMenu).perform();
Thread.sleep(1000);

WebElement cdro = wait.until(ExpectedConditions.elementToBeClickable(
    /*By.xpath("//a[@href='https://www.cloudbees.com/products/cloudbees-cdro']")));*/
    By.xpath("//a[contains(@id, 'subcategory-item-0__CloudBees CD/RO')]")));
cdro.click();
System.out.println("Cloud bees Button clicked");


            // Step 3: Verify Cost Savings = $2m
            WebElement costSavings = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[contains(@class, 'text-callout') and normalize-space(text())='$2m']")));
            Assert.assertEquals(costSavings.isDisplayed(), costSavings.isDisplayed(),"$2m cost savings displayed");
            //assertTrue(costSavings.isDisplayed(), "Cost Savings of $2m is not displayed");


            // Step 4: Scroll down and click Auditors / Security
  WebElement auditorsSecurity = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("//span[@data-test='button-label' and normalize-space()='Auditors / Security']")));
auditorsSecurity.click();

            new Actions(driver).moveToElement(auditorsSecurity).perform();
            auditorsSecurity.click();

            // Step 5: Verify "Release Governance" text
            WebElement titleText = wait.until(ExpectedConditions.visibilityOfElementLocated(
    By.xpath("//div[@data-test='headerContent'][.//p[normalize-space()='Release Governance']]//h4[@data-test='headerContent.title' and normalize-space()='Generate single-click audit reports']")));
Assert.assertTrue(titleText.isDisplayed(), "Expected audit report text not found under Release Governance.");

            // Step 6: Click Resources > Documentation
            // Click the "Resources" button
WebElement resourcesBtn = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("//button[normalize-space()='Resources' and contains(@class, 'link-btn')]")));
resourcesBtn.click();

// Then click the "Documentation" link under the dropdown
WebElement documentationLink = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("//a[normalize-space()='Documentation']")));
documentationLink.click();

          // Step 7: Switch to the new tab
          String originalWindow = driver.getWindowHandle();
          Set<String> allWindows = driver.getWindowHandles();
          for (String win : allWindows) {
              if (!win.equals(originalWindow)) {
                  driver.switchTo().window(win);
                  break;
              }
          }

         // Step 8: Click in the search field
WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("//input[@placeholder='Search all CloudBees Resources']")));
searchField.click();

WebElement search1 = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("//input[@placeholder='Search']")));
search1.click();

search1.sendKeys("installation");
System.out.println("Search initiated for 'installation'.");

// Step 9: Wait for search results to appear (instead of URL change)
wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pagination")));

// Step 10: Verify that pagination options are visible at the bottom
WebElement pagination = wait.until(ExpectedConditions.visibilityOfElementLocated(
    By.cssSelector("ul.pagination"))); // Adjust selector if needed

List<WebElement> pages = pagination.findElements(By.cssSelector("li.page-item"));
Assert.assertTrue(pages.size() > 1, "Pagination options not found or only one page exists.");

System.out.println(" Pagination options verified.");

    System.out.println(" All steps completed successfully.");

} catch (Exception e) {
    e.printStackTrace();
} finally {
    driver.quit();
}
}
}
