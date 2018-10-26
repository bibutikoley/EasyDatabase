package dev.bibuti.easydatabase.models;
/*
 *
 * EasyDatabase
 * Developed By - Bibuti Koley
 * All Rights Reserved. © 2018
 * Created at - 26-Oct-18 October 2018 (09:36)
 *
 */

public class User {

    private String name, gender, workField;

    public User() {
    }

    public User(String name, String gender, String workField) {
        this.name = name;
        this.gender = gender;
        this.workField = workField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWorkField() {
        return workField;
    }

    public void setWorkField(String workField) {
        this.workField = workField;
    }
}
