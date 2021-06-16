package org.d3if4070.qassmapp.model

data class Users(
    val id: String,
    val email: String,
    val userNama: String?,
    val phoneNumber: String?,
    val alamat: String?
) {
    constructor():this("","","","","")
}
