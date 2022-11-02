package com.jk1123.mock.address.chinese;


import java.io.Serializable;
import java.util.List;

/**
 * @author huyoufu <https://github.com/huyoufu>
 * @TIME 2022/11/3 0:28
 * @description
 */
public class Region implements Serializable {
    private String code;
    private String name;
    private int level;
    private int type;
    private List<Region> children;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Region> getChildren() {
        return children;
    }

    public void setChildren(List<Region> children) {
        this.children = children;
    }
}
