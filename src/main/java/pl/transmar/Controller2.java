package pl.transmar;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;

public class Controller2 {

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea textArea;
    private LocalDate date;
    private HashMap<LocalDate, Day> days = new HashMap<>();

    public void initialize() {
        String filename = "dailyreports.ser";
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            days = (HashMap<LocalDate, Day>) in.readObject();


            in.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught in loading process.");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught in loading process.");
        }
        datePicker.setValue(LocalDate.now());
        dateSelected();
    }



    @FXML
    private void switchToPrimary() throws Exception {
        GallekApp.setRoot("sample");
    }

    @FXML
    private void dateSelected() {
        date = datePicker.getValue();
        System.out.println("Date selected: " + date);
        textArea.clear();

        if (days.containsKey(date)) {
            String description = days.get(date).getDescription();
            textArea.setText(description);
            System.out.println("Already in HashMap");
        } else {
            Day day = new Day(date);
            days.put(date, day);
            System.out.println("New object Day created");
        }
    }
    @FXML
    private void textAreaHandler() {
        Day day = days.get(date);
        day.setDescription(textArea.getText());
    }

    @FXML
    private void saveDailyReports() {
        String filename = "dailyreports.ser";

        days.values().removeIf(day -> day.getDescription() == null);
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(days);
            out.close();
            file.close();
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught in save process.");
        }
    }
}
