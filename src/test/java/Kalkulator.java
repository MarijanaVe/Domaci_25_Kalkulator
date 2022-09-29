//Testirati rad kalkulatora https://testsheepnz.github.io/BasicCalculator.html.
// Testirati rad svih operacija posebno.
//Za njega napisati edge case-eve na koje naletite,
// ili ispunite neka matematicka pravila (deljenje sa nulom, jedinicom, veliki/mali brojevi itd).
// Napisati minimum 4 edge case-a po testnoj metodi, 16 ukupno (minimum), zanemarujuci Concatenate.


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Kalkulator {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tilma\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
    }

    @BeforeMethod
    public void beforeMethod () {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
    }

    @Test
    public void sabiranje () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("1");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("1");
        String expectedResult="2";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);


        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Add");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void sabiranjeNegativnih () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("10");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("-1");
        String expectedResult="9";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Add");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void sabiranjeSaNulom () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("0");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("-1");
        String expectedResult="-1";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Add");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void sabiranjeVelikih () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("1000000000");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("5000000000");
        String expectedResult="6000000000";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Add");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void oduzimanje () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("5");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("1");
        String expectedResult="4";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Subtract");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void oduzimanjeNagativnih () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("-5");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("-1");
        String expectedResult="-4";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Subtract");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void oduzimanjeNule () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("-5");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("0");
        String expectedResult="-5";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Subtract");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void oduzimanjeVelikih () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("10000000");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("5000000");
        String expectedResult="5000000";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Subtract");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }


    @Test
    public void mnozenje () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("5");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("2");
        String expectedResult="10";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Multiply");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }


    @Test
    public void mnozenjeNule () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("5");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("0");
        String expectedResult="0";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Multiply");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }


    @Test
    public void mnozenjeNegativnih () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("-5");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("-3");
        String expectedResult="15";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Multiply");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void mnozenjeVelikih () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("10");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("20000000000");
        String expectedResult="20000000000";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Multiply");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void deljenje () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("10");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("2");
        String expectedResult="5";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Divide");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void deljenjeNulom () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("0");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("10");
        String expectedResult="0";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Divide");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void deljenjeNulom2 () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("10");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("0");
        WebElement expResult = driver.findElement(By.id("errorMsgField"));
        String expectedResult= expResult.getAttribute("value");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Divide");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("errorMsgField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }


    @Test
    public void deljenjejedinicom () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("1");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("10");
        String expectedResult="0.1";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Divide");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void deljenjeVelikih () throws InterruptedException {

        WebElement number1Field= driver.findElement(By.id("number1Field"));
        number1Field.sendKeys("1000000000");
        WebElement number2Field= driver.findElement(By.id("number2Field"));
        number2Field.sendKeys("10");
        String expectedResult="100000000";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(1000);

        WebElement operationAdd = driver.findElement(By.id("selectOperationDropdown"));

        Select select = new Select(operationAdd);
        select.selectByVisibleText("Divide");

        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult= result.getAttribute("value");

        Assert.assertEquals(expectedResult,actualResult);

    }




    @AfterClass
    public void afterClass () {
        driver.quit();
    }



}
