package com.babakov.task.controllers;

import com.babakov.task.dto.team.TeamRequestDto;
import com.babakov.task.dto.team.TeamResponseDto;
import com.babakov.task.facade.TeamFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamRestController {

    private final TeamFacade teamFacade;

    public TeamRestController(TeamFacade teamFacade) {
        this.teamFacade = teamFacade;
    }

    @ResponseBody
    @GetMapping
    public ResponseEntity<List<TeamResponseDto>> findAll() {
        return ResponseEntity.ok(teamFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(teamFacade.findById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody TeamRequestDto team) {
        teamFacade.create(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        teamFacade.delete(id);
        return ResponseEntity.ok(true);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Long id, @RequestBody TeamRequestDto teamRequestDto) {
        teamFacade.update(teamRequestDto, id);
        return ResponseEntity.ok(true);
    }
}
