package dao;

import java.util.List;

import models.Movie;

public interface MovieDaoInterface {

	public void addMovie(Movie movie);

	public List<Movie> getAllMovies();

	public Movie getMovieById(String id);
}
