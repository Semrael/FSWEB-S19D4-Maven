package com.workintech.s19d1.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="movie",schema="fsweb")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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

    @Column(name = "release_Date")
    private LocalDate releaseDate;

    //@JsonBackReference
    //@JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinTable(name = "actor_movie", schema = "fsweb",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;

    public void addActor(Actor actor){
        if(actors==null){
            actors=new ArrayList<>();
        }
        actors.add(actor);
    }


}
