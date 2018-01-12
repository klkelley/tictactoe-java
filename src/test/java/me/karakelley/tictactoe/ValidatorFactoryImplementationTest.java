package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorFactoryImplementationTest {
  private ValidatorFactory validator;

  @BeforeEach
  public void setUp() {
    validator = new ValidatorFactoryImplementation();
  }

  @Test
  public void testMakingNumberValidator() {
    assertTrue(validator.make("NumberValidator") instanceof NumberValidator);
  }

  @Test
  public void testMakingEnterValidator() {
    assertTrue(validator.make("EnterValidator") instanceof EnterValidator);
  }

}