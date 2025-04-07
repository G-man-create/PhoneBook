package program.phonebook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;

import java.io.File;

public class Launcher {
    public static void main(String[] args){
        new File("logs").mkdirs();

        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        File configFile = new File("src/main/resources/program/phonebook/log4j2.xml");
        if (configFile.exists()) {
            context.setConfigLocation(configFile.toURI());
        } else {
            System.err.println("Log4j2 config file not found at: " + configFile.getAbsolutePath());
        }
        Main.main(args);
    }
}
