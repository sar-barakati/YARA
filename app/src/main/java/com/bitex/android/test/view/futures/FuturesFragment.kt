package com.bitex.android.test.view.futures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bitex.android.test.R
import com.bitex.android.test.data.model.PriceModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_futures.*

@AndroidEntryPoint
class FuturesFragment : Fragment() {

    private val viewModel: FutureViewModel by viewModels()

    private val list = listOf(
        PriceModel("7.887.75", "0.236"),
        PriceModel("7.887.59", "3.164"),
        PriceModel("7.887.54", "0.348"),
        PriceModel("7.887.31", "0.236"),
        PriceModel("7.886.09", "0.692"),
        PriceModel("7.886.00", "0.180"),
        PriceModel("7.886.00", "7.881.84"),
        PriceModel("7.885.67", "1.950"),
        PriceModel("7.885.39", "2.328"),
        PriceModel("7.885.32", "0.010"),
        PriceModel("7.885.00", "21.206"),
        PriceModel("7.884.72", "0.360"),
        PriceModel("7.884.45", "1.971"),
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_futures, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val adapter = PriceAdapter(list)
        recycler.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        buy_long.setOnClickListener {
            viewModel.getDate(92)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FuturesFragment().apply {
            }
    }
}