package com.c4hco.test.automation.database.EntityObj;

import lombok.Data;

@Data
public class IncomeDataEntity {
    String member_id;
    String employer_ah_id;
    String employer_id;
    String employer_name;
    String type;
    String kind;
    String amount;
    String period;
    String annual_amount;
    String future_income_changes_ind;
    String self_employed_ind;
    String season_comm_tip_ind;
    String season_comm_tip_samelower_ind;
    String created_by;
    String monthly_amount;
}
