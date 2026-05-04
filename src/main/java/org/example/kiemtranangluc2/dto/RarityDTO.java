package org.example.kiemtranangluc2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.kiemtranangluc2.model.GameItem;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
public class RarityDTO {
    @Length(min = 5, max = 50, message = "Name phải từ 3 đến 50 ký tự")
    @NotBlank(message = "Name Không được để trống")
    private String name;

    @NotNull(message = "Drop Rate Không được để trống")
    private Double dropRate;

}
