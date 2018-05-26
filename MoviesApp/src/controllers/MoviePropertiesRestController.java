package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MovieDao;
import models.Movie;

@Controller
public class MoviePropertiesRestController {
	
	@Autowired
	private MovieDao movieDao;

	public MovieDao getMovieDao() {
		return movieDao;
	}

	public void setMovieDao(MovieDao movieDao) {
		this.movieDao = movieDao;
	}

	@RequestMapping(value = "/movies/{movie_id}", method = RequestMethod.GET)
	public String getMovie(@PathVariable("movie_id") String movie_id, Model model) {

		Movie m = movieDao.getMovieById(movie_id);

		model.addAttribute("movie_by_id", m);

		return "movie_properties";

	}
}
