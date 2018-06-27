package com.rss.keshava.controller;

import com.rss.keshava.domain.Staff;
import com.rss.keshava.domain.Status;
import com.rss.keshava.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin (origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/staff")
public class StaffController {
    @Autowired
    private StaffService staffSerice;

    @PostMapping
    public Status create(@RequestBody Staff staff) {
        return staffSerice.create(staff);
    }

    @PutMapping
    public Status update(@Valid @RequestBody Staff staff) {
        return staffSerice.update(staff);
    }

    @GetMapping("/")
    public Iterable<Staff> getAll() {
        return staffSerice.getAll();
    }

    @GetMapping(value = "/{uid}")
    public Staff get(@PathVariable String uuid) {
        return staffSerice.getByUuid(uuid);
    }

    @DeleteMapping(value = "/{uid}")
    public Status delete(@PathVariable String uid) {
        return staffSerice.delete(uid);
    }
}
