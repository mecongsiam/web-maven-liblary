package by.htp.liblary.tdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import by.htp.liblary.dao.connection_pool.ConnectionPool;
import by.htp.liblary.dao.connection_pool.ConnectionPoolException;
import by.htp.liblary.entity.Abonement;

public class MainB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Abonement> arr = new ArrayList<Abonement>();
		Abonement abonement;

		ConnectionPool p = ConnectionPool.getInstance();
		Connection con = null;

		ResultSet rs = null;

		try {
			p.initPoolData();
			con = p.takeConnection();
			try {


				String sql = "SELECT id_book,book_auther.name,group_concat(surname),year "
						+ "as surname from book_auther group by id_book";
				PreparedStatement pr = con.prepareStatement(sql);

				rs = pr.executeQuery();
				while (rs.next()) {
					/*abonement = new Abonement();
					abonement.setLogin(rs.getString(1));
					abonement.setIdAbonement(Integer.parseInt(rs.getString(2)));
					abonement.setName(rs.getString(3));
					abonement.setSurname(rs.getString(4));
					abonement.setEmail(rs.getString(5));
					abonement.setAddress(rs.getString(6));
					abonement.setPhone(rs.getString(7));
					arr.add(abonement);*/

					System.out.println(rs.getString(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					System.out.println(rs.getString(4));
					

				}
				

				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

}
