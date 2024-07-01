package com.example.serviceexpensesincome1.controller;


import com.example.serviceexpensesincome1.dto.*;
import com.example.serviceexpensesincome1.service.DistributionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

/** Контроллер распределения счетов */
@NoArgsConstructor
@RequestMapping("/distribution/")
@Slf4j
@Tag(name = "управление данными")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
public class DistributionController {
    DistributionService distributionService;
    public DistributionController(DistributionService distributionService) {
        this.distributionService = distributionService;
    }

    //------------------Ведение справочника зданий;-------------------------------
   @Operation(summary = "Получить распределения счет")
   @ApiResponses({
           @ApiResponse(responseCode = "200", description = "OK", content = {
                           @Content(array = @ArraySchema(schema = @Schema(implementation = ScoreDTO.class)))})
   })
   @GetMapping("{id}")
   public ResponseEntity<DistributionDTO> getDistributionId(@PathVariable(name = "id")
                                                  @Min(value = 1, message = "Идентификатор должен быть больше 0")
                                                  @Parameter(description = "Идентификатор объявления",
                                                          example = "1")
                                                          int id) {
      return ResponseEntity.ok(distributionService.getDistributionId(id));
   }
   @Operation(summary = "Обновить распределения счет")
   @ApiResponses({
           @ApiResponse(responseCode = "200", description = "OK"),
           @ApiResponse(responseCode = "401", description = "Unauthorized"),
           @ApiResponse(responseCode = "403", description = "Forbidden"),
           @ApiResponse(responseCode = "404", description = "Not Found")
   })
   @PatchMapping("{id}")
   public ResponseEntity<?> updateDistribution(
           @PathVariable(name = "id") @NonNull @Parameter(description = "Больше 0, Например 1") Integer id,
           @RequestBody DistributionDTO distributionDTO) {

      return ResponseEntity.ok().body(distributionService.updateDistribution(id, distributionDTO));
   }
   @Operation(summary = "Удалить распределения счет по id")
   @ApiResponses({
           @ApiResponse(responseCode = "204", description = "No Content"),
           @ApiResponse(responseCode = "401", description = "Unauthorized"),
           @ApiResponse(responseCode = "403", description = "Forbidden")
   })
   @DeleteMapping(value = "{id}")
   public void removeDistribution(@PathVariable(name = "id")
                         @Min(value = 1, message = "Идентификатор должен быть больше 0")
                         @Parameter(description = "Идентификатор объявления",
                                 example = "1") int id) {
      distributionService.removeDistribution(id);
   }
   //------------------------------------------------Ведение справочника основных средств;------------------------------
   @Operation(summary = "Получить основных средств")
   @ApiResponses({
           @ApiResponse(responseCode = "200", description = "OK", content = {
                   @Content(array = @ArraySchema(schema = @Schema(implementation =ScoreDTO.class)))})
   })
   @GetMapping("tools/{id}")
   public ResponseEntity<ToolsDTO> getTools(@PathVariable(name = "id")
                                                            @Min(value = 1, message = "Идентификатор должен быть больше 0")
                                                            @Parameter(description = "Идентификатор объявления",
                                                                    example = "1") int id) {
       return ResponseEntity.ok(distributionService.getToolsId(id));
   }
    @Operation(summary = "Обновить основных средств")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @PatchMapping("tools/{id}")
    public ResponseEntity<?> updateTools(
            @PathVariable(name = "id") @NonNull @Parameter(description = "Больше 0, Например 1") Integer id,
            @RequestBody ToolsDTO toolsDTO) {

        return ResponseEntity.ok().body(distributionService.updateTools(id, toolsDTO));
    }
    @Operation(summary = "Удалить основных средств по id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @DeleteMapping(value = "tools/{id}")
    public void removeTools(@PathVariable(name = "id")
                                   @Min(value = 1, message = "Идентификатор должен быть больше 0")
                                   @Parameter(description = "Идентификатор объявления",
                                           example = "1") int id) {
        distributionService.removeTools(id);
    }
    //------------------------Ведение справочника работ/услуг;--------------------------------
    @Operation(summary = "Получить услугу")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = ScoreDTO.class)))})
    })
    @GetMapping("service/{id}")
    public ResponseEntity<ServiceDTO> getService(@PathVariable(name = "id")
                                             @Min(value = 1, message = "Идентификатор должен быть больше 0")
                                             @Parameter(description = "Идентификатор объявления",
                                                     example = "1") int id) {
        return ResponseEntity.ok(distributionService.getServiceId(id));
    }
    @Operation(summary = "Обновить услугу")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @PatchMapping("service/{id}")
    public ResponseEntity<?> updateService(
            @PathVariable(name = "id") @NonNull @Parameter(description = "Больше 0, Например 1") Integer id,
            @RequestBody ServiceDTO serviceDTO) {

        return ResponseEntity.ok().body(distributionService.updateService(id, serviceDTO));
    }
    @Operation(summary = "Удалить услугу по id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @DeleteMapping(value = "service/{id}")
    public void removeService(@PathVariable(name = "id")
                            @NotBlank(message = "id не должен быть пустым")
                            @Min(value = 1, message = "Идентификатор должен быть больше 0")
                            @Parameter(description = "Идентификатор объявления",
                                    example = "1") int id) {
        distributionService.removeService(id);
    }
    //-------------------------Ведение справочника договоров--------------------------------------
    @Operation(summary = "Получить договор")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = ScoreDTO.class)))})
    })
    @GetMapping("contract/{id}")
    public ResponseEntity<ContractDTO> getContract(@PathVariable(name = "id")
                                                 @NotBlank(message = "id не должен быть пустым")
                                                 @Min(value = 1, message = "Идентификатор должен быть больше 0")
                                                 @Parameter(description = "Идентификатор объявления",
                                                         example = "1") int id) {
        return ResponseEntity.ok(distributionService.getContractFromId(id));
    }
    @Operation(summary = "Обновить договор")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @PatchMapping("contract/{id}")
    public ResponseEntity<?> updateContract(
            @PathVariable(name = "id") @NonNull @Parameter(description = "Больше 0, Например 1") Integer id,
            @RequestBody ContractDTO contractDTO) {

        return ResponseEntity.ok().body(distributionService.updateContract(id, contractDTO));
    }
    @Operation(summary = "Удалить договор по id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @DeleteMapping(value = "contract/{id}")
    public void removeContract(@PathVariable(name = "id")
                              @NotBlank(message = "id не должен быть пустым")
                              @Min(value = 1, message = "Идентификатор должен быть больше 0")
                              @Parameter(description = "Идентификатор объявления",
                                      example = "1") int id) {
        distributionService.removeContract(id);
    }
    //------------------Ведение справочника зданий;-------------------------------
    @Operation(summary = "Получить здание")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = ScoreDTO.class)))})
    })
    @GetMapping("building/{id}")
    public ResponseEntity<BuildingDTO> getBuildingId(@PathVariable(name = "id")
                                                             @NotBlank(message = "id не должен быть пустым")
                                                             @Min(value = 1, message = "Идентификатор должен быть больше 0")
                                                             @Parameter(description = "Идентификатор объявления",
                                                                     example = "1") int id) {
        return ResponseEntity.ok(distributionService.getBuildingId(id));
    }
    @Operation(summary = "Обновить здание")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @PatchMapping("building/{id}")
    public ResponseEntity<?> updateBuilding(
            @PathVariable(name = "id") @NonNull @Parameter(description = "Больше 0, Например 1") Integer id,
            @RequestBody BuildingDTO buildingDTO) {

        return ResponseEntity.ok().body(distributionService.updateBuilding(id, buildingDTO));
    }
    @Operation(summary = "Удалить здание по id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @DeleteMapping(value = "building/{id}")
    public void removeBuilding(@PathVariable(name = "id")
                                   @NotBlank(message = "id не должен быть пустым")
                                   @Min(value = 1, message = "Идентификатор должен быть больше 0")
                                   @Parameter(description = "Идентификатор объявления",
                                           example = "1") int id) {
        distributionService.removeBuilding(id);
    }

    //------------------------- истории результатов распределения расходов.--------------------------------------
    @Operation(summary = "Получить истории распределения расходов")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = ScoreDTO.class)))})
    })
    @GetMapping("history/{year1}/{year2}")
    public ResponseEntity<List<DistributionHistoryDTO>> getHistory(@PathVariable(name = "year1")
                                                                       @NotBlank(message = "year не должен быть пустым")
                                                                       @Min(value = 1, message = "Идентификатор должен быть больше 0")
                                                                       @Max(value = 9999,message = "Идентификатор должен быть меньше 9999")
                                                                       @Parameter(description = "начальный год запроса",
                                                                                                 example = "2020") LocalDate year1,
                                                                   @PathVariable(name = "year1")
                                                                   @NotBlank(message = "year не должен быть пустым")
                                                                   @Min(value = 1, message = "Идентификатор должен быть больше 0")
                                                                   @Max(value = 9999,message = "Идентификатор должен быть меньше 9999")
                                                                   @Parameter(description = "конечный год запроса",
                                                                           example = "2024") LocalDate year2) {
        return ResponseEntity.ok(distributionService.getHistory(year1,year2));
    }
    @Operation(summary = "Получить здание")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = ScoreDTO.class)))})
    })
    @GetMapping("xls")
    public ResponseEntity<MultipartFile> getXls() {
        return ResponseEntity.ok(distributionService.getXls());
    }
}
