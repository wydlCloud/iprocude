package com.wy.other.designpattern.builder;

/**
 * Created on 2019/7/27.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2018
 * Company:
 *
 * @author wy
 */
public class BuilderTest {

    private String name;
    private Integer age;
    private String grade;
    private Integer fat;
    private Integer sodium;

    public BuilderTest(Builder builder) {
        name = builder.name;
        age = builder.age;
        grade = builder.grade;
        fat = builder.fat;
        sodium = builder.sodium;
    }

    public static class Builder {
        private String name;
        private Integer age;
        private String grade;
        private Integer fat;
        private Integer sodium;

        /*  public Builder(String name, Integer age, String grade, Integer fat, Integer sodium) {
              this.name = name;
              this.age = age;
              this.fat = fat;
              this.sodium = sodium;
              this.grade = grade;
          }
  */
        public Builder nama(String val) {
            name = val;
            return this;
        }

        public Builder age(Integer val) {
            age = val;
            return this;
        }

        public Builder grade(String val) {
            grade = val;
            return this;
        }

        public Builder fat(Integer val) {
            fat = val;
            return this;
        }

        public Builder sodium(Integer val) {
            sodium = val;
            return this;
        }

        public BuilderTest build() {
            return new BuilderTest(this);
        }
    }

    public static void main(String[] args) {
        BuilderTest builderTest = new BuilderTest.Builder().age(21).fat(21).grade("一年级二班").sodium(1).nama("张三").build();



    }
}