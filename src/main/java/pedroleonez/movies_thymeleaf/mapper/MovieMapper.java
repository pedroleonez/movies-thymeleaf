package pedroleonez.movies_thymeleaf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import pedroleonez.movies_thymeleaf.dtos.input.UpsertMovieDto;
import pedroleonez.movies_thymeleaf.dtos.output.RecoveryMovieDto;
import pedroleonez.movies_thymeleaf.model.Movie;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    
    RecoveryMovieDto toRecovery(Movie movie);

    @Mapping(target = "id", ignore = true)
    Movie toCreate(UpsertMovieDto upsertMovieDto);

    @Mapping(target = "id", ignore = true)
    void toUpdate(UpsertMovieDto upsertMovieDto, @MappingTarget Movie movie);
}
