package com.launchacademy.marathon.controllers;

import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.repositories.SongRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SongController {

  private final SongRepository songRepository;

  @Autowired
  public SongController(SongRepository songRepository) {
    this.songRepository = songRepository;
  }

  @GetMapping("/songs/new")
    public String getNewSong(@ModelAttribute Song song, Model model) {
    model.addAttribute("song", song);
    return "songs/new";
  }


  @GetMapping("/songs")
  public String getIndex(Model model) {
    model.addAttribute("songs", songRepository.findAll());
    return "songs/index";
  }

@PostMapping("/songs")
  public String create(@ModelAttribute @Valid Song song, BindingResult binding, Model model){

    if(binding.hasErrors()){
      return "songs/new";
    }else{
      songRepository.save(song);
      return  "redirect:/songs";  //this will take us back to the index
    }

}

}
