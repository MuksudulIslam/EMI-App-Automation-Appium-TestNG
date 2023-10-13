package Screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EMIcalScreen {
    @FindBy(id = "com.continuum.emi.calculator:id/btnStart")
    WebElement btn_start;
    @FindBy(id = "com.continuum.emi.calculator:id/etLoanAmount")
    WebElement input_Amount;
    @FindBy(id = "com.continuum.emi.calculator:id/etInterest")
    WebElement input_Interest;
    @FindBy(id = "com.continuum.emi.calculator:id/etYears")
    WebElement input_Period_yr;
    @FindBy(id = "com.continuum.emi.calculator:id/etFee")
    WebElement input_Pfee;
    @FindBy(id = "com.continuum.emi.calculator:id/btnCalculate")
    WebElement btn_calculate;
    @FindBy(id = "com.continuum.emi.calculator:id/btnReset")
    WebElement btn_Reset;
    @FindBy(id = "com.continuum.emi.calculator:id/monthly_emi_result")
    public WebElement res_monthlyEmi;
    @FindBy(id = "com.continuum.emi.calculator:id/total_interest_result")
    public WebElement res_totalInterest;
    @FindBy(id = "com.continuum.emi.calculator:id/processing_fee_result")
    public WebElement res_totalPfee;
    @FindBy(id = "com.continuum.emi.calculator:id/total_payment_result")
    public WebElement res_totalPayment;

    public EMIcalScreen(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void emiStart(){
        btn_start.click();
    }

    public void calculateEMI(int amount, double interest, int year, double pfee){
            input_Amount.sendKeys(String.valueOf(amount));
            input_Interest.sendKeys(String.valueOf(interest));
            input_Period_yr.sendKeys(String.valueOf(year));
            input_Pfee.sendKeys(String.valueOf(pfee));
            btn_calculate.click();
    }

    public void resetEMI(){
        btn_Reset.click();
    }
}
