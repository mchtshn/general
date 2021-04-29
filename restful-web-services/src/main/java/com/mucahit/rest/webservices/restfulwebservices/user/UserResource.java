package com.mucahit.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{userId}")
    public EntityModel<User> retrieveUser(@PathVariable int userId) {
        User user = userDaoService.findOne(userId);
        if (user == null) {
            throw new UserNotFoundException("user " + " with id-" + userId + " not found");
        }

        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder linkBuilder =WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserResource.class).retrieveAllUsers());
        entityModel.add(linkBuilder.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        User user = userDaoService.deleteById(userId);
        if (user == null) {
            throw new UserNotFoundException("user " + " with id-" + userId + " not found");
        }
    }


}
