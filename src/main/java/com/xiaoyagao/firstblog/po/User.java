package com.xiaoyagao.firstblog.po;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="t_user")
@Data
public class User {
    @Id
    private Long id;
    private String nickname;
    private String username;
    private String password;
    private String email;
    private String avatar;//用户头像
    private Integer type;//用户类型
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();
}
