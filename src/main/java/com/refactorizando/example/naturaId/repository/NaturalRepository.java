package com.refactorizando.example.naturaId.repository;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface NaturalRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

  Optional<T> findBySimpleNaturalId(ID naturalId);

  Optional<T> findByNaturalId(Map<String, Object> naturalIds);
}
