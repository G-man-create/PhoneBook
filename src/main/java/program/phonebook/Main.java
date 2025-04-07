package program.phonebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

import java.io.File;

public class Main extends Application {
    private static final Logger logger = LogManager.getLogger(Main.class);

    @Override
    public void start(Stage stage) throws Exception {
        logger.info("Запуск приложения Телефонный справочник");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            Scene scene = new Scene(loader.load());
            Menu menuController = loader.getController();
            menuController.setStage(stage);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("telephone.png")));
            stage.setScene(scene);
            stage.setTitle("Телефонный справочник");
            stage.show();
        } catch (Exception e) {
            logger.error("Ошибка при запуске приложения", e);
            throw e;
        }
    }

    public static void main(String[] args) {
        new File("logs").mkdirs();

        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        File configFile = new File("src/main/resources/program/phonebook/log4j2.xml");
        if (configFile.exists()) {
            context.setConfigLocation(configFile.toURI());
        } else {
            System.err.println("Log4j2 config file not found at: " + configFile.getAbsolutePath());
        }

        launch(args);
    }
}