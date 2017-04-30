package pl.edu.pw.elka.rso.eres3.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.pw.elka.rso.eres3.controllers.abstractions.AbstractCrudController;
import pl.edu.pw.elka.rso.eres3.domain.entities.SubjectRealization;
import pl.edu.pw.elka.rso.eres3.domain.repositories.SubjectRealizationRepository;

/**
 * Rest controlller for subject's versions.
 */
public class SubjectRealizationController extends AbstractCrudController<SubjectRealization, Integer> {

	private static final String mapping = "/subjects/versions/realizations";
	private final SubjectRealizationRepository realizationRepository;

	protected SubjectRealizationController(final SubjectRealizationRepository realizationRepository, final boolean artificialId) {
		super(realizationRepository, artificialId);
		this.realizationRepository = realizationRepository;
	}

	@RequestMapping(value =  "/subjects/versions/{id}/realizations", method = RequestMethod.GET)
	public Iterable<SubjectRealization> getAllSubjectVersionsRealizations(@PathVariable final int id) {
		return realizationRepository.findBySubjectVersionId(id);
	}

	@RequestMapping(value = mapping + "/{id}", method = RequestMethod.GET)
	public ResponseEntity<SubjectRealization> getSubjectRealization(@PathVariable final int id){
		return getEntity(id);
	}

	@RequestMapping(value = mapping, method = RequestMethod.POST)
	public ResponseEntity<SubjectRealization> addSubjectRealization(@RequestBody final SubjectRealization realization){
		return addEntity(realization);
	}

	@RequestMapping(value = mapping + "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<SubjectRealization> deleteSubjectVerion(@PathVariable final int id) {
		return deleteEntity(id);
	}

	@Override
	protected String getControllerMapping() {
		return mapping;
	}
}