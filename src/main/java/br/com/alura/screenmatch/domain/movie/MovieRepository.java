package br.com.alura.screenmatch.domain.movie;

import org.springframework.data.jpa.repository.JpaRepository;
public interface MovieRepository extends JpaRepository<Movie, Long> {
}