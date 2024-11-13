package com.naengbu.user.controller.fridge;

import com.naengbu.user.entity.fridge.FridgeEntity;
import com.naengbu.user.service.fridge.FridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FridgeController {

    @Autowired
    private FridgeService fridgeService;

    @GetMapping("/{id}")
    public ResponseEntity<FridgeEntity> getFridgeById(@PathVariable("id") String fridgeId) {
        try {
            FridgeEntity fridgeEntity = fridgeService.getFridgeById(fridgeId);
            return new ResponseEntity<>(fridgeEntity, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<FridgeEntity> addFridge(@RequestBody FridgeEntity fridgeEntity) {
        FridgeEntity savedFridge = fridgeService.addFridge(fridgeEntity);
        return new ResponseEntity<>(savedFridge, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FridgeEntity> updateFridge(@PathVariable("id") String fridgeId, @RequestBody FridgeEntity fridgeEntity) {
        try {
            fridgeEntity.setFridgeId(fridgeId);
            FridgeEntity updatedFridge = fridgeService.updateFridge(fridgeEntity);
            return new ResponseEntity<>(updatedFridge, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFridge(@PathVariable("id") String fridgeId) {
        try {
            fridgeService.deleteFridge(fridgeId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
