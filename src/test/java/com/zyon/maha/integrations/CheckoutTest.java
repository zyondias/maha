package com.zyon.maha.integrations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CheckoutTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnTotalPriceOfAListOfProducts() throws Exception {
        List<String> productsId = Arrays.asList("001", "002", "001", "004", "003", "001");

        mockMvc.perform(MockMvcRequestBuilders
                .post("/checkout")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(productsId)))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(360));

    }

    @Test
    void shouldReturnZeroWhenProductIdsIsEmpty() throws Exception {
        List<String> productsId = new ArrayList<>();

        mockMvc.perform(MockMvcRequestBuilders
                .post("/checkout")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(productsId)))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(0));

    }

    @Test
    void shouldReturnZeroWhenProductIdsNoExistOnDataBase() throws Exception {
        List<String> productsId = Arrays.asList("no-exist-code");

        mockMvc.perform(MockMvcRequestBuilders
                .post("/checkout")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(productsId)))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(0));

    }

}
