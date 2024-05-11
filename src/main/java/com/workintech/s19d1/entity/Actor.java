package com.workintech.s19d1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = "actor", schema = "fsweb")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Actor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Aktör ismi null olamaz")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Aktör soyadı null olamaz")
    @Column(name = "last_name")
    private String lastName;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;


    @Column(name = "birth_date")
    private LocalDate birthDate;

    //actor_movie=>junction table

    @JsonManagedReference
    @ManyToMany(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="actor_movie",schema="fsweb",
           joinColumns = @JoinColumn(name="actor_id"),
            inverseJoinColumns = @JoinColumn(name="movie_id"))
    private List<Movie> movies;//=new ArrayList<>()'te kullanılabilirdi aşağıdaki hatayı almamak için


    //ilk defa gelen kayıt için nullpointerexception almamak için  projeyi run ettiğimde boş bir arrayList dönücek
    public void addMovie(Movie movie){
        if(movies==null){
            movies=new ArrayList<>();
        }
        movies.add(movie);
    }
}
