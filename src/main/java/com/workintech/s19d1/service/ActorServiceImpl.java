package com.workintech.s19d1.service;

import com.workintech.s19d1.dao.ActorDao;
import com.workintech.s19d1.dao.MovieDao;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {
    private ActorDao actordao;
    private MovieDao movieDao;

    @Autowired
    public ActorServiceImpl(ActorDao actordao, MovieDao movieDao) {
        this.actordao = actordao;
        this.movieDao = movieDao;
    }

    @Override
    public ActorDao save(Actor actor) {
        Actor savedActor=actordao.save(actor);
        return new ActorDao(savedActor.getId(), savedActor.getFirstName(), savedActor.getLastName(), savedActor.getBirthDate());


    }

    @Override
    public ActorDao update(Long id, List<Movie> movieList) {
        Optional<Actor> updateOptional=actordao.findById(id);
        if(updateOptional.isPresent()){
            Actor actor=updateOptional.get();
            for(Movie movie:movieList){
                actor.addMovie(movie);
            }
            return  save(actor);
        }
       //Throw Exception
        return null;
    }

    @Override
    public ActorDao findById(Long id) {
        return null;
    }

    @Override
    public ActorDao delete(Long id) {
        return null;
    }

    @Override
    public ActorDao addMovieToStudent(Long actorId, Long movieId) {
        return null;
    }
}
