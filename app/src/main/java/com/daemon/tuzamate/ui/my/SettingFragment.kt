package com.daemon.tuzamate.ui.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.daemon.tuzamate.R
import com.daemon.tuzamate.databinding.FragmentSettingBinding
import com.daemon.tuzamate.ui.base.MainActivity

class SettingFragment : Fragment() {
    private lateinit var navController: NavController
    private var _binding: FragmentSettingBinding? = null
    private val binding: FragmentSettingBinding
        get() = requireNotNull(_binding){"FragmentSettingBinding -> null"}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSettingBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        (requireActivity() as MainActivity).hideBottomNavigation(false)

        binding.btnPostMy.setOnClickListener {
            navController.navigate(R.id.action_navigation_setting_to_post_scrap)
        }

        binding.btnPostLike.setOnClickListener {
            navController.navigate(R.id.action_navigation_setting_to_post_scrap)
        }

        binding.btnPostScrap.setOnClickListener {
            navController.navigate(R.id.action_navigation_setting_to_post_scrap)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}