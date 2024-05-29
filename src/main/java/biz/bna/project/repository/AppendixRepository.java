package biz.bna.project.repository;
import biz.bna.project.model.Appendix;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AppendixRepository extends TableRepository<Appendix>{

    public AppendixRepository() {
        super(Appendix.class);
    }

    public Appendix getOne(int id) throws SQLException {
        String sql = String.format("SELECT * FROM %s WHERE %1$s_id = ?", "appendix");
        Appendix appendix = new Appendix();
        try{
            ResultSet resultSet = databaseUtils.select(sql, id);
            if(resultSet.next()){
                appendix.setAppendixId(resultSet.getInt("id"));
                appendix.setAppendixName(resultSet.getString("name"));
                appendix.setAppendixPath(resultSet.getString("description"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return appendix;
    }

    public List<Appendix> findWhere(String where, Map<Integer, Object> params) {
        String sql = String.format("SELECT * FROM %s WHERE %s", "appendix", where);
        List<Appendix> appendixViews = new ArrayList<>();

        try {
            ResultSet resultSet = databaseUtils.select(sql, params);
            while (resultSet.next()) {
                Appendix appendix = new Appendix();
                appendix.setAppendixId(resultSet.getInt("appendix_id"));
                appendix.setAppendixName(resultSet.getString("appendix_name"));
                appendix.setAppendixPath(resultSet.getString("appendix_path"));
                appendixViews.add(appendix);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appendixViews;
    }

    public List<Appendix> findWhere(String where, Object param0Value) {
        String sql = String.format("SELECT * FROM %s WHERE %s", "appendix", where);
        List<Appendix> appendixViews = new ArrayList<>();

        try {
            ResultSet resultSet = databaseUtils.select(sql, param0Value);
            while (resultSet.next()) {
                Appendix appendix = new Appendix();
                appendix.setAppendixId(resultSet.getInt("id"));
                appendix.setAppendixName(resultSet.getString("name"));
                appendix.setAppendixPath(resultSet.getString("description"));
                appendixViews.add(appendix);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appendixViews;
    }

    @Override
    public void update(Appendix obj) {
        String sql = String.format("UPDATE %s SET " + "%1$s_name = ?, " + "%1$s_path = ? " + "WHERE %1$s_id = ?", "appendix");
        Map<Integer, Object> params = Map.of(
                1, obj.getAppendixName(),
                2, obj.getAppendixPath(),
                3, obj.getAppendixId()
        );
        databaseUtils.executeSql(sql, params);
    }

    @Override
    public void insert(Appendix obj) {
        String sql = String.format("INSERT INTO %s (%1$s_id, %1$s_name, %1$s_path) VALUES (?, ?, ?)", "appendix");
        obj.setAppendixId(databaseUtils.getSequenceNextValue("appendix_id_gen"));
        Map<Integer, Object> params = Map.of(
                1, obj.getAppendixId(),
                2, obj.getAppendixName(),
                3, obj.getAppendixPath()
        );
        databaseUtils.executeSql(sql, params);
    }
}
