package br.com.alura.screenmatch.domain.movie;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movie_name;
    private Integer duration;
    private Integer movie_release;
    private String genre;
    public Movie(DataMovieRegister data) {
        this.movie_name = data.movieName();
        this.duration = data.movieDuration();
        this.movie_release = data.movieRelease();
        this.genre = data.movieGenre();
    }
    public Movie(){}
    public Long getId() {
        return id;
    }
    public String getMovie_name() {
        return movie_name;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getMovie_release() {
        return movie_release;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + movie_name + '\'' +
                ", duration=" + duration +
                ", genre='" + genre + '\'' +
                ", Release=" + movie_release +
                '}';
    }

    public void updateMovie(DataMovieEditor dataMovie) {
        this.movie_name = dataMovie.movieName();
        this.duration = dataMovie.movieDuration();
        this.genre = dataMovie.movieGenre();
        this.movie_release = dataMovie.movieRelease();
    }
}
