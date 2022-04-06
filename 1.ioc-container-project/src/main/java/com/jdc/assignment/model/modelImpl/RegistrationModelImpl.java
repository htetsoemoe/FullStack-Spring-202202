package com.jdc.assignment.model.modelImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.assignment.domain.Course;
import com.jdc.assignment.domain.OpenClass;
import com.jdc.assignment.domain.Registration;
import com.jdc.assignment.model.RegistrationModel;

public class RegistrationModelImpl implements RegistrationModel {

	private static final String SELECT_SQL = """
			select r.id registrationId, r.open_class_id openClassId, r.student, r.phone, r.email,
			op.course_id courseId, op.start_date, op.teacher,
			c.id course_id, c.name, c.fees, c.duration, c.description
			from registration r
			join open_class op on op.id = r.open_class_id
			join course c on c.id = op.course_id
			where op.id = ?;
			""";
	private static final String INSERT = "insert into registration(open_class_id, student, phone, email) values(?, ?, ?, ?);";
	
	private DataSource dataSource;

	public RegistrationModelImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Registration> findByCourseId(int openClassId) {
		var list = new ArrayList<Registration>();

		try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(SELECT_SQL)) {

			stmt.setInt(1, openClassId);
			var rs = stmt.executeQuery();

			while (rs.next()) {
				var course = new Course();
				course.setId(rs.getInt("courseId"));
				course.setName(rs.getString("name"));
				course.setFees(rs.getInt("fees"));
				course.setDuration(rs.getInt("duration"));
				course.setDescription(rs.getString("description"));

				var openClass = new OpenClass();
				openClass.setId(rs.getInt("openClassID"));
				openClass.setCourse(course);
				openClass.setStartDate(rs.getDate("start_date").toLocalDate());
				openClass.setTeacher(rs.getString("teacher"));

				var registration = new Registration();
				registration.setId(rs.getInt("registrationId"));
				registration.setOpenClass(openClass);
				registration.setStudent(rs.getString("student"));
				registration.setPhone(rs.getString("phone"));
				registration.setEmail(rs.getString("email"));

				list.add(registration);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void createRegistration(Registration registration) {
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(INSERT)) {
			
			stmt.setInt(1, registration.getOpenClass().getId());//******
			stmt.setString(2, registration.getStudent());//
			stmt.setString(3, registration.getPhone());
			stmt.setString(4, registration.getEmail());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
