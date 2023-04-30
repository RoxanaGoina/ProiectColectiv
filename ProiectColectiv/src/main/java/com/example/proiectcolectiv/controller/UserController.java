package com.example.proiectcolectiv.controller;

import com.example.proiectcolectiv.model.*;
import com.example.proiectcolectiv.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private BadgesRepository badgesRepository;
    @Autowired
    private LabelRepository labelRepository;
    @Autowired
    private CommentRepository commentRepository;
    @GetMapping("/getStefan")
    @Transactional
    public User getDummyUser(){
        User a = new User();
        a.setUid("1");
        a.setEmail("stefan@uvt.ro");
        return a;
    }

    @GetMapping("/saveIasmina")
    @Transactional
    public User saveIasminaToDb(){


        User a = new User();
        a.setUid( "3");
        a.setEmail("iasmina@uvt.ro");
       // userRepository.save(a);
        return userRepository.save(a);

    }


    @GetMapping("/getAllUsers")
    @Transactional
    public List<User> getAllUsers(){

        return userRepository.findAll();
    }


    @GetMapping("/users/{id}")
    @Transactional
    public UserPremium getDummyUserPremium(@PathVariable("id") String id) {
        UserPremium a = new UserPremium();
        User user = userRepository.findById(id).get();
        a.setUid(user.getUid());
        a.setPhotoURL(user.getUrl());
        UserPremium.Stats stats=new UserPremium.Stats(postRepository.getUserQuestions(id),postRepository.getUserLikes(id),postRepository.getUserDislikes(id));
        a.setStats(stats);
        List<Badges> b=badgesRepository.getUserBadges(id);
        Map<String, List<String>> m=new HashMap<>();
        for(Badges i: b){
            if(m.containsKey(i.getBadgeType()))
            {   List<String> l=new ArrayList<>();
                l.addAll(m.get(i.getBadgeType()));
                l.add(i.getIdBadges());
                m.put(i.getBadgeType(),l);

            }
            else {
                List<String> list=new ArrayList<>();
                list.add(i.getIdBadges());
                m.put(i.getBadgeType(),list);
            }
        }
        a.setBadges(m);

        List<Question> questions=new ArrayList<>();
        //questions.setQuestionID();
        List<Post> post=postRepository.getPostbyID(id);
        //System.out.println("A");
        for(Post i:post){
            Question q=new Question();
            q.setQuestionID(i.getPostID());
            User1 u=new User1();
            u.setDisplayName(userRepository.getUserDisplayName(i.getUserID()));
            u.setPhotoURL(userRepository.getUserURL(i.getUserID()));
            q.setUser(u);
            List<String> label=labelRepository.getPostbyID(i.getPostID());
            q.setQuestionLabel(label);
            q.setQuestionContent(i.getQuestionContent());
            q.setQuestionTitle(i.getQuestionID());
            q.setLikes(i.getLikes());
            q.setDislikes(i.getDisikes());
            q.setCategory(i.getCategory());
            q.setCode(i.getQuestionContent());
            List<Comment> comment=commentRepository.getPostbyID(i.getPostID());
            List<Answer> answers=new ArrayList<>();
            for(Comment c:comment ){
                Answer answer=new Answer();
                answer.setCode(c.getContent());
                User1 user1=new User1();
                user1.setPhotoURL(userRepository.getUserURL(c.getUserID()));
                user1.setDisplayName(userRepository.getUserDisplayName(c.getUserID()));
                answer.setUser(user1);
                answer.setAnswerTitle(c.getContent());
                answer.setAnswerDetails(c.getContent());
                answers.add(answer);
            }
            q.setAnswers(answers);
            questions.add(q);
        }
        a.setQuestions(questions);
        return a;
    }


}
