package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beans.Machine;
import beans.Marque;
import connexion.Connexion;
import dao.IDao;

public class MachineService implements IDao<Machine> {
	
MarqueService ms = new MarqueService();  @Override
    public boolean create(Machine o) {
        String sql = "insert into machine(reference,dateAchat,prix,marque) values (?, ?, ?,?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getReference());
            ps.setDate(2, new Date(o.getDateAchat().getTime()));
            ps.setDouble(3, o.getPrix());
            ps.setInt(4, o.getMarque().getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());

        }
        return false;
    }

    @Override
    public boolean delete(Machine o) {
        String sql = "delete from machine where id  = ?";
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
    public boolean update(Machine o) {

        String sql = "update machine set reference  = ? ,dateAchat = ? , prix = ? , marque = ? where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getReference());
            ps.setDate(2, new Date(o.getDateAchat().getTime()));
            ps.setDouble(3, o.getPrix());
            ps.setInt(4, o.getMarque().getId());
            ps.setInt(5, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());

        }
        return false;
    }

    @Override
    public Machine findById(int id) {
        Machine m = null;
        
        String sql = "select * from machine where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"),ms.findById(rs.getInt("marque")));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }
    
   

    @Override
    public List<Machine> findAll() {
        List<Machine> machines = new ArrayList<Machine>();

        String sql = "select * from machine";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"),ms.findById(rs.getInt("marque"))));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    public List<Machine> findMachineByReference(String ref) {
        List<Machine> machines = new ArrayList<Machine>();

        String sql = "select * from machine where reference =  ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setString(1, ref);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"),ms.findById(rs.getInt("marque"))));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    public Boolean findReference(String reference) {
        String sql = "select count(*) from machine where reference = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setString(1, reference);
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
    
    public Boolean findReferenceExceptId(String reference,int id) {
        String sql = "select count(*) from machine where reference = ? and id !=?";
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
            System.out.println("findReference " + e.getMessage());
        }
        return false;
    }
    
    

    
    public List<Machine> findMachineParMarque(Marque M){
    	List<Machine> machines = new ArrayList<Machine>();
        String sql = "select * from machine where marque=?"; 
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, M.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"),ms.findById(rs.getInt("marque"))));
            }
        } catch (SQLException e) {
            System.out.println("findReference " + e.getMessage());
        }
        return machines;
    }
    
    public List<Machine> findMachineBetweenTwoDates(java.util.Date date1, java.util.Date date2) {
    	List<Machine> machines = new ArrayList<Machine>();
    	MarqueService ms = new MarqueService();
        try {
            String req = "select * from machine where dateAchat between ? and ?";
            PreparedStatement pr =Connexion.getInstane().getConnection().prepareStatement(req);;
            pr.setDate(1, new Date(date1.getTime()));
            pr.setDate(2, new Date(date2.getTime()));
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
            	machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"), ms.findById(rs.getInt("marque"))));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return machines;
    }
    
    public Map<String,Integer> findMachinesLesPlusAchete() {
    	Map<String,Integer> machines = new HashMap<String,Integer>();
    	MarqueService ms = new MarqueService();
        try {
            String req = "select m.libelle,count(*) from marque m, machine o where m.id=o.marque group by m.id order by count(*) desc limit 5";
            PreparedStatement pr =Connexion.getInstane().getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
            	machines.put(rs.getString("libelle"), rs.getInt("count"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return machines;
    }
    
    public Map<String,Integer> findVariationMarque() {
    	Map<String,Integer> machines = new HashMap<String,Integer>();
        try {
            String req = "select libelle,count(*) from machine a, marque b where a.marque=b.id group by marque ";
            PreparedStatement pr =Connexion.getInstane().getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
            	machines.put(rs.getString("libelle"), rs.getInt("count"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return machines;
    }
    
    public Map<Integer,Integer> findMachinesByMarque(int id) {
    	Map<Integer,Integer> machines = new HashMap<Integer,Integer>();
        try {
            String req = " select MONTH(a.dateAchat), count(*) from machine a, marque b where a.marque=b.id and marque = ? group by MONTH(a.dateAchat)";
            PreparedStatement pr =Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
            	machines.put(rs.getInt("MONTH(a.dateAchat)"), rs.getInt("count"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return machines;
    }

}
