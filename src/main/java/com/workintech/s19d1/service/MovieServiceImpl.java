package com.workintech.s19d1.service;

import com.workintech.s19d1.dao.MovieDao;
import com.workintech.s19d1.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{
    private MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Autowired

    @Override
    public Optional<Movie> findById(Long id) {
        Optional<Movie> movieOptional=movieDao.findById(id);
        if(movieOptional.isPresent()) {
            return Optional.of(movieOptional.get());
           // MovieDao(movieOptional.get().getName(),movieOptional.get().getDirectorName(),movieOptional.get().getActors(),movieOptional.get().getRating());
        }
     //throw Exception
        return null;
    }

}
