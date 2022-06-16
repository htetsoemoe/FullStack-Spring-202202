package com.jdc.project.model.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.project.model.dto.Project;
import com.jdc.project.model.service.utils.ProjectHelper;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectHelper projectHelper;
	
	@Autowired
	private SimpleJdbcInsert projectInsert;
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private RowMapper<Project> rowMapper;
	
	public ProjectService() {
		rowMapper = new BeanPropertyRowMapper<>(Project.class);
	}
	
	public int create(Project project) {
		projectHelper.validate(project);		
		return projectInsert.executeAndReturnKey(projectHelper.insertParams(project)).intValue();
	}

	public Project findById(int id) {
		var sql = "select p.id, p.name, p.description, m.id as manager_id, p.start as start_date, p.months, m.name as manager_name, m.login_id as manager_login from project p inner join member m on p.manager = m.id where p.id =:id";
		 return template.queryForObject(sql, Map.of("id", id), rowMapper);
	
	}

	public List<Project> search(String project, String manager, LocalDate dateFrom, LocalDate dateTo) {
		var sql = """
				select p.id, p.name, p.description, m.id as manager_id, p.start as start_date, p.months, m.name as manager_name, m.login_id as manager_login 
				from project p 
				inner join member m on p.manager = m.id
				""";
		var sb = new StringBuffer(sql);
		var params = new HashMap<String, Object>();
		
		if(null == project && null == manager && null == dateFrom && null == dateTo) {
			return template.query(sql, rowMapper);
		}
		
		if (StringUtils.hasLength(manager)) {
			sb.append(" where m.name like :manager");
			params.put("manager", manager.concat("%"));
			return template.queryForStream(sb.toString(), params, rowMapper).map(a -> (Project)a).toList();
		}
		
		if (null != dateFrom) {
			sb.append(" where p.start like :startDate");
			params.put("startDate", dateFrom.toString().concat("%"));
			return template.queryForStream(sb.toString(), params, rowMapper).map(a -> (Project)a).toList();
		}
		
		if (null != dateTo) {
			sb.append(" where p.start like :dateTo");
			params.put("dateTo", dateTo.toString().concat("%"));
			return template.queryForStream(sb.toString(), params, rowMapper).map(a -> (Project)a).toList();
		}
		
		return null;
	}

	public int update(int id, String name, String description, LocalDate startDate, int month) {

		var sql = "update project set name = :name, description = :description, start = :start, months = :months where id = :id";
		
		var param = new MapSqlParameterSource();
		param.addValue("name", name);
		param.addValue("description", description);
		param.addValue("start", Date.valueOf(startDate));
		param.addValue("months", month);
		param.addValue("id", id);
		
		return template.update(sql, param);
	}

	public int deleteById(int id) {
		var sql = "delete from project where id = :id";
		var param = new MapSqlParameterSource();
		param.addValue("id", id);
		
		return template.update(sql, param);
	}

}
