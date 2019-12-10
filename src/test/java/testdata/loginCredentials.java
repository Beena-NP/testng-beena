package testdata;

import org.testng.annotations.DataProvider;

public class loginCredentials {

    @DataProvider(name="loginCredentials")
    public static Object[][] loginData()
    {
        return new Object[][]
        {
            {"beenabioinfo@gmail.com", "abc123"}
        };
    }


}
