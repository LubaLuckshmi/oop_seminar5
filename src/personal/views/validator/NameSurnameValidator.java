package personal.views.validator;

import personal.model.User;

public class NameSurnameValidator {
    String userInput;
    public NameSurnameValidator(String userInput) {
        this.userInput = userInput;
    }

    public void validate() throws Exception {
        if (!userInput.matches("^\\S+$")){
            throw new Exception("Валидация не прошла");
        }
    }

}
