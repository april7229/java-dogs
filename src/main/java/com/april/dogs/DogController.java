package com.april.dogs;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController


public class DogController {

    List<Resource<Employee>> employees = emprepos.findAll().stream()
            .map(assembler::toResource)
            .collect(Collectors.toList());

        return new Resources<>(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
}

    @GetMapping("/employees/{id}") // /employees/4
    public Resource<Dog> findOne(@PathVariable Long id)
    {
        Dog foundDog = dogrepos.findById(id)
                .orElseThrow(() -> new DogNotFoundException(id));

        return assembler.toResource(foundEmp);
    }

    @PutMapping("/dog/{id}")
    public ResponseEntity<?> replaceEmployee(@RequestBody Employee newEmp, @PathVariable Long id)
            throws URISyntaxException
    {
         updatedDog = dogrepos.findById(id)
        Dog updatedDog = dogrepos.findById(id)
                .map(dog ->
                {
                    dog.setId(newDog.getId());
                    dog.setName(newDog.getName());
                    dog.setWeight(newDog.getWeight());
                    dog.setSize(newDog.isSize());
                    return dogrepos.save(dog);
                })
                .orElseGet(() ->
                {
                    newDog.setId(id);
                    return dogrepos.save(newDog);
                });

        Resource<Dog> resource = assembler.toResource(updatedDog);
        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    @DeleteMapping("/dog/{id}")
    public ResponseEntity<?> deleteDog(@PathVariable Long id)
    {
        emprepos.dogById(id);

        return ResponseEntity.noContent().build();
    }
}




