package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.Movie;
import models.MoviesList;

@Controller
public class MoviePropertiesRestController {
	private MoviesList moviesList;

	public void setMoviesList(MoviesList moviesList) {
		this.moviesList = moviesList;
	}

	public MoviesList getMoviesList() {
		return moviesList;
	}

	@RequestMapping(value = "/movies/{movie_id}", method = RequestMethod.GET)
	public String getMovie(@PathVariable("movie_id") String movie_id, Model model) {

		Movie m = moviesList.getMovie(movie_id);
		
		model.addAttribute("movie_by_id", m);


		return "movie_properties";

	}
}
