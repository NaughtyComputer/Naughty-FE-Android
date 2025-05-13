package com.daemon.tuzamate.ui.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.daemon.tuzamate.databinding.FragmentPostScrapBinding
import com.daemon.tuzamate.ui.base.MainActivity

class PostScrapFragment : Fragment() {
    private lateinit var navController: NavController
    private var _binding: FragmentPostScrapBinding? = null
    private val binding: FragmentPostScrapBinding
        get() = requireNotNull(_binding){"FragmentPostScrapBinding -> null"}

    private lateinit var postScrapAdapter: PostScrapAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPostScrapBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        (requireActivity() as MainActivity).hideBottomNavigation(false)

        val dummyList = listOf(
            PostScrap(
                "제목 1",
                "05/12",
                "내용입니다.",
                12,
                4
            ),
            PostScrap(
                "제목 2",
                "05/10",
                "다른 내용입니다.",
                30,
                10
            )
        )

        postScrapAdapter = PostScrapAdapter(dummyList)
        binding.rvPostScrap.adapter = postScrapAdapter

        binding.btnBack.setOnClickListener {
            navController.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}