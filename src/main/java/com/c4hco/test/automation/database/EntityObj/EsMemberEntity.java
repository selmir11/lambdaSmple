package com.c4hco.test.automation.database.EntityObj;

import lombok.Data;

@Data
public class EsMemberEntity {
    String first_name;
    String middle_name;
    String last_name;
    String name_suffix;
    String gender;
    String birth_date;
    String applying_for_coverage_ind;
    String job_income_optout_ind;
}
