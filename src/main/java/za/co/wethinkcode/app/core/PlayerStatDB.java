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
    private static final PlayerStatDB _db = new PlayerStatDB();
    private static Connection connect;
    private static boolean hasData = false;

    private PlayerStatDB() { }

    public static PlayerStatDB getPlayerStats() {
        return PlayerStatDB._db;
    }
    
    // for the continue screen
    public List<Map<String, String>> getUsers() throws SQLException, ClassNotFoundException {
        if (connect == null)
            getConnection();
        Statement statement = connect.createStatement();
        ResultSet res = statement.executeQuery("SELECT * FROM users");
        try {
            List<Map<String, String>> ret = new ArrayList<>();
            while (res.next()){
                Map<String,String> player = new HashMap<>();
                player.put("name", res.getString("name"));
                player.put("id", res.getString("id"));
                player.put("type", res.getString("type"));
                player.put("xp", res.getString("xp"));
                player.put("hp", res.getString("hp"));
                player.put("level", res.getString("level"));
                player.put("y", res.getString("y"));
                player.put("x", res.getString("x"));
                player.put("attack", res.getString("attack"));
                player.put("defence", res.getString("defence"));
                player.put("artifact", res.getString("artifact"));
		player.put("experience", res.getString("experience"));
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
        PreparedStatement pStatement = connect.prepareStatement("INSERT INTO users(name, type, xp, hp, attack, defence, level, y, x, artifact, experience) values(?,?,?,?,?,?,?,?,?,?,?);");
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
	pStatement.setInt(11, hero.getHeroExperience());
        pStatement.execute();
        pStatement.close();
    }

    public ResultSet getGeneratedKeys() throws SQLException, ClassNotFoundException {
        if (connect == null)
            getConnection();
        PreparedStatement getGeneratedKeys = connect.prepareStatement("SELECT MAX(id) AS LAST FROM users;");
        return getGeneratedKeys.executeQuery();
    }

    public void updateInfo(Hero hero) throws SQLException, ClassNotFoundException {
        if (connect == null){
            getConnection();
        }
        PreparedStatement pStatement = connect.prepareStatement("UPDATE users SET name = ?, type = ?, xp = ?, hp = ?, attack = ?, defence = ?," +
								" level = ?, y = ?, x = ?, artifact = ?, experience = ? WHERE id = "+hero.getHeroId()+";");
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
	pStatement.setInt(11, hero.getHeroExperience());
        pStatement.execute();
        pStatement.close();
    }

    private void getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connect = DriverManager.getConnection("jdbc:sqlite:Swingy");
        init();
    }

    private void init() throws SQLException {
        if (!hasData){
            hasData = true;
            Statement statement = connect.createStatement();
            ResultSet res = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='users'");
            if (!res.next()){
                Statement statement1 = connect.createStatement();
                statement1.execute("CREATE TABLE `users` ( `id` integer, `name` varchar(30), `type` varchar(20)," +
                        " `xp` integer, `hp` integer, `attack` integer, `defence` integer, `level` integer," +
                        "`y` integer, `x` integer, `artifact` varchar(20), `experience` integer, primary key(id));");
            }
        }
    }
}
