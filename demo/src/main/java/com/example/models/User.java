package com.example.models;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {} // construtor vazio

    public boolean isIdValid() {
        return id > 0;
    }
    
    public boolean isNameValid() {
        return name != null && name.trim().length() >= 3 && name.trim().length() <= 50;
    } // trim() remove espacos extras no inicio e no fim
        
    public boolean isEmailValid() {
        return email != null && email.contains("@");
    }

    public boolean isPasswordValid() {
        return password != null && password.length() >= 8;
    }    
    
    @Override
    public String toString() { // para facilitar no debug
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' + 
                '}'; // tirar password para nao expor senha
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
