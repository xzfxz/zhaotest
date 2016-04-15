package com.zhao.dotest.test;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/7.
 */
public class UserInfo implements Serializable {
    private String name;
    private int id;
    private double score;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (id != userInfo.id) return false;
        if (Double.compare(userInfo.score, score) != 0) return false;
        return name != null ? name.equals(userInfo.name) : userInfo.name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public UserInfo(String name, int id, double score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public UserInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
