package com.example.proiectcolectiv.controller;
import com.example.proiectcolectiv.model.Post;
import com.example.proiectcolectiv.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class PostController {
    @Autowired
    private PostRepository postRepository;

}
