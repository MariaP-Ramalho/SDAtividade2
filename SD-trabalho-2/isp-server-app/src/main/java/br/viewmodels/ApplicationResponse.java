package br.ucsal.ispserverapp.controller;

import java.util.List;

import org.apache.logging.log4j.CloseableThreadContext.Instance;

public class ApplicationResponse {
    private List<Application> application;

    public List<Application> getApplication() {
        return application;
    }

    public void setApplication(List<Application> application) {
        this.application = application;
    }
}

public class Application {
    private String name;
    private List    <Instance> instance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Instance> getInstance() {
        return instance;
    }

    public void setInstance(List<Instance> instance) {
        this.instance = instance;
    }
}




