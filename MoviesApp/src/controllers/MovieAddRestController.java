package controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import models.Movie;
import models.MoviesList;

@Controller
public class MovieAddRestController {
	private MoviesList moviesList;

	public void setMoviesList(MoviesList moviesList) {
		this.moviesList = moviesList;
	}

	public MoviesList getMoviesList() {
		return moviesList;
	}

	@RequestMapping(value = "/add_movie", method = RequestMethod.GET)
	public String showForm(Model model) {

		return "movie_add";

	}

	@RequestMapping(value = "/add_movie", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String uploadMovie(@RequestParam("videofile") MultipartFile file, @RequestParam("name") String name,
			@RequestParam("author") String author, @RequestParam("genre") String genre,
			@RequestParam("year") int productionYear) {

		try {

			String extension = "";

			int i = file.getOriginalFilename().lastIndexOf('.');
			if (i > 0) {
				extension = file.getOriginalFilename().substring(i + 1);
			}

			String path = "uploads";

			File dir = new File(path);

			if (!dir.exists()) {
				dir.mkdir();
			}

			UUID uuid = UUID.randomUUID();
			String filename = "upload_" + uuid.toString() + "." + extension;
			byte[] bytes = file.getBytes();
			File fsFile = new File("C:/uploads/" + filename);
			fsFile.createNewFile();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fsFile));
			stream.write(bytes);
			stream.close();

			Movie m = new Movie(uuid.toString(), name, author, genre, productionYear, filename);
			moviesList.addMovie(m);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return "add_confirm";
	}
}
