package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.domain.movie.DataMovieEditor;
import br.com.alura.screenmatch.domain.movie.DataMovieRegister;
import br.com.alura.screenmatch.domain.movie.Movie;
import br.com.alura.screenmatch.domain.movie.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {
    //private List<Movie> moviesArray = new ArrayList<>();
    @Autowired
    private MovieRepository repository;
    @GetMapping("form")
    public String theMovieRegister(Long id, Model model){
        if(id != null){
            var moo = repository.getReferenceById(id);
            model.addAttribute("movie", moo);
        }
        return "movies/form";
    }

    @GetMapping
    public String theMovieList(Model model){
        //model.addAttribute("list", moviesArray);
        model.addAttribute("list", repository.findAll());
        return "movies/list";
    }

    @PostMapping
    @Transactional
    public String registerMovie(DataMovieRegister dataMovie){
        var movie = new Movie(dataMovie);
        //moviesArray.add(movie);
        repository.save(movie);
        System.out.println(repository);
        return "redirect:/movies";
    }
    @DeleteMapping
    @Transactional
    public String deleteMovie(Long id){
        repository.deleteById(id);
        return "redirect:/movies";
    }

    @PutMapping
    @Transactional
    public String editMovie(DataMovieEditor dataMovie){
        var moo = repository.getReferenceById(dataMovie.id());
        moo.updateMovie(dataMovie);
        return "redirect:/movies";
    }
}
