package pedroleonez.movies_thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pedroleonez.movies_thymeleaf.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
