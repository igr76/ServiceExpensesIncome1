package com.example.serviceexpensesincome1.controller;

import com.example.serviceexpensesincome1.dto.DistributionDTO;
import com.example.serviceexpensesincome1.dto.ForecastingDTO;
import com.example.serviceexpensesincome1.dto.ScoreDTO;
import com.example.serviceexpensesincome1.service.DistributionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/** Контроллер прогнозирования расходов */
@NoArgsConstructor
@RequestMapping("/forecasting")
@Slf4j
@Tag(name = "прогнозирования расходов")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
public class ForecastingController {
    DistributionService distributionService;

    public ForecastingController(DistributionService distributionService) {
        this.distributionService = distributionService;
    }

    @Operation(summary = "Получить здание")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = ScoreDTO.class)))})
    })
    @GetMapping("{date1},{date2}")
    public ResponseEntity<List<ForecastingDTO>> getDistributionId(@PathVariable(name = "date1") LocalDate date1,
                                                                  @PathVariable(name = "date2")LocalDate date2) {
        return ResponseEntity.ok(distributionService.getForecasting(date1,date2));
    }
}
