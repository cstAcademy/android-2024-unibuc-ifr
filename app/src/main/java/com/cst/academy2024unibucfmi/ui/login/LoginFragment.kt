package com.cst.academy2024unibucfmi.ui.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.cst.academy2024unibucfmi.BuildConfig
import com.cst.academy2024unibucfmi.R
import com.cst.academy2024unibucfmi.databinding.FragmentLoginBinding
import com.cst.academy2024unibucfmi.models.api.LoginAPIRequestModel
import com.cst.academy2024unibucfmi.models.api.LoginAPIResponseModel
import com.cst.academy2024unibucfmi.utils.VolleyRequestQueue
import com.cst.academy2024unibucfmi.utils.extensions.logErrorMessage
import com.cst.academy2024unibucfmi.utils.extensions.showToast
import com.google.gson.Gson

class LoginFragment : Fragment(), LoginFragmentListener {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.listener = this
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (BuildConfig.DEBUG) {
            viewModel.username.value = "mor_2314"
            viewModel.password.set("83r5^_")
        }

        setupObservables()
    }

    private fun setupObservables() {
        viewModel.loginModel.observe(viewLifecycleOwner) { loginModel ->
            doLogin(loginModel)
        }
    }

    override fun goToRegister() {
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        findNavController().navigate(action)
    }

    private fun goToProducts() {
        val action = LoginFragmentDirections.actionLoginFragmentToProductsFragment()
        findNavController().navigate(action)
    }

    private fun doLogin(loginModel: LoginAPIRequestModel) {
//        val username = when (viewModel.username.get()?.isNotEmpty()) {
//            true -> viewModel.username.get() ?: ""
//            else -> {
//                getString(R.string.authentication_invalid_username).showToast(context)
//                return
//            }
//        }
//        val password = when (viewModel.password.get()?.isNotEmpty()) {
//            true -> viewModel.password.get() ?: ""
//            else -> {
//                getString(R.string.authentication_invalid_password).showToast(context)
//                return
//            }
//        }
//        val loginAPIRequestModel = LoginAPIRequestModel(
//            username = username,
//            password = password
//        )

        val url = "https://fakestoreapi.com/auth/login"

        // Request a string response from the provided URL.
        val stringRequest = object : StringRequest(
            Request.Method.POST,
            url,
            { response ->
                Gson().fromJson(response, LoginAPIResponseModel::class.java).let { responseModel ->
                    responseModel.token.showToast(context)
                    goToProducts()
                }
            },
            {
                "Login didn't work!".logErrorMessage()
            }) {
            override fun getParams(): MutableMap<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["username"] = loginModel.username
                params["password"] = loginModel.password

                return params
            }
        }

        // Add the request to the RequestQueue.
        VolleyRequestQueue.addToRequestQueue(stringRequest)
    }

    override fun forgotPassword() {

    }
}

interface LoginFragmentListener {
    fun forgotPassword()
    fun goToRegister()
}