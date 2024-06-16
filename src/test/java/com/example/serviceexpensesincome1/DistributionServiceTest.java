package com.example.serviceexpensesincome1;

import com.example.serviceexpensesincome1.dto.*;
import com.example.serviceexpensesincome1.entity.Distribution;
import com.example.serviceexpensesincome1.entity.DistributionHistory;
import com.example.serviceexpensesincome1.entity.Tools;
import com.example.serviceexpensesincome1.mapper.*;
import com.example.serviceexpensesincome1.repository.*;
import com.example.serviceexpensesincome1.service.impl.DistributionServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@ExtendWith(MockitoExtension.class)
public class DistributionServiceTest {
    @Mock
    DistributionRepository distributionRepository;
    @Mock
    DistributionMapper distributionMapper;
    @Mock
    ToolsRepository toolsRepository;
    @Mock
    ToolsMapper toolsMapper;
    @Mock
    ServiceRepository serviceRepository;
    @Mock
    ServiceMapper serviceMapper;
    @Mock
    ContractRepository contractRepository;
    @Mock
    ContractMapper contractMapper;
    @Mock
    DistributionHistoryRepository distributionHistoryRepository;
    @Mock
    DistributionHistoryMapper distributionHistoryMapper;
    @InjectMocks
    DistributionServiceImpl distributionService = new DistributionServiceImpl(distributionRepository,distributionMapper,
            toolsRepository,toolsMapper,serviceRepository,serviceMapper,contractRepository,contractMapper
            ,distributionHistoryRepository,distributionHistoryMapper);
    @Test
    void getTaskTest() {
        Distribution distribution=getDistribution();
        DistributionDTO distributionDTO=getDistributionDTO();
        when(distributionRepository.findById(any())).thenReturn(Optional.ofNullable(distribution));
        when(distributionMapper.toDTO(any())).thenReturn(distributionDTO);
        assertThat(distributionService.getDistributionId(1)).isEqualTo(distributionDTO);
        verify(distributionRepository, times(1)).findById(any());
    }
    @Test
    void updateDistributionTest() {
        Distribution distribution=getDistribution();
        DistributionDTO distributionDTO=getDistributionDTO();
        when(distributionRepository.findById(any())).thenReturn(Optional.ofNullable(distribution));
        when(distributionMapper.toHistory(any())).thenReturn(getDistributionHistory());
        when(distributionMapper.toEntity(any())).thenReturn(getDistribution());
        when(distributionRepository.save(any())).thenReturn(getDistribution());
        when(distributionHistoryRepository.save(any())).thenReturn(getDistributionHistory());
        assertThat(distributionService.updateDistribution(1,distributionDTO)).isEqualTo(distributionDTO);
        verify(distributionRepository, times(1)).findById(any());
    }
    @Test
    void removeDistributionTest() {
        Distribution distribution=getDistribution();
        when(distributionRepository.findById(any())).thenReturn(Optional.ofNullable(distribution));
        doNothing().when(distributionRepository).delete(distribution);
        distributionService.removeDistribution(1);
        verify(distributionRepository, times(1)).findById(any());
    }
    @Test
    void getToolsIdTest() {
        Tools tools=getTools(); ToolsDTO toolsDTO=getToolsDTO();
        when(toolsRepository.findById(any())).thenReturn(Optional.ofNullable(tools));
        when(toolsMapper.toDTO(any())).thenReturn(toolsDTO);
        assertThat(distributionService.getToolsId(1)).isEqualTo(toolsDTO);
        verify(toolsRepository, times(1)).findById(any());
    }
//    @Test
//    void updateToolsTest() {
//        Distribution distribution=getDistribution();
//        DistributionDTO distributionDTO=getDistributionDTO();
//        when(distributionRepository.findById(any())).thenReturn(Optional.ofNullable(distribution));
//        when(distributionMapper.toHistory(any())).thenReturn(getDistributionHistory());
//        when(distributionMapper.toEntity(any())).thenReturn(getDistribution());
//        when(distributionRepository.save(any())).thenReturn(getDistribution());
//        when(distributionHistoryRepository.save(any())).thenReturn(getDistributionHistory());
//        assertThat(distributionService.updateDistribution(1,distributionDTO)).isEqualTo(distributionDTO);
//        verify(distributionRepository, times(1)).findById(any());
//    }
//    @Test
//    void removeToolsTest() {
//        Distribution distribution=getDistribution();
//        when(distributionRepository.findById(any())).thenReturn(Optional.ofNullable(distribution));
//        doNothing().when(distributionRepository).delete(distribution);
//        distributionService.removeDistribution(1);
//        verify(distributionRepository, times(1)).findById(any());
//    }


    private Distribution getDistribution() {
        return new Distribution(1,"mts",1,1,LocalDate.of(2021,10,10),1,
                LocalDate.of(2021,10,10),1,1,"111","rty",1,1, Type.TYPE,true,1,1);
    }
    private DistributionDTO getDistributionDTO() {
        return new DistributionDTO("mts",1,1,"2021-10-10",1,
                "2021-10-10",1,1,"111","rty",2,1, Type.TYPE,true,1,1);
    }
    private DistributionHistoryDTO getDistributionHistoryDTO() {
        return new DistributionHistoryDTO("mts",1,1,"2021-10-10",1,
                "2021-10-10",1,1,"111","rty",2,1, Type.TYPE,true,1,1,  "2021-10-10");
    }private DistributionHistory getDistributionHistory() {
        return new DistributionHistory(1,"mts",1,1,LocalDate.of(2021,10,10),1,
                LocalDate.of(2021,10,10),1,1,"111","rty",2,1, Type.TYPE,true,1,1,  LocalDate.of(2021,10,10));
    }

    private Tools getTools() {
        return new Tools(1,Type.TYPE,true,true,1,
                LocalDate.of(2021,10,10),LocalDate.of(2021,10,10),
                LocalDate.of(2021,10,10),LocalDate.of(2021,10,10),
                1, Unit.METR);
    }
    private ToolsDTO getToolsDTO() {
        return new ToolsDTO(1,Type.TYPE,true,true,1,
                "2021-10-10","2021-10-10","2021-10-10","2021-10-10",1, Unit.METR);
    }
}
