package com.paularolim.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), CharacterListFragment.OnListSelected {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            supportFragmentManager.beginTransaction()
                .add(R.id.container_root, CharacterListFragment.newInstance(), "characters")
                .commit()
    }

    override fun onSelected(character: Character) {
        var args = Bundle()
        args.putSerializable("detail", character)

        val fragment = CharacterDetailFragment()
        fragment.arguments = args

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_root, fragment, "fragmentDetail")
            .addToBackStack(null)
            .commit()
    }
}