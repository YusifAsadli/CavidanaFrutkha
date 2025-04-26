package edu.az.itbrains123.ecommerse.repositories;

import edu.az.itbrains123.ecommerse.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
