package com.c4hco.test.automation.database.dbHandler;

import com.c4hco.test.automation.database.EntityObj.EsMemberEntity;
import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;

public class EsMemberDbHandler {

        private PostgresStatementExecutor executor = new PostgresStatementExecutor();

        public EsMemberEntity getEsMemberDbHandler(String query) {
            ResultSet rs;
            EsMemberEntity esMemberEntity = new EsMemberEntity();
            try {
                rs = executor.executeQuery(query);
                while (rs.next()) {
                    /* ---- Set all the values from db ---- */
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        String columnName = rs.getMetaData().getColumnName(i);
                        Object columnValue = rs.getObject(i);

                        // Set the field value using reflection
                        try {
                            Field field = EsMemberEntity.class.getDeclaredField(columnName);
                            field.setAccessible(true);
                            if (columnValue != null) {
                                // Perform type conversion based on field type
                                if (field.getType() == String.class) {
                                    field.set(esMemberEntity, columnValue.toString());
                                } else if (field.getType() == BigDecimal.class && columnValue instanceof Number) {
                                    field.set(esMemberEntity, BigDecimal.valueOf(((Number) columnValue).doubleValue()));
                                } else {
                                    // Handle other types as needed
                                    field.set(esMemberEntity, columnValue);
                                }
                            } else {
                                // Handle the case where columnValue is null
                                // For example, you could set a default value or leave the field uninitialized
                                // field.set(esMemberHouseholdEntity, defaultValue);
                            }
                        } catch (NoSuchFieldException e) {
                            // Handle the case where the ResultSet column does not match a field in the object
                            // You can ignore it or handle it according to your requirements
                        }
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return esMemberEntity;
        }
    }
