package com.coderscastle.searchwithrecycler

import android.os.Bundle
import android.view.KeyEvent
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.search.SearchBar
import com.google.android.material.search.SearchView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView :RecyclerView = findViewById(R.id.recycler_view)
        val searchView : SearchView = findViewById(R.id.search_view)
        val searchBar : SearchBar = findViewById(R.id.search_bar)

        recyclerView.layoutManager = LinearLayoutManager(this)

       val myData = listOf(
            UsersData("Anaconda",10),
            UsersData("Bear",11),
            UsersData("Cobra",12),
            UsersData("Dear",13),
            UsersData("Elephant",14),
            UsersData("Fox",15),
            UsersData("Goat",16),
            UsersData("Horse",17),
            UsersData("Lion",18),
            UsersData("Monkey",19),
            UsersData("Ox",20),
            UsersData("Pig",21),
            UsersData("Rabbit",22),
            UsersData("Snake",23),
            UsersData("Tiger",24),
            UsersData("Wolf",25),
            UsersData("Zebra",26),
            UsersData("Penguin",27),
            UsersData("Koala",28),
            UsersData("Koala",29),
            UsersData("Koala",30),
        )

         val adapter = Adapter(myData)
        recyclerView.adapter = adapter

        searchBar.setOnMenuItemClickListener {
            val textMenu = it.title
            Toast.makeText(this, textMenu, Toast.LENGTH_SHORT).show()
            true
        }

        searchView.editText.setOnEditorActionListener { v, actionId, event ->
            val text = v?.text.toString()
            searchView.hide()
            searchBar.setText(text)
            true
        }

    }

}