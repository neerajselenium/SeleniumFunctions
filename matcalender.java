package dump;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class Calender2 {
	 static String day="10";
	 static String month="JAN";
	 static String year="2017";

	public static void main(String[] args) throws InterruptedException {
		
		 	WebDriver driver=null;
	
		 	String baseURL = "https://material.angular.io/components/datepicker/overview";
	
	        	
	    	ChromeOptions options = new ChromeOptions();
	    	options.addArguments("--disable-notifications");
	    	
	        driver = new ChromeDriver(options);

	        driver.manage().window().maximize();
	        
	        driver.get(baseURL);
	        
	        WebElement elm =  driver.findElement(By.xpath("//div//button[@aria-label='Open calendar']"));
		    elm.click();
		    	
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("//button[@class='mat-calendar-period-button mat-button']/span")).click();
		        WebElement el = driver.findElement(By.xpath("//button[@class='mat-calendar-previous-button mat-icon-button']"));
		      
		 		    	   
		      while(!selectDate(driver,year)) 
		        {
		        	if(!clickStale(driver, el))
		        	{	
		           	clickStale(driver, el);
		        	} 
		            selectDate(driver,year);
		        } 
		      
		      
		      selectMonth(driver,month);
		      selectday(driver,day);
		 	       
		 		}	
	
	
	private static void selectday(WebDriver driver, String day) {
	    
        WebElement elmCal= driver.findElement(By.xpath("//mat-calendar[@id='mat-datepicker-0']"));
        
        WebElement dSelect= elmCal.findElement(By.xpath("//table[@class='mat-calendar-table']"));
        
        List<WebElement> rows= dSelect.findElements(By.tagName("tr"));
        
        int rowsCount= rows.size();
    
    	
    	first:
        for(int row =1;row<rowsCount;row++)
        {
        	 List<WebElement> columns=rows.get(row).findElements(By.tagName("td"));
        	 
        	 int colCount= columns.size();
        	 
        	 for(int col=0; col<colCount;col++)
        	 {
        		String celtext = columns.get( col).getText();
        		System.out.println("Cell Value Of row number "+row+" and column number "+col+" Is "+celtext);
        		
        		  if(celtext.equals(day))
        		{
        			  columns.get( col).click();
        			   break first;	        			
        			
        		}
        		
        	 }
       		        	
        }
       
	
	}

			       
	
	private static void selectMonth(WebDriver driver, String month) {
	    
        WebElement elmCal= driver.findElement(By.xpath("//mat-calendar[@id='mat-datepicker-0']"));
        
        WebElement dSelect= elmCal.findElement(By.xpath("//table[@class='mat-calendar-table']"));
        
        List<WebElement> rows= dSelect.findElements(By.tagName("tr"));
        
        int rowsCount= rows.size();
    
    	
    	first:
        for(int row =1;row<rowsCount;row++)
        {
        	 List<WebElement> columns=rows.get(row).findElements(By.tagName("td"));
        	 
        	 int colCount= columns.size();
        	 
        	 for(int col=0; col<colCount;col++)
        	 {
        		String celtext = columns.get( col).getText();
        		System.out.println("Cell Value Of row number "+row+" and column number "+col+" Is "+celtext);
        		
        		  if(celtext.equals(month))
        		{
        			  columns.get( col).click();
        			   break first;	        			
        			
        		}
        		
        	 }
       		        	
        }
       
	
	}
	
	

	
	
	private static boolean  selectDate(WebDriver driver, String Year) throws InterruptedException {
		        
	        WebElement elmCal= driver.findElement(By.xpath("//mat-calendar[@id='mat-datepicker-0']"));
	        
	        WebElement dSelect= elmCal.findElement(By.xpath("//table[@class='mat-calendar-table']"));
	        
	        List<WebElement> rows= dSelect.findElements(By.tagName("tr"));
	        
	        int rowsCount= rows.size();
	    
	    	boolean flag= false;
	    	first:
	        for(int row =1;row<rowsCount;row++)
	        {
	        	 List<WebElement> columns=rows.get(row).findElements(By.tagName("td"));
	        	 
	        	 int colCount= columns.size();
	        	 
	        	 for(int col=0; col<colCount;col++)
	        	 {
	        		String celtext = columns.get( col).getText();
	        		System.out.println("Cell Value Of row number "+row+" and column number "+col+" Is "+celtext);
	        		
	        		  if(celtext.equals(year))
	        		{
	        			  columns.get( col).click();
	        			  flag=true;
	        			  break first;	        			
	        			
	        		}
	        		
	        	 }
	        	
	        		        	
	        }
	      	        
			return flag;
		
	}
	


	public static boolean clickStale(final WebDriver driver, final WebElement elem) 
	{
		boolean result = false;
        int attempts = 0;
        while(attempts < 1) {
            try {
            	elem.click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            
            e.printStackTrace();
            }
            attempts++;
        }
        return result;
	}
	
	
}
	        
	            
	    
	     
