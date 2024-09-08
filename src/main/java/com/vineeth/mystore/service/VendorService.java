package com.vineeth.mystore.service;

import com.vineeth.mystore.entities.Vendor;
import com.vineeth.mystore.exception.InvalidVendorDataException;
import com.vineeth.mystore.repository.MyStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    private final MyStoreRepository myStoreRepository;

    @Autowired
    public VendorService(MyStoreRepository myStoreRepository) {
        this.myStoreRepository = myStoreRepository;
    }

    public ResponseEntity<List<Vendor>> getVendorsDetails() {
        List<Vendor> lst = myStoreRepository.findAll();
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    public ResponseEntity<Vendor> createVendor(Vendor vendor) {
        if(vendor!=null) {
            Vendor newVendor = new Vendor();
            if (vendor.getVendorName() != null && vendor.getVendorEmail() != null
                    && vendor.getVendorPhone() != null && vendor.getVendorAddress() != null) {
                newVendor.setVendorName(vendor.getVendorName());
                newVendor.setVendorEmail(vendor.getVendorEmail());
                newVendor.setVendorPhone(vendor.getVendorPhone());
                newVendor.setVendorAddress(vendor.getVendorAddress());
                return new ResponseEntity<>(myStoreRepository.save(newVendor), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Vendor> updateVendor(Vendor vendor, long vendorId) {
        if(vendorId==0){
            return ResponseEntity.badRequest().build();
        }else{
            try{
                if(vendor.getVendorEmail() != null
                        && vendor.getVendorPhone() != null && vendor.getVendorAddress() != null) {
                    Vendor newVendor = new Vendor();
                    newVendor.setVendorName(vendor.getVendorName());
                    newVendor.setVendorEmail(vendor.getVendorEmail());
                    newVendor.setVendorPhone(vendor.getVendorPhone());
                    newVendor.setVendorAddress(vendor.getVendorAddress());
                    return new ResponseEntity<>(myStoreRepository.save(newVendor), HttpStatus.OK);
                }else{
                    return ResponseEntity.badRequest().build();
                }
            }catch (Exception e) {
                throw new InvalidVendorDataException("Invalid Vendor Details");
            }
        }
    }
}
