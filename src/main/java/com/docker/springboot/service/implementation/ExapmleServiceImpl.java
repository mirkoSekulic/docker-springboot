package com.docker.springboot.service.implementation;

import com.docker.springboot.domain.Example;
import com.docker.springboot.repository.ExampleRepository;
import com.docker.springboot.service.ExampleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExapmleServiceImpl implements ExampleService {

    private final ExampleRepository exampleRepository;

    public ExapmleServiceImpl(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    @Override
    public Page<Example> findAll(Pageable pageable) {
        return exampleRepository.findAll(pageable);
    }
}
