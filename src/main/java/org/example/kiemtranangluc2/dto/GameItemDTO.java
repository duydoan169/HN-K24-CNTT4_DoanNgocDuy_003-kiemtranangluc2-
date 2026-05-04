package org.example.kiemtranangluc2.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.kiemtranangluc2.model.Rarity;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class GameItemDTO {
    @Length(min = 5, max = 150, message = "Item name phải từ 5 đến 150 ký tự")
    @NotBlank(message = "Item name Không được để trống")
    private String itemName;

    @NotBlank(message = "Game title Không được để trống")
    private String gameTitle;

    @NotNull(message = "Market price Không được để trống")
    private Double marketPrice;

    @NotNull(message = "Market price Không được để trống")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dropDate;

    @NotNull(message = "File Không được để trống")
    private MultipartFile file;

    @NotNull(message = "Is tradeable Không được để trống")
    private Boolean isTradeable;

    @NotNull(message = "Rarity Không được để trống")
    private Long rarityId;
}
