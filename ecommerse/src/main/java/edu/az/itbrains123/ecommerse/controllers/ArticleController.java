package edu.az.itbrains123.ecommerse.controllers;

import edu.az.itbrains123.ecommerse.dtos.article.ArticleCreateDto;
import edu.az.itbrains123.ecommerse.dtos.article.ArticleHomeDto;
import edu.az.itbrains123.ecommerse.dtos.article.ArticleUpdateDto;
import edu.az.itbrains123.ecommerse.repositories.ArticleRepository;
import edu.az.itbrains123.ecommerse.sevices.impls.ArticleServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticleController {
    private final ArticleServiceImpl articleService;

    public ArticleController(ArticleRepository articleRepository, ModelMapper modelMapper, ArticleServiceImpl articleService, ModelMapper modelMapper1) {
        this.articleService = articleService;
    }

    @GetMapping("/dashboard/article")
    public String article(Model model) {
        List<ArticleHomeDto> data = articleService.findAllArticles();
        model.addAttribute("articles", data);
        return "/dashboard/article/index";
    }

    @GetMapping("/dashboard/article/create")
    public String createArticle(Model model) {
        List<ArticleHomeDto> data = articleService.findAllArticles();
        model.addAttribute("articles", data);
        return "/dashboard/article/create";
    }

    @PostMapping("/dashboard/article/create")
    public String createArticle(@ModelAttribute("article") ArticleCreateDto articleCreateDto) {
        articleService.createArticle(articleCreateDto);
        return "redirect:/dashboard/article";
    }

    @GetMapping("/dashboard/article/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        return "/dashboard/article/delete";
    }

    @PostMapping("/dashboard/article/delete/{id}")
    public String removeArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return "redirect:/dashboard/article";
    }

    @GetMapping("/dashboard/article/update/{id}")
    public String updateArticle(@PathVariable Long id, Model model) {
        ArticleUpdateDto articleUpdateDto = articleService.findArticleById(id);
        model.addAttribute("article", articleUpdateDto);
        return "/dashboard/article/update";
    }

    @PostMapping("/dashboard/article/update/{id}")
    public String updateArticle(@PathVariable Long id, ArticleUpdateDto articleUpdateDto) {
        articleService.updateArticle(articleUpdateDto, id);
        return "redirect:/dashboard/article";
    }


}
