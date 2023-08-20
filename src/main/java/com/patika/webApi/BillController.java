package com.patika.webApi;

import com.patika.business.abstracts.BillService;
import com.patika.business.requests.BillRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bill")
public class BillController {

    private BillService _billService;

    @Autowired
    public BillController(BillService _billService) {
        this._billService = _billService;
    }

    @PostMapping( "/add")
    public ResponseEntity<Object> add(BillRequest billRequest){
        return ResponseEntity.ok(this._billService.add(billRequest));
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(BillRequest billRequest){
        return ResponseEntity.ok(this._billService.add(billRequest));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(Integer id){
        return ResponseEntity.ok(this._billService.delete(id));
    }

    @GetMapping("/getall")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.ok(this._billService.getAll());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Object> getById(Integer id){
        return ResponseEntity.ok(this._billService.getById(id));
    }

    @PutMapping( "/paybill/{id}")
    public ResponseEntity<Object> payBill(@PathVariable Integer id){
        return ResponseEntity.ok(this._billService.payBill(id));
    }

    @PutMapping( "/cancelbill/{id}")
    public ResponseEntity<Object> cancelBill(@PathVariable Integer id){
        return ResponseEntity.ok(this._billService.cancelBill(id));
    }

    @GetMapping( "/getbycode/{id}")
    public ResponseEntity<Object> getByCode(@PathVariable Integer id){
        return ResponseEntity.ok(this._billService.getByCode(id));
    }
}
