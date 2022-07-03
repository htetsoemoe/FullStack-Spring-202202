package com.jdc.mappings.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.jdc.mappings.model.dto.Course;
import com.jdc.mappings.model.dto.Level;

@Service 
public class CourseService {
	
	@Autowired
	private SimpleJdbcInsert courseInsert;
	
	private RowMapper<Course> rowMapper;
	
	public CourseService() {
		rowMapper = (rs, rowNum) -> {
			var c = new Course();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setLevel(Level.valueOf(rs.getString("level")));
			c.setDuration(rs.getInt("duration"));
			c.setFees(rs.getInt("fees"));
			
			return c;
		};
	}
	
	
	public int create(Course c) {
		var params = new HashMap<String, Object>();
		params.put("name", c.getName());
		params.put("level", c.getLevel().name());
		params.put("duration", c.getDuration());
		params.put("fees", c.getFees());
		
		return courseInsert.executeAndReturnKeyHolder(params).getKey().intValue();
	}
	
	public Course findById(int id) {	
		return courseInsert.getJdbcTemplate().query("select * from course where id = ?", rowMapper, id)
				.stream().findAny().orElse(null);
	}
	
	public List<Course> getAll() {	
		return courseInsert.getJdbcTemplate().query("select * from course", rowMapper);
	}
	
	
	
	
	/**
	 * 
	 * 		private List<Course> repo;
	
			@Autowired
			CourseCodeGenerator codeGen;
				
			public CourseService() {
				repo = new ArrayList<>();
			}
			
			// this method will invoke after default constructor invoked
			@PostConstruct
			public void init() {
				create(new Course("Java Basic", Level.Basic, 4, 180000));
				create(new Course("Full Stack Spring", Level.Advance, 4, 300000));
				create(new Course("Spring Cloud", Level.Advance, 4, 300000));
				create(new Course("Flutter", Level.Basic, 4, 200000));
			}
			
			public int create(Course c) {
				var id = codeGen.next();
				c.setId(id);
				repo.add(c);
				
				return id;
			}
			
			public Course findById(int id) {
				return repo.stream().filter(c -> c.getId() == id).findAny().orElse(null);
			}
			
			public List<Course> getAll() {
				return List.copyOf(repo);
			}
	 */
	
}
