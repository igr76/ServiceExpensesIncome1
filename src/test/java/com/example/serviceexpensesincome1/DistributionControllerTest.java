package com.example.serviceexpensesincome1;

import com.example.serviceexpensesincome1.controller.DistributionController;
import com.example.serviceexpensesincome1.dto.DistributionDTO;
import com.example.serviceexpensesincome1.entity.Distribution;
import com.example.serviceexpensesincome1.exeption.ElemNotFound;
import com.example.serviceexpensesincome1.mapper.DistributionMapper;
import com.example.serviceexpensesincome1.repository.DistributionRepository;
import com.example.serviceexpensesincome1.service.DistributionService;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DistributionController.class)
public class DistributionControllerTest {
    private MockMvc mockMvc;
    private DistributionController distributionController;
    private DistributionRepository distributionRepository;
    private DistributionMapper distributionMapper;
    private MockMultipartFile file;
    private JSONObject jsonObject;
    @Test
    void getDistributionIdTest() throws Exception {
        int id = 1;
        String url = "/distribution/"  + id;

        when(distributionRepository.findById(any())).thenReturn(Optional.of(new Distribution()));
        when(distributionMapper.toDTO(any())).thenReturn(new DistributionDTO());

        mockMvc.perform(get("/distribution/"  + id))
                .andExpect(status().isOk());
    }
}
