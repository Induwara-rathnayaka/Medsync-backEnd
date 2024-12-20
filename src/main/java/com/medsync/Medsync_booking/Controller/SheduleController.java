package com.medsync.Medsync_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medsync.Medsync_booking.Model.Shedule;
import com.medsync.Medsync_booking.Service.SheduleService;

@RestController
@RequestMapping({"shedule"})
public class SheduleController {

    @Autowired
    SheduleService sheduleService;

    @PostMapping({"/create"})
    public ResponseEntity<Shedule> createShedule(@RequestBody Shedule shedule) {
        Shedule createShedule = sheduleService.creatShedule(shedule);
        return ResponseEntity.ok(createShedule);
    }
    
    @PostMapping({"/getByID/{id}"})
    public ResponseEntity<Shedule> getSheduleByID(@PathVariable String id) {
        Shedule getShedule = sheduleService.getSheduleById(id);
        return getShedule != null 
        ? ResponseEntity.ok(getShedule) 
        : ResponseEntity.notFound().build();
    }

    @PostMapping({"/getAll"})
    public ResponseEntity<List<Shedule>> getAllShedule() {
        List<Shedule> Sheduless = sheduleService.getAllShedule();
        return ResponseEntity.ok(Sheduless);
    }

    @PostMapping({"/update/{id}"})
    public ResponseEntity<Shedule> updateShedule(@PathVariable String id, @RequestBody Shedule shedule) {
        Shedule upShedule = sheduleService.updateShedule(id, shedule);        
        return upShedule != null 
        ? ResponseEntity.ok(upShedule) 
        : ResponseEntity.notFound().build();
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteShedule(@PathVariable String id) {
        String result = sheduleService.deleteShedule(id);
        return result != null 
        ? ResponseEntity.ok(result) 
        : ResponseEntity.notFound().build();
    }
}
