package com.securepenny.databindingbasic;

/**
 * Created by R041708040 on 11/26/2017.
 */

public class DetailInfo {
    private String title;
    private String name;
    private String age;
    private String group;

    public DetailInfo(String title,String name, String age, String group) {
        this.title=title;
        this.name = name;
        this.age = age;
        this.group=group;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
