package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Member {
    @Id
    private int memberId;

    @NotBlank(message="name cannot be empty")
    private String name;
    
    @Email(message="enter valid email")
    private String email;

    @Pattern(regexp = "[0-9]{10}", message = "Mobile number must be 10 digits")
    private String mobileNo;
    @NotBlank(message="city cannot be empty")
    private String city;
    @NotBlank(message="password cannot be empty")
    private String password;

    public Member() {
    }

    public Member(String city, String email, int memberId, String mobileNo, String name, String password) {
        this.city = city;
        this.email = email;
        this.memberId = memberId;
        this.mobileNo = mobileNo;
        this.name = name;
        this.password = password;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member [memberId=" + memberId + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo
                + ", city=" + city + ", password=" + password + "]";
    }
    


    
}
