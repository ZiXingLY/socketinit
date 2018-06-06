package com.qy.model;

import javax.persistence.*;

@Table(name = "qy_chats_group_member")
public class ChatsGroupMember {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 群组id
     */
    private Integer chats_group_id;

    /**
     * 用户id
     */
    private Integer member_id;

    /**
     * 添加时间
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
     * 获取群组id
     *
     * @return chats_group_id - 群组id
     */
    public Integer getChats_group_id() {
        return chats_group_id;
    }

    /**
     * 设置群组id
     *
     * @param chats_group_id 群组id
     */
    public void setChats_group_id(Integer chats_group_id) {
        this.chats_group_id = chats_group_id;
    }

    /**
     * 获取用户id
     *
     * @return member_id - 用户id
     */
    public Integer getMember_id() {
        return member_id;
    }

    /**
     * 设置用户id
     *
     * @param member_id 用户id
     */
    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public String getAdd_time() {
        return add_time;
    }

    /**
     * 设置添加时间
     *
     * @param add_time 添加时间
     */
    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }
}