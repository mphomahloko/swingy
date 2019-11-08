package za.co.wethinkcode.app.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import za.co.wethinkcode.app.model.Hero;

public class PlayerStatDB {
    private static PlayerStatDB _db = new PlayerStatDB();
    private static Connection connect;
    private static boolean hasData = false;

    private PlayerStatDB() { return ; }

    public static PlayerStatDB getPlayerStats() {
        return PlayerStatDB._db;
    }

    public List<Map<String, String>> getUsers() throws SQLException, ClassNotFoundException {
        if (connect == null)
            getConnection();
        Statement statement = connect.createStatement();
        ResultSet res = statement.executeQuery("SELECT * FROM users");
        try {
            ResultSet players = res;
            List<Map<String, String>> ret = new ArrayList<Map<String, String>>();
            while (players.next()){
                Map<String,String> player = new HashMap<String, String>();
                player.put("name", players.getString("name"));
                player.put("id", players.getString("id"));
                player.put("type", players.getString("type"));
                player.put("xp", players.getString("xp"));
                player.put("hp", players.getString("hp"));
                player.put("level", players.getString("level"));
                player.put("y", players.getString("y"));
                player.put("x", players.getString("x"));
                player.put("attack", players.getString("attack"));
                player.put("defence", players.getString("defence"));
                player.put("artifact", players.getString("artifact"));
                ret.add(player);
            }
            return ret;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void insertInfo(Hero hero) throws SQLException, ClassNotFoundException {
        if (connect == null){
            getConnection();
        }
        PreparedStatement pStatement = connect.prepareStatement("INSERT INTO users(name, type, xp, hp, attack, defence, level, y, x, artifact) values(?,?,?,?,?,?,?,?,?,?);");
        pStatement.setString(1, hero.getHeroName());
        pStatement.setString(2, hero.getHeroType());
        pStatement.setInt(3, hero.getHeroXP());
        pStatement.setInt(4, hero.getHeroHP());
        pStatement.setInt(5, hero.getHeroAttack());
        pStatement.setInt(6, hero.getHeroDefence());
        pStatement.setInt(7, hero.getHeroLevel());
        pStatement.setInt(8, hero.getHeroY());
        pStatement.setInt(9, hero.getHeroX());
        pStatement.setString(10, hero.getHeroArtifact());
        pStatement.execute();
        pStatement.close();
    }

    public ResultSet getGeneratedKeys() throws SQLException, ClassNotFoundException {
        if (connect == null)
            getConnection();
        PreparedStatement getGeneratedKeys = connect.prepareStatement(
                "SELECT MAX(id) AS LAST FROM users;");
        return getGeneratedKeys.executeQuery();
    }

    public void updateInfo(int id, String name, String type, int xp, int hp, int attack, int defence, int level, int y, int x, String artifact) throws SQLException, ClassNotFoundException {
        if (connect == null){
            getConnection();
        }
        PreparedStatement pStatement = connect.prepareStatement("UPDATE users SET name = ?, type = ?, xp = ?, hp = ?, attack = ?, defence = ?, level = ?, y = ?, x = ?, artifact = ? WHERE id = "+id+";");
        pStatement.setString(1, name);
        pStatement.setString(2, type);
        pStatement.setInt(3, xp);
        pStatement.setInt(4, hp);
        pStatement.setInt(5, attack);
        pStatement.setInt(6, defence);
        pStatement.setInt(7, level);
        pStatement.setInt(8, y);
        pStatement.setInt(9, x);
        pStatement.setString(10, artifact);
        pStatement.execute();
        pStatement.close();
    }

    private void getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connect = DriverManager.getConnection("jdbc:sqlite:Swingy");
        init();
    }

    private void init() throws SQLException, ClassNotFoundException {
        if (!hasData){
            hasData = true;
            Statement statement = connect.createStatement();
            ResultSet res = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='users'");
            if (!res.next()){
                Statement statement1 = connect.createStatement();
                statement1.execute("CREATE TABLE `users` ( `id` integer , `name` varchar(30) , `type` varchar(20) ," +
                        " `xp` integer , `hp` integer , `attack` integer , `defence` integer , `level` integer ," +
                        "`y` integer , `x` integer , `artifact` varchar(20), primary key(id));");
            }
        }
    }
}