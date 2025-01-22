package com.example.DigitalLibrary.interfaces;

import java.util.Map;

public interface QueryModel {

    public String getCreateQuery();
    public String getSearchOneQuery();
    public String getSearchAllQuery();
    public String getDeleteQuery();
    public String getUpdateObeQuery(Map<String,Object>fields);
}
