package com.workintech.s19d1.service;


import com.workintech.s19d1.entity.Movie;

import java.util.Optional;

public interface MovieService {
    Optional<Movie> findById(Long id) ;
}
