package com.ufcfantasy.ui

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ufcfantasy.R
import com.ufcfantasy.data.MockData
import com.ufcfantasy.databinding.ActivityFighterDetailBinding
import com.ufcfantasy.model.Fighter

class FighterDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFighterDetailBinding
    private var isSelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFighterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fighter = MockData.findById(intent.getIntExtra(EXTRA_FIGHTER_ID, -1))
        if (fighter == null) {
            finish()
            return
        }

        isSelected = savedInstanceState?.getBoolean(STATE_SELECTED, false) ?: false

        bindFighter(fighter)
        updateSelectButton()

        binding.backButton.setOnClickListener { finish() }
        binding.selectButton.setOnClickListener {
            isSelected = !isSelected
            updateSelectButton()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(STATE_SELECTED, isSelected)
    }

    private fun bindFighter(fighter: Fighter) {
        (fighter.heroImageResId ?: fighter.imageResId)?.let { binding.heroImage.setImageResource(it) }

        binding.weightClassBadge.text = getString(R.string.weight_class_format, fighter.weightClass)
        binding.fighterName.text = fighter.name
        binding.currentPoints.text = fighter.points.formatPoints()

        fighter.lastFightPoints?.let {
            binding.lastFightPoints.text = getString(R.string.last_points_value, it)
        } ?: run {
            binding.lastFightPoints.text = getString(R.string.no_data)
        }

        setValue(binding.winsValue, fighter.wins?.toString())
        setValue(binding.lossesValue, fighter.losses?.toString())
        setValue(binding.knockoutsValue, fighter.knockouts?.toString())

        val strikes = fighter.significantStrikes
        setStat(
            binding.strikesValue, binding.strikesBar,
            strikes?.let { getString(R.string.percent_format, it) },
            strikes
        )

        val knockdowns = fighter.knockdowns
        setStat(
            binding.knockdownsValue, binding.knockdownsBar,
            knockdowns?.toString(),
            knockdowns?.let { it * 20 }
        )

        val takedowns = fighter.takedowns
        setStat(
            binding.takedownsValue, binding.takedownsBar,
            takedowns?.toString(),
            takedowns?.let { it * 20 }
        )

        val control = fighter.groundControl
        val controlSeconds = control?.filter { it.isDigit() }?.toIntOrNull()
        setStat(
            binding.groundControlValue, binding.groundControlBar,
            control,
            controlSeconds?.let { it * 100 / MAX_GROUND_CONTROL_SECONDS }
        )
    }

    private fun setValue(view: TextView, value: String?) {
        view.text = value ?: getString(R.string.no_value)
    }

    private fun setStat(valueView: TextView, bar: ProgressBar, value: String?, progress: Int?) {
        setValue(valueView, value)
        bar.progress = (progress ?: 0).coerceIn(0, 100)
    }

    private fun updateSelectButton() {
        if (isSelected) {
            binding.selectButton.setText(R.string.fighter_selected)
            binding.selectButton.setBackgroundResource(R.drawable.bg_button_selected)
        } else {
            binding.selectButton.setText(R.string.select_fighter)
            binding.selectButton.setBackgroundResource(R.drawable.bg_button_primary)
        }
    }

    companion object {
        const val EXTRA_FIGHTER_ID = "fighter_id"
        private const val STATE_SELECTED = "state_selected"
        private const val MAX_GROUND_CONTROL_SECONDS = 300
    }
}
