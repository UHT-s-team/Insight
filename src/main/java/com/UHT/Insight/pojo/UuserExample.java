package com.UHT.Insight.pojo;

import java.util.ArrayList;
import java.util.List;

public class UuserExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    public UuserExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUuIdIsNull() {
            addCriterion("UU_ID is null");
            return (Criteria) this;
        }

        public Criteria andUuIdIsNotNull() {
            addCriterion("UU_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUuIdEqualTo(Integer value) {
            addCriterion("UU_ID =", value, "uuId");
            return (Criteria) this;
        }

        public Criteria andUuIdNotEqualTo(Integer value) {
            addCriterion("UU_ID <>", value, "uuId");
            return (Criteria) this;
        }

        public Criteria andUuIdGreaterThan(Integer value) {
            addCriterion("UU_ID >", value, "uuId");
            return (Criteria) this;
        }

        public Criteria andUuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("UU_ID >=", value, "uuId");
            return (Criteria) this;
        }

        public Criteria andUuIdLessThan(Integer value) {
            addCriterion("UU_ID <", value, "uuId");
            return (Criteria) this;
        }

        public Criteria andUuIdLessThanOrEqualTo(Integer value) {
            addCriterion("UU_ID <=", value, "uuId");
            return (Criteria) this;
        }

        public Criteria andUuIdIn(List<Integer> values) {
            addCriterion("UU_ID in", values, "uuId");
            return (Criteria) this;
        }

        public Criteria andUuIdNotIn(List<Integer> values) {
            addCriterion("UU_ID not in", values, "uuId");
            return (Criteria) this;
        }

        public Criteria andUuIdBetween(Integer value1, Integer value2) {
            addCriterion("UU_ID between", value1, value2, "uuId");
            return (Criteria) this;
        }

        public Criteria andUuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("UU_ID not between", value1, value2, "uuId");
            return (Criteria) this;
        }

        public Criteria andUuNameIsNull() {
            addCriterion("UU_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUuNameIsNotNull() {
            addCriterion("UU_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUuNameEqualTo(String value) {
            addCriterion("UU_NAME =", value, "uuName");
            return (Criteria) this;
        }

        public Criteria andUuNameNotEqualTo(String value) {
            addCriterion("UU_NAME <>", value, "uuName");
            return (Criteria) this;
        }

        public Criteria andUuNameGreaterThan(String value) {
            addCriterion("UU_NAME >", value, "uuName");
            return (Criteria) this;
        }

        public Criteria andUuNameGreaterThanOrEqualTo(String value) {
            addCriterion("UU_NAME >=", value, "uuName");
            return (Criteria) this;
        }

        public Criteria andUuNameLessThan(String value) {
            addCriterion("UU_NAME <", value, "uuName");
            return (Criteria) this;
        }

        public Criteria andUuNameLessThanOrEqualTo(String value) {
            addCriterion("UU_NAME <=", value, "uuName");
            return (Criteria) this;
        }

        public Criteria andUuNameLike(String value) {
            addCriterion("UU_NAME like", value, "uuName");
            return (Criteria) this;
        }

        public Criteria andUuNameNotLike(String value) {
            addCriterion("UU_NAME not like", value, "uuName");
            return (Criteria) this;
        }

        public Criteria andUuNameIn(List<String> values) {
            addCriterion("UU_NAME in", values, "uuName");
            return (Criteria) this;
        }

        public Criteria andUuNameNotIn(List<String> values) {
            addCriterion("UU_NAME not in", values, "uuName");
            return (Criteria) this;
        }

        public Criteria andUuNameBetween(String value1, String value2) {
            addCriterion("UU_NAME between", value1, value2, "uuName");
            return (Criteria) this;
        }

        public Criteria andUuNameNotBetween(String value1, String value2) {
            addCriterion("UU_NAME not between", value1, value2, "uuName");
            return (Criteria) this;
        }

        public Criteria andUuPhoneIsNull() {
            addCriterion("UU_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andUuPhoneIsNotNull() {
            addCriterion("UU_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andUuPhoneEqualTo(String value) {
            addCriterion("UU_PHONE =", value, "uuPhone");
            return (Criteria) this;
        }

        public Criteria andUuPhoneNotEqualTo(String value) {
            addCriterion("UU_PHONE <>", value, "uuPhone");
            return (Criteria) this;
        }

        public Criteria andUuPhoneGreaterThan(String value) {
            addCriterion("UU_PHONE >", value, "uuPhone");
            return (Criteria) this;
        }

        public Criteria andUuPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("UU_PHONE >=", value, "uuPhone");
            return (Criteria) this;
        }

        public Criteria andUuPhoneLessThan(String value) {
            addCriterion("UU_PHONE <", value, "uuPhone");
            return (Criteria) this;
        }

        public Criteria andUuPhoneLessThanOrEqualTo(String value) {
            addCriterion("UU_PHONE <=", value, "uuPhone");
            return (Criteria) this;
        }

        public Criteria andUuPhoneLike(String value) {
            addCriterion("UU_PHONE like", value, "uuPhone");
            return (Criteria) this;
        }

        public Criteria andUuPhoneNotLike(String value) {
            addCriterion("UU_PHONE not like", value, "uuPhone");
            return (Criteria) this;
        }

        public Criteria andUuPhoneIn(List<String> values) {
            addCriterion("UU_PHONE in", values, "uuPhone");
            return (Criteria) this;
        }

        public Criteria andUuPhoneNotIn(List<String> values) {
            addCriterion("UU_PHONE not in", values, "uuPhone");
            return (Criteria) this;
        }

        public Criteria andUuPhoneBetween(String value1, String value2) {
            addCriterion("UU_PHONE between", value1, value2, "uuPhone");
            return (Criteria) this;
        }

        public Criteria andUuPhoneNotBetween(String value1, String value2) {
            addCriterion("UU_PHONE not between", value1, value2, "uuPhone");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Boolean value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Boolean value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Boolean value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Boolean value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Boolean value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Boolean value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Boolean> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Boolean> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Boolean value1, Boolean value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Boolean value1, Boolean value2) {
            addCriterion("SEX not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("COMPANY is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("COMPANY is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("COMPANY =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("COMPANY <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("COMPANY >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("COMPANY <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("COMPANY <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("COMPANY like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("COMPANY not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("COMPANY in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("COMPANY not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("COMPANY between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("COMPANY not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andPCommentIsNull() {
            addCriterion("P_COMMENT is null");
            return (Criteria) this;
        }

        public Criteria andPCommentIsNotNull() {
            addCriterion("P_COMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andPCommentEqualTo(String value) {
            addCriterion("P_COMMENT =", value, "pComment");
            return (Criteria) this;
        }

        public Criteria andPCommentNotEqualTo(String value) {
            addCriterion("P_COMMENT <>", value, "pComment");
            return (Criteria) this;
        }

        public Criteria andPCommentGreaterThan(String value) {
            addCriterion("P_COMMENT >", value, "pComment");
            return (Criteria) this;
        }

        public Criteria andPCommentGreaterThanOrEqualTo(String value) {
            addCriterion("P_COMMENT >=", value, "pComment");
            return (Criteria) this;
        }

        public Criteria andPCommentLessThan(String value) {
            addCriterion("P_COMMENT <", value, "pComment");
            return (Criteria) this;
        }

        public Criteria andPCommentLessThanOrEqualTo(String value) {
            addCriterion("P_COMMENT <=", value, "pComment");
            return (Criteria) this;
        }

        public Criteria andPCommentLike(String value) {
            addCriterion("P_COMMENT like", value, "pComment");
            return (Criteria) this;
        }

        public Criteria andPCommentNotLike(String value) {
            addCriterion("P_COMMENT not like", value, "pComment");
            return (Criteria) this;
        }

        public Criteria andPCommentIn(List<String> values) {
            addCriterion("P_COMMENT in", values, "pComment");
            return (Criteria) this;
        }

        public Criteria andPCommentNotIn(List<String> values) {
            addCriterion("P_COMMENT not in", values, "pComment");
            return (Criteria) this;
        }

        public Criteria andPCommentBetween(String value1, String value2) {
            addCriterion("P_COMMENT between", value1, value2, "pComment");
            return (Criteria) this;
        }

        public Criteria andPCommentNotBetween(String value1, String value2) {
            addCriterion("P_COMMENT not between", value1, value2, "pComment");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table uuser
     *
     * @mbg.generated do_not_delete_during_merge Sat Jan 11 18:41:37 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table uuser
     *
     * @mbg.generated Sat Jan 11 18:41:37 CST 2020
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}