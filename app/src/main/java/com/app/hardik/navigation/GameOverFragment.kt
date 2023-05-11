package com.app.hardik.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.app.hardik.navigation.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_over, container, false)

        binding.tryAgainButton.setOnClickListener {
//            (Navigation.createNavigateOnClickListener(R.id.action_gameOverFragment_to_gameFragment))
            it.findNavController().navigate(GameOverFragmentDirections.actionGameOverFragmentToGameFragment())
        }

        return binding.root
    }
}