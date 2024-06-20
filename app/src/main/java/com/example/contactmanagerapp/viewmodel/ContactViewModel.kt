package com.example.contactmanagerapp.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactmanagerapp.repository.ContactRepository
import com.example.contactmanagerapp.room.Contact
import kotlinx.coroutines.launch

//View Model: store and manage UI-related Data
//separating the UI-related logic from UI controller (Activity/Frag.)

class ContactViewModel(private val repository: ContactRepository) : ViewModel() , Observable {

    val contacts = repository.contacts
    private var isUpdateOrDelete = false
    private lateinit var contactToUpdateOrDelete: Contact

    @Bindable
    val inputName = MutableLiveData<String?>()

    @Bindable
    val inputEmail = MutableLiveData<String?>()

    @Bindable
    val inputPhone = MutableLiveData<String?>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun insert(contact: Contact) = viewModelScope.launch {
        repository.insert(contact)
    }

    fun delete(contact: Contact) = viewModelScope.launch {
        repository.delete(contact)

        //resetting the button and the fields
        inputName.value = null
        inputEmail.value = null
        inputPhone.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value = "save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun update(contact: Contact) = viewModelScope.launch {
        repository.update(contact)

        //resetting the button and the fields
        inputName.value = null
        inputEmail.value = null
        inputPhone.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value = "save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun clearAll() = viewModelScope.launch {
        repository.deleteAll()
    }


    fun saveOrUpdate(){
        if(isUpdateOrDelete){
            contactToUpdateOrDelete.contact_name = inputName.value!!
            contactToUpdateOrDelete.contact_email = inputEmail.value!!
            contactToUpdateOrDelete.contact_phone = inputPhone.value!!
            update(contactToUpdateOrDelete)
        }else{
            val name = inputName.value!!
            val email = inputEmail.value!!
            val phone = inputPhone.value!!

            insert(Contact(0 , name , email , phone))

            inputPhone.value = null
            inputEmail.value = null
            inputName.value = null

        }
    }


    fun clearAllOrDelete(){
        if(isUpdateOrDelete){
            delete(contactToUpdateOrDelete)
        }else{
            clearAll()
        }
    }

    fun initUpdateAndDelete(contact: Contact){
        inputName.value = contact.contact_name
        inputEmail.value = contact.contact_email
        inputPhone.value = contact.contact_phone
        isUpdateOrDelete = true
        contactToUpdateOrDelete = contact
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}