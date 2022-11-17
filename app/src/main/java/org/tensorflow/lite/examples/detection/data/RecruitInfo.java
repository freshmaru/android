package org.tensorflow.lite.examples.detection.data;

import java.util.Date;

public class RecruitInfo {
    private String image;           //회사 이미지
    private String con_nm;          //회사명
    private String sj;              //모집 제목
    private String qlfc_rqrmnt;     //자격요건
    private String rcpt_ddln_day;   //접수마감일
    private String duty_cn;         //직무내용
    private String emplymt_form;    //고용형태
    private String rcrtmt_noppl;    //모집인원
    private String wadge_cdn;       //임금조건
    private String ccr_cdn;         //경력조건
    private String slctn_mthd;      //전형방법
    private String rcpt_mthd;       //접수방법
    private String sbmsn_doc_prmtrl;    //제출서류
    private String plc_work;        //근무예정지
    private String work_hr_form;    //근무시간/형태
    private String telno;           //전화번호
    private String addr;            //본사 주소
    private Integer no;             //id

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public RecruitInfo(){}

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCon_nm() {
        return con_nm;
    }

    public void setCon_nm(String con_nm) {
        this.con_nm = con_nm;
    }

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }

    public String getQlfc_rqrmnt() {
        return qlfc_rqrmnt;
    }

    public void setQlfc_rqrmnt(String qlfc_rqrmnt) {
        this.qlfc_rqrmnt = qlfc_rqrmnt;
    }

    public String getRcpt_ddln_day() {
        return rcpt_ddln_day;
    }

    public void setRcpt_ddln_day(String  rcpt_ddln_day) {
        this.rcpt_ddln_day = rcpt_ddln_day;
    }

    public String getDuty_cn() {
        return duty_cn;
    }

    public void setDuty_cn(String duty_cn) {
        this.duty_cn = duty_cn;
    }

    public String getEmplymt_form() {
        return emplymt_form;
    }

    public void setEmplymt_form(String emplymt_form) {
        this.emplymt_form = emplymt_form;
    }

    public String getRcrtmt_noppl() {
        return rcrtmt_noppl;
    }

    public void setRcrtmt_noppl(String rcrtmt_noppl) {
        this.rcrtmt_noppl = rcrtmt_noppl;
    }

    public String getWadge_cdn() {
        return wadge_cdn;
    }

    public void setWadge_cdn(String wadge_cdn) {
        this.wadge_cdn = wadge_cdn;
    }

    public String getCcr_cdn() {
        return ccr_cdn;
    }

    public void setCcr_cdn(String ccr_cdn) {
        this.ccr_cdn = ccr_cdn;
    }

    public String getSlctn_mthd() {
        return slctn_mthd;
    }

    public void setSlctn_mthd(String slctn_mthd) {
        this.slctn_mthd = slctn_mthd;
    }

    public String getRcpt_mthd() {
        return rcpt_mthd;
    }

    public void setRcpt_mthd(String rcpt_mthd) {
        this.rcpt_mthd = rcpt_mthd;
    }

    public String getSbmsn_doc_prmtrl() {
        return sbmsn_doc_prmtrl;
    }

    public void setSbmsn_doc_prmtrl(String sbmsn_doc_prmtrl) {
        this.sbmsn_doc_prmtrl = sbmsn_doc_prmtrl;
    }

    public String getPlc_work() {
        return plc_work;
    }

    public void setPlc_work(String plc_work) {
        this.plc_work = plc_work;
    }

    public String getWork_hr_form() {
        return work_hr_form;
    }

    public void setWork_hr_form(String work_hr_form) {
        this.work_hr_form = work_hr_form;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
