package biz.bna.project.utils;

public class OrmUtils {
    public static String getTableName(Class cls){
        return cls.getSimpleName();
    }
}
