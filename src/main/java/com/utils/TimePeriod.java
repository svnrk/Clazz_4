package com.utils;

import com.service.*;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class TimePeriod {
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private List<ZonedDateTime> workDays;
    private List<ZonedDateTime> holidays;
    PublicHolidayService service = new PublicHolidayService();

    public TimePeriod() {
        this.startDate = null;
        this.endDate = null;
    }

    public TimePeriod(ZonedDateTime startDate_, ZonedDateTime endDate_) {
        try {
            if (startDate_.isBefore(endDate_)) {
                this.startDate = startDate_;
                this.endDate = endDate_;
            } else if (endDate_.isBefore(startDate_)) {
                this.startDate = endDate_;
                this.endDate = startDate_;
            } else {
                this.startDate = startDate_;
                this.endDate = startDate_;
            }

            holidays = getListOfHolidaysInPeriod();
            workDays = getListOfWorkDaysInPeriod();
        }
        catch (NullPointerException e){
            System.out.println("No date");
        }
    }

    public Long getPeriodLengthInDays() {
        return ChronoUnit.DAYS.between(startDate, endDate)+1;
    }

    public Long getPeriodLengthInYears() {
        return ChronoUnit.YEARS.between(startDate, endDate);
    }

    public Integer getNumberOfWorkDaysInPeriod() {
        workDays = getListOfWorkDaysInPeriod();
        return workDays.size();
    }

    public List<ZonedDateTime> getListOfWorkDaysInPeriod() {
        workDays = new ArrayList<>();
        for (ZonedDateTime day = startDate; day.isBefore(endDate.plusDays(1)); day.plusDays(1)) {
            int weekday = day.getDayOfWeek().getValue();
            if (weekday < 6) {
                workDays.add(day);
            }
            day = day.plusDays(1);
        }
        return workDays;
    }

    public Integer getNumberOfHolidaysInPeriod() {
        holidays = getListOfHolidaysInPeriod();
        return holidays.size();
    }

    public List<ZonedDateTime> getListOfHolidaysInPeriod() {
        holidays = new ArrayList<>();
        int yearStart = startDate.getYear();
        int yearEnd = endDate.getYear();
        for (int i = yearStart; i <= yearEnd; i++) {
            holidays.addAll(service.getPublicHolidays(Integer.toString(i)));
        }
        holidays.removeIf(holiday -> (holiday.isBefore(startDate)) || (holiday.isAfter(endDate)));

        return holidays;
    }

    public List<ZonedDateTime> getListOfWorkdaysMinusHolidaysInPeriod(){
        workDays = getListOfWorkDaysInPeriod();
        holidays = getListOfHolidaysInPeriod();
        workDays.removeAll(holidays);
        return workDays;
    }

    public Integer getNumberOfWorkdaysMinusHolidaysInPeriod(){
        workDays = getListOfWorkdaysMinusHolidaysInPeriod();
        return workDays.size();
    }

    @Override
    public String toString() {
        return "TimePeriod{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
