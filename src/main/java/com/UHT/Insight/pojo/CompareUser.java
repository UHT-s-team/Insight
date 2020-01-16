package com.UHT.Insight.pojo;

public class CompareUser {
    private Integer U_ID;//gameToUser表的用户Id
    private Integer idSum;//uid对应的评论数量

    public Integer getU_ID() {
        return U_ID;
    }

    public void setU_ID(Integer u_ID) {
        U_ID = u_ID;
    }

    public Integer getIdSum() {
        return idSum;
    }

    public void setIdSum(Integer idSum) {
        this.idSum = idSum;
    }
}
