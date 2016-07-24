package com.depeng.design_pattern.builder;

public class DataHolder {
    private final String data;
    private final int num;

    public DataHolder(String data, int num) {
        this.data = data;
        this.num = num;
    }


    public String getData() {
        return data;
    }

    public int getNum() {
        return num;
    }

    public static class Builder{
        private String data;
        private int num;

        public Builder withData(String data) {
            this.data = data;
            return this;
        }

        public Builder withNum(int num) {
            this.num    = num;
            return this;
        }

        public DataHolder build() {
            return new DataHolder(data, num);
        }
        
    }
}
