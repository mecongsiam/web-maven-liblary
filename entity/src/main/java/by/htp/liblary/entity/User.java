package by.htp.liblary.entity;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idUser;
    private String role;
    private String login;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        
        if (idUser != user.getIdUser()) {
            return false;
        }
        if (!role.equals(user.getRole())) {

            return false;
        }
        if (!login.equals(user.getLogin())) {
            return false;
        }
        return true;
    }

    public int hashcode() {
        return idUser * 7 + role.hashCode() * 7 + login.hashCode() * 10;
    }

    // to do
}
