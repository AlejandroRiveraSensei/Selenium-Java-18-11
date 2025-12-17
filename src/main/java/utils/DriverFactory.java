package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    // ThreadLocal ensures each thread gets its own WebDriver instance
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    public static WebDriver driver;

    public static WebDriver initializaDriver(){
        ChromeOptions options = new ChromeOptions();
        Map<Object,Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        prefs.put("profile.password_manager_leak_detection",false);
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments();
        options.setExperimentalOption("prefs",prefs);
        // Correr chrome en background
        // CI/CD Implementation
        if(System.getenv("CI") != null){
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*"); // CORS error
            options.addArguments("--disable-gpu");
            options.addArguments("--user-data-dir=/tmp/chrome-" + System.currentTimeMillis()); // Add temporary directory to avoid errors
        }

        driver = new ChromeDriver(options);
        return driver;
    }

    public static void launchUrl(String url){
        driver.get(url);
    }

}
