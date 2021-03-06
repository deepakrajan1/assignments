package week4.day1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://leafground.com/pages/frame.html");
		
		driver.switchTo().frame(0);
		
		//Take the screenshot
		WebElement clickme = driver.findElement(By.xpath("//button[text()='Click Me']"));
		File source = clickme.getScreenshotAs(OutputType.FILE);
		File destination = new File ("./images/clickme.png");
		FileUtils.copyFile(source, destination);
		
		driver.switchTo().defaultContent();
		
		//List of frames
		List<WebElement> list = driver.findElements(By.tagName("iframe"));
		Thread.sleep(1000);
		int size = list.size();
		System.out.println(" No of Frames : "+ size);
		
		driver.close();
	
	}
}
