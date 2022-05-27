package com.babakov.demo.controllers;

import com.babakov.demo.dto.team.TeamRequestDto;
import com.babakov.demo.dto.team.TeamResponseDto;
import com.babakov.demo.facade.TeamFacade;
import com.babakov.demo.type.TeamType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teams")
public class TeamController {

    private final TeamFacade teamFacade;


    public TeamController(TeamFacade teamFacade) {
        this.teamFacade = teamFacade;
    }

    @GetMapping()
    public String findAll(Model model) {
       List<TeamResponseDto> teams = teamFacade.findAll();
       model.addAttribute("teams", teams);
        return "pages/team/team_all";
    }

    @GetMapping("/new")
    public String redirectToNewDepartmentPage(Model model) {
        model.addAttribute("team", new TeamRequestDto());
        model.addAttribute("types", TeamType.values());
        return "pages/team/team_new";
    }

    @PostMapping("/new")
    public String createNewDepartment(@ModelAttribute("team") TeamRequestDto teamRequestDto) {
        teamFacade.create(teamRequestDto);
        return "redirect:/teams";
    }

    @GetMapping("/details/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("team", teamFacade.findById(id));
        return "pages/team/team_details";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        teamFacade.delete(id);
        return "redirect:/teams";
    }
}
