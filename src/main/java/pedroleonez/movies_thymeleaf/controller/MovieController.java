package pedroleonez.movies_thymeleaf.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import pedroleonez.movies_thymeleaf.dtos.input.UpsertMovieDto;
import pedroleonez.movies_thymeleaf.dtos.output.RecoveryMovieDto;
import pedroleonez.movies_thymeleaf.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid UpsertMovieDto upsertMovieDto) {
        movieService.create(upsertMovieDto);
        return ResponseEntity.status(201).build();
    }
    
    @GetMapping
    public ResponseEntity<List<RecoveryMovieDto>> findAll() {
        var movies = movieService.findAll();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecoveryMovieDto> findById(@PathVariable("id") Long id) {
        var movie = movieService.findById(id);
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Valid UpsertMovieDto upsertMovieDto) {
        movieService.update(id, upsertMovieDto);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        movieService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
