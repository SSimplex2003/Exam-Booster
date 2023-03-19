package com.code.wings.exambooster.controller;

import com.code.wings.exambooster.entity.Category;
import com.code.wings.exambooster.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String listCategories(Model theModel) {

        List<Category> theCategories = categoryService.findAll();

        // add to the spring model
        theModel.addAttribute("categories", theCategories);

        return "/categories/list-categories";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("category") Category theCategory) {

        System.out.println(theCategory);

        // save the category
        categoryService.save(theCategory);

        // use a redirect to prevent duplicate submissions
        return "redirect:/categories/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("categoryId") int theId) {

        // delete the category
        categoryService.deleteById(theId);

        // redirect to /categories/list
        return "redirect:/categories/list";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Category theCategory = new Category();

        theModel.addAttribute("category", theCategory);

        return "/categories/category-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("categoryId") int theId,
                                    Model theModel) {

        // get the category from the service
        Category theCategory = categoryService.findById(theId);

        // set category as a model attribute to pre-populate the form
        theModel.addAttribute("category", theCategory);

        // send over to our form
        return "/categories/category-form";
    }

}
