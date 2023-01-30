package com.ebookfrenzy.roomdemo.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ebookfrenzy.roomdemo.R

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.roomdemo.Contact
import androidx.fragment.app.viewModels

import com.ebookfrenzy.roomdemo.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)

        listenerSetup()
        observerSetup()
        recyclerSetup()

        return binding.root
    }

    private fun listenerSetup() {

        binding.addButton.setOnClickListener {
            val name = binding.nameBox.text.toString()
            val phoneNumber = binding.phoneBox.text.toString()

            if (name != "" && phoneNumber != "") {
                val product = Contact(name, phoneNumber)
                viewModel.insertContact(product)
                clearFields()
            } else {
                Toast.makeText(context, "Incomplete Information", Toast.LENGTH_SHORT).show();
            }
        }

        binding.findButton.setOnClickListener {
            val name = binding.nameBox.text.toString()

            if (name != "") {
                viewModel.findContact(binding.nameBox.text.toString())
            } else {
                Toast.makeText(context, "Enter a Name", Toast.LENGTH_SHORT).show()
            }
        }

        binding.ascButton.setOnClickListener{
            viewModel.sortAsc()
        }
        binding.descButton.setOnClickListener{
            viewModel.sortDesc()
        }

    }

        private fun observerSetup() {

            viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer { contacts ->
                contacts?.let {
                    adapter?.setContactList(it)
                }
            })

            viewModel.getSearchResults().observe(viewLifecycleOwner, Observer { contacts ->

                contacts?.let {
                    if (it.isNotEmpty()) {
                        adapter?.setContactList(it)
                    } else {
                        Toast.makeText(context, "No Match", Toast.LENGTH_SHORT).show()
                    }
                }
            })

            viewModel.getSortedASC().observe(viewLifecycleOwner, Observer { contacts ->

                contacts?.let {
                    if (it.isNotEmpty()) {
                        adapter?.setContactList(it)
                    } else {
                        Toast.makeText(context, "Can't sort", Toast.LENGTH_SHORT).show()
                    }
                }
            })

            viewModel.getSortedDESC().observe(viewLifecycleOwner, Observer { contacts ->

                contacts?.let {
                    if (it.isNotEmpty()) {
                        adapter?.setContactList(it)
                    } else {
                        Toast.makeText(context, "Can't sort", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }


        private fun recyclerSetup() {
            adapter = ContactListAdapter(R.layout.contact_list_item)
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
            binding.recyclerView.adapter = adapter

            adapter!!.setOnActionDeleteListener { viewModel.deleteContact(it.id) }
        }

        private fun clearFields() {
            binding.nameBox.setText("")
            binding.phoneBox.setText("")
        }
    }