package rs.ac.uns.acs.nais.ColumnarDatabaseService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.acs.nais.ColumnarDatabaseService.dto.FeedbackWorkshopDTO;
import rs.ac.uns.acs.nais.ColumnarDatabaseService.dto.UserWorkshopDTO;
import rs.ac.uns.acs.nais.ColumnarDatabaseService.service.FeedbackWorkshopService;
import rs.ac.uns.acs.nais.ColumnarDatabaseService.service.UserWorkshopService;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackWorkshopController {

    @Autowired
    private FeedbackWorkshopService feedbackWorkshopService;

    @PostMapping
    public ResponseEntity<FeedbackWorkshopDTO> create(@RequestBody FeedbackWorkshopDTO dto) {

        FeedbackWorkshopDTO created = feedbackWorkshopService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FeedbackWorkshopDTO>> getAll(){
        return new ResponseEntity<>(feedbackWorkshopService.getAll(), HttpStatus.OK);
    }


    @DeleteMapping("/{workshop_id}/{user_id}")
    public ResponseEntity<FeedbackWorkshopDTO> delete(@PathVariable Long workshop_id, @PathVariable Long user_id){
        return new ResponseEntity<>(feedbackWorkshopService.delete(workshop_id, user_id), HttpStatus.OK);
    }

    @PutMapping("/update/{workshop_id}/{user_id}")
    public ResponseEntity<FeedbackWorkshopDTO> update(@RequestBody FeedbackWorkshopDTO feedbackWorkshopDTO, @PathVariable Long workshop_id, @PathVariable Long user_id){
        return  new ResponseEntity<>(feedbackWorkshopService.update(feedbackWorkshopDTO, workshop_id, user_id), HttpStatus.OK);
    }
}
