package com.utils;

import com.service.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TimePeriodTest {
    ZonedDateTime startDate = DateConverter.dateStringToZDT("20-09-2019");
    ZonedDateTime endDate = DateConverter.dateStringToZDT("27-12-2019");
    ZonedDateTime endDate2 = DateConverter.dateStringToZDT("27-09-2019");
    ZonedDateTime endDate3 = DateConverter.dateStringToZDT("20-09-2020");

    TimePeriod timePeriod1 = new TimePeriod(Objects.requireNonNull(startDate), endDate);
    TimePeriod timePeriod2 = new TimePeriod(Objects.requireNonNull(endDate), startDate);
    TimePeriod timePeriod3 = new TimePeriod(startDate, endDate2);
    TimePeriod timePeriod4 = new TimePeriod(startDate, endDate3);

    @Mock
    PublicHolidayService service = new PublicHolidayService();

    @InjectMocks
    TimePeriod timePeriod5 = new TimePeriod(startDate, endDate2);

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getsPeriodLengthInDays(){
        long output1 = timePeriod1.getPeriodLengthInDays();
        Assert.assertEquals(99, output1);

        long output2 = timePeriod2.getPeriodLengthInDays();
        Assert.assertEquals(99, output2);

        long output3 = timePeriod3.getPeriodLengthInDays();
        Assert.assertEquals(8, output3);

        long output4 = new TimePeriod(startDate, startDate).getPeriodLengthInDays();
        Assert.assertEquals(1, output4);
    }

    @Test (expected = NullPointerException.class)
    public void getsNullPointerExeption() {
        long output1 = new TimePeriod(null, null).getPeriodLengthInDays();

    }

    @Test
    public void getsPeriodLengthInYears(){
        long output1 = timePeriod1.getPeriodLengthInYears();
        Assert.assertEquals(0, output1);
    }

    @Test
    public void getsNumberOfWorkdaysInPeriod(){
        long output1 = timePeriod1.getNumberOfWorkDaysInPeriod();
        Assert.assertEquals(71, output1);

        long output2 = timePeriod3.getNumberOfWorkDaysInPeriod();
        Assert.assertEquals(6, output2);
    }

    @Test
    public void getsListOfWorkdaysInPeriod(){
        List<ZonedDateTime> output1 = timePeriod1.getListOfWorkDaysInPeriod();
        Assert.assertEquals(71, output1.size());

        List<ZonedDateTime> output2 = timePeriod3.getListOfWorkDaysInPeriod();
        Assert.assertEquals(6, output2.size());
    }

    @Test
    public void getsNumberOfHolidaysInPeriod(){
        int output1 = timePeriod1.getNumberOfHolidaysInPeriod();
        Assert.assertEquals(3, output1);

        int output2 = timePeriod3.getNumberOfHolidaysInPeriod();
        Assert.assertEquals(0, output2);

        int output3 = timePeriod4.getNumberOfHolidaysInPeriod();
        Assert.assertEquals(12, output3);
    }

    @Test
    public void getsListOfHolidaysInPeriod(){
        String output1 = timePeriod1.getListOfHolidaysInPeriod().toString();
        Assert.assertEquals("[2019-12-24T00:00+02:00[Europe/Tallinn], 2019-12-25T00:00+02:00[Europe/Tallinn], 2019-12-26T00:00+02:00[Europe/Tallinn]]", output1);

    }

    @Test
    public void getsNumberOfWorkdaysMinusHolidaysInPeriod(){
        int output1 = timePeriod1.getNumberOfWorkdaysMinusHolidaysInPeriod();
        Assert.assertEquals(68, output1);

        int output2 = timePeriod3.getNumberOfWorkdaysMinusHolidaysInPeriod();
        Assert.assertEquals(6, output2);

        int output3 = timePeriod4.getNumberOfWorkdaysMinusHolidaysInPeriod();
        Assert.assertEquals(251, output3);

    }


    @Test
    public void getsNumberOfHolidaysInPeriodWithMock(){
        List<ZonedDateTime> mockList = new ArrayList<>();
        mockList.add(DateConverter.dateStringToZDT("21-09-2019"));
        mockList.add(DateConverter.dateStringToZDT("22-09-2019"));
        mockList.add(DateConverter.dateStringToZDT("23-09-2019"));
        when(service.getPublicHolidays("2019")).thenReturn(mockList);

        int output1 = timePeriod5.getNumberOfHolidaysInPeriod();
        Assert.assertEquals(3, output1);

    }

    @Test
    public void getsEmptyListOfHolidays(){
        List<ZonedDateTime> mockList = new ArrayList<>();

        when(service.getPublicHolidays("2019")).thenReturn(mockList);

        int output1 = timePeriod5.getNumberOfHolidaysInPeriod();
        Assert.assertEquals(0, output1);

    }

}