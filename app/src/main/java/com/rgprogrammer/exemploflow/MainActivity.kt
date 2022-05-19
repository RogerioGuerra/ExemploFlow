package com.rgprogrammer.exemploflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rgprogrammer.exemploflow.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding
    private val viewModel: MViewModel by viewModels()
    private val adapterMusic = MusicAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        setupRecyclerView()

        binding!!.btMusicFlow.setOnClickListener {

            lifecycleScope.launch {
                viewModel.getMusicStyles().collect {
                    adapterMusic.addMusic(it)

                }

            }

        }
        binding!!.btMusicLivedata.setOnClickListener {

            lifecycleScope.launch {
                viewModel.musicstyls.observe(this@MainActivity) { music ->
                    adapterMusic.addMusic(music)

                }
            }

        }

    }

    private fun setupRecyclerView() {
        val decorator = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        decorator.setDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.decoration
            )!!
        )

        val lManager = LinearLayoutManager(this)
        binding!!.recyclerView.run {
            layoutManager = lManager
            setHasFixedSize(true)
            addItemDecoration(decorator)
            adapter = adapterMusic

        }

    }
}