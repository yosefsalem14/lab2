import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Login_Controller {

    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label resultLabel;
    private ArrayList<User> users ;
    @FXML
    public void initialize() {
        users = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("Accounts.txt"))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                if (parts.length != 2) continue;

                try {
                    users.add(new User(parts[0], parts[1]));
                } catch (IllegalArgumentException ignored) {
                    // invalid user skipped
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Accounts.txt not found");
        }
    }

    @FXML
    private void handleLogin() {

        String email = emailField.getText();
        String password = passwordField.getText();

        for (User u : users) {
            if (u.getName().equals(email)
                    && u.getPassword().equals(password)) {

                try {
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("Success.fxml")
                    );

                    Scene scene = new Scene(loader.load());

                    Stage stage = (Stage) emailField.getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return;
            }
        }

        resultLabel.setText("User not found");
    }

}