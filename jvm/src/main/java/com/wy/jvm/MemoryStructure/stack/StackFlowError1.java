package com.wy.jvm.MemoryStructure.stack;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

/**
 * @author wy
 * @company
 * @Classname StackFlowError1
 * @Description
 * Caused by: java.lang.StackOverflowError
 */

public class StackFlowError1 {

    public static void main(String[] args) throws JsonProcessingException {
        Dept dept=new Dept();
        dept.setName("技术部");
        Emp emp=new Emp();
        emp.setName("吕小雅");
        emp.setDept(dept);
        Emp emp1=new Emp();
        emp1.setName("李四");
        emp1.setDept(dept);
        dept.setEmps(Arrays.asList(emp,emp1));
        ObjectMapper mapper=new ObjectMapper();
        // {name:"技术部"，emps:{name:"吕小雅",dept:{name:"",emps:{"name:"",dept:{}"}}}}
        String s = mapper.writeValueAsString(dept);
        System.out.println(s);

    }
    static class Emp{
        private String name;
       // 可以解决循环依赖的问题，在某个过程中进行忽略可以解决
       // @JsonIgnore
        private Dept dept;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Dept getDept() {
            return dept;
        }

        public void setDept(Dept dept) {
            this.dept = dept;
        }
    }
    static class Dept{
        private String name;
        private List<Emp> emps;

        public List<Emp> getEmps() {
            return emps;
        }

        public void setEmps(List<Emp> emps) {
            this.emps = emps;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
