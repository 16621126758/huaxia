package cn.com.chnsys.pojo;

/**
 * @Class: EmployeeNew
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-29 10:54
 */
public class EmployeeNew extends Employee {
    private Status status;

    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }

    public EmployeeNew(int id, String name, int age, double salary,
            Status status) {
        super(id, name, age, salary);
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public EmployeeNew(){};

}
