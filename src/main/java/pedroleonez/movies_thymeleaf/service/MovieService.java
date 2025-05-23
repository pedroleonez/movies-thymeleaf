package pedroleonez.movies_thymeleaf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pedroleonez.movies_thymeleaf.dtos.input.UpsertMovieDto;
import pedroleonez.movies_thymeleaf.dtos.output.RecoveryMovieDto;
import pedroleonez.movies_thymeleaf.mapper.MovieMapper;
import pedroleonez.movies_thymeleaf.repository.MovieRepository;

@Service
public class MovieService {
    
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public void create(UpsertMovieDto upsertMovieDto) {
        var movie = movieMapper.toCreate(upsertMovieDto);
        movieRepository.save(movie);
    }

    public List<RecoveryMovieDto> findAll() {
        var movies = movieRepository.findAll();
        return movies.stream()
                .map(movieMapper::toRecovery)
                .toList();
    }

    public RecoveryMovieDto findById(Long id) {
        var movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        return movieMapper.toRecovery(movie);
    }

    public void update(Long id, UpsertMovieDto upsertMovieDto) {
        var movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        movieMapper.toUpdate(upsertMovieDto, movie);
        movieRepository.save(movie);
    }

    public void delete(Long id) {
        var movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        movieRepository.delete(movie);
    }
}
