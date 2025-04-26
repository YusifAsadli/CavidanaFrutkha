package edu.az.itbrains123.ecommerse.sevices;

import edu.az.itbrains123.ecommerse.dtos.article.ArticleCreateDto;
import edu.az.itbrains123.ecommerse.dtos.article.ArticleHomeDto;
import edu.az.itbrains123.ecommerse.dtos.article.ArticleUpdateDto;
import edu.az.itbrains123.ecommerse.dtos.category.CategoryHomeDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AricleService {
    void createArticle(ArticleCreateDto articleCreateDto);
    void updateArticle(ArticleUpdateDto articleUpdateDto,Long id);
    void deleteArticle(Long id);
    ArticleUpdateDto findArticleById(Long id);
    List<ArticleHomeDto> findAllArticles();
}
