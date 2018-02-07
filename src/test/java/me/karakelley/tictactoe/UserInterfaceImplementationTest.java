package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UserInterfaceImplementationTest {

 private IO io = mock(IO.class);
 private BoardPresenter boardPresenter = mock(BoardPresenter.class);
 private UserInterfaceFactory userInterfaceFactory;
 private UserInterface userInterface = new HumanUserInterface(io, boardPresenter, "Player one wins!\n", "Player two wins!\n");

 @BeforeEach
 public void setUp() {
  userInterfaceFactory = new UserInterfaceImplementation(io, boardPresenter);
 }

 @Test
 public void testReturnsDefaultUI() {
  assertEquals(userInterface, userInterfaceFactory.makeGameInterface("1", userInterface));
 }

 @Test
 public void returns_same_interface_with_player_one_wins_message() {
   UserInterface newUserInterface =  userInterfaceFactory.makeGameInterface("1", userInterface);
   assertEquals("Player one wins!\n", newUserInterface.winningStatement(true));
 }

 @Test
 public void returns_same_interface_with_player_two_wins_message() {
  UserInterface newUserInterface =  userInterfaceFactory.makeGameInterface("1", userInterface);
  assertEquals("Player two wins!\n", newUserInterface.winningStatement(false));
 }

 @Test
 public void returns_New_User_Interface_With_You_Win_Message() {
  UserInterface newUserInterface = userInterfaceFactory.makeGameInterface("2", userInterface);
  assertEquals("You win!\n", newUserInterface.winningStatement(true));
 }

 @Test
 public void returns_new_interface_with_you_lose_message() {
  UserInterface newUserInterface = userInterfaceFactory.makeGameInterface("2", userInterface);
  assertEquals("You lose!\n", newUserInterface.winningStatement(false));
 }

 @Test
 public void returns_new_interface_with_you_never_had_a_chance_message() {
  UserInterface newUserInterface = userInterfaceFactory.makeGameInterface("4", userInterface);
  assertEquals("You never had a chance!\n", newUserInterface.winningStatement(false));
 }

 @Test
 public void returns_new_interface_with_you_lose_message_for_hard_computer() {
  UserInterface newUserInterface = userInterfaceFactory.makeGameInterface("3", userInterface);
  assertEquals("You lose!\n", newUserInterface.winningStatement(false));
 }

 @Test
 public void returns_new_interface_with_you_win_message_for_hard_computer() {
  UserInterface newUserInterface = userInterfaceFactory.makeGameInterface("3", userInterface);
  assertEquals("You win!\n", newUserInterface.winningStatement(true));
 }


}