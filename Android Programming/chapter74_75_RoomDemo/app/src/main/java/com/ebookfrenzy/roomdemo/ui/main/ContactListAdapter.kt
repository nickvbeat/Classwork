package com.ebookfrenzy.roomdemo.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.roomdemo.Contact
import com.ebookfrenzy.roomdemo.R
import org.w3c.dom.Text

class ContactListAdapter(private val contactItemLayout: Int) :  RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null
    private var delete: ((Contact)-> Unit)? = null

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val contact = contactList?.get(listPosition)
        val name = holder.name
        val phoneNumber = holder.phone
        val id = holder.id

        contactList.let {
            name.text = it!![listPosition].contactName
            phoneNumber.text = it!![listPosition].phoneNumber
            id.text = it!![listPosition].id.toString()
        }

        holder.delete.setOnClickListener{
            if (contact != null) {
                delete?.invoke(contact)
                notifyDataSetChanged()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false
        )
        return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }


    fun setOnActionDeleteListener(callback: (Contact) -> Unit){
        this.delete = callback
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView = itemView.findViewById(R.id.textView)
        var phone: TextView = itemView.findViewById(R.id.textView2)
        var id: TextView = itemView.findViewById(R.id.textView3)
        var delete: ImageView = itemView.findViewById(R.id.imageView)
    }
}