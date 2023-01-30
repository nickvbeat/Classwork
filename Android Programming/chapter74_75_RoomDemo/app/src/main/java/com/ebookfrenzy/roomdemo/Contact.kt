package com.ebookfrenzy.roomdemo

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null


    var phoneNumber: String = ""

    constructor() {}

    /*SHOWN IN BOOK BUT DOES NOT SEEM TO BE NEEDED
    constructor(id: Int, productname: String, quantity: Int) {
        this.productName = productname
        this.quantity = quantity
    }*/

    constructor(contactname: String, phoneNumber: String) {
        this.contactName = contactname
        this.phoneNumber = phoneNumber
    }
}