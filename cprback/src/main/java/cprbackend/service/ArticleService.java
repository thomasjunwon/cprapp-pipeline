package cprbackend.service;

import cprbackend.entity.Article;
import cprbackend.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    public Article createArticle(Article article){
        return articleRepository.save(article);
    }

    public List<Article> findArticleAll(){
        return articleRepository.findAll();
    }
    public List<Article> findArticlesByUserId(String userId){
        return articleRepository.findByAuthor(userId);
    }
    public Article findArticleById(Long id){
        return articleRepository.findById(id);
    }

    @Transactional
    public Article updateArticle(Article article){
        Article oldArticle = articleRepository.findById(article.getId());
        oldArticle.setContent(article.getContent());
        return article;
    }

    @Transactional
    public Article deleteArticle(Article article){
        return articleRepository.delete(article);
    }

    //검색기능 구현-
    //findArticleByTitle



    //게시판-retrieve 전용, create, update,delete 전용
}
