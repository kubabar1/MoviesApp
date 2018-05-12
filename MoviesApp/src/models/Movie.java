package models;

public class Movie {
	private String id;
	private String name;
	private String author;
	private String genre;
	private int productionYear;
	private String filename;

	public Movie() {

	}

	public Movie(String id, String name, String author, String genre, int productionYear, String filename) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.productionYear = productionYear;
		this.filename = filename;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "Movie [" + "id=" + id + "name=" + name + ", author=" + author + ", genre=" + genre + ", productionYear="
				+ productionYear + ", filename=" + filename + "]";
	}
}