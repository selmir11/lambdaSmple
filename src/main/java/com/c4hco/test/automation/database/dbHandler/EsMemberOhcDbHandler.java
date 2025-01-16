package com.c4hco.test.automation.database.dbHandler;

import com.c4hco.test.automation.database.EntityObj.EsMemberHraAhEntity;
import com.c4hco.test.automation.database.EntityObj.EsMemberHraEntity;
import com.c4hco.test.automation.database.EntityObj.EsMemberOhcEntity;
import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;
import com.c4hco.test.automation.utils.BasicActions;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;

public class EsMemberOhcDbHandler {
    private PostgresStatementExecutor executor = new PostgresStatementExecutor();
    private final BasicActions basicActions = new BasicActions();

    public EsMemberOhcEntity getOptionsFromOhcTables(String query)  {
        EsMemberOhcEntity esMemberOhcEntity = new EsMemberOhcEntity();
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
                        Field field = EsMemberOhcEntity.class.getDeclaredField(columnName);
                        field.setAccessible(true);
                        if (columnValue != null) {
                            // Perform type conversion based on field type
                            if (field.getType() == String.class) {
                                field.set(esMemberOhcEntity, columnValue.toString());
                            } else if (field.getType() == BigDecimal.class && columnValue instanceof Number) {
                                field.set(esMemberOhcEntity, BigDecimal.valueOf(((Number) columnValue).doubleValue()));
                            } else {
                                // Handle other types as needed
                                field.set(esMemberOhcEntity, columnValue);
                            }
                        } else {
                            // Handle the case where columnValue is null
                            // For example, you could set a default value or leave the field uninitialized
                            // field.set(esMemberOhcEntity, defaultValue);
                        }
                    } catch (NoSuchFieldException e) {
                        // Handle the case where the ResultSet column does not match a field in the object
                        // You can ignore it or handle it according to your requirements
                    }
                }
//                dbDataList.add(esMemberOhcEntity);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return esMemberOhcEntity;
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
