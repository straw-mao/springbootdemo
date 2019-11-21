package com.straw.springbootdemo.jdbcdemo.dao;

import com.straw.springbootdemo.jdbcdemo.entity.UserEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ Author : straw
 * @ Date   : 2019/11/21 17:46
 * @ Desc   :
 */

@Repository
public class UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public int add(UserEntity user) {
        String sql = "insert into user (name,pwd) values(?,?)";
        int result = jdbcTemplate.update(sql, user.getName(), user.getPwd());
        return result;
    }

    public int update(UserEntity user) {
        String sql = "update user set name=?,pwd=? where id=?";
        int result = jdbcTemplate.update(sql, user.getName(), user.getPwd(), user.getId());
        return result;
    }

    public int deleteById(String id) {
        String sql = "delete from user where id = ?";
        int result = jdbcTemplate.update(sql, id);
        return result;
    }

    public UserEntity getUserById(String id) {
        String sql = "select * from user where id=?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<UserEntity>() {
            @Override
            public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserEntity userEntity = new UserEntity();
                userEntity.setId(rs.getInt(1));
                userEntity.setName(rs.getString(2));
                userEntity.setPwd(rs.getString(3));
                return userEntity;
            }
        }, id);
    }

    public List<UserEntity> findAll() {

        List<UserEntity> list = jdbcTemplate.query("SELECT * FROM USER", new RowMapper<UserEntity>() {
            @Override
            public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserEntity userEntity = new UserEntity();
                userEntity.setId(rs.getInt(1));
                userEntity.setName(rs.getString(2));
                userEntity.setPwd(rs.getString(3));
                return userEntity;
            }
        });
        return list;
    }
}
