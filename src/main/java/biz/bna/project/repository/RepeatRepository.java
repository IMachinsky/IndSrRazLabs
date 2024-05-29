package biz.bna.project.repository;

import biz.bna.project.model.Repeat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RepeatRepository extends TableRepository<Repeat>{

    public RepeatRepository() {
        super(Repeat.class);
    }

    public List<Repeat> findWhere(String where, Map<Integer, Object> params) {
        String sql = String.format("SELECT * FROM %s WHERE %s", "repeat", where);
        List<Repeat> repeats = new ArrayList<>();
        try {
            ResultSet resultSet = databaseUtils.select(sql, params);
            while (resultSet.next()) {
                Repeat repeat = new Repeat();
                repeat.setRepeatId(resultSet.getInt("repeat_id"));
                repeat.setWordId(resultSet.getInt("word_id"));
                repeat.setAppendixId(resultSet.getInt("appendix_id"));
                repeat.setRepeatCount(resultSet.getInt("repeat_count"));
                repeats.add(repeat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return repeats;
    }

    public List<Repeat> findWhere(String where, Object param0Value) {
        String sql = String.format("SELECT * FROM %s WHERE %s", "repeat", where);
        List<Repeat> repeats = new ArrayList<>();
        try {
            ResultSet resultSet = databaseUtils.select(sql, param0Value);
            while (resultSet.next()) {
                Repeat repeat = new Repeat();
                repeat.setRepeatId(resultSet.getInt("repeat_id"));
                repeat.setWordId(resultSet.getInt("word_id"));
                repeat.setAppendixId(resultSet.getInt("appendix_id"));
                repeat.setRepeatCount(resultSet.getInt("repeat_count"));
                repeats.add(repeat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return repeats;
    }

    @Override
    public void update(Repeat obj) {
        String sql = String.format("UPDATE %s SET " + "appendix_id = ?, " + "word_id = ?, " + "%1$s_count = ? " + "WHERE %1$s_id = ?", "repeat");
        Map<Integer, Object> params = Map.of(
                1, obj.getAppendixId(),
                2, obj.getWordId(),
                3, obj.getRepeatCount(),
                4, obj.getRepeatId()
        );
        databaseUtils.executeSql(sql, params);
    }

    @Override
    public void insert(Repeat obj) {
        String sql = String.format("INSERT INTO %s ( %1$s_id, appendix_id, word_id, %1$s_count) " + "VALUES (?, ?, ?, ?) ", "repeat");
        Map<Integer, Object> params = Map.of(
                1, databaseUtils.getSequenceNextValue("repeat_id_gen"),
                2, obj.getAppendixId(),
                3, obj.getWordId(),
                4, obj.getRepeatCount()
        );
        databaseUtils.executeSql(sql, params);
    }
}
