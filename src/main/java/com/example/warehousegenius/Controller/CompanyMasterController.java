package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.CompanyMaster;
import com.example.warehousegenius.Service.CompanyMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/companies")
public class CompanyMasterController {

    @Autowired
    private CompanyMasterService companyMasterService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET method to fetch all companies
    @GetMapping
    public List<CompanyMaster> getAllCompanies() {
        return companyMasterService.getAllCompanies();
    }

    // POST method to create a company
    @PostMapping
    public CompanyMaster createCompany(@RequestBody CompanyMaster company) {
        CompanyMaster createdCompany = companyMasterService.createOrUpdateCompany(company);
        messagingTemplate.convertAndSend("/topic/companies", createdCompany);
        return createdCompany;
    }

    // PUT method to update a company
    @PutMapping("/{id}")
    public ResponseEntity<CompanyMaster> updateCompany(@PathVariable Long id, @RequestBody CompanyMaster companyDetails) {
        Optional<CompanyMaster> company = companyMasterService.getCompanyById(id);
        if (company.isPresent()) {
            CompanyMaster updatedCompany = company.get();
            updatedCompany.setCompanyName(companyDetails.getCompanyName());
            updatedCompany.setCompanyDescription(companyDetails.getCompanyDescription());
            updatedCompany.setAddress(companyDetails.getAddress());
            updatedCompany.setLandline(companyDetails.getLandline());
            updatedCompany.setFax(companyDetails.getFax());
            updatedCompany.setMobileNumber(companyDetails.getMobileNumber());
            updatedCompany.setEmail(companyDetails.getEmail());
            updatedCompany.setContactPersons(companyDetails.getContactPersons());
            updatedCompany.setVatNo(companyDetails.getVatNo());
            updatedCompany.setCstNo(companyDetails.getCstNo());
            updatedCompany.setTinNo(companyDetails.getTinNo());
            updatedCompany.setLbtNo(companyDetails.getLbtNo());
            updatedCompany.setExciseNo(companyDetails.getExciseNo());
            updatedCompany.setExciseChapHeading(companyDetails.getExciseChapHeading());
            updatedCompany.setExciseRange(companyDetails.getExciseRange());
            updatedCompany.setExciseDivision(companyDetails.getExciseDivision());
            updatedCompany.setExciseCommiissionerate(companyDetails.getExciseCommiissionerate());
            updatedCompany.setBanks(companyDetails.getBanks());

            messagingTemplate.convertAndSend("/topic/companies", updatedCompany);
            return ResponseEntity.ok(companyMasterService.createOrUpdateCompany(updatedCompany));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete a company
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyMasterService.deleteCompany(id);
        messagingTemplate.convertAndSend("/topic/companies", id);
        return ResponseEntity.ok().build();
    }
}
