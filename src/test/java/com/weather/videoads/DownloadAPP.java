package com.weather.videoads;


	
	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.List;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.SearchContext;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.FirefoxProfile;
	import org.testng.annotations.Test;

	

		@SuppressWarnings("unused")
		public class DownloadAPP extends Driver {
			
			public void downloadTheAPP() throws InterruptedException, IOException {		

		/*
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
				Driver.property();
				           
				String downloadPath = properties.getProperty("downloadPath");
				System.out.println("downloadPath is : "+downloadPath);
			
				FirefoxProfile profile = new FirefoxProfile();
				
				profile.setPreference("browser.download.folderList", 2);
				profile.setPreference("browser.download.manager.showWhenStarting", false);
				profile.setPreference("browser.download.dir", downloadPath);
				
				profile.setPreference("browser.helperApps.neverAsk.openFile",
						"text/csv,application/x-msexcel,application/octet-stream,application/vnd.android.package-archive,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/apk");
				
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
		"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/apk");
				
				profile.setPreference("browser.helperApps.alwaysAsk.force", false);
				profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
				profile.setPreference("browser.download.manager.focusWhenStarting", false);
				profile.setPreference("browser.download.manager.useWindow", false);
				profile.setPreference("browser.download.manager.showAlertOnComplete", false);
				profile.setPreference("browser.download.manager.closeWhenDone", false);
				profile.setPreference("browser.download.useDownloadDir", false); 
				
				//To delete all the .APKs from the download path
				
				File index = new File(downloadPath);
				
				if (!index.exists()) {
					
					System.out.println("Specified folder is not exist and creating the same folder now");
				    
					index.mkdir();
				
				} else {
					
					System.out.println("Specified folder is exist and deleting the same folder");
					
					FileUtils.cleanDirectory(index);
					
					System.out.println("Deleted all the files in the specified folder");
					
				}
				
				WebDriver wd = new FirefoxDriver(profile);
				
				Thread.sleep(5000);
				
				wd.manage().window().maximize();
				
				wd.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			
				wd.get("https://rink.hockeyapp.net/users/sign_in");
				
				wd.findElement(By.id("user_email")).sendKeys("kvelappan@weather.com");
				
				wd.findElement(By.id("user_password")).sendKeys("300interstate");
				
				wd.findElement(By.name("commit")).click();
				
				System.out.println("Logged-in into HockeyApp");
				
				Thread.sleep(2000);
//			
//				String Apps = wd.findElement(By.xpath("//ul[@class='nav nav-tabs']/li[2]/a")).getText();
//				
//				System.out.println("Apps text :: "+Apps);
//				
//				wd.findElement(By.xpath("//ul[@class='nav nav-tabs']/li[2]/a")).click();
//				
//				//Click on Android Link
//					
//				Thread.sleep(2000);
//				
//		        String platforms = wd.findElement(By.xpath("//ul[@class='nav nav-pills']/li[2]")).getText();
//				
//				System.out.println("platforms text :: "+platforms);
//			
//				Thread.sleep(1000);
//				
//				wd.findElement(By.linkText("Android")).click();
//
//				System.out.println("Selected Android in the Platforms Dropdown");
//				
//				Thread.sleep(1000);
//				
//				wd.findElement(By.xpath("//input[@type='text']")).click();
//				
//				String platform = wd.findElement(By.xpath("//ul[@class='nav nav-pills']/li[2]/a")).getText();
//				
//				System.out.println("Platform selected is : " + platform);	
//			
//				 // String expectedToClick = "Android Flagship Dev";
//				 
//				// String expectedToClick = "The Weather Channel (flagship)";
//				 
//				 String expectedToClick= properties.getProperty("BuildToDownload");
//				 
//				 System.out.println("expectedToClick is : " + expectedToClick);
//				 
//				 DifferentBuilds db = new DifferentBuilds();
//				 
//				if (expectedToClick.contains("Android Flagship Dev")) {
//						
//					db.downloadApp_AndroidFlagshipDev(wd);
//
//				} else if (expectedToClick.contains("The Weather Channel (flagship)")) {
//
//					db.downloadApp_TheWeatherChannelFlagship(wd);
//				}	
				
				WebElement AppType = wd.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/ul/li[2]/a"));

				
				String Apps = AppType.getText();
				System.out.println("Apps text :: "+Apps);
				
			
				System.out.println("Apps text :: "+Apps);
				if(Apps.contains("Android")){
					System.out.println("Apps content already in :: "+Apps);
				}else{
					

					AppType.click();
					Thread.sleep(2000);
					for(int i=2;i<=7;i++){
						WebElement platforms = wd.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/ul/li[2]/ul/li["+i+"]/a/span"));
						String platformsText = platforms.getText();
						System.out.println("platforms text :: "+platformsText);
						if(platformsText.contains("Android")){
							Thread.sleep(2000);
							platforms.click();
							System.out.println("Selected "+platformsText +"in the Platforms Dropdown");
							break;
						}else{
							System.out.println(platformsText +"not found in the list");
						}
					}

				}

				
				
//				wd.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/ul/li[2]/a")).click();
//				Thread.sleep(2000);
//				String platforms = wd.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/ul/li[2]/ul/li[3]/a/span")).getText();
//				System.out.println("platforms text :: "+platforms);
//				Thread.sleep(2000);
//				wd.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/ul/li[2]/ul/li[3]/a/span")).click();
//				System.out.println("Selected Android in the Platforms Dropdown");
				Thread.sleep(1000);
				String expectedToClick= properties.getProperty("BuildToDownload");
				System.out.println("expectedToClick is : " + expectedToClick);
				
				DifferentBuilds db = new DifferentBuilds();
				 
				if (expectedToClick.contains("Android Flagship Dev")) {
						
					db.downloadApp_AndroidFlagshipDev(wd);

				} else if (expectedToClick.contains("The Weather Channel (flagship)")) {

					db.downloadApp_TheWeatherChannelFlagship(wd);
				}	
				
				
				
				Thread.sleep(1000);
				
				//driver.navigate().to(properties.getProperty("downloadPath"));
				
				String buildNumber =null;
				
				wd.navigate().refresh();
				
				buildNumber  = wd.findElement(By.xpath("//table/tbody/tr/td//a")).getText();
				
				System.out.println("Build Number is "+buildNumber);
				
				properties.setProperty("BuildNumber-Version", buildNumber);
				
				String appPath = properties.getProperty("appPath");
				
				System.out.println("appPath - 1 "+appPath);
				
				appPath = appPath.substring(appPath.indexOf("/Users"), appPath.lastIndexOf("APK/")+4);
				
				System.out.println("appPath - 2 "+appPath);
				
				appPath = appPath+buildNumber;
				
				System.out.println("appPath - 3 "+appPath);
				
				properties.setProperty("appPath", appPath);
				
				FileOutputStream fout = new FileOutputStream(properties.getProperty("dataFilePath"));		
				
				properties.store(fout, "Adding the build text from APKFile1");
				
				wd.close();
			} 
		}

	
