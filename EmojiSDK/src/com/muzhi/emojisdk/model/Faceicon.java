package com.muzhi.emojisdk.model;

import java.io.Serializable;

/**
 * 表情javabean
 * @author Jazzy
 */
public class Faceicon implements Serializable {
    private String name; //网络传输中的值
    private String path; //在系统中的绝对路径
    private String fileName; //图片文件名

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
