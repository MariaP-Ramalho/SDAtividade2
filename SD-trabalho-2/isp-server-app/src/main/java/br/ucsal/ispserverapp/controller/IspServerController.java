package br.ucsal.ispserverapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IspServerController {

    @GetMapping("/health")
    public String healthy() {
        return "ISP server rodando";
    }

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/validacao")
    public String validacao() {

        // PUXAR AQUI AS APLICAÇÕES DO DNS-SERVER E TRANSFORMAR NUM LIST

        // Get applications from service discovery
        List<Application> applications = new ArrayList<Application>();

        // Find the VALIDACAO-APP instance
        String instanceUrl = findInstanceUrl(applications, "VALIDACAO-APP");

        // Forward request to the instance
        return "Forwarding request to: " + instanceUrl;
    }

    @GetMapping("/perfil")
    public String perfil() {
        // PUXAR AQUI AS APLICAÇÕES DO DNS-SERVER E TRANSFORMAR NUM LIST

        // Get applications from service discovery
        List<Application> applications = new ArrayList<Application>();

        // Find the PERFIL-APP instance
        String instanceUrl = findInstanceUrl(applications, "PERFIL-APP");

        // Forward request to the instance
        return "Forwarding request to: " + instanceUrl;
    }

    private String findInstanceUrl(List<Application> applications, String appName) {
        if (applications != null) {
            for (Application app : applications) {
                if (app.getName().equals(appName)) {
                    //AJUSTAR AQUI PRA PEGAR CERTO A INSTÂNCIA
                    return app.getInstance().get(0).toString(); 
                }
            }
        }
        return null;
    }



}
