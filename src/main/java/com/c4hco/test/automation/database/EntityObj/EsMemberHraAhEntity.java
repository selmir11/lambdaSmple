package com.c4hco.test.automation.database.EntityObj;

import lombok.Data;

@Data
public class EsMemberHraAhEntity {
    String plan_year;
    String emplr_hra_ctb;
    String hra_type;
    String emplr_ctb_optout_ind;
    String hra_not_affordable_ind;
}
