package com.workintech.s19d1.service;

import com.workintech.s19d1.dao.ActorDao;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.exceptions.ApiException;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ActorServiceImpl implements ActorService {
    private final ActorDao actordao;


    @Override
    public List<Actor> findAll() {
        return actordao.findAll();
    }

    @Override
    public Actor save(Actor actor) {
        return actordao.save(actor);
    }

    @Override
    public Actor findById(Long id) {
        return actordao.findById(id).orElseThrow(()->new ApiException("actor is not found with id: "+id, HttpStatus.NOT_FOUND));
    }

    @Override
    public void delete(Actor actor) {
          actordao.delete(actor);

    }
}