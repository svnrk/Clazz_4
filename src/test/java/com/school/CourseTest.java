package com.school;

import com.school.Course;
import com.school.Teacher;
import com.service.PublicHolidayService;
import com.utils.DateConverter;
import com.utils.TimePeriod;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.ZonedDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

public class CourseTest {
    Teacher mathTeacher = new Teacher("Math", "Teacher", "14-03-1980");
    ZonedDateTime startDate = DateConverter.dateStringToZDT("20-09-2019");
    ZonedDateTime endDate = DateConverter.dateStringToZDT("27-12-2019");

    @Mock
    TimePeriod timePeriod = new TimePeriod(startDate, endDate);

    @InjectMocks
    Course math = new Course("Mathematics 101", 3, timePeriod, mathTeacher);

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void returnsCourseLengthInDays() {
        when(timePeriod.getPeriodLengthInDays()).thenReturn((long) 3);
        long output = math.getLengthInDays();
        Assert.assertEquals(3, output);
    }

    @Test
    public void returnsCourseLengthInDaysMinusHolidays() {
        when(timePeriod.getNumberOfWorkdaysMinusHolidaysInPeriod()).thenReturn( 3);
        int output = math.getNumberOfWorkDaysMinusHolidays();
        Assert.assertEquals(3, output);
    }

    @Test
    public void getsCoursesList(){
        List<Course> courses = Course.getCourses();
        for (Course c : courses){
            System.out.println(c);
        }
    }
}
