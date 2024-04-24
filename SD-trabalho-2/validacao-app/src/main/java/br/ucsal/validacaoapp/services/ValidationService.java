package br.ucsal.validacaoapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ValidationService implements IValidationService {

    private List<String> userList;

    public ValidationService() {
        this.userList = new ArrayList<>();
        userList.add("everton@pro.ucsal.br");
        userList.add("everton@pro.ucsal.br");
        userList.add("jose@ucsal.edu.br");
        userList.add("carolina@ucsal.edu.br");
        userList.add("maria@ucsal.edu.br");
        userList.add("joao@ucsal.edu.br");
    }

    public String validateUser(String email) {
        if (userList.contains(email)) {
            return String.format("E-mail do usuário %s existe na base de dados.", email);
        } else {
            return String.format("O e-mail do usuário %s não foi encontrado.", email);
        }
    }
}