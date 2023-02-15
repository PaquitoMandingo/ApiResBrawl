package com.example.apiresbrawl

class BrawlersActivity : AppCompatActivity() {
    private lateinit var brawlersAdapter: BrawlersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brawlers)

// Crea un adaptador delista de Brawlers y configura el RecyclerView
brawlersAdapter = BrawlersAdapter()
val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
recyclerView.layoutManager = LinearLayoutManager(this)
recyclerView.adapter = brawlersAdapter


//    // Obtiene los Brawlers de la API y los agrega al adaptador
val repository = BrawlStarsRepository()
    val token = "YOUR_AUTH_TOKEN"
    GlobalScope.launch {
        val brawlers = repository.getBrawlers(token)
        withContext(Dispatchers.Main) {
            brawlersAdapter.submitList(brawlers)
        }
    }
}
