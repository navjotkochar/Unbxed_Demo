package Demo_Unbxd.Demo_Unbxd;

import org.openqa.selenium.interactions.Action;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App {
	static Locators my_locators;

	public static WebElement locateListItem(WebDriver driver, String titleText) {
		List<WebElement> lis = driver.findElements(By.xpath("//ul[@class='module-group']/li"));
		WebElement listItem = lis.get(0);
		for (WebElement li : lis) {
			if (li.getText().contains(titleText)) {
				listItem = li;
				break;
			}

		}
		return (listItem);
	}

	public static void main(String[] args) throws Exception {
		// System.out.println( "Hello World!" );

		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://quickfuseapps.com";
		driver.get(url);
		driver.findElement(By.id(my_locators.BTN_ID_CREATE_APP)).click();
		// Click on lets get started
		WebDriverWait wait = new WebDriverWait(driver, 25);
		WebElement start_button = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(my_locators.BTN_XPATH_GET_STARTED)));
		start_button.click();
		// Click on New App
		WebElement newPage = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.id(my_locators.LINK_ID_NEW_PAGE)));
		newPage.click();

		// Name the new page as "Test"
		WebElement inpName = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(my_locators.INPUT_XPATH_NEW_PAGE_NAME)));
		inpName.sendKeys("Test\n");

		// Click on Messaging
		WebElement messaging = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(my_locators.LINK_XPATH_MESSAGING)));
		messaging.click();

		// Drag and Drop "Send an SMS" to center pane
		WebElement sendSMS = locateListItem(driver, "Send an SMS");
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(sendSMS, 400, -20).build().perform();

		// Connect Start to SMS module
		WebElement start_south = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(my_locators.DIV_XPATH_START_SOUTH_CONN)));
		WebElement sms_north = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(my_locators.DIV_XPATH_SMS_NORTH_CONN)));
		builder = new Actions(driver);
		builder.dragAndDrop(start_south, sms_north).build().perform();

		// fill SMS details
		WebElement phoneNumber = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.name(my_locators.INP_NAME_PHONE_NUMBER)));
		phoneNumber.sendKeys("98722327");
		WebElement textMessage = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.name(my_locators.INP_NAME_SMS_MESSAGE)));
		textMessage.sendKeys("Selenium Demo");

		// Drag and Drop "Send an Email" to center pane
		WebElement sendEmail = locateListItem(driver, "Send an Email");
		builder = new Actions(driver);
		builder.dragAndDropBy(sendEmail, 700, 10).build().perform();

		// Connect Start to SMS 'not sent' to Email
		WebElement sms_east = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(my_locators.DIV_XPATH_SMS_EAST_CONN)));
		WebElement email_north = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(my_locators.DIV_XPATH_EMAIL_NORTH_CONN)));
		builder = new Actions(driver);
		builder.dragAndDrop(sms_east, email_north).build().perform();

		// fill Email details
		WebElement smtp = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.name(my_locators.INP_NAME_SMTP)));
		smtp.sendKeys("smtp.gmail.com");
		Thread.sleep(2000);
		// smtp.sendKeys(".com");

		WebElement port = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.name(my_locators.INP_NAME_PORT)));
		port.sendKeys("8080");

		WebElement username = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.name(my_locators.INP_NAME_USER_NAME)));
		username.sendKeys("admin");

		WebElement pw = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.name(my_locators.INP_NAME_PASS_WORD)));
		pw.sendKeys("admin");

		WebElement from = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.name(my_locators.INP_NAME_FROM)));
		from.sendKeys("abc@demo.com");

		WebElement to = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.name(my_locators.INP_NAME_TO)));
		to.sendKeys("bcd@demo.com");

		WebElement subject = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.name(my_locators.INP_NAME_SUBJECT)));
		subject.sendKeys("Demo Email");

		WebElement cc = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.name(my_locators.INP_NAME_CC)));
		cc.sendKeys("cde@demo.com");

		// Click on Basic
		WebElement basic = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(my_locators.LINK_XPATH_BASIC)));
		basic.click();

		//Drag and Drop 'Exit' to the left of SMS
		WebElement exit = locateListItem(driver, "Hang Up or Exit");
	    builder = new Actions(driver);
		builder.dragAndDropBy(exit, 300, 300).build().perform();

		// Connect SMS 'Sent' to 'Exit'
		WebElement sms_west = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(my_locators.DIV_XPATH_SMS_WEST_CONN)));
		WebElement exit1_north = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(my_locators.DIV_XPATH_EXIT1_NORTH_CONN)));
		builder = new Actions(driver);
		builder.dragAndDrop(sms_west, exit1_north).build().perform();

		//Drag and Drop 'Exit' to the left of Email
		exit = locateListItem(driver, "Hang Up or Exit");
	    builder = new Actions(driver);
		builder.dragAndDropBy(exit, 500, 400).build().perform();

		// Connect Email 'Sent' to 'Exit'
		WebElement email_west = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(my_locators.DIV_XPATH_EMAIL_WEST_CONN)));
		WebElement exit2_north = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(my_locators.DIV_XPATH_EXIT2_NORTH_CONN)));
		builder = new Actions(driver);
		builder.dragAndDrop(email_west, exit2_north).build().perform();

		//Drag and Drop 'Exit' to the right of Email
		exit = locateListItem(driver, "Hang Up or Exit");
	    builder = new Actions(driver);
		builder.dragAndDropBy(exit, 1000, 400).build().perform();

		// Connect Email 'Not Sent' to 'Exit'
		WebElement email_east = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(my_locators.DIV_XPATH_EMAIL_EAST_CONN)));
		WebElement exit3_north = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(my_locators.DIV_XPATH_EXIT3_NORTH_CONN)));
		builder = new Actions(driver);
		builder.dragAndDrop(email_east, exit3_north).build().perform();

		System.out.println("Done!");
	}
}
