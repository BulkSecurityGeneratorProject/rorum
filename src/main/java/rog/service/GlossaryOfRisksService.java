package rog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rog.domain.GlossaryOfRisks;
import rog.repository.GlossaryOfRisksRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Service Implementation for managing GlossaryOfRisks.
 */
@Service
@Transactional
public class GlossaryOfRisksService {

    private final Logger log = LoggerFactory.getLogger(GlossaryOfRisksService.class);

    @Autowired
    private GlossaryOfRisksRepository glossaryOfRisksRepository;

    @Autowired
    private GlossaryManagementService glossaryManagementService;
    /**
     * Save a glossaryOfRisks.
     *
     * @param glossaryOfRisks the entity to save
     * @return the persisted entity
     */
    public GlossaryOfRisks save(GlossaryOfRisks glossaryOfRisks) {
        log.debug("Request to save GlossaryOfRisks : {}", glossaryOfRisks);
        return glossaryOfRisksRepository.save(glossaryOfRisks);
    }

    /**
     *  Get all the glossaryOfRisks.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<GlossaryOfRisks> findAll(Pageable pageable) {
        log.debug("Request to get all GlossaryOfRisks");
        return glossaryOfRisksRepository.findAll(pageable);
    }

    /**
     *  Get one glossaryOfRisks by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public GlossaryOfRisks findOne(Long id) {
        log.debug("Request to get GlossaryOfRisks : {}", id);
        return glossaryOfRisksRepository.findOne(id);
    }

    /**
     *  Delete the  glossaryOfRisks by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete GlossaryOfRisks : {}", id);
        glossaryOfRisksRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public List<GlossaryOfRisks> getAllOfCurrentOrganisationByGlossaryOfPurposesId(Long purposeId){
        return glossaryOfRisksRepository.getAllOfCurrentOrganisationByGlossaryOfPurposesId(purposeId);
    }

    @Transactional
    public Set<GlossaryOfRisks> getAllByGlossaryOfPurposesId(Long purposeId) {
        return glossaryOfRisksRepository.getAllByGlossaryOfPurposesId(purposeId);
    }

    @Transactional(readOnly = true)
    public List<GlossaryOfRisks> findAll() {
        return glossaryOfRisksRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<GlossaryOfRisks> findAllByImportantToIsGreaterThan() {
        LocalDate ld = LocalDate.now();
        return glossaryOfRisksRepository.findAllByImportantToIsGreaterThan(ld);
    }

    @Transactional
    public List<GlossaryOfRisks> getAllUserRisks() {
        List<GlossaryOfRisks> result = new ArrayList<>();
        glossaryManagementService.getAllAssignmentToCellOfCurrentOrganisation()
            .forEach(gop -> result.addAll(glossaryOfRisksRepository.getAllByGlossaryOfPurposesId(gop.getId())));
        return result;
    }

}
