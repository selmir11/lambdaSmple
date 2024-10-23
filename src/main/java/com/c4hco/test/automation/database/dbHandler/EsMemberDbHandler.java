package com.c4hco.test.automation.database.dbHandler;

import com.c4hco.test.automation.database.EntityObj.EsMemberEntity;
import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;
import com.c4hco.test.automation.utils.BasicActions;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;

public class EsMemberDbHandler {

        private PostgresStatementExecutor executor = new PostgresStatementExecutor();
        private final BasicActions basicActions = new BasicActions();

        public EsMemberEntity getEsMemberDetails(String query) {
            EsMemberEntity esMemberEntity = new EsMemberEntity();
            ResultSet rs;
            basicActions.wait(5000);

            try {
                rs = executor.executeQuery(query);
                while (rs.next()) {

                    // Loop through all columns and set values in EsMemberEntity object
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        String columnName = rs.getMetaData().getColumnName(i);
                        Object columnValue = rs.getObject(i);

                        try {
                            Field field = EsMemberEntity.class.getDeclaredField(columnName);
                            field.setAccessible(true);

                            if (columnValue != null) {
                                if (field.getType() == String.class) {
                                    field.set(esMemberEntity, columnValue.toString());
                                } else if (field.getType() == BigDecimal.class && columnValue instanceof Number) {
                                    field.set(esMemberEntity, BigDecimal.valueOf(((Number) columnValue).doubleValue()));
                                } else {
                                    field.set(esMemberEntity, columnValue);
                                }
                            }

                        } catch (NoSuchFieldException e) {
                            // Handle the case where the column doesn't match any field in EsMemberEntity
                            // You can log this or ignore it
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return esMemberEntity;
        }
    }

