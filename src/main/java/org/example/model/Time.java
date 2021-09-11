package org.example.model;

import lombok.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Data
@Builder
@AllArgsConstructor
public class Time {
    private String currentTime;

    public Time() {
        this.currentTime = " " + new GregorianCalendar().get(Calendar.HOUR) + " : " +
                new GregorianCalendar().get(Calendar.MINUTE);
    }
}
