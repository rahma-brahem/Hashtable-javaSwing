package tn.usousse.eniso.stage.presentation.controller;

import tn.usousse.eniso.stage.Model.Table;
import tn.usousse.eniso.stage.service.Service;





public class HashtableController   {
    private Service service;

    public HashtableController(Service service) {
        this.service = service;
    }

    public Service getService() {
        return service;
    }

    public Table getModel() {
        return getService().getTable();
    }
}
