package models;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MoviesList {

	private ArrayList<Movie> listMovies;

	public MoviesList() {
		listMovies = new ArrayList<Movie>();
		loadMovies();
	}

	public void setListMovies(ArrayList<Movie> listMovies) {
		this.listMovies = listMovies;
	}

	private void loadMovies() {
		try {

			File inputFile = new File(getClass().getResource("movie_db.xml").toURI());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("movie");

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				Movie movie = new Movie();

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					movie.setId(eElement.getElementsByTagName("id").item(0).getTextContent());
					movie.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
					movie.setAuthor(eElement.getElementsByTagName("author").item(0).getTextContent());
					movie.setGenre(eElement.getElementsByTagName("genre").item(0).getTextContent());
					movie.setProductionYear(
							Integer.parseInt(eElement.getElementsByTagName("productionYear").item(0).getTextContent()));
					movie.setFilename(eElement.getElementsByTagName("filename").item(0).getTextContent());

					listMovies.add(movie);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Movie> getListMovies() {
		return listMovies;
	}

	public Movie getMovie(String id) {

		int n = listMovies.size();

		Movie m = null;
		for (int i = 0; i < n; i++) {
			if (listMovies.get(i).getId().equals(id)) {
				m = listMovies.get(i);
			}
		}

		if (m == null) {
			throw new NullPointerException("Movie not found!");
		}

		return m;
	} 

	public void addMovie(Movie movie) {
		try {
			File inputFile = new File(getClass().getResource("movie_db.xml").toURI());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			Document document = dBuilder.parse(inputFile);
			
			Element root = document.getDocumentElement();

			Element movieRoot = document.createElement("movie");

			Element e = null;

			e = document.createElement("id");
			e.appendChild(document.createTextNode(movie.getId()));
			movieRoot.appendChild(e);

			e = document.createElement("name");
			e.appendChild(document.createTextNode(movie.getName()));
			movieRoot.appendChild(e);

			e = document.createElement("author");
			e.appendChild(document.createTextNode(movie.getAuthor()));
			movieRoot.appendChild(e);

			e = document.createElement("genre");
			e.appendChild(document.createTextNode(movie.getGenre()));
			movieRoot.appendChild(e);

			e = document.createElement("productionYear");
			e.appendChild(document.createTextNode(Integer.toString(movie.getProductionYear())));
			movieRoot.appendChild(e);

			e = document.createElement("filename");
			e.appendChild(document.createTextNode(movie.getFilename()));
			movieRoot.appendChild(e);

			root.appendChild(movieRoot);
			
			DOMSource source = new DOMSource(document);

			try {
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
			    Transformer transformer = transformerFactory.newTransformer();
			    StreamResult result = new StreamResult(new File(getClass().getResource("movie_db.xml").toURI()));
			    transformer.transform(source, result);
			} catch (TransformerException te) {
				System.err.println(te.getMessage());
			}

			
			listMovies.add(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
