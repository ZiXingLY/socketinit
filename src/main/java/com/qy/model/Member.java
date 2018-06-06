package com.qy.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "qy_member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户编号
     */
    private Integer user_number;

    /**
     * 聊天设备uuid
     */
    private String socket_uuid;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户正在聊天中的用户id
     */
    private Integer chating_id;

    /**
     * 推送注册id
     */
    private String rid;

    /**
     * 用户性别：0男 1女
     */
    private Integer sex;

    /**
     * 变数
     */
    private Long variable;

    /**
     * 简介
     */
    private String introduce;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 提问数
     */
    private Integer question_number;

    /**
     * 回答数
     */
    private Integer answer_number;

    /**
     * 粉丝数
     */
    private Integer fans_number;

    /**
     * 关注数
     */
    private Integer focus_number;

    /**
     * 收藏数
     */
    private Integer collection_number;

    /**
     * 点赞数
     */
    private Integer like_number;

    /**
     * 评论数
     */
    private Integer comments_number;

    /**
     * 加持数
     */
    private Integer blessing_number;

    /**
     * 举报数
     */
    private Integer report_number;

    /**
     * 被屏蔽数
     */
    private Integer shielded_number;

    /**
     * 被举报数
     */
    private Integer reported_number;

    /**
     * 会员状态：0非会员 1普通 2终身
     */
    private Integer member_state;

    /**
     * 认证方式：0空 1自问自答 2在校师生／校友 3专家／学者 4团体／机构
     */
    private Integer authentication;

    /**
     * 认证状态：0未申请 1待认证 2通过认证 3未通过
     */
    private Integer authentication_state;

    /**
     * 自问自答认证状态：0未通过 1通过
     */
    private Integer ask_answer_state;

    /**
     * 用户状态：0未禁用 1禁用
     */
    private Integer user_state;

    /**
     * 隐藏状态：0未隐藏 1隐藏
     */
    private Integer hidden_state;

    /**
     * 个人重量值
     */
    private Long personal_weight_number;

    /**
     * 注册时间
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
     * 获取用户编号
     *
     * @return user_number - 用户编号
     */
    public Integer getUser_number() {
        return user_number;
    }

    /**
     * 设置用户编号
     *
     * @param user_number 用户编号
     */
    public void setUser_number(Integer user_number) {
        this.user_number = user_number;
    }

    /**
     * 获取聊天设备uuid
     *
     * @return socket_uuid - 聊天设备uuid
     */
    public String getSocket_uuid() {
        return socket_uuid;
    }

    /**
     * 设置聊天设备uuid
     *
     * @param socket_uuid 聊天设备uuid
     */
    public void setSocket_uuid(String socket_uuid) {
        this.socket_uuid = socket_uuid;
    }

    /**
     * 获取用户账号
     *
     * @return account - 用户账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置用户账号
     *
     * @param account 用户账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取用户密码
     *
     * @return password - 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     *
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户头像
     *
     * @return avatar - 用户头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置用户头像
     *
     * @param avatar 用户头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取用户昵称
     *
     * @return nickname - 用户昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置用户昵称
     *
     * @param nickname 用户昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取用户正在聊天中的用户id
     *
     * @return chating_id - 用户正在聊天中的用户id
     */
    public Integer getChating_id() {
        return chating_id;
    }

    /**
     * 设置用户正在聊天中的用户id
     *
     * @param chating_id 用户正在聊天中的用户id
     */
    public void setChating_id(Integer chating_id) {
        this.chating_id = chating_id;
    }

    /**
     * 获取推送注册id
     *
     * @return rid - 推送注册id
     */
    public String getRid() {
        return rid;
    }

    /**
     * 设置推送注册id
     *
     * @param rid 推送注册id
     */
    public void setRid(String rid) {
        this.rid = rid;
    }

    /**
     * 获取用户性别：0男 1女
     *
     * @return sex - 用户性别：0男 1女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置用户性别：0男 1女
     *
     * @param sex 用户性别：0男 1女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取变数
     *
     * @return variable - 变数
     */
    public Long getVariable() {
        return variable;
    }

    /**
     * 设置变数
     *
     * @param variable 变数
     */
    public void setVariable(Long variable) {
        this.variable = variable;
    }

    /**
     * 获取简介
     *
     * @return introduce - 简介
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 设置简介
     *
     * @param introduce 简介
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    /**
     * 获取余额
     *
     * @return balance - 余额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置余额
     *
     * @param balance 余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取提问数
     *
     * @return question_number - 提问数
     */
    public Integer getQuestion_number() {
        return question_number;
    }

    /**
     * 设置提问数
     *
     * @param question_number 提问数
     */
    public void setQuestion_number(Integer question_number) {
        this.question_number = question_number;
    }

    /**
     * 获取回答数
     *
     * @return answer_number - 回答数
     */
    public Integer getAnswer_number() {
        return answer_number;
    }

    /**
     * 设置回答数
     *
     * @param answer_number 回答数
     */
    public void setAnswer_number(Integer answer_number) {
        this.answer_number = answer_number;
    }

    /**
     * 获取粉丝数
     *
     * @return fans_number - 粉丝数
     */
    public Integer getFans_number() {
        return fans_number;
    }

    /**
     * 设置粉丝数
     *
     * @param fans_number 粉丝数
     */
    public void setFans_number(Integer fans_number) {
        this.fans_number = fans_number;
    }

    /**
     * 获取关注数
     *
     * @return focus_number - 关注数
     */
    public Integer getFocus_number() {
        return focus_number;
    }

    /**
     * 设置关注数
     *
     * @param focus_number 关注数
     */
    public void setFocus_number(Integer focus_number) {
        this.focus_number = focus_number;
    }

    /**
     * 获取收藏数
     *
     * @return collection_number - 收藏数
     */
    public Integer getCollection_number() {
        return collection_number;
    }

    /**
     * 设置收藏数
     *
     * @param collection_number 收藏数
     */
    public void setCollection_number(Integer collection_number) {
        this.collection_number = collection_number;
    }

    /**
     * 获取点赞数
     *
     * @return like_number - 点赞数
     */
    public Integer getLike_number() {
        return like_number;
    }

    /**
     * 设置点赞数
     *
     * @param like_number 点赞数
     */
    public void setLike_number(Integer like_number) {
        this.like_number = like_number;
    }

    /**
     * 获取评论数
     *
     * @return comments_number - 评论数
     */
    public Integer getComments_number() {
        return comments_number;
    }

    /**
     * 设置评论数
     *
     * @param comments_number 评论数
     */
    public void setComments_number(Integer comments_number) {
        this.comments_number = comments_number;
    }

    /**
     * 获取加持数
     *
     * @return blessing_number - 加持数
     */
    public Integer getBlessing_number() {
        return blessing_number;
    }

    /**
     * 设置加持数
     *
     * @param blessing_number 加持数
     */
    public void setBlessing_number(Integer blessing_number) {
        this.blessing_number = blessing_number;
    }

    /**
     * 获取举报数
     *
     * @return report_number - 举报数
     */
    public Integer getReport_number() {
        return report_number;
    }

    /**
     * 设置举报数
     *
     * @param report_number 举报数
     */
    public void setReport_number(Integer report_number) {
        this.report_number = report_number;
    }

    /**
     * 获取被屏蔽数
     *
     * @return shielded_number - 被屏蔽数
     */
    public Integer getShielded_number() {
        return shielded_number;
    }

    /**
     * 设置被屏蔽数
     *
     * @param shielded_number 被屏蔽数
     */
    public void setShielded_number(Integer shielded_number) {
        this.shielded_number = shielded_number;
    }

    /**
     * 获取被举报数
     *
     * @return reported_number - 被举报数
     */
    public Integer getReported_number() {
        return reported_number;
    }

    /**
     * 设置被举报数
     *
     * @param reported_number 被举报数
     */
    public void setReported_number(Integer reported_number) {
        this.reported_number = reported_number;
    }

    /**
     * 获取会员状态：0非会员 1普通 2终身
     *
     * @return member_state - 会员状态：0非会员 1普通 2终身
     */
    public Integer getMember_state() {
        return member_state;
    }

    /**
     * 设置会员状态：0非会员 1普通 2终身
     *
     * @param member_state 会员状态：0非会员 1普通 2终身
     */
    public void setMember_state(Integer member_state) {
        this.member_state = member_state;
    }

    /**
     * 获取认证方式：0空 1自问自答 2在校师生／校友 3专家／学者 4团体／机构
     *
     * @return authentication - 认证方式：0空 1自问自答 2在校师生／校友 3专家／学者 4团体／机构
     */
    public Integer getAuthentication() {
        return authentication;
    }

    /**
     * 设置认证方式：0空 1自问自答 2在校师生／校友 3专家／学者 4团体／机构
     *
     * @param authentication 认证方式：0空 1自问自答 2在校师生／校友 3专家／学者 4团体／机构
     */
    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }

    /**
     * 获取认证状态：0未申请 1待认证 2通过认证 3未通过
     *
     * @return authentication_state - 认证状态：0未申请 1待认证 2通过认证 3未通过
     */
    public Integer getAuthentication_state() {
        return authentication_state;
    }

    /**
     * 设置认证状态：0未申请 1待认证 2通过认证 3未通过
     *
     * @param authentication_state 认证状态：0未申请 1待认证 2通过认证 3未通过
     */
    public void setAuthentication_state(Integer authentication_state) {
        this.authentication_state = authentication_state;
    }

    /**
     * 获取自问自答认证状态：0未通过 1通过
     *
     * @return ask_answer_state - 自问自答认证状态：0未通过 1通过
     */
    public Integer getAsk_answer_state() {
        return ask_answer_state;
    }

    /**
     * 设置自问自答认证状态：0未通过 1通过
     *
     * @param ask_answer_state 自问自答认证状态：0未通过 1通过
     */
    public void setAsk_answer_state(Integer ask_answer_state) {
        this.ask_answer_state = ask_answer_state;
    }

    /**
     * 获取用户状态：0未禁用 1禁用
     *
     * @return user_state - 用户状态：0未禁用 1禁用
     */
    public Integer getUser_state() {
        return user_state;
    }

    /**
     * 设置用户状态：0未禁用 1禁用
     *
     * @param user_state 用户状态：0未禁用 1禁用
     */
    public void setUser_state(Integer user_state) {
        this.user_state = user_state;
    }

    /**
     * 获取隐藏状态：0未隐藏 1隐藏
     *
     * @return hidden_state - 隐藏状态：0未隐藏 1隐藏
     */
    public Integer getHidden_state() {
        return hidden_state;
    }

    /**
     * 设置隐藏状态：0未隐藏 1隐藏
     *
     * @param hidden_state 隐藏状态：0未隐藏 1隐藏
     */
    public void setHidden_state(Integer hidden_state) {
        this.hidden_state = hidden_state;
    }

    /**
     * 获取个人重量值
     *
     * @return personal_weight_number - 个人重量值
     */
    public Long getPersonal_weight_number() {
        return personal_weight_number;
    }

    /**
     * 设置个人重量值
     *
     * @param personal_weight_number 个人重量值
     */
    public void setPersonal_weight_number(Long personal_weight_number) {
        this.personal_weight_number = personal_weight_number;
    }

    /**
     * 获取注册时间
     *
     * @return add_time - 注册时间
     */
    public String getAdd_time() {
        return add_time;
    }

    /**
     * 设置注册时间
     *
     * @param add_time 注册时间
     */
    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }
}