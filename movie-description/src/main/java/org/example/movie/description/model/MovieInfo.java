package org.example.movie.description.model;

public class MovieInfo {
    private String director;
    private String description;
    private String year;

    public MovieInfo(String director, String description, String year) {
        this.director = director;
        this.description = description;
        this.year= year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
                "director='" + director + '\'' +
                ", description='" + description + '\'' + ", year='" + year + '\'' +
                '}';
    }
}