package cprbackend.repository;

import cprbackend.entity.Article;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepository {
    private EntityManager em;
    public Article save(Article article){
        em.persist(article);
        return article;
    }

    public List<Article> findAll(){
        return em.createQuery("select a from Article a", Article.class).getResultList();
    }

    public Article findById(Long id){
        return em.find(Article.class,id);
    }

    public Article findByTitle(String title){
        return em.createQuery("select a from Article a where m.title=:title", Article.class).setParameter("title",title).getSingleResult();
    }

    public List<Article> findByAuthor(String author){
        return em.createQuery("select a from Article a where a.author=:author", Article.class).setParameter("author",author).getResultList();
    }

    public Article delete(Article article){
        em.remove(article);
        return article;
    }
}
