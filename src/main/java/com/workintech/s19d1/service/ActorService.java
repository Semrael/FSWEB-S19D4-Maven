package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;

import java.util.List;

public interface ActorService {
   List<Actor> findAll();
   Actor save(Actor actor);

   Actor findById(Long id);
  void  delete(Actor actor);

}
