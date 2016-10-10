package fr.adaming.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validatorMail")
public class MonValidator implements Validator {

	@Override
	public void validate(FacesContext contexr, UIComponent component,
			Object value) throws ValidatorException {

		String saisie = (String) value;
		try {
			if (!saisie.contains("@")) {
				
				throw new Exception(
						"Le mail doit contenir un @, vérifiez votre saisie");
			}
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
}
