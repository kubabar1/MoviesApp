package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MovieDao;
import models.Movie;

@Controller
public class MoviesListRestController {

	@Autowired
	private MovieDao movieDao;

	public MovieDao getMovieDao() {
		return movieDao;
	}

	public void setMovieDao(MovieDao movieDao) {
		this.movieDao = movieDao;
	}

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public String getMovie(Model model) {

		List<Movie> lm = movieDao.getAllMovies();

		model.addAttribute("moviesList", lm);

		return "movie_list";

	}

}
