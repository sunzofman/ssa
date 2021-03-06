package es.gorka.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.gorka.edu.dto.SnippetDTO;
import es.gorka.edu.repository.SnippetRepository;

@Service(value = "snippetService")
public class SnippetServiceImpl implements SnippetService {

	@Autowired
	SnippetRepository repository;

	@Override
	public SnippetDTO newEntity() {
		return new SnippetDTO();
	}

	@Override
	public boolean insertNewEntityDto(SnippetDTO snippetDTO) {
		repository.insert(snippetDTO);
		return true;
	}

	@Override
	public List<SnippetDTO> listAll() {
		return repository.selectAll();
	}

	@Override
	public SnippetDTO search(SnippetDTO dto) {
		return repository.selectOneByEntity(dto);
	}

	@Override
	public List<SnippetDTO> searchAll(SnippetDTO dto) {
		return null;
	}

}
