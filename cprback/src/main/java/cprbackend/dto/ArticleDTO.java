package cprbackend.dto;

import cprbackend.entity.Article;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
    private Long id;
    private String title;
    private String author;
    private String content;

    public ArticleDTO(final Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.author = article.getAuthor();
        this.content = article.getContent();
    }

    public static Article toArticleEntity(ArticleDTO articleDTO){
        return Article.builder().id(articleDTO.getId())
                .title(articleDTO.getTitle())
                .author(articleDTO.getAuthor())
                .content(articleDTO.getContent()).build();
    }
}
