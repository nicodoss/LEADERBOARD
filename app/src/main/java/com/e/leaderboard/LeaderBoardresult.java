package com.e.leaderboard;

public class LeaderBoardresult {
 private String name;
 private String hours;
 private String imagecover;

 public LeaderBoardresult(){};
    public LeaderBoardresult(String name,String hours,String imagecover){
        this.name=name;
        this.hours=hours;
        this.imagecover=imagecover;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getImagecover() {
        return imagecover;
    }

    public void setImagecover(String imagecover) {
        this.imagecover = imagecover;
    }
}
