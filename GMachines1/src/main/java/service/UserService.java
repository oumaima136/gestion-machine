package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Machine;
import beans.User;
import connexion.Connexion;
import dao.IDao;

public class UserService implements IDao<User> {
	MarqueService ms = new MarqueService();
    @Override
    public boolean create(User o) {
        String sql = "INSERT INTO users (nom, email, mdp, sexe, type) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getEmail());
            ps.setString(3, o.getMdp());
            ps.setString(4, o.getSexe());
            ps.setBoolean(5, o.isType());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());

        }
        return false;
    }

    @Override
    public boolean delete(User o) {
        String sql = "delete from users where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("delete : erreur sql : " + e.getMessage());

        }
        return false;
    }

    @Override
    public boolean update(User o) {

        String sql = "update users set nom  = ? ,email = ? , mdp = ?, sexe = ?,type=? where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getEmail());
            ps.setString(3, o.getMdp());
            ps.setString(4, o.getSexe());
            ps.setBoolean(5, o.isType());
            ps.setInt(6, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());

        }
        return false;
    }
    
    public Boolean findEmailExceptId(String reference,int id) {
        String sql = "select count(*) from users where email = ? and id !=?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setString(1, reference);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             if(rs.getInt("count")==0) {
            	 return true;
             }
            }
        } catch (SQLException e) {
            System.out.println("findCode " + e.getMessage());
        }
        return false;
    }

    @Override
    public User findById(int id) {
        User m = null;
        String sql = "select * from users where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("nom"), rs.getString("email"),
                        rs.getString("mdp"),rs.getString("sexe"),rs.getBoolean("type"));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<User>();

        String sql = "select * from users";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("nom"), rs.getString("email"),
                        rs.getString("mdp"),rs.getString("sexe"),rs.getBoolean("type")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return users;
    }
    
   public  User authentification(String email,String mdp) {
        String sql = "select * from users where email=? and mdp=?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,mdp);
            
            ResultSet rs = ps.executeQuery();
           while(rs.next()) {
        	   
        	   return new User(rs.getInt("id"), rs.getString("nom"), rs.getString("email"),
                        rs.getString("mdp"),rs.getString("sexe"),rs.getBoolean("type"));
           }
           
        	   
        } catch (SQLException e) {
            System.out.println( e.getMessage());
        }
        return null;
    }
   
   public List<User> findAllExepect(int id) {
       List<User> users = new ArrayList<User>();

       String sql = "select * from users where id != ?";
       try {
           PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
           ps.setInt(1, id);
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {
               users.add(new User(rs.getInt("id"), rs.getString("nom"), rs.getString("email"),
                       rs.getString("mdp"),rs.getString("sexe"),rs.getBoolean("type")));
           }

       } catch (SQLException e) {
           System.out.println("findAll " + e.getMessage());
       }
       return users;
   }

public boolean findUser(String email) {
        String sql = "select count(*) from users where email = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             if(rs.getInt("count")==0) {
            	 return true;
             }
            }
        } catch (SQLException e) {
            System.out.println("findReference " + e.getMessage());
        }
        return false;
    }

   
}