package com.weather.videoads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*import com.twc.driver.Driver;
import com.twc.General.downloadAPP;
import com.twc.driver.PropertyFile;*/

public class DifferentBuilds extends Driver{
	
	public void downloadApp_AndroidFlagshipDev(WebDriver wd) throws InterruptedException, IOException{
		
		//d.property();

  /*	Properties properties = new Properties();

		String dataFilePath = "/Users/monocept/Documents/workspace_luna/com.twc.androidLogcat/buildInfo.properties";
	    //String dataFilePath = "/Users/monocept/Documents/workspace_luna/com.twc.androidLogcat/DataFileNew.Properties";
		
		File file = new File(dataFilePath);

		try {
			FileInputStream fileInput = new FileInputStream(file);
			properties.load(fileInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    */
		
	
		PropertyFile.property();
		
		Thread.sleep(1000);

		String flag = wd.findElement(By.xpath("//table[@id='apps']/tbody/tr[2]/td[2]/div")).getText();
		
		System.out.println("Flag :: " + flag);
		
		wd.findElement(By.xpath("//table[@id='apps']/tbody/tr[2]/td[2]/div")).click();

		Thread.sleep(1000);
		
		wd.findElement(By.linkText("Private Page")).click();
		String  version  = wd.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div[3]/div[7]/h3")).getText();
		
		System.out.println("Version of the build is :: "+version); 
		
		String ver = version.substring(version.indexOf("(")+1, version.indexOf(")"));
		
		System.out.println("Present Build version : "+ver);
		
		//String buildText = "TWC_"+ver+"_release.apk";
		
		//System.out.println("Build Name is :: "+buildText);
		
         String Old_Build = properties.getProperty("AndroidFlagshipDev_BuildVersion");
		
		 System.out.println("Old_Build version : "+Old_Build);
		
		if (!ver.equals(Old_Build)){
			
			System.out.println("New build exists. So, download");
				
			properties.setProperty("AndroidFlagshipDev_BuildVersion", ver);		
			
			FileOutputStream fos =  new FileOutputStream(properties.getProperty("dataFilePath"));
			
			properties.store(fos, "Build Information to download the latest apk and run the scripts");
			
			fos.close();
			
			//wd.findElement(By.xpath("//table[@class='meta-info']/tbody/tr[4]/td[2]//a")).click();
			
			
			Thread.sleep(2000);
			
		//	wd.findElement(By.xpath("//div[@class='state']/a")).click();
			
			wd.findElement(By.linkText("Download")).click();
			Thread.sleep(2000);
			
			wd.navigate().to(properties.getProperty("downloadPath"));
			
			Thread.sleep(200000);
			
		} else{
			
			System.out.println("No need to Download the Alpha - Build, becoz Old Build only exists.");
		}
		

	}
	
	public void downloadApp_TheWeatherChannelFlagship(WebDriver wd) throws InterruptedException, IOException{
			
		Thread.sleep(1000);
		
		//Driver.property();
		Properties properties=new Properties();
		
   /*		
		Properties properties = new Properties();

		String dataFilePath = "/Users/monocept/Documents/workspace_luna/com.twc.androidLogcat/buildInfo.properties";
		//String dataFilePath = "/Users/monocept/Documents/workspace_luna/com.twc.androidLogcat/DataFileNew.Properties";
		File file = new File(dataFilePath);

		try {
			FileInputStream fileInput = new FileInputStream(file);
			properties.load(fileInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
   */	
	
		String flag = wd.findElement(By.xpath("//table[@id='apps']/tbody/tr[4]/td[2]/div")).getText();

		System.out.println(" Flag :: " + flag);

		wd.findElement(By.xpath("//table[@id='apps']/tbody/tr[4]/td[2]/div")).click();
		
		String  version  = wd.findElement(By.xpath("//table[@class='meta-info']/tbody/tr[4]/td[2]//a")).getText();
		
		System.out.println(" Version of the build is :: "+version); 
		
		String ver = version.substring(version.indexOf("(")+1, version.indexOf(")"));
		
		System.out.println("Present Build version : "+ver);
		
		String buildText = "TWC_"+ver+"_release.apk";
		
		//System.out.println("Build Name is :: "+buildText);
		
		  String Old_Build = properties.getProperty("AndroidFlagship_Beta");
			
			 System.out.println("Old_Build version : "+Old_Build);
			
			if (!ver.equals(Old_Build)){
				
				System.out.println("New build exists. So, download");
					
				properties.setProperty("AndroidFlagship_Beta", ver);

				FileOutputStream fos =  new FileOutputStream(properties.getProperty("dataFilePath"));
				
				properties.store(fos, "Build Information to download the latest apk and run the scripts");
				
				fos.close();
				
				wd.findElement(By.xpath("//table[@class='meta-info']/tbody/tr[4]/td[2]//a")).click();
				
				Thread.sleep(2000);
				
				wd.findElement(By.xpath("//div[@class='state']/a")).click();
				
				Thread.sleep(2000);
				
				wd.navigate().to(properties.getProperty("downloadPath"));
				
				Thread.sleep(240000);
				
			} else{
				
				System.out.println("No need to Download the Beta - Build, becoz Old Build only exists.");
			}	
	}

}