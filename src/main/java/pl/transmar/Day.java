package pl.transmar;

import java.io.Serializable;
import java.time.LocalDate;

public class Day implements Serializable {
    private LocalDate date;
    private String description;

    public Day(LocalDate date) {
        this.date = date;
        this.description = "";
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
            return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
