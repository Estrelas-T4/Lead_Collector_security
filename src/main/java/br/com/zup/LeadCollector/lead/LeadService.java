package br.com.zup.LeadCollector.lead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadService {
    @Autowired
    private LeadRepository leadRepository;

    public Lead salvarLead(Lead lead){
        return leadRepository.save(lead);
    }

    public Iterable<Lead> exibirLeads(){
        return leadRepository.findAll();
    }

}
