package com.school;


import com.utils.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;



public class Course {

    private String name;
    private Integer eap;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private TimePeriod timePeriod;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();

    private static List<Course> courses = new ArrayList<>();

    public Course(String name, Integer eap, String startDate, String endDate, Teacher teacher) {
        this.name = name;
        this.eap = eap;
        this.startDate = DateConverter.dateStringToZDT(startDate);
        this.endDate = DateConverter.dateStringToZDT(endDate);
        this.timePeriod = new TimePeriod(this.startDate, this.endDate);
        this.teacher = teacher;
        courses.add(this);
    }

    public Course(String name, Integer eap, TimePeriod timePeriod, Teacher teacher) {
        this.name = name;
        this.eap = eap;
        this.timePeriod = timePeriod;
        this.teacher = teacher;
        courses.add(this);
    }

    public void addStudent(Student student) {
        if (students.contains(student)){
            student.addCourse(this);}
        }


    public String getName() {
        return name;
    }

    public Integer getEap() {
        return eap;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public Long getLengthInDays(){
        return timePeriod.getPeriodLengthInDays();
    }

    public Integer getNumberOfWorkDaysMinusHolidays(){
        return timePeriod.getNumberOfWorkdaysMinusHolidaysInPeriod();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEap(Integer eap) {
        this.eap = eap;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = DateConverter.dateStringToZDT(startDate);
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = DateConverter.dateStringToZDT(endDate);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", eap=" + eap +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", teacher=" + teacher +
                '}' + '\n';
    }

    public static List<Course> getCourses(){
        return courses;
    }
}
