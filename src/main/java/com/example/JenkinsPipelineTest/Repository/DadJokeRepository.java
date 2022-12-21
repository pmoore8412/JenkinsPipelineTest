package com.example.JenkinsPipelineTest.Repository;

import com.example.JenkinsPipelineTest.Entity.DadJokes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadJokeRepository extends JpaRepository<DadJokes, Long> {
}
