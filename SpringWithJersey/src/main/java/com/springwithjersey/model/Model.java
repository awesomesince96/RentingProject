package com.springwithjersey.model;

import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@MappedSuperclass
@Data
@EntityListeners({AuditingEntityListener.class})
public abstract class Model implements Serializable {
  private static final long serialVersionUID = -6187061292150106087L;
  public static final String MODEL_ID = "id";

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @CreatedBy
  @Column(name = "createdBy")
  private String createdBy;

  @CreatedDate
  @Column(name = "createdDate")
  private Date createdDate;

  @LastModifiedBy
  @Column(name = "updatedBy")
  private String updatedBy;

  @LastModifiedDate
  @Column(name = "updatedDate")
  private Date updatedDate;

  protected  <T extends Model> T findById(Long id, List<T> list) {
    return list.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
  }
}
