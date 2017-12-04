package com.securepenny.databindingbasic;

/**
 * Created by R041708040 on 11/26/2017.
 */

public class DetailInfo {
    private String name;
    private String age;

    public DetailInfo(String name, String age) {
        this.name = name;
        this.age = age;
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

}
