/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
 
@FacesValidator("util.validators.PasswordValidator")
public class PasswordValidator implements Validator{
    
        /*
        The password's first character must be a letter, it must contain at 
        least 8 characters and no more than 16 characters and no characters other 
        than letters, numbers and the underscore may be used.
        */
	private static final String EMAIL_PATTERN = "^[a-zA-Z]\\w{7,15}$";
 
	private Pattern pattern;
	private Matcher matcher;
 
	public PasswordValidator(){
		  pattern = Pattern.compile(EMAIL_PATTERN);
	}
 
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
 
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
 
			FacesMessage msg = 
				new FacesMessage("Password validation failed.", 
						"Invalid password format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
 
		}
 
	}
}