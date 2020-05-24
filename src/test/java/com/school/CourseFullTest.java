package com.school;

import org.junit.Assert;
import org.junit.Test;

public class CourseFullTest {
    Teacher mathTeacher = new Teacher("Math", "Teacher", "14-03-1980");
    Course math = new Course("Mathematics 101", 3, "01-09-2020", "20-12-2020", mathTeacher);

    @Test
    public void returnsCourseLengthInDays() {
        long output = math.getLengthInDays();
        Assert.assertEquals(111, output);
    }

    @Test
    public void returnsCourseLengthInDaysMinusHolidays() {
        int output = math.getNumberOfWorkDaysMinusHolidays();
        Assert.assertEquals(79, output);
    }
}
