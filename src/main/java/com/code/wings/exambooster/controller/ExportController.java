package com.code.wings.exambooster.controller;

import com.code.wings.exambooster.dao.QuestionRepository;
import com.code.wings.exambooster.entity.Category;
import com.code.wings.exambooster.entity.Question;
import com.code.wings.exambooster.service.CategoryService;
import com.code.wings.exambooster.service.QuestionService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/export")
public class ExportController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/showFormForGenerateQuiz")
    public String showFormForGenerateQuiz(Model theModel) {

        // create model attribute to bind form data
        Question theQuestion = new Question();

        theModel.addAttribute("question", theQuestion);

        List<Category> categories = categoryService.findAll();
        theModel.addAttribute("categories", categories);

        return "/export/generate-quiz";
    }

    @PostMapping("/generateQuiz")
    public String generateQuiz(@ModelAttribute("question") Question theQuestion, Model theModel) {
        List<Category> categories = categoryService.findAll();
        List<String> categoriesName = new ArrayList<>();

        for (Category category : categories) {
            categoriesName.add(category.getName());
        }
        if(theQuestion.getCategory().equals("0")) {
            return "redirect:/export/showFormForGenerateQuiz";
        }

        List<Question> questions = questionRepository.findByCategoryContainsAllIgnoreCase(categoriesName.get(Integer.parseInt(theQuestion.getCategory()) - 1));
        Collections.shuffle(questions);

        int index = Math.min(theQuestion.getId(), questions.size());
        theModel.addAttribute("questions", questions.subList(0, index));

        return "/export/quiz";
    }
}
