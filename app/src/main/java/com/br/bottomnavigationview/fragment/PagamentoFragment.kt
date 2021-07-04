package com.br.bottomnavigationview.fragment

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.br.bottomnavigationview.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_pagamento.*
import kotlinx.android.synthetic.main.toolbar_back.*


class PagamentoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pagamento, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar()

        btnBack.setOnClickListener { backAnimator() }
    }

    private fun initToolbar() {
        tituloToolbar.text = "Pagamentos"
        ibBack.setOnClickListener { backAnimator() }
    }

    private fun backAnimator() {
        content_toolbar.apply {
            content_toolbar.animate()
                .alpha(0f)
                .setDuration(250)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?) {
                        findNavController().popBackStack()
                    }
                })
        }
    }

}