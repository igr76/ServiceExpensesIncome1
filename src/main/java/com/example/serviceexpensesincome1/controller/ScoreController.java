package com.example.serviceexpensesincome1.controller;

import com.example.serviceexpensesincome1.dto.ScoreDTO;
import com.example.serviceexpensesincome1.service.ScoreService;
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
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Контроллер  счетов */
@NoArgsConstructor
@RequestMapping("/score")
@Slf4j
@Tag(name = "ведение счетов")
@RestController
public class ScoreController {
    private ScoreService scoreService;
    @Operation(summary = "Получить все cчета")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = ScoreDTO.class)))
                    }
            )
    })
    @GetMapping
    public ResponseEntity<List<ScoreDTO>> getScoreAll() {
        return ResponseEntity.ok(scoreService.getScoreAll());
    }
    @Operation(summary = "Обновить счет")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {
                            @Content(
                                    schema = @Schema(ref = "#/components/schemas/AdsDTO"))
                    }
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found"
            )
    })
    @PatchMapping("{id}")
    public ResponseEntity<?> updateScore(
            @PathVariable(name = "id") @NonNull @Parameter(description = "Больше 0, Например 1") Integer id,
            @RequestBody ScoreDTO scoreDTO) {

        return ResponseEntity.ok().body(scoreService.updateScore(id, scoreDTO));
    }
    @Operation(summary = "Удалить счет по id")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "No Content"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden"
            )
    })
    @DeleteMapping(value = "/{id}")
    public void removeScore(@PathVariable(name = "id")
                          @NotBlank(message = "id не должен быть пустым")
                          @Min(value = 1, message = "Идентификатор должен быть больше 0")
                          @Parameter(description = "Идентификатор объявления",
                                  example = "1") int id) {
        scoreService.removeScore(id);
    }
}
