package pedroleonez.movies_thymeleaf.dtos.input;

import jakarta.validation.constraints.NotBlank;

public record UpsertMovieDto(
        @NotBlank
        String title,

        @NotBlank
        String movieYear) {
}
