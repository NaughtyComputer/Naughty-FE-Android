package com.daemon.tuzamate.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.daemon.tuzamate.databinding.FragmentHomeBinding
import com.daemon.tuzamate.ui.base.MainActivity

class HomeFragment : Fragment() {
    private lateinit var navController: NavController
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = requireNotNull(_binding){"FragmentHomeBinding -> null"}

    private val cardList = listOf(
        Card("카카오페이", "https://flexible.img.hani.co.kr/flexible/normal/970/574/imgdb/original/2024/0814/20240814503581.jpg"),
        Card("토스", "https://i0.wp.com/designcompass.org/wp-content/uploads/2022/09/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA-2022-09-05-%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB-9.34.33.png?resize=800%2C734&ssl=1"),
        Card("토스", "https://cdn.smedaily.co.kr/news/photo/202502/317099_253395_4246.jpg"),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        (requireActivity() as MainActivity).hideBottomNavigation(false)

        setupViewPager()
    }

    private fun setupViewPager() {
        binding.viewPagerCardNews.apply {
            adapter = CardNewsAdapter(cardList)
            offscreenPageLimit = 3
            setPageTransformer { page, position ->
                page.apply {
                    val scaleFactor = 0.85f + (1 - kotlin.math.abs(position)) * 0.15f
                    scaleY = scaleFactor
                    scaleX = scaleFactor
                    alpha = 0.5f + (1 - kotlin.math.abs(position)) * 0.5f
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}