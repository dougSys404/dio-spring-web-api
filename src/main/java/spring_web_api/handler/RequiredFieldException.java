package spring_web_api.handler;

public class RequiredFieldException extends BusinessException{
    public RequiredFieldException(String field) {
        super("The field %s is required!", field);
    }
}
