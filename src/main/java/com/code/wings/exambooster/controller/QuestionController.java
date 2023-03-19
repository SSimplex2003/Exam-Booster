package com.code.wings.exambooster.controller;

import com.code.wings.exambooster.entity.Category;
import com.code.wings.exambooster.entity.Question;
import com.code.wings.exambooster.service.CategoryService;
import com.code.wings.exambooster.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String listQuestions(Model theModel) {

        List<Question> theQuestions = questionService.findAll();

        // add to the spring model
        theModel.addAttribute("questions", theQuestions);
        theModel.addAttribute("showBackButton", false);

        return "/questions/list-questions";
    }

    @PostMapping("/save")
    public String saveQuestion(@ModelAttribute("question") Question theQuestion) {

        System.out.println(theQuestion);

        // Setting creator
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        theQuestion.setCreator(username);

        // Setting category

        List<Category> categories = categoryService.findAll();
        List<String> categoriesName = new ArrayList<>();

        for (Category category : categories) {
            categoriesName.add(category.getName());
        }

        if(theQuestion.getCategory().equals("0")) {
            theQuestion.setCategory("Unknown");
        } else {
            theQuestion.setCategory(categoriesName.get(Integer.parseInt(theQuestion.getCategory()) - 1));
        }

        // save the question
        questionService.save(theQuestion);

        // use a redirect to prevent duplicate submissions
        return "redirect:/questions/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("questionId") int theId) {

        // delete the question
        questionService.deleteById(theId);

        // redirect to /questions/list
        return "redirect:/questions/list";

    }

    @GetMapping("/search")
    public String search(@RequestParam("questionCategory") String theCategory,
                         Model theModel) {
        List<Question> theQuestions = questionService.searchBy(theCategory);

        System.out.println(theQuestions);

        // add to the spring model
        theModel.addAttribute("questions", theQuestions);
        theModel.addAttribute("showBackButton", true);

        // send to /questions/list
        return "/questions/list-questions";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Question theQuestion = new Question();

        theModel.addAttribute("question", theQuestion);

        List<Category> categories =  categoryService.findAll();
        theModel.addAttribute("categories", categories);

        return "/questions/question-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("questionId") int theId,
                                    Model theModel) {

        // get the question from the service
        Question theQuestion = questionService.findById(theId);

        // set question as a model attribute to pre-populate the form
        theModel.addAttribute("question", theQuestion);

        List<Category> categories =  categoryService.findAll();
        theModel.addAttribute("categories", categories);

        // send over to our form
        return "/questions/question-form";
    }

}
