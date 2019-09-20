package com.hines.james.junitexecutorservice.services;

import com.hines.james.junitexecutorservice.config.DataSourceProperties;
import com.hines.james.junitexecutorservice.data.repositories.OmFavoritesRepository;
import com.hines.james.junitexecutorservice.data.repositories.OmniMetaDataRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class JunitExecutorServiceApplicationTests {
	private OmniClobDeleterService mockDeleterService;

	@Mock
	private OmFavoritesRepository mockOmFavoritesRepository;

	@Mock
	private OmniMetaDataRepository mockOmniMetaDataRepository;

	@Mock
	private DataSourceProperties mockDataSourceProperties;

	@BeforeAll
	public void setup() {
		mockDeleterService = new OmniClobDeleterService(mockOmFavoritesRepository, mockOmniMetaDataRepository, mockDataSourceProperties);
	}

	@Test
	void multiThreadedDeleteCallsTheCorrectRepo() {
		//mockDeleterService.delete();
	}

}
