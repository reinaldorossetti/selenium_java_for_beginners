package br.com.selenium.for_beginners.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import br.com.selenium.for_beginners.enums.Browsers;
import br.com.selenium.for_beginners.enums.OperationSystems;

public class DriverFactory {

    public static WebDriver createDriver(String mvnParameter){

        try {
            String soName = getSoName();
            String browserType = getBrowserTypeFromParameter(mvnParameter);
            System.setProperty(browserType, getDriversPath(soName).concat(getFullExecutableNameFromParameter(mvnParameter)));
        }catch (Exception e){
            System.out.println("ERROR: Please select one of the valid browsers for the test.");
            Browsers.showAvaliableBrowsersOptions();
            System.exit(1);
        }
		
        return Browsers.valueOf(mvnParameter).createDriverInstance();
    }

    private static String formatSoName(String soName){
        return soName.replace(" ", "_").toUpperCase();
    }

    private static String getBrowserTypeFromParameter(String mvnParameter ){
        return Browsers.valueOf(mvnParameter).getBrowserType();
    }

    private static String getDriversPath(String osName){
        return OperationSystems.valueOf(formatSoName(osName)).getDriversPath();
    }

    private static String getSoName(){
        return System.getProperty("os.name");
    }

    private static String getFullExecutableNameFromParameter (String mvnParameter){
        return Browsers.valueOf(mvnParameter).getExecutable();
    }
}
