package com.example.ifuaif.zavdannya_1;

/**
 * Created by IFuaIF on 27.05.2016.
 */
public class Item {

    private String tasks; // Заголовок
    private String comments; // Підзаголdаок

    Item(String t, String c) {

        this.tasks = t;
        this.comments = c;
    }//Конструктор створюэ новий елемент відповідно з переданими параметрами

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }
}