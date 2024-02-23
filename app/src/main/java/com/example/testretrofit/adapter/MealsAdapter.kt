package com.example.testretrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testretrofit.databinding.MealItemBinding
import com.example.domain.entity.Meal

class MealsAdapter(private var mealsList: List<com.example.domain.entity.Meal>) : RecyclerView.Adapter<MealsAdapter.MealsViewHolder>() {
    inner class MealsViewHolder(val binding: MealItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(meal: com.example.domain.entity.Meal) {
            binding.apply {
                Glide.with(itemView)
                    .load(meal.strMealThumb)
                    .into(userIv)
                userNameTv.text = meal.strMeal          }
        }
    }


    fun submitList(list: List<com.example.domain.entity.Meal>) {
        mealsList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        val itemBinding =
            MealItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealsViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
         return mealsList.size
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
        val meal = mealsList[position]
        holder.bind(meal)
    }
}