package mps.doorbellsystem.controllers;

import mps.doorbellsystem.exceptions.InvalidFlagException;
import mps.doorbellsystem.model.Flag;
import mps.doorbellsystem.repository.FlagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class FlagController {
    @Autowired
    FlagRepository flagRepository;

    @GetMapping(path = "/api/flags")
    public List<Flag> getAllFlags() {
        return flagRepository.findAll();
    }
    @GetMapping(path = "/api/systemOn")
    public boolean isHome() {
        if(flagRepository.findById("eventsOn").orElseThrow(InvalidFlagException::new).isValue() == true) {
            return false;// check the events
        } else {
            return !flagRepository.findById("isHome").orElseThrow(() -> new InvalidFlagException()).isValue();
        }
    }
    @GetMapping(path = "/api/flags/{name}")
    public Boolean getFlagValueByName(@PathVariable String name) {
        return flagRepository.findById(name).get().isValue();
    }
    @PatchMapping(path = "/api/flags/{name}")
    public Flag updateFlag(@PathVariable String name, @RequestBody Flag valueFlag) {
        Flag flagToUpdate = flagRepository.findById(name).orElseThrow(InvalidFlagException::new);
        flagToUpdate.setValue(valueFlag.isValue());
        return flagRepository.save(flagToUpdate);
    }
}