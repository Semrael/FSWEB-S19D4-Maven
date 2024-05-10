package com.workintech.s19d1.service;

import com.workintech.s19d1.dao.ActorDao;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;

import java.util.List;

public interface ActorService {
   ActorDao save(Actor actor);
   ActorDao update(Long id, List<Movie> movieList);
   ActorDao findById(Long id);
   ActorDao delete(Long id);
   ActorDao addMovieToStudent(Long actorId,Long movieId);
}
