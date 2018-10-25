package com.dws.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name cannot be Blank")
    private String name;
    @NotBlank(message = "Image cannot be Blank")
    private String image;
    @NotBlank(message = "Rating cannot be Blank")
    private String rating;
    @NotBlank(message = "Genre cannot be Blank")
    private String genre;
    @NotNull(message = "Year cannot be Empty")
    private Integer year;
    @NotBlank(message = "Summary cannot be Blank")
    private String summary;

    protected Movie() {
    }

    public Movie(String name, String image, String rating, String genre, int year, String summary) {
        this.name = name;
        this.image = image;
        this.rating = rating;
        this.genre = genre;
        this.year = year;
        this.summary = summary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) &&
                Objects.equals(image, movie.image) &&
                Objects.equals(rating, movie.rating) &&
                Objects.equals(genre, movie.genre) &&
                Objects.equals(year, movie.year) &&
                Objects.equals(summary, movie.summary);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, image, rating, genre, year, summary);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", rating='" + rating + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", summary='" + summary + '\'' +
                '}';
    }
}
