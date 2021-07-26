package com.example.todoapp.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.todoapp.view.fragments.functions.BuyAirtimeFragment
import com.example.todoapp.view.fragments.functions.BuyTokenFragment
import com.example.todoapp.view.fragments.functions.PayNHIFFragment

const val MY_GARDEN_PAGE_INDEX = 0
const val PLANT_LIST_PAGE_INDEX = 1
const val PAY_NHIG_PAGE_INDEX = 2

class SunflowerPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        MY_GARDEN_PAGE_INDEX to { BuyAirtimeFragment() },
        PLANT_LIST_PAGE_INDEX to { BuyTokenFragment() },
        PAY_NHIG_PAGE_INDEX to { PayNHIFFragment() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}