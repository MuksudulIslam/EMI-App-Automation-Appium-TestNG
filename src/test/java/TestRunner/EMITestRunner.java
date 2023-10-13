package TestRunner;

import Data.DataSet;
import Screen.EMIcalScreen;
import Setup.Setup;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EMITestRunner extends Setup {
    EMIcalScreen screen;

    @BeforeTest(description = "EMI Calculator Start")
    public void StartEMI() {
        screen = new EMIcalScreen(driver);
        screen.emiStart();
    }

    @Test(priority = 1, description = "Calculator EMI Calculate", dataProviderClass = DataSet.class, dataProvider = "data-provider")
    public void CalculateEMI(int amount, double interest, int year, double pfee, int mEmi, int tInterest, int PFees, int tPayment ) {
        screen = new EMIcalScreen(driver);
        screen.calculateEMI(amount, interest, year, pfee);

        String actual_mEmi = String.valueOf(Math.round(Double.parseDouble(screen.res_monthlyEmi.getText().replace(",",""))));
        String actual_tInterest = String.valueOf(Math.round(Double.parseDouble(screen.res_totalInterest.getText().replace(",",""))));
        String actual_tPfee = String.valueOf(Math.round(Double.parseDouble(screen.res_totalPfee.getText().replace(",",""))));
        String actual_tPayment = String.valueOf(Math.round(Double.parseDouble(screen.res_totalPayment.getText().replace(",",""))));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual_mEmi, String.valueOf(mEmi));
        softAssert.assertEquals(actual_tInterest, String.valueOf(tInterest));
        softAssert.assertEquals(actual_tPfee, String.valueOf(PFees));
        softAssert.assertEquals(actual_tPayment, String.valueOf(tPayment));
        softAssert.assertAll();

        screen.resetEMI();

    }


}
