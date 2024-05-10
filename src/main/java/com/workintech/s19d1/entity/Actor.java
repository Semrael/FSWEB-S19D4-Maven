package com.workintech.s19d1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "actor", schema = "fsweb")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
   

    @Column(name = "birth_date")
    private Date  birthDate;

    //actor_movie=>junction table
    @ManyToMany(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="actor_movie",schema="fsweb",
           joinColumns = @JoinColumn(name="actor_id"),
            inverseJoinColumns = @JoinColumn(name="movie_id"))
    private List<Movie> movies;

    public void addMovie(Movie movie){
        if(movies==null){
            movies=new ArrayList<>();
        }
        movies.add(movie);
    }
}
