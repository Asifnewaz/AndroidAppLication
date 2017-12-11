package com.securepenny.newsapp.model;

import java.util.List;


/**
 * Created by R041708040 on 12/7/2017.
 */

public class Website {
    private String status;
    private List<Source> sources;

    public Website() {
    }

    public Website(String status, List<Source> sourceList) {
        this.status = status;
        this.sources = sourceList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sourceList) {
        this.sources = sourceList;
    }
}
