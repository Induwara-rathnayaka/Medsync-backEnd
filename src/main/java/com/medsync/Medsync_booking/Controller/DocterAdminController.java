package com.medsync.Medsync_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medsync.Medsync_booking.Model.DocterAdmin;
import com.medsync.Medsync_booking.Service.DocterAdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/docter_admin")
@NoArgsConstructor

public class DocterAdminController {

    @Autowired
    private DocterAdminService docterAdminService;

    @PostMapping
    public ResponseEntity<DocterAdmin> createDocterAdmin(@RequestBody DocterAdmin docterAdmin) {
        DocterAdmin createdDocter = docterAdminService.createDocterAdmin(docterAdmin);
        return ResponseEntity.ok(createdDocter);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<DocterAdmin> getDocterAdminById(@PathVariable String id) {
        DocterAdmin docterAdmin = this.docterAdminService.getDocterAdminById(id);
        return docterAdmin != null ? ResponseEntity.ok(docterAdmin) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<DocterAdmin>> getAllDocterAdmin() {
        List<DocterAdmin> docterAdmin = this.docterAdminService.getAllDocterAdmin();
        return ResponseEntity.ok(docterAdmin);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<DocterAdmin> updateDocterAdmin(@PathVariable String id, @RequestBody DocterAdmin docterAdmin) {
        DocterAdmin updatedDocterAdmin = this.docterAdminService.updateDocterAdmin(id, docterAdmin);
        return updatedDocterAdmin != null ? ResponseEntity.ok(updatedDocterAdmin) : ResponseEntity.notFound().build();
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteDocterAdmin(@PathVariable String id) {
        this.docterAdminService.deleteDocterAdmin(id);
        return ResponseEntity.noContent().build();
    }


}
