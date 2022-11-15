package com.yara.android.batman.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.yara.android.batman.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.batman_list_fragment.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BatmanListFragment : Fragment() {

    companion object {
        const val ID = "ID"
    }

    private val viewModel: BatmanListViewModel by viewModels()
    private lateinit var batmanListAdapter: BatmanListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.batman_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        batmanListAdapter = BatmanListAdapter()
        recycler.apply {
            adapter = batmanListAdapter
            layoutManager = GridLayoutManager(requireContext(), 3)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.movieState.collect {
                    if (it.isNotEmpty()) {
                        progressBar.visibility = View.INVISIBLE
                        batmanListAdapter.movies = it
                        batmanListAdapter.notifyItemRangeChanged(0, it.size)
                    }
                }
            }
        }

        batmanListAdapter.onItemClick = {
            val bundle = Bundle()
            bundle.putString(ID, it.imdbID)
            findNavController().navigate(
                R.id.action_batmanListFragment_to_batmanDetailFragment,
                bundle
            )
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        //to avoid leak
        batmanListAdapter.onItemClick = null
    }


}