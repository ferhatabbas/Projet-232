package view.command;

import controller.Game;

import java.util.Scanner;

public abstract class Command {

    protected Game _game;
    protected Scanner _lecture;

    public Command(Game game, Scanner lecture)
    {
        set_game(game);
        set_lecture(lecture);
    }

    public abstract void execute();

    public Game get_game() {
        return _game;
    }

    public void set_game(Game _game) {
        this._game = _game;
    }

    public Scanner get_lecture() {
        return _lecture;
    }

    public void set_lecture(Scanner _lecture) {
        this._lecture = _lecture;
    }
}
