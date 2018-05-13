# 1. Nazwa programu
MoviesApp

# 2. Cel programu
Celem programu *MoviesApp* jest umożliwienie użytkownikowi dodawania filmów, wyświetlania ich w postaci listy oraz wyświetlania 
szczegółów jednego z filmów.

# 3. Obsługa programu
Aby uruchomić program należy - używając kodu umieszczonego w repozytorium - zbudować plik WAR. Następnie utworzony plik umieszczamy w 
odpowiednim folderze naszego serwera - w przypadku serwera *Apache Tomcat* jest to folder *webapps* - a następnie uruchomić serwer. Po
uruchomieniu serwera będziemy mieli możliwość dostania się do strony internetowej podając odpowiedni adres w oknie naszej przeglądarki.


Strona powitalnia *http://localhost:8080/MoviesApp/*

![alt text](https://github.com/kubabar1/MoviesApp/blob/master/readme_images/welcome_view.png "Strona powitalnia")

Strona wyświetlająca listę filmów *http://localhost:8080/MoviesApp/movies* - można się do niej dostać po kliknięciu przycisku 
*SHOW LIST* znajdującego się w menu po lewej stronie

![alt text](https://github.com/kubabar1/MoviesApp/blob/master/readme_images/list_view.png "Lista filmów")

Strona wyświetlająca właściwości danego filmu *http://localhost:8080/MoviesApp/movies/2* - można się do niej dostać po kliknięciu 
na dany element listy

![alt text](https://github.com/kubabar1/MoviesApp/blob/master/readme_images/properties_view.png "Właściwości filmu")

Strona umożliwiająca dodanie nowego filmu *http://localhost:8080/MoviesApp/add_movie* - można się do niej dostać po kliknięciu 
przycisku *ADD MOVIE* znajdującego się w menu po lewej stronie

![alt text](https://github.com/kubabar1/MoviesApp/blob/master/readme_images/add_movie_view.png "Dodawanie filmu")

Po dodaniu filmu wyświetla się następująca strona

![alt text](https://github.com/kubabar1/MoviesApp/blob/master/readme_images/movie_add_confirm_view.png "Dodawanie filmu")

Po dodaniu nowego filmu zostanie on umieszczony na stałe w folderze */uploads* na komputerze, a następnie będzie mógł on być wyświetlany na 
liście filmów.

Ponadto strona została zaprojektowana w sposób responsywny, dzięki czemu może być bez problemu wygodnie wyświetlana na urządzeniach moblinych.

![alt text](https://github.com/kubabar1/MoviesApp/blob/master/readme_images/responsive_view.png "Responsywność")


# 4. Opis danych dostarczanych podczas dodawania nowego filmu

![alt text](https://github.com/kubabar1/MoviesApp/blob/master/readme_images/add_movie_view.png "Dodawanie filmu")

Dodając nowy film należy podać nazwę filmu, nazwę autora, wybrać z listy gatunek filmu, wpisać rok produkcji oraz wybrać plik zawierający 
film który chcemy dodać. Nazwa filmu i autor powinny być ciągami znaków, natomiast rok produkcji powinien być liczbą. Podane dane są
zapisywane w pliku XML *movie_db.xml* znajdującym się w katalogu src.models. Dane z tego pliku są ładowane do listy filmów po wejściu na
stronę */MoviesApp/movies*. Dodany plik jest zapisywany w folderze /uploads znajdującym się na komputerze. Jeżeli taki folder nie 
istnieje, zostaje on utworzony automatycznie podczas dodawania pierwszego filmu. 


# 5. Uproszczony diagram modułów i pakietów
![alt text](https://github.com/kubabar1/MoviesApp/blob/master/readme_images/class_diagram.png "Diagram modułów")

Diagram modułów

![alt text](https://github.com/kubabar1/MoviesApp/blob/master/readme_images/package_diagram.png "Diagram pakietów")

Diagram pakietów


# 6. Opis modułów 
## 6.1. controllers
### 6.1.1.MovieAddRestController
Klasa ta jest kontolerem odpowiedzialnym za dodawanie filmów. Jest ona również odpowiedzialna za wyświetlanie formularza 
służącego do dodawania filmów oraz wyświetlanie potwierdzenia dodania nowego filmu.<br/><br/>
**Metody:**<br/>
– public String showForm(Model model) - metoda ta wyświetla formularz służący do dodawania filmów,<br/>
– public String uploadMovie(@RequestParam("videofile") MultipartFile file, @RequestParam("name") String name,
@RequestParam("author") String author, @RequestParam("genre") String genre,@RequestParam("year") int productionYear) - 
metoda ta służy do dodawania filmów, dodaje ona film do folderu */uploads* oraz wywołuje metodę klasy *MoviesList* która dodaje 
właściwości filmu do pliku *movie_db.xml*<br/>

### 6.1.2. MoviePropertiesRestController
Klasa ta jest kontrolerem odpowiedzialnym za wyświetlanie właściwości danego filmu.<br/><br/>
**Metody:**<br/>
– public String getMovie(@PathVariable("movie_id") String movie_id, Model model) - metoda ta służy do wyświetlania podstrony z 
własnościami filmu<br/>

### 6.1.3. MoviesListRestController
Klasa ta jest kontrolerem odpowiedzialnym za wyświetlanie listy filmów.<br/><br/>
**Metody:**<br/>
– public String getMovie(Model model) - metoda ta służy do wyświetlenia listy filmów<br/>

### 6.1.4. Movie
Klasa ta zawiera pola opisujące dodawany film oraz metody dostępowe.<br/><br/>
**Metody:**<br/>
Klasa ta zawiera wyłącznie metody dostępowe.<br/>

### 6.1.5. MoviesList
Klasa ta zawiera listę filmów.<br/><br/>
**Metody:**<br/>
– private void loadMovies()  - metoda ta załadowuje do listy filmów *ArrayList* obiekty klasy *Movies*, na podstawie pliku 
*movies_db.xml*,<br/>
– public Movie getMovie(String id) - metoda ta zwraca obiekt klasy *Movies* z listy filmów *ArrayList* o podanym *id*, <br/>
– public void addMovie(Movie movie) - metoda ta służy do dodawania właściwości nowego filmu do pliku *movies_db.xml*<br/>

# 7. Opis struktur i wzorców projektowych
## 7.1 Struktury:
**ArrayList** - struktura danych w której elementy są ułożone w liniowym porządku. W programie jest wykorzystywana do przechowywania
wczytanych z pliku *movies_db.xml* właściwości poszczególnych filmów - obiektów klasy *Movies*. Obiekty są ładowane do listy po każdym
wejściu na adres /MoviesApp/movies, przy użyciu metody *loadMovies()* znajdującej się w klasie *MoviesList*.

## 7.2 Wzorce projektowe:
**MVC** - ModelViewController, wzorzec projektowy organizujący strukturę aplikacji posiadających graficzny interfejs użytkownika. Wzorzec
MVC zakłada podział aplikacji na 3 części: *model* - reprezentacja problemu/logiki aplikacji, *view* - opisuje jak wyświetlić część
modelu w ramach interfejsu użytkownika ,*controller*- przyjmuje od użytkownika dane wejściowe, aktualizuje model, odświeża widok. Klasy 
realizujące część modelu zawarte są w programie w katalogu *models*, a realizujące część kontrolerów w katalogu *controllers*. Widok
jest reprezentowany przez pliki *.jsp znajdujące się w katalogu *jsp*. W celu wykorzystanie tego wzorca w programie został wykorzystany
framework Spring-a o nazwie *Spring Web MVC*.

# 8. Podsumowanie
Program w poprawny sposób spełnia początkowe założenia i umożliwia dodawanie filmów, wyświetlanie ich listy oraz wyświetlanie 
ich właściwości.
