package com.paularolim.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharacterListFragment : Fragment() {
    private lateinit var listener: OnListSelected

    private lateinit var names: Array<String>
    private lateinit var descriptions: Array<String>
    private lateinit var images: IntArray

    companion object {
        fun newInstance() = CharacterListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val activity = activity as Context
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = CharacterListAdapter()

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val resources = context.resources
        names = resources.getStringArray(R.array.names)
        descriptions = resources.getStringArray(R.array.descriptions)

        val typedArray = resources.obtainTypedArray(R.array.images)
        val imageCount = names.size
        images = IntArray(imageCount)
        for (i in 0 until imageCount) {
            images[i] = typedArray.getResourceId(i, 0)
        }
        typedArray.recycle()

        if (context is OnListSelected) {
            listener = context
        } else {
            throw ClassCastException("$context must be implement")
        }
    }

    internal inner class CharacterListAdapter : RecyclerView.Adapter<ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.item_list, parent, false
                )
            )

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val character = Character(names[position], descriptions[position], images[position])
            holder.bind(character)
            holder.itemView.setOnClickListener {
                listener.onSelected(character)
            }
        }

        override fun getItemCount(): Int {
            return names.size
        }
    }

    internal inner class ViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(character: Character) {
            itemView.findViewById<ImageView>(R.id.list_image).setImageResource(character.imageResourceId)
            itemView.findViewById<TextView>(R.id.list_name).text = character.name
        }
    }

    // onclick event
    interface OnListSelected {
        fun onSelected(character: Character)
    }
}