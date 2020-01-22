package com.softserve.academy.controller;

import com.softserve.academy.model.Article;
import com.softserve.academy.setvice.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/article")
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String create(ModelMap model) {
        Article article = new Article();
        article.setCreatedAt(new Date(System.currentTimeMillis()));
        article.setAuthorId(0L);
        model.addAttribute("article", article);
        return "add-article";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String create(@ModelAttribute("article") Article article) {
        articleService.create(article);
        return "redirect:list";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public ModelAndView update(@RequestParam("id") long id) {
        Article article = articleService.readById(id);
        ModelAndView modelAndView = new ModelAndView("edit-article");
        modelAndView.addObject("article", article);
        return modelAndView;
    }

    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String update(@ModelAttribute("article") Article article) {
        articleService.update(article);
        return "redirect:list";
    }

    @RequestMapping(path = "/remove", method = RequestMethod.GET)
    public String delete(@RequestParam("id") long id) {
        articleService.delete(id);
        return "redirect:list";
    }

    @RequestMapping(path = "/show", method = RequestMethod.GET)
    public String readById(@RequestParam("id") long id, ModelMap model) {
        Article article = articleService.readById(id);
        model.addAttribute("article", article);
        return "show-article";
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String readAll(ModelMap model) {
        List<Article> articles = articleService.readAll();
        model.addAttribute("articles", articles);
        return "articles-list";
    }

}
