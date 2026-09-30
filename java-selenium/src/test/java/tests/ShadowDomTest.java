package tests;

import org.testng.annotations.Test;

public class ShadowDomTest extends BaseTest{

    @Test(groups = {"smoke"})
    public void testClickButton(){
        driver.get(BASE_URL + "/click");


}
