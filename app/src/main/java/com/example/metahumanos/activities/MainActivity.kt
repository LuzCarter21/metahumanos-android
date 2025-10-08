package com.example.metahumanos.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.metahumanos.R
import com.example.metahumanos.adapters.AgentsAdapter
import com.example.metahumanos.data.AgentService
import com.example.metahumanos.data.Agents
import com.example.metahumanos.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch




class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: AgentsAdapter

    var filteredAgentList: List<Agents> = emptyList()
    var originalAgentList: List<Agents> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        adapter = AgentsAdapter(filteredAgentList) { position ->
            val agent = filteredAgentList[position]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("AGENT_ID",agent.id)
            startActivity(intent)

            binding.RecyclerViewAgents.adapter = adapter
            binding.RecyclerViewAgents.layoutManager = GridLayoutManager (this, 2)


        }


    }
    fun getAgentList(){
    CoroutineScope(Dispatchers.IO).launch {
        try {
            val service = AgentService.getInstance()
            originalAgentList = service.allAgents()
            filteredAgentList = originalAgentList
            CoroutineScope(Dispatchers.Main).launch {
                adapter.updateItems(filteredAgentList)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}