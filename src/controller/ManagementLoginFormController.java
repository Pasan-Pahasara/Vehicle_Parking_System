package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagementLoginFormController {
    public JFXButton btnCancel;
    public JFXPasswordField txtPassword;
    public JFXTextField txtName;
    public AnchorPane ManagementLogInContext;
    public AnchorPane anchorPane;
    public Label managementLabel;
    public JFXButton btnLogin;
    public Label lblHide;
    double x, y;


    public void draggedOnMouse(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setX(mouseEvent.getScreenX() - x);
        stage.setX(mouseEvent.getScreenY() - y);
    }

    public void pressedOnMouse(MouseEvent mouseEvent) {
        x = mouseEvent.getSceneX();
        y = mouseEvent.getSceneY();
    }

    public void close(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void max(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }

    public void min(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public void cancelOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) ManagementLogInContext.getScene().getWindow();
        stage.close();
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        login();
    }

    private void login() throws IOException {
        try {
            if (txtName.getText().equalsIgnoreCase("Admin") && txtPassword.getText().equals("0000")) {
                URL resource = getClass().getResource("../view/HomePageForm.fxml");
                Parent load = FXMLLoader.load(resource);
                Scene scene = new Scene(load);
                Stage stage1 = (Stage) anchorPane.getScene().getWindow();
                Stage stage2 = (Stage) ManagementLogInContext.getScene().getWindow();
                Stage stage = new Stage();
                stage.setTitle("Vehicle Parking System");
                stage.setScene(scene);
                stage1.close();
                stage2.close();
                stage.show();
            } else {
                managementLabel.setText("Enter correct username or password");
            }
        } catch (NullPointerException e) {

        }
    }

    //------hide show-----

    public void showPassword(MouseEvent mouseEvent) {

        Image img = new Image("assets/noHide.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(20);
        view.setFitWidth(20);
        lblHide.setGraphic(view);

        txtPassword.setPromptText(txtPassword.getText());
        txtPassword.setText("");
        txtPassword.setDisable(true);
        txtPassword.requestFocus();
    }

    public void hidePassword(MouseEvent mouseEvent) {

        Image img = new Image("assets/hide.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(20);
        view.setFitWidth(20);
        lblHide.setGraphic(view);

        txtPassword.setText(txtPassword.getPromptText());
        txtPassword.setPromptText("");
        txtPassword.setDisable(false);
    }

    //-----------Short cut------

    public void usernameEnterPress(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            txtPassword.requestFocus();
        }
    }

    public void enterKeyPressed(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) login();
    }

    public void setController(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }
}
