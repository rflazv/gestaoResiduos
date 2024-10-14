package br.com.fiap.gestao_residuos.controller;

import br.com.fiap.gestao_residuos.model.CollectionSchedule;
import br.com.fiap.gestao_residuos.repository.CollectionScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedules")
public class CollectionScheduleController {

    @Autowired
    private CollectionScheduleRepository scheduleRepository;

    @GetMapping
    public List<CollectionSchedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @PostMapping
    public CollectionSchedule createSchedule(@RequestBody CollectionSchedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CollectionSchedule> updateSchedule(@PathVariable Long id, @RequestBody CollectionSchedule scheduleDetails) {
        Optional<CollectionSchedule> schedule = scheduleRepository.findById(id);

        if (schedule.isPresent()) {
            CollectionSchedule updatedSchedule = schedule.get();
            updatedSchedule.setDataHora(scheduleDetails.getDataHora());
            updatedSchedule.setRota(scheduleDetails.getRota());
            scheduleRepository.save(updatedSchedule);
            return ResponseEntity.ok(updatedSchedule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        if (scheduleRepository.existsById(id)) {
            scheduleRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
