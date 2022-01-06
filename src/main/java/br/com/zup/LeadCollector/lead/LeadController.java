package br.com.zup.LeadCollector.lead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@RestController
@RequestMapping("/leads")
public class LeadController {
    @Autowired
    private LeadService leadService;

    @PostMapping()//C
    @ResponseStatus(HttpStatus.CREATED)
    public Lead cadastrarLead(@RequestBody Lead lead){
        return leadService.salvarLead(lead);
    }

    @GetMapping//R
    public Iterable<Lead> exibirTodosLeads(){
        return leadService.exibirLeads();
    }

    @PutMapping//U
    public Lead ataualizarLead(@RequestBody Lead lead){
        return leadService.atualizarLead(lead);
    }

    @DeleteMapping//D
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarLead(@RequestParam String email){
        leadService.deletarLead(email);
    }
}
