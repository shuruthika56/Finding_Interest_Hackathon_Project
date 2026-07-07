
package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader() {

        prop = new Properties();

        try {

            FileInputStream fis = new FileInputStream(
                    "src/main/resources/config.properties");

            prop.load(fis);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public String getUrl() {

        return prop.getProperty("url");
    }

    public String getBrowser() {

        return prop.getProperty("browser");
    }


    public String getLoanAmount() {
        return prop.getProperty("loanAmount");
    }

    public String getInterestRate(){

        return prop.getProperty("interestRate");
    }

    public String getLoanTenure(){

        return prop.getProperty("loanTenure");
    }

    public String getFeesCharges(){

        return prop.getProperty("feesCharges");
    }

    public String getEmi(){
        return prop.getProperty("emi");
    }

    public String getMonth(){
        return prop.getProperty("loanTenureMonth");
    }







}