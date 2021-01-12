package pl.transmar;

import javafx.fxml.FXML;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;

public class Controller2 {

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea textArea;
    private LocalDate date;
    protected static HashMap<LocalDate, Day> days = new HashMap<>();



    public void initialize() {
        datePicker.setDayCellFactory(new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(DatePicker param) {
                final DateCell dc = new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (Controller2.days.containsKey(item) && Controller2.days.get(item).getDescription().trim().equals("")) {
                            setTextFill(Color.BLACK);
                        } else if (Controller2.days.containsKey(item)) {
                            setTextFill(Color.BLUEVIOLET);
                        } else {
                            setTextFill(Color.BLACK);
                        }
                    }
                };
                return dc;
            }
        });

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
            System.out.println("Object exists - not creating.");
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
