package com.example.serviceexpensesincome1.mapper;

import com.example.serviceexpensesincome1.dto.DistributionHistoryDTO;
import com.example.serviceexpensesincome1.entity.DistributionHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface DistributionHistoryMapper {
//    @Mapping(target = "accountYear", source = "accountYear",
//            dateFormat = "dd-MM-yyyy ")
//    @Mapping(target = "dateAccount", source = "dateAccount",
//            dateFormat = "dd-MM-yyyy ")
//    @Mapping(target = "DateRegistration", source = "DateRegistration",
//            dateFormat = "dd-MM-yyyy ")
    DistributionHistoryDTO  toDTO(DistributionHistory distributionHistory);
//    @Mapping(target = "accountYear", source = "accountYear",
//            dateFormat = "dd-MM-yyyy ")
//    @Mapping(target = "dateAccount", source = "dateAccount",
//            dateFormat = "dd-MM-yyyy ")
//    @Mapping(target = "DateRegistration", source = "DateRegistration",
//            dateFormat = "dd-MM-yyyy ")
    Collection<DistributionHistoryDTO> toDTOList(Collection<DistributionHistory> distributionHistoryCollection);
}
