package com.vineeth.mystore.controller;

import com.vineeth.mystore.entities.Vendor;
import com.vineeth.mystore.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vendor")
public class VendorController {

    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping(value = "/getVendorsDetails")
    public ResponseEntity<List<Vendor>> getVendorsDetails() {
        return vendorService.getVendorsDetails();
    }

    @PostMapping(value = "/createVendor")
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    @PutMapping(value = "/updateVendor/{vendorId}")
    public ResponseEntity<Vendor> updateVendor(@RequestBody Vendor vendor, @PathVariable long vendorId) {
        return vendorService.updateVendor(vendor, vendorId);
    }

    @DeleteMapping("/deleteVendor/{vendorId}")
    public ResponseEntity<Object> deleteVendor(@PathVariable long vendorId) {
        return vendorService.deleteVendor(vendorId);
    }

}
