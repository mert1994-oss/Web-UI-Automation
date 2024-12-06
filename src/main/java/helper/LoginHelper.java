/*
package helper;

import enums.ROLE;
import lombok.extern.slf4j.Slf4j;
import model.Tokens;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;
import util.DriverFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LoginHelper {

    private static final String ACCESS_TOKEN_NAME = "ps_cloud_token";
    private static final String REFRESH_TOKEN_NAME = "refresh_token";

    public static void checkAndSetTokens(String roleName) {
        ROLE role = ROLE.getRole(roleName);

        WebDriver driver = DriverFactory.getDriver();
        driver.manage().deleteAllCookies();

        //We have to go to the page to be able to set the tokens
        driver.get(ConfigReader.getProperties().get("cookie-landing-page").toString());

        login(role);

        driver.get(ConfigReader.getProperties().get("url").toString());
    }

    private static void login(ROLE role) {

        String email = ConfigReader.getProperties().get(role.getEmailParam()).toString();
        String password = ConfigReader.getProperties().get(role.getPasswordParam()).toString();

        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost httppost = new HttpPost(ConfigReader.getProperties().get("authentication-url").toString());

        try {
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            nameValuePairs.add(new BasicNameValuePair("grant_type", "password"));
            nameValuePairs.add(new BasicNameValuePair("username", email));
            nameValuePairs.add(new BasicNameValuePair("password", password));
            nameValuePairs.add(new BasicNameValuePair("client_id", "pscloud"));
            nameValuePairs.add(new BasicNameValuePair("client_secret", ConfigReader.getProperties().get("authentication-secret").toString()));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            String access_token = "";
            String refreshToken = "";

            while (access_token.equals("")) {
                try {
                    JSONObject jsonObject = getJsonObject(httpclient, httppost);

                    if ((jsonObject.get("access_token")) != null) {
                        access_token = jsonObject.getString("access_token");
                        refreshToken = jsonObject.getString("refresh_token");
                    } else {
                        log.error("Failed to get access token");
                    }
                } catch (Exception e) {
                    log.error("Failed to get access token" + e.getMessage());
                }

            }

            Tokens tokens = new Tokens();
            tokens.setAccessToken(access_token);
            tokens.setRefreshToken(refreshToken);
            addCookiesToDriver(tokens);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static JSONObject getJsonObject(CloseableHttpClient httpclient, HttpPost httppost) throws IOException {
        String jsonString = EntityUtils.toString(httpclient.execute(httppost).getEntity());
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject;
    }

    private static void addCookiesToDriver(Tokens tokens) {
        DriverFactory.getDriver().manage().addCookie(new Cookie(ACCESS_TOKEN_NAME, tokens.getAccessToken()));
        DriverFactory.getDriver().manage().addCookie(new Cookie(REFRESH_TOKEN_NAME, tokens.getRefreshToken()));
    }

} */