package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    public LoginPage(Page page){
        this.page = page;
    }

    public void enterUsername(String user){
        page.fill("#username", user);
    }

    public void enterPassword(String pass){
        page.fill("#password", pass);
    }

    public void clickLogin(){
        page.click("button[type='submit']");
    }
}