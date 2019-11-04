package com.iist.demo.auth.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iist.demo.auth.model.User;

@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public User get(String userName) {
		
		Map<String, Object> argMap = new HashMap<String, Object>();
		String sql = "SELECT * FROM tbl_users WHERE user_name =:userName";
		
		argMap.put("userName", userName);
		try {
			return this.jdbcTemplate.queryForObject(sql, argMap, new BeanPropertyRowMapper<User>(User.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	
}
