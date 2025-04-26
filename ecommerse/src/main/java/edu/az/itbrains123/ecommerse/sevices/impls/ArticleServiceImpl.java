package edu.az.itbrains123.ecommerse.sevices.impls;

import edu.az.itbrains123.ecommerse.dtos.article.ArticleCreateDto;
import edu.az.itbrains123.ecommerse.dtos.article.ArticleHomeDto;
import edu.az.itbrains123.ecommerse.dtos.article.ArticleUpdateDto;
import edu.az.itbrains123.ecommerse.dtos.category.CategoryHomeDto;
import edu.az.itbrains123.ecommerse.models.Article;
import edu.az.itbrains123.ecommerse.repositories.ArticleRepository;
import edu.az.itbrains123.ecommerse.sevices.AricleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements AricleService {
    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

    public ArticleServiceImpl(ArticleRepository articleRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createArticle(ArticleCreateDto articleCreateDto) {
        Article article=new Article();
        article.setName(articleCreateDto.getName());
        article.setDescription(articleCreateDto.getDescription());
        article.setPublish(articleCreateDto.getPublish());
        articleRepository.save(article);
    }

    @Override
    public void updateArticle(ArticleUpdateDto articleUpdateDto,Long id) {
        Article article=articleRepository.findById(id).orElseThrow();
        article.setName(articleUpdateDto.getName());
        article.setDescription(articleUpdateDto.getDescription());
        article.setPublish(articleUpdateDto.getPublish());
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        Article article =articleRepository.findById(id).orElseThrow();
        articleRepository.deleteById(id);
    }

    @Override
    public ArticleUpdateDto findArticleById(Long id) {
        Article article=articleRepository.findById(id).orElseThrow();
        ArticleUpdateDto result=modelMapper.map(article,ArticleUpdateDto.class);
        return result;
    }

    @Override
    public List<ArticleHomeDto> findAllArticles() {
        List<ArticleHomeDto> articles=articleRepository.findAll()
                .stream()
                .map(article -> modelMapper.map(article, ArticleHomeDto.class)).toList();
        return articles;
    }


}
