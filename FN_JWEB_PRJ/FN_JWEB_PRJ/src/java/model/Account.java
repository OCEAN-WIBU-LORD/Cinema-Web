/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Account {
    private int acc_id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int age;
    private int gender;
    private String email;
    private int points;
    private int account_type_id;

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" + "acc_id=" + acc_id + ", username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", gender=" + gender + ", email=" + email + ", points=" + points + ", account_type_id=" + account_type_id + '}';
    }

    public Account(int acc_id, String username, String password, String firstname, String lastname, int age, int gender, String email, int points, int account_type_id) {
        this.acc_id = acc_id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.points = points;
        this.account_type_id = account_type_id;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getAccount_type_id() {
        return account_type_id;
    }

    public void setAccount_type_id(int account_type_id) {
        this.account_type_id = account_type_id;
    }
    
    
}
