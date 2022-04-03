package com.binar.recyclerviewsample.binar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.binar.recyclerviewsample.Contacts
import com.binar.recyclerviewsample.R
import com.binar.recyclerviewsample.databinding.ItemUserBinding

class UserAdapter(private val contacts : List<Contacts>,
                  private var onItemClick : (Contacts)->Unit) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(val binding: ItemUserBinding):RecyclerView.ViewHolder(binding.root){

        val usernameTextView = binding.usernameTextView
        val phoneNumberTextView = binding.phonenumberTextView
        val roots:LinearLayout = binding.roots

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.usernameTextView.text = contacts[position].username
        holder.phoneNumberTextView.text = contacts[position].phoneNumber.toString()
        holder.roots.setOnClickListener {
            onItemClick(contacts[position])
        }


    }

    override fun getItemCount(): Int {
        return contacts.size
    }

}