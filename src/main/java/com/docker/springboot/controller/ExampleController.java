package com.docker.springboot.controller;

import com.docker.springboot.dto.ExampleDTO;
import com.docker.springboot.mapper.ExampleMapper;
import com.docker.springboot.service.ExampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "examples", tags = {"examples"})
@RequestMapping("examples")
public class ExampleController {
    private final ExampleService exampleService;
    private final ExampleMapper exampleMapper;

    public ExampleController(ExampleService exampleService, ExampleMapper exampleMapper) {
        this.exampleService = exampleService;
        this.exampleMapper = exampleMapper;
    }

    @GetMapping
    @ApiOperation(value = "Get a page of examples..", nickname = "finAll")
    public ResponseEntity<Page<ExampleDTO>> list(Pageable pageable)
    {
        Page<ExampleDTO> exampleDTOPage = exampleService.findAll(pageable)
                .map(exampleMapper::exampleToExampleDTO);

        return new ResponseEntity<>(exampleDTOPage, HttpStatus.OK);
    }
}
