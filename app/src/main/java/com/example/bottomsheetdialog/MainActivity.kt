package com.example.bottomsheetdialog

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items= listOf(
        Item("Item 1","Description for item 1"),
        Item("Item 2", "Description for item 2"),
        Item("Item 3", "Description for item 3")
    )
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter= ItemAdapter(items){
            items->
            val bottomSheet= ItemDetailSheetFragment.newInstance(items.title,items.description)
            bottomSheet.show(supportFragmentManager,"ItemDetailSheetFragment")
        }
    }
}