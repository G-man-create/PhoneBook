package program.phonebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

import java.io.File;
/**
 * Главный класс приложения "Телефонный справочник", который является точкой входа в программу.
 * Cодержит логику для запуска графического интерфейса пользователя с использованием JavaFX.
 * <p>
 * Класс инициализирует окно приложения, загружает FXML-ресурсы и настраивает логирование с использованием Log4j2.
 */
public class Main extends Application {
    /** Логгер для записи логов. */
    private static final Logger logger = LogManager.getLogger(Main.class);
    /**
     * Инициализирует и отображает главное окно приложения.
     * Загружает FXML-разметку для основного меню, устанавливает иконку и стили для сцены.
     *
     * @param stage основное окно приложения.
     * @throws Exception если возникает ошибка при загрузке FXML или при установке сцены.
     */
    @Override
    public void start(Stage stage) throws Exception {
        logger.info("Запуск приложения Телефонный справочник");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            Scene scene = new Scene((Parent) loader.load());
            Menu menuController = loader.getController();
            menuController.setStage(stage);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("telephone.png")));
            scene.getStylesheets().add(getClass().getResource("/program/phonebook/style.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Телефонный справочник");
            stage.show();
        } catch (Exception e) {
            logger.error("Ошибка при запуске приложения", e);
            throw e;
        }
    }
    /**
     * Точка входа в приложение.
     * Настроивает конфигурацию логирования Log4j2 перед запуском приложения.
     *
     * @param args аргументы командной строки (не используются в текущей реализации).
     */
    public static void main(String[] args) {

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