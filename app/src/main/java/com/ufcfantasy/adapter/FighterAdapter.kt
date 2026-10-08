package com.ufcfantasy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ufcfantasy.R
import com.ufcfantasy.databinding.ItemFighterBinding
import com.ufcfantasy.model.Fighter
import com.ufcfantasy.ui.formatPoints

class FighterAdapter(
    private val fighters: List<Fighter>,
    private val onFighterClick: (Fighter) -> Unit
) : RecyclerView.Adapter<FighterAdapter.FighterViewHolder>() {

    inner class FighterViewHolder(
        private val binding: ItemFighterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(fighter: Fighter, position: Int) {
            val context = binding.root.context

            binding.fighterRank.text = context.getString(R.string.rank_position_format, position + 1)
            binding.fighterName.text = fighter.name
            binding.fighterWeightClass.text = fighter.weightClass
            binding.fighterPoints.text = context.getString(
                R.string.points_format,
                fighter.points.formatPoints()
            )

            fighter.imageResId?.let { binding.fighterAvatar.setImageResource(it) }
                ?: binding.fighterAvatar.setImageDrawable(null)

            fighter.lastFightPoints?.let {
                binding.fighterLastFight.text = context.getString(R.string.last_fight_format, it)
            } ?: run {
                binding.fighterLastFight.text = context.getString(R.string.no_data)
            }

            binding.root.setOnClickListener { onFighterClick(fighter) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FighterViewHolder {
        val binding = ItemFighterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FighterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FighterViewHolder, position: Int) {
        holder.bind(fighters[position], position)
    }

    override fun getItemCount(): Int = fighters.size
}
