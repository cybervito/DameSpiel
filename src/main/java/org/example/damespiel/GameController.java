package org.example.damespiel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    // Im GameController
    @GetMapping("/game")
    public String game(Model model) {
        GameBoard board = new GameBoard();
        model.addAttribute("board", board.getBoardForUI()); // Aktualisiert, um die neue Methode zu verwenden
        return "game";
    }

}
