package br.com.acalv3.application.comunicate.model.response

import br.com.acalv3.domain.model.Customer
import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.domain.Page
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME
import java.time.LocalDate
import java.util.*

data class CustomerPageResponse(
    val id: UUID,
    val name: String?,
    val document: String?,
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd")
    val birthDay: LocalDate?,
)

fun Customer.toCustomerPageResponse() = CustomerPageResponse(
    id = id,
    name = name,
    document = document,
    birthDay = birthDay
)
fun Page<Customer>.toCustomerPageResponse() = map{ it.toCustomerPageResponse() }