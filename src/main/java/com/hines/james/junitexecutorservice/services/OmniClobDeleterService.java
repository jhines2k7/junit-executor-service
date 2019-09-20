package com.hines.james.junitexecutorservice.services;

import com.hines.james.junitexecutorservice.config.DataSourceProperties;
import com.hines.james.junitexecutorservice.config.DynamicDataSourceConfiguration;
import com.hines.james.junitexecutorservice.messaging.AuthoringObsoleteMessage;
import com.hines.james.junitexecutorservice.multitenancy.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class OmniClobDeleterService {
    private DataSourceProperties dataSourceProperties;
    private DynamicDataSource dynamicDataSource;
    private ClobDeleterRepositoryService clobDeleterRepositoryService;

    public OmniClobDeleterService(ClobDeleterRepositoryService clobDeleterRepositoryService,
                                  DataSourceProperties dataSourceProperties,
                                  DynamicDataSource dynamicDataSource) {
        this.dataSourceProperties = dataSourceProperties;
        this.dynamicDataSource = dynamicDataSource;
        this.clobDeleterRepositoryService = clobDeleterRepositoryService;
    }

    public void deleteOmniMetaData(AuthoringObsoleteMessage message) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


        for(DynamicDataSourceConfiguration dataSourceConfiguration : dataSourceProperties.getDynamicDataSourceConfigurations()) {
            dynamicDataSource.setDataSourceName(dataSourceConfiguration.getName());

            executorService.execute(() -> delete(message, dataSourceConfiguration, clobDeleterRepositoryService));

            dynamicDataSource.clear();
        }
    }

    void delete(AuthoringObsoleteMessage message, DynamicDataSourceConfiguration dataSourceConfiguration, ClobDeleterRepositoryService clobDeleterRepositoryService) {
        if(dataSourceConfiguration.getName().contains("omni")) {
            clobDeleterRepositoryService.deleteClobData(message.toString());
        }else if(dataSourceConfiguration.getName().contains("favorites_deleter")) {
            clobDeleterRepositoryService.deleteFavoritesData(message.toString());
        }
    }
}
