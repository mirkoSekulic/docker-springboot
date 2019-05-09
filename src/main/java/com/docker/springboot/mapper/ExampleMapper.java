package com.docker.springboot.mapper;

import com.docker.springboot.domain.Example;
import com.docker.springboot.dto.ExampleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ExampleMapper {
    ExampleDTO exampleToExampleDTO(Example example);
}
