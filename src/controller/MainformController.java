package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import model.SubjectMarks;

public class MainformController {
    public TextField txtID;
    public TextField txtName;
    public TextField txtSubject;
    public TextField txtMarks;
    public Button btnRemove;
    public Button btnAdd;
    public Button btnPrint;
    public Button btnExport;
    public TableView<SubjectMarks> tblMarks;


    public void initialize(){
        btnAdd.setDisable(true);
        btnRemove.setDisable(true);
        btnExport.setDisable(true);
        btnPrint.setDisable(true);

        ChangeListener<String> changeListener = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!(txtSubject.getText().trim().isEmpty()) || txtMarks.getText().trim().isEmpty()) {
                    btnAdd.setDisable(false);
                } else {
                    btnAdd.setDisable(true);
                }

            }
        };

        txtSubject.textProperty().addListener(changeListener);

        txtMarks.textProperty().addListener(changeListener);

        // Number only text field
        txtMarks.setTextFormatter(new TextFormatter<Object>(change -> {
            if (change.getControlNewText().matches("^\\d*([.]\\d*)?$")) {
                return change;
            }

            return null;
        }));
    }



    public void btnRemove_OnAction(ActionEvent actionEvent) {
    }

    public void btnAdd_OnAction(ActionEvent actionEvent) {
    }

    public void btnPrint_OnAction(ActionEvent actionEvent) {
    }

    public void btnExport_OnAction(ActionEvent actionEvent) {
    }
}
