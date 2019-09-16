import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TextArea decryptedText;
    public TextArea encryptedText;

    public Button encryptButton;
    public Button decryptButton;
    public Button loadFilesButton;


    public RadioButton columnRadioButton;
    public RadioButton gridRadioButton;
    public RadioButton visenerRadioButton;

    public TextField keyEdit;

    public ToggleGroup toggleButtonGroup;

    private static final String EMPTY_STRING = "";

    @FXML
    private void onPressEncryptButton(ActionEvent event) {
        String key = EMPTY_STRING;
        String plainText = EMPTY_STRING;
        String cipherText = EMPTY_STRING;
        if (columnRadioButton.isSelected()) {
            key = Utils.cleanTextEng(keyEdit.getText());
            plainText = Utils.cleanTextEng(decryptedText.getText());
            keyEdit.setText(key);
            decryptedText.setText(plainText);
            cipherText = Encryptor.columnEncrypt(plainText, key);
        } else if (gridRadioButton.isSelected()) {
            plainText = Utils.cleanTextEng(decryptedText.getText());
            decryptedText.setText(plainText);
            cipherText = Encryptor.customGridEncrypt(plainText);
        } else if (visenerRadioButton.isSelected()) {
            key = Utils.cleanTextRus(keyEdit.getText());
            plainText = Utils.cleanTextRus(decryptedText.getText());
            keyEdit.setText(key);
            decryptedText.setText(plainText);
            cipherText = Encryptor.visenerEncrypt(plainText, key);
        }
        decryptedText.setText(EMPTY_STRING);
        encryptedText.setText(cipherText);
        try {
            FileIOController.writeInput(plainText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileIOController.writeOutput(cipherText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onPressDecryptButton(ActionEvent event) {
        String key = EMPTY_STRING;
        String plainText = EMPTY_STRING;
        String cipherText = EMPTY_STRING;
        if (columnRadioButton.isSelected()) {
            key = Utils.cleanTextEng(keyEdit.getText());
            cipherText = Utils.cleanTextEng(encryptedText.getText());
            keyEdit.setText(key);
            encryptedText.setText(cipherText);
            plainText = Encryptor.columnDecrypt(cipherText, key);
        } else if (gridRadioButton.isSelected()) {
            cipherText = Utils.cleanTextEng(encryptedText.getText());
            encryptedText.setText(cipherText);
            plainText = Encryptor.customGridDecrypt(cipherText);
        } else if (visenerRadioButton.isSelected()) {
            key = Utils.cleanTextRus(keyEdit.getText());
            cipherText = Utils.cleanTextRus(encryptedText.getText());
            keyEdit.setText(key);
            encryptedText.setText(cipherText);
            plainText = Encryptor.visenerDecrypt(cipherText, key);
        }
        encryptedText.setText(EMPTY_STRING);
        decryptedText.setText(plainText);
        try {
            FileIOController.writeInput(plainText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileIOController.writeOutput(cipherText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onPressLoadFilesButton(ActionEvent event) {
        try {
            decryptedText.setText(FileIOController.readInput());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            encryptedText.setText(FileIOController.readOutput());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            decryptedText.setText(FileIOController.readInput());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            encryptedText.setText(FileIOController.readOutput());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
