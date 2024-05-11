package com.cloudvendor.restapi.controller;

import com.cloudvendor.restapi.models.CloudVendor;
import com.cloudvendor.restapi.response.ResponseHandler;
import com.cloudvendor.restapi.service.CloudVendorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
class CloudVendorController {

    CloudVendorService cloudVendorService;


    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    //Read Specific Cloud Vendor
    @GetMapping("{vendorId}")
    @ApiOperation(value = "Cloud vendor id", notes = "Provide cloud vendor details", response = ResponseEntity.class)
    public ResponseEntity<Object> getVendorDetails(@PathVariable("vendorId") String vendorId) {
        return ResponseHandler.responseBuilder("Here are requested Details.", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
    }

    //Get All Cloud Vendor
    @GetMapping("/")
    public List<CloudVendor> getAllVendorDetails() {
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping("/")
    public String setVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Vendor Created Successfully";
    }

    @PutMapping("/")
    public String updateVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Vendor updated Successfully";
    }

    @DeleteMapping("/{vendorId}")
    public String deleteVendorDetails(@PathVariable("vendorId") String vendorId) {
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Vendor deleted Successfully";
    }

}
