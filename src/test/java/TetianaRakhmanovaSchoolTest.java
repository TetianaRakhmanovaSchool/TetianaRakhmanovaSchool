import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TetianaRakhmanovaSchoolTest {

    //TC_1_1  - Тест кейс:
    //1. Открыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню Search
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголовок изменился на "Paris, FR"

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Applications\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);
        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type= 'submit']")
        );
        searchButton.click();

        Thread.sleep(5000);
        WebElement parisFRChoiceInDropDownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']//span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropDownMenu.click();

        Thread.sleep(5000);
        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );

        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testGuideTab_TC_11_01() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Applications\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        //String button = "Guide";

        String expectedResult1 = "OpenWeatherMap API guide - OpenWeatherMap";
        String expectedResult2 = "https://openweathermap.org/guide";


        driver.get(url);
        Thread.sleep(5000);
        WebElement guideTab = driver.findElement(
                By.xpath("//div[@id='desktop-menu']//ul//li//a[text()='Guide'] ")
        );
        guideTab.click();

        Thread.sleep(2000);
        String actualResult1 = driver.getTitle();
        String actualResult2 = driver.getCurrentUrl();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }


//        @Test
//        public void testName() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Applications\\WebDriver\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();

//        String url = "https://openweathermap.org/";
//        driver.get(url);
//        driver.manage().window().maximize();
//        driver.quit();
//    }


    @Test
    public void testTemperatureF_TC_11_02() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Applications\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String fTempSymbol = "°F";

        String expectedResult = "°F";

        driver.manage().window().maximize();
        driver.get(url);

        Thread.sleep(5000);
        WebElement temperatureF = driver.findElement(
                By.xpath("//div[text()='Imperial: °F, mph']")
        );
        temperatureF.click();

        Thread.sleep(2000);
        WebElement showF = driver.findElement(
                By.xpath("//span[@class='heading']")
        );

        String tempInF = showF.getText();

        String actualResult = tempInF.substring(tempInF.length() - 2);

        Assert.assertTrue(showF.getText().contains(fTempSymbol));
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();

    }

    @Test
    public void testTextAndButtons_TC_11_03() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Applications\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";

        String expectedResult = "We use cookies which are essential for the site to work. " +
                "We also use non-essential cookies to help us improve our services. Any data collected is anonymised. " +
                "You can allow all cookies or manage them individually.";
        String expectedResult1 = "Allow all";
        String expectedResult2 = "Manage cookies";

        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(5000);

        WebElement panelText = driver.findElement(
                By.xpath("//p[@class='stick-footer-panel__description']"));

        Thread.sleep(2000);
        WebElement allowAllButton = driver.findElement(
                By.xpath("//button[text()='Allow all']"));
        Thread.sleep(2000);
        WebElement manageCookiesButton = driver.findElement(
                By.xpath("//a[text()=' Manage cookies ']"));


        String actualResult = panelText.getText();
        String actualResult1 = allowAllButton.getText();
        String actualResult2 = manageCookiesButton.getText();

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }

    @Test
    public void testSupportMenu_TC_11_04() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Applications\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";

        String expectedResult1 = "FAQ";
        String expectedResult2 = "How to start";
        String expectedResult3 = "Ask a question";

        driver.get(url);
        driver.manage().window().maximize();


        Thread.sleep(5000);
        WebElement supportButton = driver.findElement(
                By.xpath("//div[@id='support-dropdown']")
        );
        supportButton.click();


        Thread.sleep(5000);
        WebElement faq = driver.findElement(
                By.xpath("//li/ul/li//a[@href='/faq']")
        );
        WebElement howToStart = driver.findElement(
                By.xpath("//li/ul/li/a[@href='/appid']")
        );
        WebElement askAquestion = driver.findElement(
                By.xpath("//li/ul/li/a[@href='https://home.openweathermap.org/questions']")
        );

        String actualResult1 = faq.getText();
        String actualResult2 = howToStart.getText();
        String actualResult3 = askAquestion.getText();

        //Assert.assertEquals(driver.findElements(By.xpath("//div[@id='support-dropdown']/ul[@id='support-dropdown-menu']/li")).size(), 3);
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();
    }

    @Test
    public void testSupport_TC_11_05() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Applications\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String email = "carolOfTheBells@gmail.com";
        String message = "New message for testing";

        String expectedResult = "reCAPTCHA verification failed, please try again.";

        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(5000);
        WebElement supportButton = driver.findElement(
                By.xpath("//div[@id='support-dropdown']")
        );
        supportButton.click();

        Thread.sleep(3000);
        WebElement askQuestion = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li/a[@href='https://home.openweathermap.org/questions']")
//                By.xpath("//ul[@id='support-dropdown-menu']//li//a[@target='_blank']")
        );
        askQuestion.click();

//        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {   /// when you're redirected to a new tab --- write these 2 lines of code !!
            driver.switchTo().window(winHandle);
        }
        // Switch back to original browser (first window)
//        driver.switchTo().window(winHandleBefore);

        Thread.sleep(5000);
        WebElement emailField = driver.findElement(
                By.id("question_form_email")
        );
        emailField.click();
        emailField.sendKeys(email);
        Thread.sleep(5000);
        WebElement subjectField = driver.findElement(
                By.xpath("//select[@id='question_form_subject']")
        );
        subjectField.click();
        Thread.sleep(5000);
        WebElement selectQuestion = driver.findElement(
                By.xpath("//option[@value='Sales']")
        );
        selectQuestion.click();
        Thread.sleep(5000);
        WebElement messageField = driver.findElement(
                By.xpath("//textarea[@id='question_form_message']")
        );
        messageField.click();
        messageField.sendKeys(message);
        Thread.sleep(5000);
        WebElement submitButton = driver.findElement(
                By.xpath("//input[@value='Submit']")
        );
        submitButton.click();
        Thread.sleep(5000);
        WebElement reCaptcha = driver.findElement(
                By.xpath("//div[@class='help-block']")
        );

        String actualResult = reCaptcha.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testEmailCannotBeBlank_TC_11_06() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Applications\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";

        String message = "Test message";
        String expectedResult = "can't be blank";

        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(5000);
        WebElement supportMenu = driver.findElement(
                By.xpath("//div[@id='support-dropdown']"));
        supportMenu.click();

        String originalWindow = driver.getWindowHandle(); /// 1-st window
        Thread.sleep(2000);
        WebElement askQuestionButton = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li/a[@href='https://home.openweathermap.org/questions']"));
        askQuestionButton.click();

        for (String windowHandle : driver.getWindowHandles()) { //other windows
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Thread.sleep(5000);
        WebElement subjectField = driver.findElement(
                By.xpath("//select[@id='question_form_subject']")
        );
        subjectField.click();
        Thread.sleep(5000);
        WebElement selectQuestion = driver.findElement(
                By.xpath("//option[@value='Sales']")
        );
        selectQuestion.click();
        Thread.sleep(5000);
        WebElement messageField = driver.findElement(
                By.xpath("//textarea[@id='question_form_message']")
        );
        messageField.click();
        messageField.sendKeys(message);

        String window2 = driver.getWindowHandle(); // reCaptcha window
        driver.switchTo().frame(driver.findElement(
                By.cssSelector("iframe[title='reCAPTCHA']")));
        Thread.sleep(5000);
        WebElement reCaptcha = driver.findElement(
                By.xpath("//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox']"));
        reCaptcha.click();
        Thread.sleep(10000);
        driver.switchTo().window(window2);

        WebElement submitButton = driver.findElement(
                By.xpath("//div/input[@type='submit']"));
        submitButton.click();
        Thread.sleep(5000);
        WebElement errorDisplayed = driver.findElement(
                By.xpath("//span[@class='help-block']"));

        String actualResult = errorDisplayed.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testFahrenheitAndCelsius_TC_11_07() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Applications\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String celsiusSymbol = "°C";
        String expectedResult = "°C";

        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(5000);
        WebElement fahrenheitButton = driver.findElement(
                By.xpath("//div[text()='Imperial: °F, mph']"));
        fahrenheitButton.click();
        Thread.sleep(2000);
        WebElement celsiusButton = driver.findElement(
                By.xpath("//div[text()='Metric: °C, m/s']"));
        celsiusButton.click();
        Thread.sleep(2000);
        WebElement changedTemperatureInCelsius = driver.findElement(
                By.xpath("//span[@class='heading']"));
        String showCelsius = changedTemperatureInCelsius.getText();

        String actualResult = showCelsius.substring(showCelsius.length() - 2);

        Assert.assertTrue(showCelsius.contains(celsiusSymbol)); //changedTemperatureInCelsius.getText()
        Assert.assertEquals(actualResult, expectedResult);


        driver.quit();
    }

    @Test
    public void testCheckLogo_TC_11_08() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Applications\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "https://openweathermap.org/";

        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(5000);
        WebElement logoIcon = driver.findElement(
                By.xpath("//img[@src='/themes/openweathermap/assets/img/logo_white_cropped.png']"));
        logoIcon.click();
        WebElement loader = driver.findElement(
                By.xpath("//div[@class='owm-loader-container']/div ")); // found it by DevTools > Sources > pause and see it in Elements tab
        loader.isDisplayed();

        String actualResult = driver.getCurrentUrl();

        Assert.assertTrue(loader.isDisplayed());
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testFindRome_TC_11_09() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Applications\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Rome";
        //String expectedResult= "https://openweathermap.org/find?q=Rome";
        String expectedResult1 = "Rome";
        String searchValue1 = "find";
        String searchValue2 = "Rome";

        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(5000);
        WebElement searchWeatherByCity = driver.findElement(
                By.xpath("//div[@id='desktop-menu']//input[@type='text']"));
        searchWeatherByCity.click();
        searchWeatherByCity.sendKeys(cityName);
        searchWeatherByCity.sendKeys(Keys.ENTER);


        String strUrl = driver.getCurrentUrl();
        Boolean actualResult;
        if (strUrl.contains(searchValue1) && strUrl.contains(searchValue2)) {
            actualResult = true;
        } else {
            actualResult = false;
        }
        Boolean expectedResult = strUrl.contains(searchValue1) && strUrl.contains(searchValue2);
        Assert.assertEquals(actualResult, expectedResult);

//        String actualResult = driver.getCurrentUrl();
//        Assert.assertEquals(actualResult, expectedResult);

        String actualResult1 = driver.findElement(
                By.xpath("//input[@class]")).getAttribute("value");
        Assert.assertEquals(actualResult1, expectedResult1);

        driver.quit();
    }

    @Test
    public void testName_TC_11_10() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Applications\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        int expectedResult = 30; // 30 orange buttons

        String url = "https://openweathermap.org/";


        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement apiButton = driver.findElement(
                By.xpath("//div/ul/li/a[@href='/api']"));
        apiButton.click();

        int actualResult = driver.findElements(
                By.xpath("//a[contains(@class,'orange')]")).size();
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    // BaseURL = "https://openweathermap.org/";
    //HomeURL = "https://home.openweathermap.org/";


}

