package com.Utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class DateConverter {
    private static ZoneId zone1 = ZoneId.of("Europe/Tallinn");
    private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public static ZonedDateTime dateStringToZDT(String dateString){
        try{
            LocalDate date = LocalDate.parse(dateString, dateFormat);
            ZonedDateTime result = date.atStartOfDay(zone1);
            return result;
        }
        catch (DateTimeParseException e) {
            System.out.println("Invalid date");
            return null;
        }
        catch (NullPointerException e) {
            System.out.println("No date");
            return null;
        }
    }

    public static ZonedDateTime dateStringToZDTSpecial(String dateString, String otherDateFormat) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(otherDateFormat);
        try {
            LocalDate date = LocalDate.parse(dateString, dateFormat);
            ZonedDateTime result = date.atStartOfDay(zone1);
            return result;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date");
            return null;
        }
        catch (NullPointerException e) {
            System.out.println("No date");
            return null;
        }

    }

    public static Long getAgeInYears(ZonedDateTime dateOfBirth) {
        return ChronoUnit.YEARS.between(dateOfBirth, ZonedDateTime.now());
    }
}
