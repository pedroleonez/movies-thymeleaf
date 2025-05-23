package pedroleonez.movies_thymeleaf.dtos.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpsertMovieDto(
        @NotBlank
        String title,

        @NotNull
        int year) {
}
