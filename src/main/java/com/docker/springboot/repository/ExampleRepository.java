package com.docker.springboot.repository;

import com.docker.springboot.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface ExampleRepository extends JpaRepository<Example, Long> {
}
