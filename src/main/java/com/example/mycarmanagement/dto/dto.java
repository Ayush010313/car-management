package com.example.mycarmanagement.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class dto {
    private Long id;

    @NotBlank
    private String make;

    @NotBlank
    private String model;

    @NotNull
    @PositiveOrZero
    private Integer year;
}
