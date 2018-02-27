package firstProject.controller;

import firstProject.model.userModel;
import firstProject.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.util.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * Created by somasekhar on 2/25/2018.
 */
@RestController
@RequestMapping(value = "users")
public class userController {

    @Autowired
    private userRepository userRepo;

    @Transactional
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<userModel> findAll(){
        return  userRepo.findAll();
    }



}
