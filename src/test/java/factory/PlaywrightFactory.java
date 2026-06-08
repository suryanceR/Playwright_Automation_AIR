package factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static void initBrowser() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false));

        context = browser.newContext();

        page = context.newPage();
    }

    public static Page getPage() {
        return page;
    }

    public static void closeBrowser() {

        if(context != null)
            context.close();

        if(browser != null)
            browser.close();

        if(playwright != null)
            playwright.close();
    }
}