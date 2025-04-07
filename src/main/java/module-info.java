module program.phonebook {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;
    opens program.phonebook to javafx.fxml;
    exports program.phonebook;
}