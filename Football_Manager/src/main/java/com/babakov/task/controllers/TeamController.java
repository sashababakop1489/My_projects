package com.babakov.task.controllers;

import com.babakov.task.dto.team.TeamRequestDto;
import com.babakov.task.dto.team.TeamResponseDto;
import com.babakov.task.facade.TeamFacade;
import com.babakov.task.type.TeamType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String createNewDepartment(@ModelAttribute("team") @Valid TeamRequestDto teamRequestDto,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "pages/team/team_new";
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

    @GetMapping("/update/{id}")
    public String redirectToUpdateTeamPage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("team", teamFacade.findById(id));
        return "pages/team/team_update";
    }

    @PostMapping("/{id}")
    public String updateTeam(@ModelAttribute("team") @Valid TeamRequestDto dto,
                             BindingResult bindingResult,
                               @PathVariable("id") Long id ){
        if (bindingResult.hasErrors())
            return "pages/team/team_update";
        teamFacade.update(dto, id);
        return "redirect:/teams";
    }
}
