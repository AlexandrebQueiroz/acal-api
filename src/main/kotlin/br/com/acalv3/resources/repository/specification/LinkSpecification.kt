package br.com.acalv3.resources.repository.specification

import br.com.acalv3.application.comunicate.model.request.link.LinkPageRequest
import br.com.acalv3.resources.model.business.LinkEntity
import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

class LinkSpecification(private val link: LinkPageRequest) {

    fun getSpecification(): Specification<LinkEntity> = run {
        Specification<LinkEntity> { root, _, builder ->
            val predicate = builder.conjunction()
            getPredicates(predicate, root, builder)
            predicate
        }
    }

    private fun getPredicates(predicate: Predicate, root: Root<LinkEntity>, builder: CriteriaBuilder) {

        if (link.name != null) {
            predicate.expressions.add(likeName(root, builder))
        }
    }

    private fun likeName(root: Root<LinkEntity>, builder: CriteriaBuilder): Predicate =
        builder.like(builder.upper(root.get("name")),"%${link.name}%")

}
