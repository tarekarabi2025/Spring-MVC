package com.tarek.springdemo.mvc;

import com.tarek.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName ;


    @NotNull(message = "is required")
    @Size (min = 1,message = "is required" )
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0,message = "must be greater than or equal 0 ")
    @Max(value = 10,message = "must be less than or equal 10 ")
    private Integer freePasses;




    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "Only 5 chars/digits")
    private String postalCode;

    @CourseCode(value = "tarek",message = "must start with tarek")
    private String courseCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
