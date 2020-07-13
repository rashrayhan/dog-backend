package com.traxon.dogbackend;


import com.traxon.dogbackend.service.DogServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DogBackendApplicationTests {
	@Autowired
	private MockMvc mockMvc;

//	@InjectMocks
//	private DogServiceImpl dogService;

	private final String LOCAL_URL = "http://localhost:8081/api/v1";

//	@Before
//	public void setUp() throws Exception {
//		mockMvc = MockMvcBuilders.standaloneSetup(dogService).build();
//	}


	@Test
	public void getAllDogs() throws Exception{
		mockMvc
				.perform(MockMvcRequestBuilders.get(LOCAL_URL+"/")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.*", Matchers.hasSize(14))) //size of the expected result
				.andReturn();
	}

	@Test
	public void createDog() throws Exception{
		String newDog = "{\"breed\":\"Wingila\",\"name\":\"Wesh\",\"origin\":\"Buffalo, CA\"}";
		mockMvc.perform(MockMvcRequestBuilders.post(LOCAL_URL+"/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(newDog)
				.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
				.andReturn();
	}

}
