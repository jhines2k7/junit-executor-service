package com.hines.james.junitexecutorservice.multitenancy;

import lombok.Data;

@Data
public class DynamicDataSource {
    private String dataSourceName;

    public void clear(){};
}
