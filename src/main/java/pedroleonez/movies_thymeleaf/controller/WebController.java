package pedroleonez.movies_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pedroleonez.movies_thymeleaf.dtos.input.UpsertMovieDto;
import pedroleonez.movies_thymeleaf.service.MovieService;

@Controller
public class WebController {
    
    private final MovieService movieService;
    private static final String REDIRECT_MOVIES = "redirect:/movies";
    
    public WebController(MovieService movieService) {
        this.movieService = movieService;
    }
    
    private void addSuccessMessage(RedirectAttributes redirectAttributes, String message) {
        redirectAttributes.addFlashAttribute("success", message);
    }
    
    private void addErrorMessage(RedirectAttributes redirectAttributes, String operation, Exception e) {
        System.out.println("Erro ao " + operation + ": " + e.getMessage());
        e.printStackTrace();
        redirectAttributes.addFlashAttribute("error", "Erro ao " + operation + ": " + e.getMessage());
    }
    
    private void addErrorMessage(Model model, String message) {
        model.addAttribute("error", message);
    }
    
    @GetMapping("/movies/create")
    public String createMovieForm() {
        return "create";
    }    @PostMapping("/movies/create")
    public String createMovie(@ModelAttribute UpsertMovieDto movieDto, RedirectAttributes redirectAttributes) {
        try {
            System.out.println("Recebido requisição para criar filme: " + movieDto.title() + ", ano: " + movieDto.movieYear());
            movieService.create(movieDto);
            addSuccessMessage(redirectAttributes, "Filme criado com sucesso!");
            return REDIRECT_MOVIES;
        } catch (Exception e) {
            addErrorMessage(redirectAttributes, "criar filme", e);
            return "redirect:/movies/create";
        }
    }
    
    @GetMapping("/movies")
    public String listMovies(org.springframework.ui.Model model) {
        var movies = movieService.findAll();
        model.addAttribute("movies", movies);
        return "list";
    }
    
    @GetMapping("/movies/{id}/edit")
    public String editMovieForm(@PathVariable Long id, Model model) {
        try {
            var movie = movieService.findById(id);
            model.addAttribute("movie", movie);
            return "edit";
        } catch (Exception e) {
            addErrorMessage(model, "Filme não encontrado: " + e.getMessage());
            return REDIRECT_MOVIES;
        }
    }
    
    @PostMapping("/movies/{id}/edit")
    public String updateMovie(
            @PathVariable Long id,
            @ModelAttribute UpsertMovieDto movieDto,
            RedirectAttributes redirectAttributes) {
        try {
            movieService.update(id, movieDto);
            addSuccessMessage(redirectAttributes, "Filme atualizado com sucesso!");
            return REDIRECT_MOVIES;
        } catch (Exception e) {
            addErrorMessage(redirectAttributes, "atualizar filme", e);
            return "redirect:/movies/" + id + "/edit";
        }
    }
    
    @PostMapping("/movies/{id}/delete")
    public String deleteMovie(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes) {
        try {
            movieService.delete(id);
            addSuccessMessage(redirectAttributes, "Filme excluído com sucesso!");
            return REDIRECT_MOVIES;
        } catch (Exception e) {
            addErrorMessage(redirectAttributes, "excluir filme", e);
            return REDIRECT_MOVIES;
        }
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
