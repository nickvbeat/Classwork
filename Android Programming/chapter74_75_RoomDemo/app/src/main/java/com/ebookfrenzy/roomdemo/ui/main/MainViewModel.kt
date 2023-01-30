package com.ebookfrenzy.roomdemo.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ebookfrenzy.roomdemo.Contact
import com.ebookfrenzy.roomdemo.ContactRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>
    private val sortedASC: MutableLiveData<List<Contact>>
    private val sortedDESC: MutableLiveData<List<Contact>>

    init {
        allContacts = repository.allContacts
        searchResults = repository.searchResults
        sortedASC = repository.sortedASC
        sortedDESC = repository.sortedDESC
    }

    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }

    fun findContact(name: String) {
        repository.findContact(name)
    }

    fun deleteContact(id: Int) {
        repository.deleteContact(id)
    }

    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }

    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }

    fun sortAsc(){
        repository.sortASC()
    }

    fun getSortedASC(): MutableLiveData<List<Contact>> {
        return sortedASC
    }

    fun sortDesc(){
        repository.sortDESC()
    }

    fun getSortedDESC(): MutableLiveData<List<Contact>> {
        return sortedDESC
    }
//    fun getTestList(): List<Contact>{
//        for(i: Int in 0..searchResults.obs)
//    }
}
