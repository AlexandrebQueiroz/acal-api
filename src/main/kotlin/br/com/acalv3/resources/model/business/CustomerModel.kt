package br.com.acalv3.resources.model.business

import br.com.acalv3.domain.enumeration.PersonTypeEnum
import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity(name = "customer_model")
class CustomerModel (

    @Id
    var id: UUID? = UUID.randomUUID(),

    @Column(nullable = false)
    var name: String? = null,

    var document: String? = null,

    @Enumerated(EnumType.STRING)
    var personType: PersonTypeEnum? = null,

    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd")
    var birthDate: LocalDate? = null,

)