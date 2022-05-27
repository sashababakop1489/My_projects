package com.babakov.demo.controllers;

import com.babakov.demo.dto.player.PlayerRequestDto;
import com.babakov.demo.dto.player.PlayerResponseDto;
import com.babakov.demo.facade.PlayerFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {

        private final PlayerFacade playerFacade;

        public PlayerController(PlayerFacade playerFacade) {
                this.playerFacade = playerFacade;
        }

        @GetMapping
        public String findAll(Model model) {
                List<PlayerResponseDto> players = playerFacade.findAll();
                model.addAttribute("players", players);
                return "pages/player/players_all";
        }

        @GetMapping("/teams/{id}")
        public String findAll(Model model, @PathVariable Long id) {
                List<PlayerResponseDto> players = playerFacade.findAllByTeamId(id);
                model.addAttribute("players", players);
                return "pages/player/players_all";
        }

        @GetMapping("/new/{teamId}")
        public String redirectToNewPlayerPage(@PathVariable Long teamId, Model model) {
                System.out.println("teamId = " + teamId);
                PlayerRequestDto dto = new PlayerRequestDto();
                dto.setTeamId(teamId);
                model.addAttribute("player", dto);
                model.addAttribute("teamId", teamId);
                return "pages/player/players_new";
        }

        @PostMapping("/new")
        public String createNewPlayer(@ModelAttribute("player") PlayerRequestDto dto) {
                System.out.println("dto = " + dto);
                playerFacade.create(dto);
                return "redirect:/players";
        }

        @GetMapping("/details/{id}")
        public String findById(@PathVariable Long id, Model model) {
                model.addAttribute("player", playerFacade.findById(id));
                return "pages/player/players_details";
        }

        @GetMapping("/delete/{id}")
        public String deleteById(@PathVariable Long id) {
                playerFacade.delete(id);
                return "redirect:/players";
        }
}

