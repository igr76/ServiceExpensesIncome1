package com.example.serviceexpensesincome1.controller;

import com.example.serviceexpensesincome1.dto.NewPassword;
import com.example.serviceexpensesincome1.dto.UserDTO;
import com.example.serviceexpensesincome1.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RequestMapping("/users")
@Slf4j
@Tag(name = "Пользователи")
@RestController
public class UserController {


  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @Operation(summary = "Установить новый пароль")
  @ApiResponses({
      @ApiResponse(
          responseCode = "200",
          description = "OK",
          content =
          @Content(
              array = @ArraySchema(schema = @Schema(implementation = NewPassword.class)))
      ),
      @ApiResponse(
          responseCode = "401",
          description = "Unauthorized",
          content = @Content(schema = @Schema())
      ),
      @ApiResponse(
          responseCode = "403",
          description = "Forbidden",
          content = @Content(schema = @Schema())
      ),
      @ApiResponse(
          responseCode = "404",
          description = "Not Found",
          content = @Content(schema = @Schema())
      )
  })
  @PostMapping(value = "/setPassword")
  public ResponseEntity<NewPassword> setPassword(
      @RequestBody
      @NotBlank(message = "newPassword не должен быть пустым") NewPassword newPassword) {
    log.info("FormLogInfo.getInfo()");
    NewPassword newPasswordDTO = userService.setPassword(newPassword);
    return ResponseEntity.ok(newPasswordDTO);
  }

  @Operation(summary = "Получить пользователя")
  @ApiResponses({
      @ApiResponse(
          responseCode = "200",
          description = "OK",
          content = @Content(
              array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))
      ),
      @ApiResponse(
          responseCode = "401",
          description = "Unauthorized",
          content = @Content(schema = @Schema())
      ),
      @ApiResponse(
          responseCode = "403",
          description = "Forbidden",
          content = @Content(schema = @Schema())
      ),
      @ApiResponse(
          responseCode = "404",
          description = "Not Found",
          content = @Content(schema = @Schema())
      )
  })
  @GetMapping(value = "/{email}")
  public ResponseEntity<UserDTO> getUser(@PathVariable(name = "id")
                                           @NotBlank(message = "id не должен быть пустым")String email) {
    log.info("FormLogInfo.getInfo()");
    return ResponseEntity.ok(userService.getUser(email));
  }

  @Operation(summary = "Обновить пользователя")
  @ApiResponses({
      @ApiResponse(
          responseCode = "200", description = "OK", content = @Content(
              array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))
      ),
      @ApiResponse(responseCode = "204", description = "No Content",
          content = @Content(schema = @Schema())
      ),
      @ApiResponse(
          responseCode = "401",
          description = "Unauthorized",
          content = @Content(schema = @Schema())
      ),
      @ApiResponse(
          responseCode = "403",
          description = "Forbidden",
          content = @Content(schema = @Schema())
      ),
      @ApiResponse(
          responseCode = "404",
          description = "Not Found",
          content = @Content(schema = @Schema())
      )
  })
  @PatchMapping
  public ResponseEntity<UserDTO> updateUser(
          @RequestBody
      @NotBlank(message = "updateUser не должен быть пустым") UserDTO userDto) {
    log.info("");
    return ResponseEntity.ok(userService.updateUser(userDto));
  }



}