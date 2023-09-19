package com.fastcampus.projectboard.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.Id;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.*;

@Getter
@ToString
@Table(indexes = {
    @Index(columnList = "title"),
    @Index(columnList = "hashtag"),
    @Index(columnList = "createdAt"),
    @Index(columnList = "createdBy")
})
@Entity
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(nullable = false)
  private String title;

  @Setter
  @Column(nullable = false, length = 10000)
  private String content;

  @Setter
  private String hashtag;

  @CreatedDate
  @Column(nullable = false)
  private LocalDateTime createdAt;

  @CreatedBy
  @Column(nullable = false, length = 100)
  private String createdBy;

  @LastModifiedDate
  @Column(nullable = false)
  private LocalDateTime modifiedAt;

  @LastModifiedBy
  @Column(nullable = false, length = 100)
  private String modifiedBy;

  protected Article() {
  }

  public Article(String title, String content, String hashtag) {
    this.title = title;
    this.content = content;
    this.hashtag = hashtag;
  }

  public static Article of(String title, String content, String hashtag) {
    return new Article(title, content, hashtag);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Article article)) {
      return false;
    }
    return Objects.equals(id, article.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
