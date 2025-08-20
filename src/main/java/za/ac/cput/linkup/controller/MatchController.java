package za.ac.cput.linkup.controller;
/* MatchController.java
MatchController class
Author: Luyanda Makhanya (222788291)
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.linkup.domain.Match;
import za.ac.cput.linkup.service.MatchService;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;
    private MatchService service;

    @Autowired
    private MatchController(MatchService service, MatchService matchService) {
        this.service = service;
        this.matchService = matchService;
    }

    @PostMapping("/create")
    public Match create(@RequestBody Match match) {
        return matchService.create(match);
    }

    @GetMapping("/read/{matchId}")
    public Match read(@PathVariable Long matchId) {
        return matchService.read(matchId);
    }

    @PostMapping("/update")
    public Match update(@RequestBody Match match) {
        return matchService.update(match);
    }

    @DeleteMapping("/delete/{matcbId}")
    public boolean delete(@PathVariable Long matchId) {
        matchService.delete(matchId);
        return matchService.read(matchId) == null;
    }

    @GetMapping("/getAll")
    public List<Match> getAll() {
        return matchService.getAllMatches();
    }

}
