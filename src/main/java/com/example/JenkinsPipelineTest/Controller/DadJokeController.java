package com.example.JenkinsPipelineTest.Controller;

import com.example.JenkinsPipelineTest.Entity.DadJokes;
import com.example.JenkinsPipelineTest.Service.DadJokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DadJokeController {

    @Autowired
    DadJokeService dadJokeService;

    @PostMapping("/addJoke")
    public void addDadJoke(@RequestBody DadJokes dadJokes) {
        dadJokeService.addDadJoke(dadJokes);
    }

    @GetMapping("/getAJoke/{id}")
    public DadJokes getADadJoke(@PathVariable long id) {
        return dadJokeService.getADadJoke(id);
    }

    @GetMapping("/listAllJokes")
    public List<DadJokes> getAllDadJokes() {
        return dadJokeService.getAllDadJokes();
    }

    @PutMapping("/updateJoke/{id}")
    public void updateDadJoke(@PathVariable long id, @RequestBody DadJokes newDadJoke) {
        dadJokeService.updateDadJoke(id, newDadJoke);
    }

    @DeleteMapping("RemoveJoke/{id}")
    public void deleteDadJoke(@PathVariable long id) {
        dadJokeService.deleteDadJoke(id);
    }

}
