package com.ufcfantasy.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ufcfantasy.R
import com.ufcfantasy.adapter.FighterAdapter
import com.ufcfantasy.data.MockData
import com.ufcfantasy.databinding.ActivityMainBinding
import com.ufcfantasy.model.Fighter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.userPoints.text = MockData.USER_POINTS.formatPoints()
        binding.globalRank.text = getString(R.string.global_rank_format, MockData.GLOBAL_RANK)

        binding.fightersRecycler.layoutManager = LinearLayoutManager(this)
        binding.fightersRecycler.adapter = FighterAdapter(MockData.fighters, ::openFighterDetail)
    }

    private fun openFighterDetail(fighter: Fighter) {
        val intent = Intent(this, FighterDetailActivity::class.java)
        intent.putExtra(FighterDetailActivity.EXTRA_FIGHTER_ID, fighter.id)
        startActivity(intent)
    }
}
