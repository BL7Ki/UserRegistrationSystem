package com.example;

import com.example.services.CreateUserService;
//import com.example.services.DeleteUserService;
import com.example.services.ReadUserService;
import com.example.services.UpdateUserService;

public class Main {
    public static void main(String[] args) {

        // Instanciando as classes
        CreateUserService createService = new CreateUserService();
        ReadUserService readService = new ReadUserService();
        UpdateUserService updateService = new UpdateUserService();
        //DeleteUserService deleteService = new DeleteUserService();

        // Exemplo de operações
        createService.create("Suarez", "Luisito@example.com", "Luisito123");
        readService.read();
        updateService.update(3, "Luis Suarez");
        //deleteService.delete(1);
    }
}
