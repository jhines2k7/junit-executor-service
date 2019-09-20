package com.hines.james.junitexecutorservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class DataSourceProperties {
    private List<DynamicDataSourceConfiguration> dynamicDataSourceConfigurations = new ArrayList<>();
}
