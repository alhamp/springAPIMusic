package com.launchacademy.marathon.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="songs")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Song {

  @Id
  @SequenceGenerator(name = "song_generator",
      sequenceName = "songs_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = "song_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotBlank
  @Size(min=1, max =25)
  @NonNull  // must be present checking...
  @Column(nullable = false)
  private String title;

  @NotBlank
  @Size(min = 1, max = 15)
  @Pattern(regexp = "^([^0-9]*)$")    //cannot contain numbers
  @Column
  private String genre;

  @Max(value = 2018)
  @NonNull
  @Min(value = 999)  //validating year of 4 digit
  @Column(name="release_year", nullable = false)
  private Integer releaseYear;


  @NonNull
  @Column(nullable = false)
  private Boolean explicit;

}
