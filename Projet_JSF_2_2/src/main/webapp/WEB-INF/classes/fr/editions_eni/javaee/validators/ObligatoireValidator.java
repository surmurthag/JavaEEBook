package fr.editions_eni.javaee.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="ObligatoireValidator")
public class ObligatoireValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) 
			throws ValidatorException 
	{
		
		if(value==null || value.toString().trim().isEmpty())
		{
//			throw new ValidatorException( 
//						new FacesMessage(FacesMessage.SEVERITY_ERROR, 
//										 "La valeur est obligatoire",
//										 "détail"));
			throw new ValidatorException( 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, 
									 context.getApplication().getResourceBundle(context, "msgs").getString("zone.erreur.obligatoire"),
									 "détail"));
		}
	}
}
