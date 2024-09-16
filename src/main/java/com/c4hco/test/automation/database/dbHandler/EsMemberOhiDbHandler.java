package com.c4hco.test.automation.database.dbHandler;

import com.c4hco.test.automation.database.EntityObj.EsMemberHraAhEntity;
import com.c4hco.test.automation.database.EntityObj.EsMemberHraEntity;
import com.c4hco.test.automation.database.EntityObj.EsMemberOhiEntity;
import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;
import com.c4hco.test.automation.utils.BasicActions;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;

public class EsMemberOhiDbHandler {
    private PostgresStatementExecutor executor = new PostgresStatementExecutor();
    private final BasicActions basicActions = new BasicActions();

    public EsMemberOhiEntity getOptionsFromOhiTables(String query)  {
        EsMemberOhiEntity esMemberOhiEntity = new EsMemberOhiEntity();
        ResultSet rs;
        basicActions.wait(5000);
        try {
            rs = executor.executeQuery(query);
            while (rs.next()) {

                /* ---- Set all the values from db ---- */
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    Object columnValue = rs.getObject(i);

                    // Set the field value using reflection
                    try {
                        Field field = EsMemberOhiEntity.class.getDeclaredField(columnName);
                        field.setAccessible(true);
                        if (columnValue != null) {
                            // Perform type conversion based on field type
                            if (field.getType() == String.class) {
                                field.set(esMemberOhiEntity, columnValue.toString());
                            } else if (field.getType() == BigDecimal.class && columnValue instanceof Number) {
                                field.set(esMemberOhiEntity, BigDecimal.valueOf(((Number) columnValue).doubleValue()));
                            } else {
                                // Handle other types as needed
                                field.set(esMemberOhiEntity, columnValue);
                            }
                        } else {
                            // Handle the case where columnValue is null
                            // For example, you could set a default value or leave the field uninitialized
                            // field.set(esMemberOhiEntity, defaultValue);
                        }
                    } catch (NoSuchFieldException e) {
                        // Handle the case where the ResultSet column does not match a field in the object
                        // You can ignore it or handle it according to your requirements
                    }
                }
//                dbDataList.add(esMemberOhiEntity);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return esMemberOhiEntity;
    }
    
    public EsMemberHraEntity getOptionsFromHraTables(String query)  {
        EsMemberHraEntity esMemberHraEntity = new EsMemberHraEntity();
        ResultSet rs;
        basicActions.wait(5000);
        try {
            rs = executor.executeQuery(query);
            while (rs.next()) {

                /* ---- Set all the values from db ---- */
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    Object columnValue = rs.getObject(i);

                    // Set the field value using reflection
                    try {
                        Field field = EsMemberHraEntity.class.getDeclaredField(columnName);
                        field.setAccessible(true);
                        if (columnValue != null) {
                            // Perform type conversion based on field type
                            if (field.getType() == String.class) {
                                field.set(esMemberHraEntity, columnValue.toString());
                            } else if (field.getType() == BigDecimal.class && columnValue instanceof Number) {
                                field.set(esMemberHraEntity, BigDecimal.valueOf(((Number) columnValue).doubleValue()));
                            } else {
                                // Handle other types as needed
                                field.set(esMemberHraEntity, columnValue);
                            }
                        } else {
                            // Handle the case where columnValue is null
                            // For example, you could set a default value or leave the field uninitialized
                            // field.set(esMemberHraEntity, defaultValue);
                        }
                    } catch (NoSuchFieldException e) {
                        // Handle the case where the ResultSet column does not match a field in the object
                        // You can ignore it or handle it according to your requirements
                    }
                }
//                dbDataList.add(esMemberHraEntity);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return esMemberHraEntity;
    }
    
    public EsMemberHraAhEntity getOptionsFromHraAhTables(String query)  {
        EsMemberHraAhEntity esMemberHraAhEntity = new EsMemberHraAhEntity();
        ResultSet rs;
        basicActions.wait(5000);
        try {
            rs = executor.executeQuery(query);
            while (rs.next()) {

                /* ---- Set all the values from db ---- */
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    Object columnValue = rs.getObject(i);

                    // Set the field value using reflection
                    try {
                        Field field = EsMemberHraAhEntity.class.getDeclaredField(columnName);
                        field.setAccessible(true);
                        if (columnValue != null) {
                            // Perform type conversion based on field type
                            if (field.getType() == String.class) {
                                field.set(esMemberHraAhEntity, columnValue.toString());
                            } else if (field.getType() == BigDecimal.class && columnValue instanceof Number) {
                                field.set(esMemberHraAhEntity, BigDecimal.valueOf(((Number) columnValue).doubleValue()));
                            } else {
                                // Handle other types as needed
                                field.set(esMemberHraAhEntity, columnValue);
                            }
                        } else {
                            // Handle the case where columnValue is null
                            // For example, you could set a default value or leave the field uninitialized
                            // field.set(esMemberHraAhEntity, defaultValue);
                        }
                    } catch (NoSuchFieldException e) {
                        // Handle the case where the ResultSet column does not match a field in the object
                        // You can ignore it or handle it according to your requirements
                    }
                }
//                dbDataList.add(esMemberHraAhEntity);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return esMemberHraAhEntity;
    }
    
}
