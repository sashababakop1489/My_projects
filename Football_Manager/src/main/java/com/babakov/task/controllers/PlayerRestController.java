package com.babakov.task.controllers;

import com.babakov.task.dto.player.PlayerRequestDto;
import com.babakov.task.dto.player.PlayerResponseDto;
import com.babakov.task.facade.PlayerFacade;
import com.babakov.task.facade.TeamFacade;
import com.babakov.task.models.Team;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/players")
public class PlayerRestController {

    private final PlayerFacade playerFacade;
    private final TeamFacade teamFacade;

    public PlayerRestController(PlayerFacade playerFacade, TeamFacade teamFacade) {
        this.playerFacade = playerFacade;
        this.teamFacade = teamFacade;
    }

    @ResponseBody
    @GetMapping
    public ResponseEntity<List<PlayerResponseDto>> findAll() {
        return ResponseEntity.ok(playerFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(playerFacade.findById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> create(@Valid @RequestBody PlayerRequestDto playerRequestDto,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.status(HttpStatus.CREATED).body(false);
        playerFacade.create(playerRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        playerFacade.delete(id);
        return ResponseEntity.ok(true);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Long id,
                                          @Valid @RequestBody PlayerRequestDto playerRequestDto,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.ok(false);
        playerFacade.update(playerRequestDto, id);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/{playerId}/buy/{teamId}")
    public ResponseEntity<Boolean> buyPlayer(@PathVariable Long playerId,
                                             @PathVariable Long teamId){

        long playerPrice = playerFacade.findById(playerId).getPrice();
        try {
            teamFacade.changePurse(teamId, playerPrice);
        } catch (Exception e){
            return ResponseEntity.ok(false);
        }

        Team oldTeam = playerFacade.findById(playerId).getTeam();
        oldTeam.setPurse(oldTeam.getPurse() + playerPrice);

        playerFacade.changeTeam(playerId, teamId);

        return ResponseEntity.ok(true);
    }

}
