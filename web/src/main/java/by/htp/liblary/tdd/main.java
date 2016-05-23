package by.htp.liblary.tdd;


public class main {

	public static void main(String[] args) {
	/*	// TODO Auto-generated method stub
		String login = "�������";
		String password = "abcd";
		String name = "gleb";
		String surname = "�����";
		String email = "vasia@yandex.com";
		String address = "ask";
		String phone = "234";
		String role = "user";
		int id = 0;
		String res=null;
		ConnectionPool p = ConnectionPool.getInstance();
		Connection con = null;

		ResultSet rs = null;

		try {
			p.initPoolData();
			con = p.takeConnection();
			try {

				String sql = "INSERT users (name,password) VALUES(?,?)";
				PreparedStatement pr = con.prepareStatement(sql);

				pr.setString(1, login);
				pr.setString(2, password);
				pr.executeUpdate();

				 sql = "SELECT id_user FROM users WHERE name= ?";
				 pr = con.prepareStatement(sql);
				pr.setString(1, login);
				rs = pr.executeQuery();
				while (rs.next()) {
					res = rs.getString(1);
				}
				
				if (res != null) {
					System.out.println("resultat zaprosa " +res);
					
					
				}
				sql = "INSERT role (id_user,user_role) VALUES(?,?)";
				pr = con.prepareStatement(sql);
				pr.setInt(1, id);
				pr.setString(2, role);
				pr.executeUpdate();

				sql = "INSERT abonement (id_user,name,surname,email,adress,phone) VALUES(?,?,?,?,?,?)";
				pr = con.prepareStatement(sql);
				pr.setInt(1, id);
				pr.setString(2, name);
				pr.setString(3, surname);
				pr.setString(4, email);
				pr.setString(5, address);
				pr.setString(6, phone);
				pr.executeUpdate();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
*/
	}
}
