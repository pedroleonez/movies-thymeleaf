package pedroleonez.movies_thymeleaf.dtos.output;

public record RecoveryMovieDto(
        Long id,
        String title,
        String movieYear,
        String director,
        String genre
) {

}
