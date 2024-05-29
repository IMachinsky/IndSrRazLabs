package biz.bna.project.repository;

import biz.bna.project.model.Word;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WordRepository extends TableRepository<Word>{
    public WordRepository() {
        super(Word.class);
    }


    public List<Word> findWhere(String where, Object param0Value) throws SQLException {
        String sql = String.format("SELECT * FROM %s WHERE %s", "appendix", where);
        ResultSet resultSet = databaseUtils.select(sql, param0Value);
        List<Word> words = new ArrayList<>();
        while(resultSet.next()){
            Word word = new Word();
            words.add(word);
        }
        return words;
    }

    @Override
    public void update(Word obj) {
        String sql = String.format("UPDATE %s SET " + "%1$s_text = ? " + "WHERE %1$s_id = ?", "word");
        Map<Integer, Object> params = Map.of(
                1, obj.getWordText(),
                2, obj.getWordId()
        );
        databaseUtils.executeSql(sql, params);
    }

    @Override
    public void insert(Word obj) {
        String sql = String.format("INSERT INTO %s (%1$s_id, %1$s_text) VALUES (?, ?)", "word");
        obj.setWordId(databaseUtils.getSequenceNextValue("word_id_gen"));
        Map<Integer, Object> params = Map.of(
                1, obj.getWordId(),
                2, obj.getWordText()
        );
        databaseUtils.executeSql(sql, params);
    }
}
