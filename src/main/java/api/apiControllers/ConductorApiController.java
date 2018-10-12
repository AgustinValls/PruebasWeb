package api.apiControllers;

import api.businessController.ConductorBusinessController;

import api.dtos.ConductorDto;

import api.exceptions.ArgumentNotValidException;

public class ConductorApiController {

    public static final String CONDUCTORES = "/conductores";

    private ConductorBusinessController conductorBusinessController = new ConductorBusinessController();

    public String create(ConductorDto conductorDto) {
        this.validate(conductorDto, "conductorDto");
        this.validate(conductorDto.getNombre(), "ConductorDto nombre");
        return this.conductorBusinessController.create(conductorDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }
}