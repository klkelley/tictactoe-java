package me.karakelley.tictactoe;

public class ValidatorFactoryImplementation implements ValidatorFactory {
  private Validator validator;

  public Validator make(String name) {
    if (name.equals("NumberValidator")) {
      validator = new NumberValidator();
    } else if (name.equals("EnterValidator")) {
      validator = new EnterValidator();
    }
    return validator;
  }

}
