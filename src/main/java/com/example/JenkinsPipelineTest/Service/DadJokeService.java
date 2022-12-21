package com.example.JenkinsPipelineTest.Service;

import com.example.JenkinsPipelineTest.Entity.DadJokes;
import com.example.JenkinsPipelineTest.Repository.DadJokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DadJokeService {

    @Autowired
    DadJokeRepository dadJokeRepository;

    public void addDadJoke(DadJokes dadJokes) {
        dadJokeRepository.save(dadJokes);
    }

    public DadJokes getADadJoke(long id) {
        return dadJokeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Dad joke is not in our database"));
    }

    public List<DadJokes> getAllDadJokes() {
        return dadJokeRepository.findAll().stream().collect(Collectors.toList());
    }

    public void updateDadJoke(long id, DadJokes newDadJoke) {
        DadJokes oldDadJoke = dadJokeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Dad joke is not in our database"));

        oldDadJoke.setJoke(newDadJoke.getJoke());
        oldDadJoke.setJokeAuthor(newDadJoke.getJokeAuthor());

        dadJokeRepository.save(oldDadJoke);
    }

    public void deleteDadJoke(long id) {
        DadJokes dadJokes = dadJokeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Dad joke is not in our database"));

        dadJokeRepository.delete(dadJokes);
    }

}
