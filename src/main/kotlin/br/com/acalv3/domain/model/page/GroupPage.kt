package br.com.acalv3.domain.model.page

import java.math.BigDecimal

data class GroupPage (
    val name: String?,
    val value: BigDecimal?,
    val category: String?,
    override val sortedField: String = "id",
    override val page: Int = 0,
    override val pageSize: Int = 10,
    override val direction: String = "ASC",
) : DefaultPage()
