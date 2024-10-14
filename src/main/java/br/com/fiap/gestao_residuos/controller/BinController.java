package br.com.fiap.gestao_residuos.controller;

import br.com.fiap.gestao_residuos.model.Bin;
import br.com.fiap.gestao_residuos.repository.BinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bins")
public class BinController {

    @Autowired
    private BinRepository binRepository;

    @GetMapping
    public List<Bin> getAllBins() {
        return binRepository.findAll();
    }

    @PostMapping
    public Bin createBin(@RequestBody Bin bin) {
        return binRepository.save(bin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bin> updateBin(@PathVariable Long id, @RequestBody Bin binDetails) {
        Optional<Bin> bin = binRepository.findById(id);

        if (bin.isPresent()) {
            Bin updatedBin = bin.get();
            updatedBin.setLocalizacao(binDetails.getLocalizacao());
            updatedBin.setCapacidade(binDetails.getCapacidade());
            updatedBin.setStatus(binDetails.getStatus());
            binRepository.save(updatedBin);
            return ResponseEntity.ok(updatedBin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBin(@PathVariable Long id) {
        if (binRepository.existsById(id)) {
            binRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
