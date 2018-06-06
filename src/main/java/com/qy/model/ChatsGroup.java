package com.qy.model;

import javax.persistence.*;

@Table(name = "qy_chats_group")
public class ChatsGroup {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 群组添加时间
     */
    private String add_time;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取群组添加时间
     *
     * @return add_time - 群组添加时间
     */
    public String getAdd_time() {
        return add_time;
    }

    /**
     * 设置群组添加时间
     *
     * @param add_time 群组添加时间
     */
    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }
}