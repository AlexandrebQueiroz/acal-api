package br.com.acalv3.domain.service.strategies.group

import br.com.acalv3.domain.enumeration.Action.SAVE
import br.com.acalv3.domain.model.Group
import br.com.acalv3.domain.repository.GroupRepository
import org.springframework.stereotype.Service

@Service
class SaveGroupStrategy(
    val repository: GroupRepository,
): GroupStrategy {

    override fun action() = SAVE

    override fun can(group: Group) {
        repository.findGroup(group)?.let {
            throw RuntimeException("O grupo [${it.name}] já está cadastrado para a categoria [${group.category.value}]")
        }
    }
}