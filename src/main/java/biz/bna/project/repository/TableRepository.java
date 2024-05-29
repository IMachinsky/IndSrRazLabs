package biz.bna.project.repository;

import biz.bna.project.utils.DatabaseUtils;
import biz.bna.project.utils.OrmUtils;


public abstract class TableRepository <T>{
    private final Class<T> cls;
    protected final DatabaseUtils databaseUtils;

    public TableRepository(Class<T> cls){
        databaseUtils = new DatabaseUtils();
        this.cls = cls;
    }
    public void delete(int id){
        String sql = String.format("DELETE FROM %s WHERE %1$s_id = ?", OrmUtils.getTableName(cls));
        databaseUtils.executeSql(sql, id);
    }

    public void delete(int[] ids){
        for(int id: ids){
            delete(id);
        }
    }

    public abstract void update(T obj);
    public abstract void insert(T obj);

}
