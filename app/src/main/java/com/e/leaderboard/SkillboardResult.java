package com.e.leaderboard;

public class SkillboardResult {
    private String name;
    private String skill;
    private String imagecover;

    public SkillboardResult() {
    }

    public SkillboardResult(String name, String skill, String imagecover) {
        this.name = name;
        this.skill = skill;
        this.imagecover = imagecover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getImagecover() {
        return imagecover;
    }

    public void setImagecover(String imagecover) {
        this.imagecover = imagecover;
    }
}
