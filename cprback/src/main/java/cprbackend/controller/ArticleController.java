package cprbackend.controller;

import cprbackend.dto.ArticleDTO;
import cprbackend.dto.ResponseDTO;
import cprbackend.entity.Article;
import cprbackend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/communityboard")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    //읽기 게시판: read
    @GetMapping("/common")
    public ResponseEntity<?> retrieveArticles(){
        List<Article> articles = articleService.findArticleAll();
            List<ArticleDTO> dtos=articles.stream().map(ArticleDTO ::new).toList();
            ResponseDTO<ArticleDTO> responseDTO=ResponseDTO.<ArticleDTO>builder().data(dtos).build();
            return ResponseEntity.ok().body(responseDTO);
    }


    //나의 게시판: create, retrieve, update, delete
    @GetMapping("my")
    public ResponseEntity<?> retrieveMyArticles(@AuthenticationPrincipal String userId){
        List<Article> articles=articleService.findArticlesByUserId(userId);
        List<ArticleDTO> dtos=articles.stream().map(ArticleDTO::new).toList();
        ResponseDTO<ArticleDTO> responseDTO=ResponseDTO.<ArticleDTO>builder().data(dtos).build();
        return ResponseEntity.ok().body(responseDTO);
    }

    @PostMapping("my")
    public ResponseEntity<?> createMyArticle(@AuthenticationPrincipal String userId, ArticleDTO articleDTO){
        try {
            Article article = ArticleDTO.toArticleEntity(articleDTO);
            article.setAuthor(userId);
            Article savedArticle = articleService.createArticle(article);
            List<Article> list = Arrays.asList(savedArticle);
            ResponseDTO<Article> responseDTO=ResponseDTO.<Article>builder().data(list).build();
            return ResponseEntity.ok().body(responseDTO);
        } catch (Exception e) {
            String error=e.getMessage();
            ResponseDTO<Article> responseDTO=ResponseDTO.<Article>builder().error(error).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @PutMapping("my")
    public ResponseEntity<?> updateMyArticle(@AuthenticationPrincipal String userId,ArticleDTO articleDTO){
        try{
            Article article=ArticleDTO.toArticleEntity(articleDTO);
            article.setAuthor(userId);
            Article updatedArticle = articleService.updateArticle(article);
            ResponseDTO<Article> responseDTO=ResponseDTO.<Article>builder().data(Arrays.asList(updatedArticle)).build();
            return ResponseEntity.ok().body(responseDTO);
        } catch (Exception e) {
            String error=e.getMessage();
            ResponseDTO<Article> responseDTO=ResponseDTO.<Article>builder().error(error).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @DeleteMapping("my")
    public ResponseEntity<?> deleteMyArticle(@AuthenticationPrincipal String userId, ArticleDTO articleDTO){
        try {
            Article article = ArticleDTO.toArticleEntity(articleDTO);
            Article deletedArticle = articleService.deleteArticle(article);
            ResponseDTO<Article> responseDTO=ResponseDTO.<Article>builder().data(Arrays.asList(deletedArticle)).build();
            return ResponseEntity.ok().body(responseDTO);
        }catch (Exception e) {
            String error=e.getMessage();
            ResponseDTO<Article> responseDTO=ResponseDTO.<Article>builder().error(error).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }


}
