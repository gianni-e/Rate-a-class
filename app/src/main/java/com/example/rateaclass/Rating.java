package com.example.rateaclass;

public class Rating
{
    private int starRating;
    private String courseName;
    private String courseNumber;
    private String comments;
    private String instructor;

    public Rating(){}

    public Rating(int rating, String name, String number, String comment, String professor)
    {
        this.starRating = rating;
        this.courseName = name;
        this.courseNumber = number;
        this.comments = comment;
        this.instructor = professor;
    }

    public void setStarRating(int rating)
    {
        this.starRating = rating;
    }
    public int getStarRating()
    {
        return this.starRating;
    }

    public void setCourseName(String name)
    {
        this.courseName = name;
    }
    public String getCourseName()
    {
        return this.courseName;
    }

    public void setCourseNumber(String number)
    {
        this.courseNumber = number;
    }
    public String getCourseNumber()
    {
        return this.courseNumber;
    }

    public void setComments(String comment)
    {
        this.comments = comment;
    }
    public String getComments()
    {
        return this.comments;
    }

    public void setInstructor(String instructor)
    {
        this.instructor = instructor;
    }
    public String getInstructor()
    {
        return this.instructor;
    }
}
