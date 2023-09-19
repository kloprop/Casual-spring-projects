package com.example.exercise_usstock;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.exercise_usstock.model.Profile;
import com.example.exercise_usstock.model.Quote;
import com.example.exercise_usstock.service.ProfileService;
import com.example.exercise_usstock.service.QuoteService;

@WebMvcTest
public class StockControllerTest {
  @Autowired
  private MockMvc mockMvc; 
  // The only obj in context which provides needed context

  @MockBean
  private ProfileService profileService; // created from mockMvc

  @MockBean
  private QuoteService quoteService; // created from mockMvc

  @Test
  void testGetStock() throws Exception  { 
    Profile profile = new Profile("China", "CNY", "CNY","Medical",
                                   LocalDate.of(2019, 5, 4), "pear",5.4, "fruit","1234",7.90, "fru","hi");
    Quote quote = new Quote(9.8, 3.4, 4, 34.5, 23.4 ,90 ,45.5);
    Mockito.when(profileService.findProfile("fru")).thenReturn(profile);
    Mockito.when(quoteService.findQuote("fru")).thenReturn(quote);
    // Mockito.verify(null, null)
    // assume that the api can be received

    ResultActions mvcResult =
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/stock/fru")); 
        // act as postMan to send request to trigger the method in controller

    mvcResult.andExpect(status().isOk()) // HTTP 200
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.data.currentPrice").value(9.8))
        // attribute called data and the first field's id attribute
        .andExpect(jsonPath("$.data.dayHigh").value(34.5))
        .andExpect(jsonPath("$.data.companyProfile.country").value("China"))
        .andExpect(jsonPath("$.data.companyProfile.currency").value("CNY"));
  }
  


}
