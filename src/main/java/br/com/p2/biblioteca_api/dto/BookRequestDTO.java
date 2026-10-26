package br.com.p2.biblioteca_api.dto;

import br.com.p2.biblioteca_api.model.ReadingStatus;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookRequestDTO(

        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "Author is required")
        String author,

        @NotBlank(message = "Genre is required")
        String genre,

        @NotNull(message = "Publication year is required")
        @Min(value = 1450, message = "Publication year must be at least 1450")
        @Max(value = 2100, message = "Publication year must not exceed 2100")
        Integer publicationYear,

        @NotNull(message = "Reading status is required")
        ReadingStatus readingStatus

) {
}