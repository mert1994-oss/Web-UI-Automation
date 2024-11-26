package helper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;
import util.DriverFactory;
import java.io.IOException;


@Slf4j
public class LoginHelper {

    public static void checkAndSetTokens() {

        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperties().get("url").toString());
    }

        private static JSONObject getJsonObject(CloseableHttpClient httpclient, HttpPost httppost) throws IOException {
        String jsonString = EntityUtils.toString(httpclient.execute(httppost).getEntity());
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject;
    }

}
