package database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

import static models.ObjectTools.toTypeWithValue;

public class DatabaseReader {

    public Connection createConnection(String driverName, String url, String user, String password) throws Exception {
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }

    public ArrayList executeSelect(Connection connection,Class typeOfEntity, String table) throws Exception {
        PreparedStatement pst = connection.prepareStatement(String.format("SELECT * FROM %s", table));
        ResultSet rs = pst.executeQuery();

        ArrayList listOfEntities = new ArrayList();
        ResultSetMetaData rsmd = rs.getMetaData();

        while (rs.next()) {
            Object entity = typeOfEntity.newInstance();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                Field[] fieldsOfEntity = typeOfEntity.getDeclaredFields();
                for (int j = 0; j < fieldsOfEntity.length; j++) {
                    if (getDbFieldName(fieldsOfEntity[j]) != null) {
                        if (getDbFieldName(fieldsOfEntity[j]).equals(rsmd.getColumnName(i))) {
                            fieldsOfEntity[j].set(entity, toTypeWithValue(fieldsOfEntity[j].getType(), rs.getObject(i).toString()));
                        }
                    }
                }
            }
            listOfEntities.add(entity);
        }
        return listOfEntities;
    }
    private String getDbFieldName(Field field) {
        Annotation annotation = field.getAnnotation(DbField.class);
        DbField columnAnnotation = (DbField) annotation;
        if (columnAnnotation == null) {
            return null;
        } else return columnAnnotation.name();
    }
}
