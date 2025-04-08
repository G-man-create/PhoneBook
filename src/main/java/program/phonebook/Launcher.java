package program.phonebook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Класс Launcher является точкой входа в приложение, вызывая метод {@link Main#main(String[])} для запуска основного приложения.
 * Этот класс используется, чтобы отделить логику запуска приложения от основной логики,
 */
public class    Launcher {
    /** Логгер для записи логов. */
    private static final Logger logger = LogManager.getLogger(Launcher.class);
    /**
     * Основная точка входа для запуска приложения.
     * Этот метод вызывает {@link Main#main(String[])} для запуска основного приложения.
     *
     * @param args аргументы командной строки, передаваемые в {@link Main#main(String[])}.
     */
    public static void main(String[] args){
        try {
            logger.info("Запуск приложения через класс Launcher.");
            Main.main(args);
        } catch (Exception e) {
            logger.error("Ошибка при запуске приложения через класс Launcher", e);
        }
    }
}
