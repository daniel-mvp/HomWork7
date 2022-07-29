package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.AcctivityDetsilBinding
import com.google.android.material.progressindicator.LinearProgressIndicator

    class DetailActivity : AppCompatActivity() {

        private lateinit var binding: AcctivityDetsilBinding

        @SuppressLint("ResourceType")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = AcctivityDetsilBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.ivBack.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            val model: PokedexModel = intent.getSerializableExtra("model") as PokedexModel
            changeSolidColor(binding.containerDetail, model.color)

            binding.tvNameDetail.text = model.name
            binding.ivPokemonImage.setImageResource(model.image)
            binding.tvNumberPokemon.text = model.number
            binding.tvAbility.text = model.ability
            changeSolidColor(binding.tvAbility, model.color)
            binding.tvAbout.setTextColor(Color.parseColor(model.color))
            binding.tvWeight.text = model.weight
            binding.tvNumberHeight.text = model.height
            binding.tvMovesPokemon.text = model.moves
            binding.tvDescription.text = model.descriptions
            binding.tvBaseStatic.setTextColor(Color.parseColor(model.color))
            binding.tvNumberHp.text = model.hp
            binding.tvNumberAtk.text = model.attack
            binding.tvNumberDef.text = model.def
            binding.tvNumberSdef.text = model.sdef
            binding.tvNumberSatk.text = model.satk
            binding.tvNumberSpd.text = model.spd
            binding.tvHp.setTextColor(Color.parseColor(model.color))
            binding.tvAtk.setTextColor(Color.parseColor(model.color))
            binding.tvDef.setTextColor(Color.parseColor(model.color))
            binding.tvSdef.setTextColor(Color.parseColor(model.color))
            binding.tvSatk.setTextColor(Color.parseColor(model.color))
            binding.tvSpd.setTextColor(Color.parseColor(model.color))

            setColorProgressBar(binding.progressHp, model.color, model.hp.toInt())
            setColorProgressBar(binding.progressAtk, model.color, model.attack.toInt())
            setColorProgressBar(binding.progressDef, model.color, model.def.toInt())
            setColorProgressBar(binding.progressSdef, model.color, model.sdef.toInt())
            setColorProgressBar(binding.progressSatk, model.color, model.satk.toInt())
            setColorProgressBar(binding.progressSpd, model.color, model.spd.toInt())
        }

        private fun setColorProgressBar(progressBar: LinearProgressIndicator, color: String, progress: Int) {
            progressBar.setIndicatorColor(Color.parseColor(color))
            progressBar.progress = progress
        }

        private fun changeSolidColor(view: View, color: String) {
            val drawable: GradientDrawable = view.background as GradientDrawable
            drawable.mutate()
            drawable.setStroke(4, Color.parseColor(color))
            drawable.setColor(Color.parseColor(color))
        }
    }



