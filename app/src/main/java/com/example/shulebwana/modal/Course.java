package com.example.shulebwana.modal;

public class Course {


    public String Coursecode;
    public String Coursename;
    public int credits;
    public int yearofstudy;

    public String getCoursecode() {
        return Coursecode;
    }

    public void setCoursecode(String coursecode) {
        Coursecode = coursecode;
    }

    public String getCoursename() {
        return Coursename;
    }

    public void setCoursename(String coursename) {
        Coursename = coursename;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getYearofstudy() {
        return yearofstudy;
    }

    public void setYearofstudy(int yearofstudy) {
        this.yearofstudy = yearofstudy;
    }

    public int getSemister() {
        return semister;
    }

    public void setSemister(int semister) {
        this.semister = semister;
    }

    public int semister;
}
