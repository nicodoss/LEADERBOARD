package com.e.leaderboard;

public class Projects {
    String FirstName;
    String LastName;
     String Address;
    String Githublink;

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getFirstName() {
        return FirstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getAddress() {
        return Address;
    }
    public void setGithublink(String githublink) {
        Githublink = githublink;
    }

    public Projects(String firstName, String lastName, String address, String githublink) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Address = address;
        this.Githublink = githublink;
    }





    public String getGithublink() {
        return Githublink;
    }
}
