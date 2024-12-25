package com.sapient.test.SapientTest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "last_name")
    private String lastName;

    @Size(max = 50)
    @Column(name = "maiden_name")
    private String maidenName;

    @Min(0)
    @Max(150)
    @Column(name = "age")
    private int age;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "gender")
    private String gender;

    @Email
    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @Size(min = 10, max = 15)
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Size(min = 5, max = 50)
    @Column(name = "username", unique = true)
    private String username;

    @NotNull
    @Size(min = 8, max = 100)
    @Column(name = "password")
    private String password;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "image")
    private String image;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Min(0)
    @Column(name = "height")
    private double height;

    @Min(0)
    @Column(name = "weight")
    private double weight;

    @Column(name = "eye_color")
    private String eyeColor;

    @Embedded
    private HairEntity hair;

    @Column(name = "ip")
    private String ip;

    @Embedded
    private AddressEntity address;

    @Column(name = "mac_address")
    private String macAddress;

    @Column(name = "university")
    private String university;

    @Embedded
    private BankEntity bank;

    @Embedded
    private CompanyEntity company;

    @Column(name = "ein")
    private String ein;

    @Column(name = "ssn")
    private String ssn;

    @Column(name = "user_agent")
    private String userAgent;

    @Embedded
    private CryptoEntity crypto;

    @Column(name = "role")
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public HairEntity getHair() {
        return hair;
    }

    public void setHair(HairEntity hair) {
        this.hair = hair;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public BankEntity getBank() {
        return bank;
    }

    public void setBank(BankEntity bank) {
        this.bank = bank;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public String getEin() {
        return ein;
    }

    public void setEin(String ein) {
        this.ein = ein;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public CryptoEntity getCrypto() {
        return crypto;
    }

    public void setCrypto(CryptoEntity crypto) {
        this.crypto = crypto;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
