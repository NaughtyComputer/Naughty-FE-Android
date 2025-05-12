package com.daemon.tuzamate.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.daemon.tuzamate.R
import com.daemon.tuzamate.databinding.FragmentLoginBinding
import com.daemon.tuzamate.ui.base.MainActivity

class LoginFragment : Fragment() {
    private lateinit var navController: NavController
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = requireNotNull(_binding){"FragmentLoginBinding -> null"}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        (requireActivity() as MainActivity).hideBottomNavigation(true)

        binding.btnKakaoLogin.setOnClickListener {
            navController.navigate(R.id.action_navigation_login_to_home)
        }

        binding.btnGoogleLogin.setOnClickListener {
            navController.navigate(R.id.action_navigation_login_to_home)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}