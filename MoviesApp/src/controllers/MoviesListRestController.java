package controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.Movie;
import models.MoviesList;

@Controller
public class MoviesListRestController {

	private MoviesList moviesList;

	public void setMoviesList(MoviesList moviesList) {
		this.moviesList = moviesList;
	}

	public MoviesList getMoviesList() {
		return moviesList;
	}

	
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public String getMovie(Model model) {

		ArrayList<Movie> lm = moviesList.getListMovies();
		
		model.addAttribute("moviesList", lm);


		return "movie_list";

	}

}
