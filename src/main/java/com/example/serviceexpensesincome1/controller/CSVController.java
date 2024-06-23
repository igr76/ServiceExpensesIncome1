package com.example.serviceexpensesincome1.controller;

import com.example.serviceexpensesincome1.dto.ContractDTO;
import com.example.serviceexpensesincome1.dto.DistributionDTO;
import com.example.serviceexpensesincome1.service.DistributionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/** Контроллер распределения счетов по загруженному файлу*/
@NoArgsConstructor
@RequestMapping("/csv")
@Slf4j
@Tag(name = "распределения счетов по загруженному файлу")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
public class CSVController {
    DistributionService distributionService;
    @Operation(summary = "распределения счетов по загруженному файлу")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @PatchMapping
    public ResponseEntity<List<DistributionDTO>> updateContract(@RequestParam MultipartFile file) throws IOException {

        return ResponseEntity.ok().body(distributionService.CSVexport(file));
    }
}
