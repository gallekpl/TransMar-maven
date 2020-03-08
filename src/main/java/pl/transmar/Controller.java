package pl.transmar;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Controller {
    @FXML
    public TextArea textArea;
    @FXML
    private TextField polePracownik;
    @FXML
    private ListView<Pracownik> listaPracownikowView;
    @FXML
    private TextField dayTextField;
    @FXML
    private TextField hoursTextField;
    @FXML
    private ChoiceBox<String> monthChoiceBox;
    @FXML
    private ChoiceBox<String> yearChoiceBox;
    @FXML
    private Label infoLabel;
    @FXML
    private List<Pracownik> lista;
    @FXML
    private Button addHoursButton;
    @FXML
    private Button addWorkerButton;
    @FXML
    private Button removeWorkerButton;
    private Year year;
    private List<Year> years;



    @FXML
    public void initialize() {
        String filename = "lists2.ser";

        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            years = (List<Year>) in.readObject();


            in.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught in loading process.");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught in loading process.");
        }
        if (years == null) {
            years = new LinkedList<>();
            Year year2020 = new Year();
            Year year2021 = new Year();
            Year year2022 = new Year();
            Year year2023 = new Year();
            Year year2024 = new Year();
            Year year2025 = new Year();
            Year year2026 = new Year();
            year = year2020;
            years.add(year2020);
            years.add(year2021);
            years.add(year2022);
            years.add(year2023);
            years.add(year2024);
            years.add(year2025);
            years.add(year2026);

        }

        listaPracownikowView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        year=years.get(0);
        lista = year.getStyczen();
        listaPracownikowView.getItems().addAll(lista);
        textArea.setText("Wybierz pracownika");

        listaPracownikowView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pracownik>() {
            @Override
            public void changed(ObservableValue<? extends Pracownik> observableValue, Pracownik pracownik, Pracownik t1) {
                if (t1 != null) {
                    textArea.setText(t1.pokazGodziny());
                    removeWorkerButton.setDisable(false);
                } else removeWorkerButton.setDisable(true);
            }
        });
        yearChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                String selected;
                switch (t1) {
                    case "2020":
                        year = years.get(0);
                        selected = monthChoiceBox.getSelectionModel().getSelectedItem();
                        monthChoiceBox.getSelectionModel().selectLast();
                        monthChoiceBox.getSelectionModel().selectFirst();
                        monthChoiceBox.getSelectionModel().select(selected);
                        break;
                    case "2021":
                        year = years.get(1);
                        selected = monthChoiceBox.getSelectionModel().getSelectedItem();
                        monthChoiceBox.getSelectionModel().selectLast();
                        monthChoiceBox.getSelectionModel().selectFirst();
                        monthChoiceBox.getSelectionModel().select(selected);
                        break;
                    case "2022":
                        year = years.get(2);
                        selected = monthChoiceBox.getSelectionModel().getSelectedItem();
                        monthChoiceBox.getSelectionModel().selectLast();
                        monthChoiceBox.getSelectionModel().selectFirst();
                        monthChoiceBox.getSelectionModel().select(selected);
                        break;
                    case "2023":
                        year = years.get(3);
                        selected = monthChoiceBox.getSelectionModel().getSelectedItem();
                        monthChoiceBox.getSelectionModel().selectLast();
                        monthChoiceBox.getSelectionModel().selectFirst();
                        monthChoiceBox.getSelectionModel().select(selected);
                        break;
                    case "2024":
                        year = years.get(4);
                        selected = monthChoiceBox.getSelectionModel().getSelectedItem();
                        monthChoiceBox.getSelectionModel().selectLast();
                        monthChoiceBox.getSelectionModel().selectFirst();
                        monthChoiceBox.getSelectionModel().select(selected);
                        break;
                    case "2025":
                        year = years.get(5);
                        selected = monthChoiceBox.getSelectionModel().getSelectedItem();
                        monthChoiceBox.getSelectionModel().selectLast();
                        monthChoiceBox.getSelectionModel().selectFirst();
                        monthChoiceBox.getSelectionModel().select(selected);
                        break;
                    case "2026":
                        year = years.get(6);
                        selected = monthChoiceBox.getSelectionModel().getSelectedItem();
                        monthChoiceBox.getSelectionModel().selectLast();
                        monthChoiceBox.getSelectionModel().selectFirst();
                        monthChoiceBox.getSelectionModel().select(selected);
                        break;
                }
            }
        });
        monthChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                switch (t1) {
                    case "January":
                        textArea.setText("Jan");
                        lista = year.getStyczen();
                        break;
                    case "February":
                        textArea.setText("Feb");
                        lista = year.getLuty();
                        break;
                    case "March":
                        textArea.setText("Mar");
                        lista = year.getMarzec();
                        break;
                    case "April":
                        textArea.setText("Apr");
                        lista = year.getKwiecien();
                        break;
                    case "May":
                        textArea.setText("May");
                        lista = year.getMaj();
                        break;
                    case "June":
                        textArea.setText("Jun");
                        lista = year.getCzerwiec();
                        break;
                    case "July":
                        textArea.setText("Jul");
                        lista = year.getLipiec();
                        break;
                    case "August":
                        textArea.setText("Aug");
                        lista = year.getSierpien();
                        break;
                    case "September":
                        textArea.setText("Sep");
                        lista = year.getWrzesien();
                        break;
                    case "October":
                        textArea.setText("Oct");
                        lista = year.getPazdziernik();
                        break;
                    case "November":
                        textArea.setText("Nov");
                        lista = year.getListopad();
                        break;
                    case "December":
                        textArea.setText("Dec");
                        lista = year.getGrudzien();
                        break;
                    default:
                        break;
                }
                listaPracownikowView.getItems().clear();
                listaPracownikowView.getItems().addAll(lista);
            }
        });
        addHoursButton.setDisable(true);
        addWorkerButton.setDisable(true);
        removeWorkerButton.setDisable(true);
    }

    public void addWorker() {
        if (!polePracownik.getText().equals("")) {
            Pracownik name = new Pracownik(polePracownik.getText());
            lista.add(name);
            listaPracownikowView.getItems().add(name);
            listaPracownikowView.getSelectionModel().selectLast();
            polePracownik.clear();
        } else {
            infoLabel.setText("Podaj imię i nazwisko.");
            infoLabelFade();
        }
    }

    public void removeWorker() {
        Pracownik name = listaPracownikowView.getSelectionModel().getSelectedItem();
        listaPracownikowView.getItems().remove(name);
        lista.remove(name);
    }

    public void dodajGodziny() {
        ObservableList<Pracownik> zaznaczeniList = listaPracownikowView.getSelectionModel().getSelectedItems();
        int day;
        int hours;
        day = Integer.parseInt(dayTextField.getText());
        hours = Integer.parseInt(hoursTextField.getText());

        for (Pracownik zaznaczeni:zaznaczeniList) {

            zaznaczeni.dodajGodziny(day, hours);
            textArea.setText(zaznaczeni.pokazGodziny());
            infoLabel.setText("Added.");
            infoLabelFade();
        }

    }

    public void saveList() {
        String filename = "lists2.ser";
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(years);
            out.close();
            file.close();
            infoLabel.setText("File saved.");
            infoLabelFade();
        }

        catch(IOException ex)
        {
            infoLabel.setText("IOException");
            infoLabelFade();
            System.out.println("IOException is caught in save process.");
        }
    }

    public void exit() {
        saveList();
        Platform.exit();
    }

    public void about(){
        textArea.setText("-------------\n\nMade by Gallek\nJDK 13\nJavaFX13\nMaven\n\n-------------");
    }

    public void infoLabelFade() {

        // Set up a fade-in and fade-out animation for the rectangle
        FadeTransition trans = new FadeTransition(Duration.seconds(3), infoLabel);

        trans.setFromValue(1.0);
        trans.setToValue(.0);
        trans.setCycleCount(1);

        // Play the Animation
        trans.play();


    }

    public void onKeyReleased() {
        int day;
        int hours;
        try {
            day = Integer.parseInt(dayTextField.getText());
            hours = Integer.parseInt(hoursTextField.getText());

        } catch(NumberFormatException e) {
            System.out.println("Wrong input.");
            //e.printStackTrace();
            day = -1;
            hours = -1;
            infoLabel.setText("Wrong input.");
            infoLabelFade();
        }
        if (day<1 || hours<0 || day>31) {
            addHoursButton.setDisable(true);
        } else {
            addHoursButton.setDisable(false);
            infoLabel.setText("Wrong input.");
            infoLabelFade();
        }
        if (polePracownik.getText().isEmpty() || polePracownik.getText().trim().isEmpty()) {
            addWorkerButton.setDisable(true);
        } else addWorkerButton.setDisable(false);
    }
}
