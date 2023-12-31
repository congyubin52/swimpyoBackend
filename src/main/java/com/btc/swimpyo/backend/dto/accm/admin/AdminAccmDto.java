package com.btc.swimpyo.backend.dto.accm.admin;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminAccmDto {

    private int a_acc_no;
    private String use_yn;
    private String a_acc_name;
    private String a_acc_intro;
    private String a_acc_kind;
    private String a_acc_bn;
    private int a_m_no;
    private String a_acc_address;
    private String a_acc_phone;
//    private String a_acc_image;
    private String a_acc_reg_date;
    private String a_acc_mod_date;

    private String a_m_email;
    private String a_m_name;

    private String a_r_check_in;

    private String a_r_p_state;
    private int a_r_price;

    private  String a_i_image;
    private List<String> a_i_images;

    private int a_i_no;
    private List<Integer> a_i_nos;

    private String a_acc_longitude;
    private String a_acc_latitude;

    private double sa_point_avg;



}
