package com.idevlab.LabMgr.Entity;

public class User {
    private String UserName;
    private String Password;
    private String Salt;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return name + age;
    }



    //#region getter and setter

    /**
     * @return the salt
     */
    public String getSalt() {
        return Salt;
    }

    /**
     * @param salt the salt to set
     */
    public void setSalt(String salt) {
        this.Salt = salt;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.UserName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.Password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    //#endregion
}