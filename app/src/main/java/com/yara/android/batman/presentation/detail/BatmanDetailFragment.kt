package com.yara.android.batman.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.yara.android.batman.R
import com.yara.android.batman.presentation.list.BatmanListFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.batman_detail_fragment.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BatmanDetailFragment : Fragment() {

    private val viewModel: BatmanDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val selectedId = arguments?.getString(BatmanListFragment.ID)
        selectedId?.let {
            viewModel.getMovieDetail(selectedId)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.batman_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.movieDetailState.collect { movieDetail ->
                if (movieDetail.title.isNotEmpty()) {
                    progressBar.visibility = View.INVISIBLE
                    Glide.with(requireContext()).load(movieDetail.poster).into(posterIv)
                    titleTv.text = movieDetail.title
                    "${getString(R.string.director)} : ${movieDetail.director}".also {
                        directorTv.text = it
                    }
                    "${getString(R.string.actors)} : ${movieDetail.actors}".also {
                        actorTv.text = it
                    }
                    "${getString(R.string.plot)} : ${movieDetail.plot}".also { plotTv.text = it }
                }
            }
        }
    }

}