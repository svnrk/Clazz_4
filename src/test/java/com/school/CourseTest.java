package com.school;

import com.school.Course;
import com.school.Teacher;
import org.junit.Assert;
import org.junit.Test;

public class CourseTest {
    Teacher mathTeacher = new Teacher("Math", "com.school.Teacher", "14-03-1980");
    Course math = new Course("Mathematics 101", 3, "01-09-2020", "20-12-2020", mathTeacher);

    @Test
    public void returnsCourseLengthInDays() {
        long output = math.getLengthInDays();
        Assert.assertEquals(output, 111);
    }

    @Test
    public void returnsCourseLengthInDaysMinusHolidays() {
        int output = math.getNumberOfWorkDaysMinusHolidays();
        Assert.assertEquals(output, 79);
    }
}
