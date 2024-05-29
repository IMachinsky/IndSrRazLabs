package biz.bna.project.utils;

import java.sql.*;
import java.util.Date;
import java.util.Map;

public class DatabaseUtils {
    final String databaseUrl = "";
    final String dataBaseUsername = "";
    final String databaseUserPassword = "";

    public DatabaseUtils() {
    }

    public void executeSql(String sql){
        try(Connection connection = DriverManager.getConnection(databaseUrl, dataBaseUsername, databaseUserPassword)){
            Statement statement = connection.createStatement();
            statement.execute(sql);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void executeSql(String sql, Object param0Value){
        executeSql(sql, Map.of(1, param0Value));
    }

    public void executeSql(String sql, Map<Integer, Object> params){
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            setParams(statement, params);
            statement.execute();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResultSet select(String sql, Map<Integer, Object> params){
        try (Connection connection = getConnection()){
            PreparedStatement stm = connection.prepareStatement(sql);
            setParams(stm, params);
            return stm.executeQuery();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public Integer getSequenceNextValue(String sequenceName){
        try (Connection connection = getConnection()){
            String sql = String.format("SELECT nextval('%s')", sequenceName);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt(1);
            }else {
                return 1;
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResultSet select(String sql){
        return select(sql, Map.of());
    }

    public ResultSet select(String sql, Object param0Value){
        return select(sql, Map.of(1, param0Value));
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(databaseUrl, dataBaseUsername, databaseUserPassword);
    }

    private void setParams(PreparedStatement statement, Map<Integer, Object> params){
        params.keySet().stream()
                .forEach(key -> {
                    try {
                        Object obj = params.get(key);
                        if (obj instanceof Integer) {
                            statement.setInt(key, (Integer) obj);
                        }
                        if (obj instanceof String) {
                            statement.setString(key, (String) obj);
                        }
                        if (obj instanceof Date) {
                            statement.setObject(key, obj);
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
