package com.xiaoyagao.firstblog.po;

import lombok.Data;
import org.apache.ibatis.annotations.One;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="t_blog")
@Data
public class Blog {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private  String firstPicture;
    private String flag;
    private Integer views;
    private boolean appreciation;
    private boolean commentabled;
    private boolean shareStatement;
    private boolean published;
    private boolean recommend;

    @ManyToOne
    private User user;
    @ManyToOne
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags=new ArrayList<>();

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments=new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public Blog() {
    }


}
