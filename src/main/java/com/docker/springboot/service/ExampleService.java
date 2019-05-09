package com.docker.springboot.service;

import com.docker.springboot.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExampleService {

    Page<Example> findAll(Pageable pageable);
}
