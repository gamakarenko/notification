package com.ramz.soap.Model;

public class User {
    private String chatId;
    private String fullName;
    private String group;

    public User(String chatId, String fullName, String group) {
        this.chatId = chatId;
        this.fullName = fullName;
        this.group = group;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "User{" +
                "chatId='" + chatId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
