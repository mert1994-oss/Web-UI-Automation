package helper;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.DriverFactory;
import java.io.File;
import java.io.IOException;

@Slf4j
public class DownloadHelper {

    private static final Logger log = LogManager.getLogger(DownloadHelper.class);

    public static boolean checkDownloadFolder(String fileName) {

        File dir = new File(DriverFactory.DOWNLOAD_PATH);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().contains(fileName)) {
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    public static String getDownloadedFilePath() {
        File dir = new File(DriverFactory.DOWNLOAD_PATH);
        File[] dirContents = dir.listFiles();

        if (dirContents.length == 1) {
            return dirContents[0].getAbsolutePath();
        }
        return "";
    }

    public static void initializeDownloadPath() {
        try {
            File file = new File(DriverFactory.DOWNLOAD_PATH);

            if (file.isDirectory()) {
                FileUtils.cleanDirectory(new File(DriverFactory.DOWNLOAD_PATH));
            } else {
                file.mkdirs();
            }

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
