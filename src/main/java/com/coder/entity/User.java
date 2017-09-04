package com.coder.entity;

@SuppressWarnings("serial")
public class User implements java.io.Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * age
     */
    private Integer age;

    /**
     * password
     */
    private String password;


    /**
     * 获取 id 的值
     *
     * @return Integer
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id 的值
     *
     * @param Integer id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 name 的值
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name 的值
     *
     * @param String name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 age 的值
     *
     * @return Integer
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置age 的值
     *
     * @param Integer age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取 password 的值
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置password 的值
     *
     * @param String password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName());
        sb.append("; id=" + (id == null ? "null" : id.toString()));
        sb.append("; name=" + (name == null ? "null" : name.toString()));
        sb.append("; age=" + (age == null ? "null" : age.toString()));
        sb.append("; password=" + (password == null ? "null" : password.toString()));

        return sb.toString();
    }
}