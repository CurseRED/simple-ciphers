import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Maksim Kuntsevich
 * Program realizes three basic encoding methods including column cipher, grid cipher and visener cipher.
 * Written using JavaFX
 * @version 1.0
 */

public class Main extends Application {

    @Override
    public void init() {
        FileIOController.initialize("input.txt", "output.txt");
    }

    @Override
    public void start(Stage stage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("template.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (root != null) {
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.setMaximized(false);
            stage.getIcons().add(new Image("file:binary-code.png"));
            stage.setTitle("Basic encryptor");
            stage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
