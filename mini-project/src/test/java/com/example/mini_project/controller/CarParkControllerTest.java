package com.example.mini_project.controller;

import com.example.mini_project.service.CarParkService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CarParkController.class,
        excludeAutoConfiguration = {SecurityAutoConfiguration.class})
class CarParkControllerTest {

    @TestConfiguration
    static class WebClientTestConfig {
        @Bean
        WebClient.Builder webClientBuilder() {
            return WebClient.builder();
        }
    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarParkService carParkService;

    private static final String ENDPOINT = "/carparks/nearest";

    @Test
    @DisplayName("400 when both latitude and longitude missing")
    void nearest_missingBothParams() throws Exception {
        mockMvc.perform(get(ENDPOINT))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message").value("Missing or invalid required parameters: latitude and longitude."));
    }

    @Test
    @DisplayName("400 when latitude missing")
    void nearest_missingLatitude() throws Exception {
        mockMvc.perform(get(ENDPOINT).param("longitude", "106.7000"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message").value("Missing or invalid required parameters: latitude and longitude."));
    }

    @Test
    @DisplayName("400 when longitude missing")
    void nearest_missingLongitude() throws Exception {
        mockMvc.perform(get(ENDPOINT).param("latitude", "10.7800"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message").value("Missing or invalid required parameters: latitude and longitude."));
    }

    @Test
    @DisplayName("400 when invalid latitude (out of range)")
    void nearest_invalidLatitude() throws Exception {
        mockMvc.perform(get(ENDPOINT)
                        .param("latitude", "999")   // triggers validation if annotated
                        .param("longitude", "106.7000"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message").value("Missing or invalid required parameters: latitude and longitude."));
    }

    @Test
    @DisplayName("400 when invalid longitude (out of range)")
    void nearest_invalidLongitude() throws Exception {
        mockMvc.perform(get(ENDPOINT)
                        .param("latitude", "10.7800")
                        .param("longitude", "999"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message").value("Missing or invalid required parameters: latitude and longitude."));
    }
}
