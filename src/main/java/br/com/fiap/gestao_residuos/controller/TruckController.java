package br.com.fiap.gestao_residuos.controller;

import br.com.fiap.gestao_residuos.model.Truck;
import br.com.fiap.gestao_residuos.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trucks")
public class TruckController {

    @Autowired
    private TruckRepository truckRepository;

    @GetMapping
    public List<Truck> getAllTrucks() {
        return truckRepository.findAll();
    }

    @PostMapping
    public Truck createTruck(@RequestBody Truck truck) {
        return truckRepository.save(truck);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Truck> updateTruck(@PathVariable Long id, @RequestBody Truck truckDetails) {
        Optional<Truck> truck = truckRepository.findById(id);

        if (truck.isPresent()) {
            Truck updatedTruck = truck.get();
            updatedTruck.setPlaca(truckDetails.getPlaca());
            updatedTruck.setMotorista(truckDetails.getMotorista());
            truckRepository.save(updatedTruck);
            return ResponseEntity.ok(updatedTruck);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTruck(@PathVariable Long id) {
        if (truckRepository.existsById(id)) {
            truckRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
