@S2 @framework
Feature: Move the player
    As a player, 
    I want to move my Pacman around on the board;
    So that I can earn all points and win the game.

    @S2.1
    Scenario: The player consumes
        Given the game has started,
        And my Pacman is next to a square containing a pellet;
        When I press an arrow key towards that square;
        Then my Pacman can move to that square,
        And I earn the points for the pellet,
        And the pellet disappears from that square.
