package com.example.searchviewdemo.activity
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchviewdemo.model.ItemsViewModel
import com.example.searchviewdemo.R
import com.example.searchviewdemo.adapter.customAdapter
import com.example.searchviewdemo.utils.onItemClickListener
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(){
    private lateinit var arrayList: ArrayList<ItemsViewModel>
    private lateinit var tempArrayList:ArrayList<ItemsViewModel>
    private lateinit var adapter: customAdapter
    private lateinit var name:ArrayList<String>
    private var activityName:ArrayList<String> = kotlin.collections.ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler)
        searchView= findViewById(R.id.searchview)

        recyclerView.layoutManager = LinearLayoutManager(this)
        arrayList= ArrayList()
        tempArrayList = ArrayList()

        name = kotlin.collections.ArrayList()
        name.add("CollapsingToolBarLayout")
        name.add("Drawer Layout")
        name.add("Ratingbar")
        name.add("Seekbar")
        name.add("SearchView")
        name.add("Radio Group")
        name.add("ToggleButton")
        name.add("CheckBox")
        name.add("cardView")
        name.add("TextInputlayout")
        name.add("WebView")
        name.add("Switch")
        name.add("Bottom Sheet")
        name.add("Recycler view Demo")
        name.add("Text To Speech Demo")
        name.add("Fragment Demo")
        name.add("Retrofit Demo")

        activityName.add("CollapsingToolBarLayoutActivity")
        activityName.add("DrawerlayoutActivity")
        activityName.add("RatingbarActivity")
        activityName.add("SeekBarActivity")
        activityName.add("-")
        activityName.add("RadioButtonActivity")
        activityName.add("ToggleButtonActivity")
        activityName.add("CheckBoxActivity")
        activityName.add("-")
        activityName.add("TextInputLayoutActivity")
        activityName.add("WebViewActivity")
        activityName.add("SwitchActivity")
        activityName.add("BottomSheetActivity")
        activityName.add("RecyclerDemoActivity")
        activityName.add("TextToSpeechActivity")
        activityName.add("FragmentActivity")
        activityName.add("RetrofitDemoActivity")



        for (i in activityName.indices){
            arrayList.add(ItemsViewModel(R.drawable.winner, name[i],activityName[i]))
        }

        tempArrayList.addAll(arrayList)


        adapter = customAdapter(tempArrayList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(newText: String?): Boolean {

                tempArrayList.clear()
                val searchText = newText!!.lowercase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    arrayList.forEach {
                        if (it.name.lowercase(Locale.getDefault()).contains(searchText)){
                            tempArrayList.addAll(listOf(it))
                        }
                    }
                    recyclerView.apply {
                        //layoutManager = LinearLayoutManager(context)
                        adapter?.notifyDataSetChanged()
                    }
                }

                else{
                    tempArrayList.clear()
                    tempArrayList.addAll(arrayList)
                    recyclerView.adapter?.notifyDataSetChanged()
                }
                return false
            }

        })


        adapter.onItemClickListener(object : onItemClickListener {
            override fun onItemClick(position: Int) {
                /*when(position){
                    0 -> startActivity(Intent(this@MainActivity, CollapsingToolBarLayoutActivity::class.java))
                    1 -> startActivity(Intent(this@MainActivity, DrawerlayoutActivity::class.java))
                    2 -> startActivity(Intent(this@MainActivity, RatingbarActivity::class.java))
                    3 -> startActivity(Intent(this@MainActivity, SeekBarActivity::class.java))
                    4 -> Toast.makeText(this@MainActivity,"Searchview is on the top",Toast.LENGTH_LONG).show()
                    5 -> startActivity(Intent(this@MainActivity, RadioButtonActivity::class.java))
                    6 -> startActivity(Intent(this@MainActivity, ToggleButtonActivity::class.java))
                    7 -> startActivity(Intent(this@MainActivity, CheckBoxActivity::class.java))
                    8 -> Toast.makeText(this@MainActivity,"cardview is in recycler-view's Design",Toast.LENGTH_LONG).show()
                    9 -> startActivity(Intent(this@MainActivity, TextInputLayoutActivity::class.java))
                    10 -> startActivity(Intent(this@MainActivity, WebViewActivity::class.java))
                    11 -> startActivity(Intent(this@MainActivity, SwitchActivity::class.java))
                }*/
                if(activityName[position] != "-") {
                    val intent = Intent().setClassName(
                        this@MainActivity,
                        "com.example.searchviewdemo.activity." + activityName[position]
                    )

                    startActivity(intent)
                }
                else{
                    Toast.makeText(this@MainActivity,"Show in this page",Toast.LENGTH_LONG).show()
                }

            }

        })
    }

}

