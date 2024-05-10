package com.workintech.s19d1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="movie",schema="fsweb")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull(message="film adı null olamaz")
    @Column(name = "name")
    private String name;
    @NotNull(message="yönetmen adı null olamaz")
    @Column(name = "director_name")
    private String directorName;
    @Column(name = "rating")
    private int rating;
    @Column(name = "releaseDate")
    private Date releaseDate;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinTable(name = "actor_movie", schema = "fsweb",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;


}
