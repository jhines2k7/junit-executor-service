package com.hines.james.junitexecutorservice.services;

import com.hines.james.junitexecutorservice.data.repositories.OmFavoritesRepository;
import com.hines.james.junitexecutorservice.data.repositories.OmniMetaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClobDeleterRepositoryService {
    private OmFavoritesRepository omFavoritesRepository;
    private OmniMetaDataRepository omniMetaDataRepository;

    @Autowired
    public ClobDeleterRepositoryService(OmFavoritesRepository omFavoritesRepository, OmniMetaDataRepository omniMetaDataRepository) {
        this.omFavoritesRepository = omFavoritesRepository;
        this.omniMetaDataRepository = omniMetaDataRepository;
    }

    void deleteClobData(String templateName){
        omniMetaDataRepository.deleteClobData(templateName);
    }

    void deleteFavoritesData(String templateName) {
          omFavoritesRepository.deleteFavoritesData(templateName);
    }
}
