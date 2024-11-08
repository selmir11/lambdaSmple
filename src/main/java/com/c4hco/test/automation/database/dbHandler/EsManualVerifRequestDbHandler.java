package com.c4hco.test.automation.database.dbHandler;

import com.c4hco.test.automation.database.EntityObj.EsManualVerifRequestEntity;
import com.c4hco.test.automation.database.EntityObj.EsSsaVerificationReqEntity;
import com.c4hco.test.automation.database.Utils.PostgresStatementExecutor;
import com.c4hco.test.automation.utils.BasicActions;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;

public class EsManualVerifRequestDbHandler {
    private PostgresStatementExecutor executor = new PostgresStatementExecutor();
    private final BasicActions basicActions = new BasicActions();

    public EsManualVerifRequestEntity getOptionsFromMVRTables(String query)  {
        EsManualVerifRequestEntity esMVREntity = new EsManualVerifRequestEntity();
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
                        Field field = EsManualVerifRequestEntity.class.getDeclaredField(columnName);
                        field.setAccessible(true);
                        if (columnValue != null) {
                            // Perform type conversion based on field type
                            if (field.getType() == String.class) {
                                field.set(esMVREntity, columnValue.toString());
                            } else if (field.getType() == BigDecimal.class && columnValue instanceof Number) {
                                field.set(esMVREntity, BigDecimal.valueOf(((Number) columnValue).doubleValue()));
                            } else {
                                // Handle other types as needed
                                field.set(esMVREntity, columnValue);
                            }
                        } else {
                        }
                    } catch (NoSuchFieldException e) {
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return esMVREntity;
    }

    public EsSsaVerificationReqEntity getSsaResponseCode(String query)  {
        System.out.println("Executing SQL Query: " + query);
        EsSsaVerificationReqEntity esSsaVerificationReqEntity = new EsSsaVerificationReqEntity();
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
                        Field field = EsSsaVerificationReqEntity.class.getDeclaredField(columnName);
                        field.setAccessible(true);
                        if (columnValue != null) {
                            // Perform type conversion based on field type
                            if (field.getType() == String.class) {
                                field.set(esSsaVerificationReqEntity, columnValue.toString());
                            } else if (field.getType() == BigDecimal.class && columnValue instanceof Number) {
                                field.set(esSsaVerificationReqEntity, BigDecimal.valueOf(((Number) columnValue).doubleValue()));
                            } else {
                                // Handle other types as needed
                                field.set(esSsaVerificationReqEntity, columnValue);
                            }
                        } else {
                        }
                    } catch (NoSuchFieldException e) {
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return esSsaVerificationReqEntity;
    }
}
