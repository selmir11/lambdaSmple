package com.c4hco.test.automation.database.EntityObj;
import lombok.Data;

@Data
public class EsManualVerifRequestEntity {
    String manual_verif_request_id;
    String account_id;
    String member_id;
    String manual_verification_type;
    String created_by;
    String manual_verif_status;
}
