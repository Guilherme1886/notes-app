package com.gui.antonio.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.gui.antonio.notes.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var loginBinding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        loginBinding?.loginFloatingButton?.setOnClickListener {
            NavHostFragment.findNavController(this@LoginFragment)
                .navigate(R.id.action_loginFragment_to_notesFragment)
        }
        return loginBinding?.root
    }

    override fun onDestroyView() {
        loginBinding = null
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}