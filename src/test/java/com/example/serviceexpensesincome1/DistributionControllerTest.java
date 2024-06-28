package com.example.serviceexpensesincome1;

import com.example.serviceexpensesincome1.controller.DistributionController;
import com.example.serviceexpensesincome1.dto.DistributionDTO;
import com.example.serviceexpensesincome1.dto.ServiceDTO;
import com.example.serviceexpensesincome1.dto.ToolsDTO;
import com.example.serviceexpensesincome1.entity.Distribution;
import com.example.serviceexpensesincome1.entity.Service;
import com.example.serviceexpensesincome1.entity.Tools;
import com.example.serviceexpensesincome1.exeption.ElemNotFound;
import com.example.serviceexpensesincome1.mapper.DistributionMapper;
import com.example.serviceexpensesincome1.mapper.ServiceMapper;
import com.example.serviceexpensesincome1.mapper.ToolsMapper;
import com.example.serviceexpensesincome1.repository.DistributionRepository;
import com.example.serviceexpensesincome1.repository.ServiceRepository;
import com.example.serviceexpensesincome1.repository.ToolsRepository;
import com.example.serviceexpensesincome1.service.DistributionService;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DistributionController distributionController;
    @MockBean
    private DistributionRepository distributionRepository;
    @MockBean
    private DistributionMapper distributionMapper;
    @MockBean
    private ToolsRepository toolsRepository;
    @MockBean
    private ToolsMapper toolsMapper;
    @MockBean
    private ServiceRepository serviceRepository;
    @MockBean
    private ServiceMapper serviceMapper;
    private MockMultipartFile file;
    private JSONObject jsonObject;

    @Test
    void getDistributionIdTest() throws Exception {
        int id = 1;

        when(distributionRepository.findById(any())).thenReturn(Optional.of(new Distribution()));
        when(distributionMapper.toDTO(any())).thenReturn(new DistributionDTO());

        mockMvc.perform(get("/distribution/"  + id))
                .andExpect(status().isOk());
    }
    @Test
    void getToolsIdTest() throws Exception {
        int id = 1;
        when(toolsRepository.findById(any())).thenReturn(Optional.of(new Tools()));
        when(toolsMapper.toDTO(any())).thenReturn(new ToolsDTO());

        mockMvc.perform(get("/distribution/tools/"  + id))
                .andExpect(status().isOk());
    }
    @Test
    void getServiceTest() throws Exception {
        int id = 1;
        when(serviceRepository.findById(any())).thenReturn(Optional.of(new Service()));
        when(serviceMapper.toDTO(any())).thenReturn(new ServiceDTO());

        mockMvc.perform(get("/distribution/tools/"  + id))
                .andExpect(status().isOk());
    }
}
