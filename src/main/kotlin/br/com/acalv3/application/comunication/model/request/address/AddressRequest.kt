package br.com.acalv3.application.comunication.model.request.address

import javax.validation.constraints.NotBlank

open class AddressRequest (

    open val name: String? = null,
)