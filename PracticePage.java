package DailyExercise;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PracticePage {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String text=driver.findElementByXPath("//header[@class='jumbotron text-center header_style']/following-sibling::h1").getText();
		System.out.println(text);
		System.out.println("");
		
		//radio button
		String text1=driver.findElementByXPath("//legend[text()='Radio Button Example']").getText();
		System.out.println(text1);
		driver.findElementByXPath("//label[@for='radio2']/input").click();
		System.out.println("Clicked Radio2");
		System.out.println("");
		
		//suggession class
		String text2=driver.findElementByXPath("//legend[text()='Suggession Class Example']").getText();
		System.out.println(text2);
		WebElement sug=driver.findElementById("autocomplete");
		sug.sendKeys(Keys.ENTER,"ind");
		sug.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
		System.out.println("Selected India");
		System.out.println("");
		 
		//drop down
		String text3=driver.findElementByXPath("//legend[text()='Dropdown Example']").getText();
		System.out.println(text3);
		driver.findElementById("dropdown-class-example").click();
		driver.findElementByXPath("//option[text()='Option2']").click();
		System.out.println("Selected Option2");
		System.out.println("");
		
		//check box
		String text4=driver.findElementByXPath("//legend[text()='Checkbox Example']").getText();
		System.out.println(text4);
		driver.findElementById("checkBoxOption3").click();
		System.out.println("Clicked Option3");
		System.out.println("");
		
		//switch window
		String text5=driver.findElementByXPath("//legend[text()='Switch Window Example']").getText();
		System.out.println(text5);
		driver.findElementById("openwindow").click();
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		String ParentWindowId=it.next();
		System.out.println("ParentWindowID :"+ParentWindowId);
		String ChildWindowId=it.next();
		System.out.println("ChildWindowID :"+ChildWindowId);
		driver.switchTo().window(ChildWindowId);
		System.out.println("Child Window Title :"+driver.getTitle());
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(ParentWindowId);
		System.out.println("Parent Window Title :"+driver.getTitle());
		System.out.println("");
		
		//switch tab
		String text6=driver.findElementByXPath("//legend[text()='Switch Tab Example']").getText();
		System.out.println(text6);
		driver.findElementById("opentab").click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it1=windows.iterator();
		String ParentWindow=it1.next();
		System.out.println("ParentWindowID :"+ParentWindow);
		String ChildWindow=it1.next();
		System.out.println("ChildWindowID :"+ChildWindow);
		driver.switchTo().window(ChildWindow);
		System.out.println("Child Window Title :"+driver.getTitle());
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(ParentWindow);
		System.out.println("Parent Window Title :"+driver.getTitle());
		System.out.println("");
		
		//switch to alert
		String text7=driver.findElementByXPath("//legend[text()='Switch To Alert Example']").getText();
		System.out.println(text7);
		driver.findElementById("name").sendKeys("dhivya");
		driver.findElementById("alertbtn").click();
		Thread.sleep(500);
		driver.switchTo().alert().accept();
		driver.findElementById("name").sendKeys("dhivya");
		driver.findElementById("confirmbtn").click();
		Thread.sleep(500);
		driver.switchTo().alert().dismiss();
		System.out.println("Alert message appeared");
		System.out.println("");
		
		//web table
		int sum=0;
		String text8=driver.findElementByXPath("//legend[text()='Web Table Example']").getText();
		System.out.println(text8);
		WebElement table=driver.findElementByCssSelector("table#product.table-display");
		int count=table.findElements(By.xpath("//table/tbody/tr/td[3]")).size();
		for(int i=0;i<count-1;i++)
		{
			String a=table.findElements(By.xpath("//table/tbody/tr/td[3]")).get(i).getText();
			sum=sum + Integer.parseInt(a);		
		}
		System.out.println("Added all the price :" +sum);
		System.out.println("");
		
		//element dispalyed
		String text9=driver.findElementByXPath("//legend[text()='Element Displayed Example']").getText();
		System.out.println(text9);
		driver.findElementById("hide-textbox").click();
		Thread.sleep(500);
		Boolean a=driver.findElementById("displayed-text").getAttribute("style").contains("display: none;");
		System.out.println("Hide-Text box appeared :"+a);
		driver.findElementById("show-textbox").click();
		Thread.sleep(500);
		Boolean b=driver.findElementById("displayed-text").getAttribute("style").contains("display: block;");
		System.out.println("Show-Text box appeared :"+b);
		System.out.println("");
		
		//mousehover 
		String text10=driver.findElementByXPath("//legend[text()='Mouse Hover Example']").getText();
		System.out.println(text10);
		WebElement button=driver.findElementById("mousehover");
	        Actions action=new Actions(driver);
	    	Thread.sleep(500);
	    	action.moveToElement(button).build().perform(); 
	    	driver.findElementByLinkText("Reload").click();
	    	System.out.println("The page is reloaded");
	    	System.out.println("");
	    
	    	//iframe
	    	String text11=driver.findElementByXPath("//legend[text()='iFrame Example']").getText();
		System.out.println(text11);
		driver.switchTo().frame("iframe-name");
		int count1=driver.findElementsByTagName("a").size();
		System.out.println("Total Tags inside the frame :" +count1);
		driver.switchTo().defaultContent();
		System.out.println("");
	
		//footer
		WebElement footer=driver.findElementByXPath("//table[@class='gf-t']");
		WebElement link=footer.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td/ul[1]"));
		int count2=link.findElements(By.tagName("a")).size();
		String column=footer.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td/ul[1]")).getText();
		System.out.println(column);
		for(int i=1;i<count2;i++)
		{
			String newTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			link.findElements(By.tagName("a")).get(i).sendKeys(newTab);
			Thread.sleep(1000);
		}
		Set<String> s=driver.getWindowHandles();
		Iterator<String> itt=s.iterator();
		while(itt.hasNext())
		{
			driver.switchTo().window(itt.next());
			System.out.println("Title: " +driver.getTitle());	 
		}
		
		
	}
	
	

}
