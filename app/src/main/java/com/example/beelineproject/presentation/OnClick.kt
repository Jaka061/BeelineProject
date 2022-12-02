package com.example.beelineproject.presentation

import androidx.fragment.app.Fragment

interface OnClick {
    fun openFragment(fragment: Fragment, addToBackStack: Boolean? = true)
}