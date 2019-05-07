package com.xyzmovies.moviecatalog.controller;

import com.xyzmovies.moviecatalog.model.CatalogItem;
import com.xyzmovies.moviecatalog.model.Movie;
import com.xyzmovies.moviecatalog.model.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("catalog")
public class MovieCatalogResource {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        RestTemplate restTemplate = new RestTemplate();
        //Movie movie = restTemplate.getForObject("http://localhost:8082/movies/movieId/", Movie.class);

        //get all rate movies id
        //hard code the things
        List<Rating> ratings = Arrays.asList(
                new Rating("Gof", 7),
                new Rating("DevilMayCryII", 9));

        return ratings.stream()
                .map(rating-> {
                    Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getMovieName(), "Desc", rating.getRating());
                })
                .collect(Collectors.toList());

        //for each movie id, call movie info and get details


        //put them all together


        //return Collections.singletonList(new CatalogItem("Transformer", "Test", 4));
    }

}
