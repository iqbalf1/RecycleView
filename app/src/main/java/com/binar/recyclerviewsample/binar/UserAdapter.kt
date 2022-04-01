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

class UserAdapter(private val contacts : List<Contacts>,
                  private var onItemClick : (Contacts)->Unit) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View):RecyclerView.ViewHolder(view){

        val usernameTextView = view.findViewById<TextView>(R.id.username_textView)
        val phoneNumberTextView = view.findViewById<TextView>(R.id.phonenumber_textView)
        val root:LinearLayout = view.findViewById(R.id.root)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.usernameTextView.text = contacts[position].username
        holder.phoneNumberTextView.text = contacts[position].phoneNumber.toString()
        holder.root.setOnClickListener {
            onItemClick(contacts[position])
        }


    }

    override fun getItemCount(): Int {
        return contacts.size
    }

}