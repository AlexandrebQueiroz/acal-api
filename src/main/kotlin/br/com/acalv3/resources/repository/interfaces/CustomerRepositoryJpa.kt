package br.com.acalv3.resources.repository.interfaces

import br.com.acalv3.resources.model.business.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.*

interface CustomerRepositoryJpa : JpaRepository<CustomerEntity, UUID>, JpaSpecificationExecutor<CustomerEntity> {
    fun findByName(name: String): CustomerEntity
    fun findByDocument(document: String): CustomerEntity?
}

