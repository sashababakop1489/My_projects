package com.babakov.task.controllers;

import com.babakov.task.dto.player.PlayerRequestDto;
import com.babakov.task.dto.player.PlayerResponseDto;
import com.babakov.task.facade.PlayerFacade;
import com.babakov.task.facade.TeamFacade;
import com.babakov.task.models.Team;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {
        private Long newTeamId;

        private final PlayerFacade playerFacade;
        private final TeamFacade teamFacade;

        public PlayerController(PlayerFacade playerFacade, TeamFacade teamFacade) {
                this.playerFacade = playerFacade;
                this.teamFacade = teamFacade;
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
                PlayerRequestDto dto = new PlayerRequestDto();
                dto.setTeamId(teamId);
                model.addAttribute("player", dto);
                model.addAttribute("teamId", teamId);
                return "pages/player/players_new";
        }

        @PostMapping("/new")
        public String createNewPlayer(@ModelAttribute("player") @Valid PlayerRequestDto dto,
                                      BindingResult bindingResult) {
                if (bindingResult.hasErrors())
                        return "pages/players/players_new";
                playerFacade.create(dto);
                return "redirect:/players";
        }

        @GetMapping("/buy/{teamId}")
        public String redirectToBuyPlayerPage(@PathVariable Long teamId, Model model) {
                List<PlayerResponseDto> players = playerFacade.findAll();
                players.removeIf(p -> p.getTeam().getId().equals(teamId));
                newTeamId = teamId;
                model.addAttribute("players", players);
                return "pages/player/players_all_for_buy";
        }

        @GetMapping("/teams/buy/{id}")
        public String buyPlayer(@PathVariable Long id) {
                Long playerPrice = playerFacade.findById(id).getPrice();
                try {
                        teamFacade.changePurse(newTeamId, playerPrice);
                } catch (Exception e){
                        return "redirect:/players";
                }

                Team oldTeam = playerFacade.findById(id).getTeam();
                oldTeam.setPurse(oldTeam.getPurse() + playerPrice);

                playerFacade.changeTeam(id, newTeamId);
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

        @GetMapping("/update/{id}")
        public String redirectToUpdatePlayerPage(Model model, @PathVariable("id") Long id) {
                model.addAttribute("player", playerFacade.findById(id));
                return "pages/player/players_update";
        }

        @PostMapping("/{id}")
        public String updatePlayer(@ModelAttribute("player") @Valid PlayerRequestDto dto,
                                   BindingResult bindingResult,
                                @PathVariable("id") Long id ){
                if (bindingResult.hasErrors())
                        return "pages/players/players_update";
                playerFacade.update(dto, id);
                return "redirect:/players";
        }
}

