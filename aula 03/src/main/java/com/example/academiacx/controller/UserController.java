package com.example.academiacx.controller;

import com.example.academiacx.facades.inter.BookMarksFacade;
import com.example.academiacx.models.UserModel;
import com.example.academiacx.models.dto.UserBookmarkDto;
import com.example.academiacx.repository.UserRepository;
import com.example.academiacx.services.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookMarksFacade bookMarksFacade;

    @GetMapping(value = "/user/list")
    public ResponseEntity<List<UserModel>> findAll()
    {
        List<UserModel> response = userService.listUsers();

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<Optional<UserModel>> findById(@PathVariable Long id)
    {
        Optional<UserModel> response = userService.findById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/bookmark/{id}")
    public ResponseEntity<?> findFavoritesBookMark(@PathVariable Long id)
    {
        UserBookmarkDto response = bookMarksFacade.getFavorites(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/user/save")
    public ResponseEntity<UserModel> save(@RequestBody UserModel userModel)
    {
        UserModel response = userService.create(userModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/user/update")
    public ResponseEntity<UserModel> update(@RequestBody UserModel userModel)
    {
        UserModel response = userService.update(userModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/user/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        Boolean success = userService.delete(id);

        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}
