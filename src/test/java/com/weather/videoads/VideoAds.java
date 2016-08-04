package com.weather.videoads;


import io.appium.java_client.AppiumDriver;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.*;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

//import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.DoubleClick;

@SuppressWarnings("unused")
public class VideoAds extends Driver{
	@SuppressWarnings("rawtypes")
 

	@BeforeClass
	public void setUp() throws Exception
	{
		
		//download the App
		DownloadAPP app=new DownloadAPP();
		app.downloadTheAPP();
		Capabilities_android capabilities=new Capabilities_android();
		capabilities.dcap();
		
		
	
		

	}
	@Test
	public void testAd() throws Exception
	{
		 PropertyFile.property();
		System.out.println("Now in Test method");
		Thread.sleep(8000);
	
	/*FileOutputStream fos=new FileOutputStream("F:\\mahesh_weather\\w1.xlsx");
       
	    
	   XSSFWorkbook wb=new XSSFWorkbook();
	    XSSFSheet s = wb.createSheet("Weather");
	    Row row = s.createRow(0);
		row.createCell(0).setCellValue("SNO");
		row.createCell(1).setCellValue("AdTime");
		wb.write(fos);
		fos.close();*/
	
	  //creating excel sheet 
		
		
		FileOutputStream fos=new FileOutputStream(properties.getProperty("excelSheet"));
		
		WritableWorkbook wwb=Workbook.createWorkbook(fos);
		WritableSheet ws=wwb.createSheet("Results",0);
		Label l1=new Label(0,0,"Videos");
		Label l2=new Label(1,0,"AdTime");
		ws.addCell(l1);
		ws.addCell(l2);
		
		
		
		Thread.sleep(8000);
		//clicking on main menu 
		
			
				
	
			// login 
			d.findElementByClassName("android.widget.ImageButton").click();
			//clicking on login
			Thread.sleep(2000);
			d.findElementByName("Log in").click();
			//Thread.sleep(2000);
			
			//uname
			
			d.findElementByName("Email").sendKeys(properties.getProperty("userName"));
			//pwd
			d.findElementById("com.weather.Weather:id/et_password").sendKeys(properties.getProperty("pwd"));
					
			//Login button
			d.findElementById("com.weather.Weather:id/bt_twc_login").click();
			System.out.println("Login success" );
			Thread.sleep(10000);
			
			// Keeping as test mode 
			//////////////////////////////////////////////////////////////////////////////
			//clicking on menu 
			d.findElementByClassName("android.widget.ImageButton").click();
			//clicking on settings
			Thread.sleep(2000);
			d.findElementByName("Settings").click();
			//clicking on about this app
			d.findElementByName("About this app").click();
			for (int i=1; i<=8; i++){
				
				d.findElementById("com.weather.Weather:id/about_version").click();
			}
			//clicking on test mode 
			d.findElementByName("TEST MODE SETTINGS").click();
			
			//clicking on ads 
			d.findElementByName("Ads").click();
			//chooce ads as test
			d.findElementByName("Test").click();
			
			// Kill the App and Launch the App
			//app_Kill_Relaunch.Kill_realaunch();
			
			System.out.println("settings done for ads as test ");
			// Close the app
			d.closeApp();
			Thread.sleep(1000);
			System.out.println("App closed successfully");

			// Relaunch the app
			d.launchApp();
			
			System.out.println("App launched successfully");
			
			//////////////////////////////////////////////////////////////////////////////////////
		d.findElement(By.id("com.weather.Weather:id/location_actionbar_name")).click();
			Thread.sleep(1000);
			//adding test location 
			System.out.println("Adding test location ");
			d.findElement(By.name("Cresbard, SD")).click();
			//d.findElementById("com.weather.Weather:id/place_name").click();
			Thread.sleep(1000);
			

			//scrolling down to videos module

			System.out.println("Scrolling started ");

			 Dimension dimensions = d.manage().window().getSize();
			  System.out.println("dimensions :: "+dimensions);

			  Double startY1 = dimensions.getHeight() * 0.80;
			  System.out.println("startY value :: "+ startY1);

			  int startY = startY1.intValue();
			  System.out.println("startY value = " + startY);

			  Double endY1 = (double) (dimensions.getHeight()/60);  //  dimensions.getHeight()  0.2;  == 512.0
			  System.out.println("endY value :: " + endY1);

			       int endY = endY1.intValue(); 
			       System.out.println("scroll to end = " + endY);

//			       Thread.sleep(1000);

			  for (int i = 0; i < dimensions.getHeight(); i++) 
				{
				  System.out.println("In for loop");

					WebElement videoModule = null;

					try {
//						videoModule = d.findElementById("com.weather.Weather:id/video_title");
						videoModule = d.findElementByName("Video");

					 } catch (Exception e) {
						// System.out.println(e);	
					 }

					if(videoModule!= null && videoModule.isDisplayed()) 
					   { 

					    System.out.println("video section is displayed and tap on video section");
					    
					    Thread.sleep(4000);
					    break;
					   }else
					   {
					    System.out.println("video section is not presented and scrolling down");

					    d.swipe(0, startY,0, endY,2000);

					   }
					  }
					  int m=1;
					  while(m<=10)
					  {
					   d.findElement(By.id("com.weather.Weather:id/grid_item_image")).click();



					  //d.findElementByName("GOT IT").click();


					  /*List<Collections> s=d.findElements(By.id("com.weather.Weather:id/video_row_thumbnail_play"));

					  //Thread.sleep(5000);
					  System.out.println("num of videos:"+s.size());*/
					  int iter=1;
					  int val=1;
					  int count=0;
					  //List<WebElement> clickVideo =d.findElements(By.className("android.widget.ImageView"));
					  //List<WebElement> clickVideo =d.findElements(By.id("com.weather.Weather:id/video_row_thumbnail"));
					  List<WebElement> clickVideo =d.findElements(By.id("com.weather.Weather:id/video_row_thumbnail"));
					  
					  //List<WebElement> clickVideo =d.findElementsByAccessibilityId("Play video");
					  System.out.println("clickvideos:"+clickVideo.size());
					 /* for(int x=0;x<clickVideo.size();x++)
					  {
					   System.out.println("list of videos "+ clickVideo.get(x).getText());
					  }*/
					  
					   for(int list=1;list<=7;list++){
					    for(int j=0;j<2;j++){

					    	 clickVideo.get(j).click();
					     String num=Integer.toString(m);
					     Label l3=new Label(0,val,num+"Iteration of video :"+iter);
					     ws.addCell(l3);

					     val++;

					     long startTime = System.currentTimeMillis();

					     System.out.println("startTime MilliSec: "+startTime);



					     try {

					      //Thread.sleep(2000);

					      d.findElementByAccessibilityId("Learn More").isDisplayed();


					      long endTime = System.currentTimeMillis();

					      System.out.println("EndTime MilliSec: "+endTime);

					      double finalTime = endTime-startTime;

					      System.out.println("finalTime MilliSec: "+finalTime);
					      //row.createCell(1,n).setCellValue(finalTime);
					      double adTime=finalTime/1000;

					      String numberAsString = new Double(adTime).toString();


					      Label l4=new Label(1,val-1,numberAsString);
					      val++;
					      ws.addCell(l4);
					      System.out.println("Total time taken to display the Ad in MilliSec of "+iter+"_Video"+":"+finalTime);

					      System.out.println("Total time taken to display the Ad in Sec of "+iter+"_Video"+":"+finalTime/1000);


					     }catch(Exception e){

					      System.out.println("Ad is not displayed");

					      Label l4=new Label(1,val-1,"Ad is not visible");
					      val++;
					      ws.addCell(l4);

					     }
					     iter++;
					    }
					//Scroll to more videos 
					    d.swipe(0, startY,0, endY,1500);
					    count = count+2;
					    System.out.println("num  of videos:"+count);
					    //Closing Video PIP 
					   if(count <=14){
					  if(d.findElement(By.id("com.weather.Weather:id/video_backdrop_tint")).isDisplayed())
						  
						  d.findElement(By.id("com.weather.Weather:id/video_backdrop_tint")).click();
					  Thread.sleep(1000);
					    d.findElement(By.id("com.weather.Weather:id/dismiss_pip")).click();
					    
					   }

					   }
					   //((AndroidDriver) d).pressKeyCode(AndroidKeyCode.BACK);
					   //d.navigate().back();
					   m++;
					   
					   break;


					  }









					  wwb.write();
					  wwb.close();

					  //Thread.sleep(10000);//
	
	}
	@AfterClass
	public void stop()
	{
		d.quit();

	}



}
