package com.qy.model;

import javax.persistence.*;

@Table(name = "qy_blacklist")
public class Blacklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    private Integer user_id;

    /**
     * 被拉黑用户id
     */
    private Integer be_pulled_black_id;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private String add_time;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * 设置用户id
     *
     * @param user_id 用户id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * 获取被拉黑用户id
     *
     * @return be_pulled_black_id - 被拉黑用户id
     */
    public Integer getBe_pulled_black_id() {
        return be_pulled_black_id;
    }

    /**
     * 设置被拉黑用户id
     *
     * @param be_pulled_black_id 被拉黑用户id
     */
    public void setBe_pulled_black_id(Integer be_pulled_black_id) {
        this.be_pulled_black_id = be_pulled_black_id;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取创建时间
     *
     * @return add_time - 创建时间
     */
    public String getAdd_time() {
        return add_time;
    }

    /**
     * 设置创建时间
     *
     * @param add_time 创建时间
     */
    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }
}