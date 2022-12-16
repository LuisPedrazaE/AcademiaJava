package com.luv2code.springboot.cruddemo.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Huesped;

@Repository
public class HuespedDAOJdbcImpl implements HuespedDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Huesped> findAll() {
		System.out.println("Implementación DAO con JDBC: " + dataSource);

		List<Huesped> listaHuespedes = new ArrayList<>();

		String sql = "select * from huesped";

		try (Connection myConn = dataSource.getConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery(sql);) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("first_name");
				String apellido = myRs.getString("last_name");
				String email = myRs.getString("email");

				// create new student object
				Huesped tempHuesped = new Huesped(id, nombre, apellido, email);

				// add it to the list of students
				listaHuespedes.add(tempHuesped);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaHuespedes;
	}

	@Override
	public Huesped findById(int theId) {
		Huesped theHuesped = null;

		try (Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = createPreparedStatement(myConn, theId);
			ResultSet myRs = myStmt.executeQuery();) {

			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("first_name");
				String apellido = myRs.getString("last_name");
				String email = myRs.getString("email");

				// use the studentId during construction
				theHuesped = new Huesped(theId, nombre, apellido, email);
			} else {
				throw new SQLException("Could not find huesped id: " + theId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theHuesped;
	}

	private PreparedStatement createPreparedStatement(Connection con, int huespedId) throws SQLException {
		String sql = "select * from huesped where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, huespedId);
		return ps;
	}

	@Override
	public void save(Huesped theHuesped) {
		String sql = "";

		if (theHuesped.getId() == 0)
			sql = "insert into huesped (first_name, last_name, email) values (?, ?, ?)";
		else
			sql = "update huesped set first_name=?, last_name=?, email=? where id=?";

		try (Connection myConn = dataSource.getConnection();
			 PreparedStatement myStmt = myConn.prepareStatement(sql)) {

			myStmt.setString(1, theHuesped.getNombre());
			myStmt.setString(2, theHuesped.getApellido());
			myStmt.setString(3, theHuesped.getEmail());

			if (theHuesped.getId() != 0)
				myStmt.setInt(4, theHuesped.getId());

			myStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteById(int theId) {

		try (Connection myConn = dataSource.getConnection(); 
			 PreparedStatement myStmt = myConn.prepareStatement("delete from huesped where id=?")) {

			myStmt.setInt(1, theId);
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
