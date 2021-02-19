package com.nexon.dao.mapper;

import com.nexon.dao.entity.BiliUserFollower;
import java.util.List;

public interface BiliUserFollowerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bili_user_follower
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bili_user_follower
     *
     * @mbg.generated
     */
    int insert(BiliUserFollower record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bili_user_follower
     *
     * @mbg.generated
     */
    BiliUserFollower selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bili_user_follower
     *
     * @mbg.generated
     */
    List<BiliUserFollower> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bili_user_follower
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(BiliUserFollower record);
}