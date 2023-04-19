package br.com.acalv3.resources.model.business

import br.com.acalv3.domain.model.Hydrometer
import br.com.acalv3.resources.model.DefaultEntity
import java.math.BigDecimal
import java.util.UUID
import javax.persistence.CascadeType.DETACH
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import org.springframework.data.domain.Page

@Entity(name = "hydrometer")
class HydrometerEntity (

    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    val id: UUID,

    val reference: String,

    val costValue: BigDecimal,

    val actualQuantity: Long,

    val lastMonthQuantity: Long,

    ) : DefaultEntity() {

    @ManyToOne(cascade = [DETACH])
    @JoinColumn(name="link_id",nullable = false)
    var link: LinkEntity? = null
}

fun Hydrometer.toEntity() = HydrometerEntity(
    id = id,
    reference = reference,
    costValue = costValue,
    actualQuantity = actualQuantity,
    lastMonthQuantity = lastMonthQuantity,
).also {
    it.link = link?.toLinkEntity()
}

fun HydrometerEntity.toDomain() = Hydrometer(
    id = id,
    reference = reference,
    costValue = costValue,
    actualQuantity = actualQuantity,
    lastMonthQuantity = lastMonthQuantity,
    link = link?.toLink()
)

fun HydrometerEntity.toDomainWithoutLink() = Hydrometer(
    id = id,
    reference = reference,
    costValue = costValue,
    actualQuantity = actualQuantity,
    lastMonthQuantity = lastMonthQuantity,
    link = link?.toLinkWithSafeHydrometer(),
)

fun Page<HydrometerEntity>.toPage() = map{ it.toDomainWithoutLink() }
fun List<HydrometerEntity>.toDomain(): List<Hydrometer> = map{ it.toDomainWithoutLink() }
fun List<HydrometerEntity>.toDomainWithoutLink(): List<Hydrometer> = map{ it.toDomainWithoutLink() }
fun List<Hydrometer>.toEntity(): List<HydrometerEntity> = map{ it.toEntity() }