package com.mami.luv2codes;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @Value(value = "${coach.name}")
  private String coachName;

  @Value(value = "${team.name}")
  private String teamName;


  @GetMapping
  public String print() {

    return coachName + "   " + teamName;
  }

}
