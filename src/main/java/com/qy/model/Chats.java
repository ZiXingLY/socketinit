package com.qy.model;

import javax.persistence.*;

@Table(name = "qy_chats")
public class Chats {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 消息发送者id
     */
    private Integer send_id;
    @Transient
    private String send_user_name;
    @Transient
    private String send_user_avatar;
    @Transient
    private String target_user_name;
    @Transient
    private String target_user_avatar;

    /**
     * 消息接受者id
     */
    private Integer target_id;
    /**
     * 群组id
     */
    private Integer chats_group_id;

    /**
     * 状态：0成功  -1拒收或失败
     */
    private Integer state;

    /**
     * 发送时间
     */
    private String add_time;

    /**
     * 消息内容
     */
    private String msg;
    /**
     * 阅读状态
     */
    private Integer read_state;

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
     * 获取消息发送者id
     *
     * @return send_id - 消息发送者id
     */
    public Integer getSend_id() {
        return send_id;
    }

    /**
     * 设置消息发送者id
     *
     * @param send_id 消息发送者id
     */
    public void setSend_id(Integer send_id) {
        this.send_id = send_id;
    }

    /**
     * 获取消息接受者id
     *
     * @return target_id - 消息接受者id
     */
    public Integer getTarget_id() {
        return target_id;
    }

    /**
     * 设置消息接受者id
     *
     * @param target_id 消息接受者id
     */
    public void setTarget_id(Integer target_id) {
        this.target_id = target_id;
    }

    /**
     * 获取状态：0成功  -1拒收或失败
     *
     * @return state - 状态：0成功  -1拒收或失败
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态：0成功  -1拒收或失败
     *
     * @param state 状态：0成功  -1拒收或失败
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取发送时间
     *
     * @return add_time - 发送时间
     */
    public String getAdd_time() {
        return add_time;
    }

    /**
     * 设置发送时间
     *
     * @param add_time 发送时间
     */
    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    /**
     * 获取消息内容
     *
     * @return msg - 消息内容
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置消息内容
     *
     * @param msg 消息内容
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getChats_group_id() {
        return chats_group_id;
    }

    public void setChats_group_id(Integer chats_group_id) {
        this.chats_group_id = chats_group_id;
    }

    public String getSend_user_name() {
        return send_user_name;
    }

    public void setSend_user_name(String send_user_name) {
        this.send_user_name = send_user_name;
    }

    public String getSend_user_avatar() {
        return send_user_avatar;
    }

    public void setSend_user_avatar(String send_user_avatar) {
        this.send_user_avatar = send_user_avatar;
    }

    public String getTarget_user_name() {
        return target_user_name;
    }

    public void setTarget_user_name(String target_user_name) {
        this.target_user_name = target_user_name;
    }

    public String getTarget_user_avatar() {
        return target_user_avatar;
    }

    public void setTarget_user_avatar(String target_user_avatar) {
        this.target_user_avatar = target_user_avatar;
    }

    public Integer getRead_state() {
        return read_state;
    }

    public void setRead_state(Integer read_state) {
        this.read_state = read_state;
    }
}