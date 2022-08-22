package com.digitalhonors.processpension.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.digitalhonors.processpension.model.PensionDetail;
import com.digitalhonors.processpension.repository.ProcessRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PensionServiceTest {

	@Mock
	ProcessPensionService mockProcessPensionService;
	
	
	@Mock
	ProcessRepository mockProcessRepository;
	
	@Test
	void calculatePension() {
		PensionDetail dummyPension=new PensionDetail();
		when(mockProcessPensionService.calculatePension(500000000d,4000000d,50000d, "Family", "Private"))
		.thenReturn(dummyPension);
	}
	
	@Test
	void saveOrUpdatePension() {
		PensionDetail dummyPension=new PensionDetail();
		when(mockProcessRepository.save(dummyPension)).thenReturn(dummyPension);
	}
}
