package com.cst.academy2024unibucfmi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cst.academy2024unibucfmi.R

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.btn_register)
        button.setOnClickListener { goToRegister() }

        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            goToProducts()
        }
    }

    private fun goToRegister() {
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        findNavController().navigate(action)
    }

    private fun goToProducts() {
        val action = LoginFragmentDirections.actionLoginFragmentToProductsFragment()
        findNavController().navigate(action)
    }
}